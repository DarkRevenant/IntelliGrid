// Copyright 2014 Harrison Snodgrass and San Diego Gas and Electric, all rights reserved

package org.sdsu.intelligrid.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Network API for the application.
 */
public class NetworkInterface implements Runnable {

	private static final int INPUT_BUFFER_CAPACITY = 10000;
	private static final int OUTPUT_BUFFER_CAPACITY = 20;

	private static final int RETRY_CONNECTION_DELAY_MS = 5000;
	private static final int TIME_BETWEEN_PACKETS_MS = 20;

	private static final int DELAY_AFTER_CONNECT_MS = 5000;

	private static final boolean ENABLE_NETWORK = true;

	private final Queue<IntelliGridPacket> outputBuffer = new ArrayBlockingQueue<>(
			OUTPUT_BUFFER_CAPACITY);
	private final Queue<IntelliGridPacket> inputBuffer = new ArrayBlockingQueue<>(
			INPUT_BUFFER_CAPACITY);

	/**
	 * NETWORK CONFIGURATION
	 */
	private static final int SERVER_PORT = 9750;
	private static final String SERVER_IP = "192.168.1.10";
	/**
	 * END NETWORK CONFIGURATION
	 */

	private Socket clientSocket = null;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	private int waitAfterConnect = DELAY_AFTER_CONNECT_MS;
	private long startTime;

	/**
	 * Pushes a network message to the output buffer to be sent at the earliest
	 * opportunity. Will overwrite old messages if the buffer is full (such as
	 * when the connection is down).
	 * <p>
	 * Does nothing if the network is not connected.
	 * 
	 * @param message
	 *            the message to send in the packet
	 * @param repeat
	 *            how many times to send the packet (error checking kludge)
	 */
	public void sendMessage(final String message, final int repeat) {
		if (clientSocket == null) {
			Logger.getGlobal().log(Level.INFO, "No client to send message!");
			return;
		}
		if (outputBuffer.size() == OUTPUT_BUFFER_CAPACITY) {
			outputBuffer.remove();
			Logger.getGlobal().log(Level.INFO, "Buffer Full!");
		}
		outputBuffer.add(new IntelliGridPacket(message, new Date(), repeat));
	}

	/**
	 * Pops off the first packet in the input buffer. Returns <tt>null</tt> if
	 * the buffer is empty.
	 * 
	 * @return the first packet in the input buffer, or <tt>null</tt> if the
	 *         buffer is empty.
	 */
	public IntelliGridPacket retrieveMessage() {
		final IntelliGridPacket packet = inputBuffer.poll();
		if (packet == null || packet.message == null
				|| packet.message.isEmpty()) {
			return null;
		} else {
			return packet;
		}
	}

	/**
	 * Returns <tt>true</tt> if the model is connected to the application.
	 * Returns <tt>false</tt> otherwise.
	 */
	public boolean isConnected() {
		return clientSocket != null && waitAfterConnect < 0;
	}

	private Socket connect() {
		final Socket connection;
		try {
			connection = new Socket(SERVER_IP, SERVER_PORT);
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE,
					"Connection failed: " + e.getMessage());
			return null;
		}

		waitAfterConnect = DELAY_AFTER_CONNECT_MS;
		startTime = System.currentTimeMillis();
		return connection;
	}

	private class XBeeReader implements Runnable {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				if (clientSocket == null || reader == null) {
					try {
						Thread.sleep(RETRY_CONNECTION_DELAY_MS);
					} catch (InterruptedException e) {
						Logger.getGlobal().log(Level.SEVERE, e.getMessage());
					}
					continue;
				}

				String in = null;
				final char[] buffer = new char[1000];
				try {
					final int howMuch = reader.read(buffer, 0, 1000);
					if (howMuch == -1) {
						Logger.getGlobal().log(Level.SEVERE,
								"Too much to read!");
						continue;
					}
					in = String.valueOf(buffer).substring(0, howMuch);
				} catch (IOException e) {
					Logger.getGlobal().log(Level.SEVERE,
							"Reader failed: " + e.getMessage());
					clientSocket = null;
					continue;
				}

				if (in != null) {
					// Logger.getGlobal().log(Level.INFO, "Read: \"" + in +
					// "\"");
					if (inputBuffer.size() == INPUT_BUFFER_CAPACITY) {
						inputBuffer.clear(); // Let's avoid some crash
					}
					inputBuffer.add(new IntelliGridPacket(in, new Date(), 1));
				}
			}
		}
	}

	@Override
	public void run() {
		if (!ENABLE_NETWORK) {
			return;
		}

		new Thread(new XBeeReader()).start();

		while (!Thread.currentThread().isInterrupted()) {
			if (clientSocket != null) {
				if (!clientSocket.isBound()) {
					clientSocket = null;
					Logger.getGlobal()
							.log(Level.SEVERE, "Socket is not bound!");
				} else if (clientSocket.isClosed()) {
					clientSocket = null;
					Logger.getGlobal().log(Level.SEVERE, "Socket is closed!");
				} else if (!clientSocket.isConnected()) {
					clientSocket = null;
					Logger.getGlobal().log(Level.SEVERE,
							"Socket is not connected!");
				}
			}
			if (clientSocket == null) {
				Logger.getGlobal().log(Level.INFO, "Attempting connection...");
				clientSocket = connect();
				if (clientSocket == null) {
					try {
						Thread.sleep(RETRY_CONNECTION_DELAY_MS);
					} catch (InterruptedException e) {
						Logger.getGlobal().log(Level.SEVERE, e.getMessage());
					}
					continue;
				}
				Logger.getGlobal().log(
						Level.INFO,
						"Connected to "
								+ clientSocket.getInetAddress().getHostName());

				try {
					reader = new BufferedReader(new InputStreamReader(
							clientSocket.getInputStream()), 65536);
					writer = new BufferedWriter(new OutputStreamWriter(
							clientSocket.getOutputStream()), 65536);
				} catch (Exception e) {
					Logger.getGlobal().log(Level.SEVERE,
							"Failed to initialize r/w: " + e.getMessage());
					clientSocket = null;
					continue;
				}
			}

			if (waitAfterConnect > 0) {
				waitAfterConnect -= System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
			}

			if (writer != null) {
				final IntelliGridPacket packet = outputBuffer.peek();

				if (packet != null) {
					final String out = packet.message;
					try {
						packet.repeat--;
						writer.write(out);
						writer.flush();
					} catch (Exception e) {
						Logger.getGlobal().log(Level.SEVERE,
								"Failed to write: " + e.getMessage());
						clientSocket = null;
						continue;
					}
					if (packet.repeat <= 0) {
						outputBuffer.poll();
					}
					// Logger.getGlobal().log(Level.INFO, "Sent \"" + out +
					// "\"");
				}

				try {
					Thread.sleep(TIME_BETWEEN_PACKETS_MS);
				} catch (InterruptedException e) {
					Logger.getGlobal().log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}
}
