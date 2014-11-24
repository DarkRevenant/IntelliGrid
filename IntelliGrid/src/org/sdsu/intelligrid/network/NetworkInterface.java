// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
	private static final int OUTPUT_BUFFER_CAPACITY = 10;

	private static final boolean ENABLE_NETWORK = true;

	private final Queue<IntelliGridPacket> outputBuffer = new ArrayBlockingQueue<>(
			OUTPUT_BUFFER_CAPACITY);
	private final Queue<IntelliGridPacket> inputBuffer = new ArrayBlockingQueue<>(
			INPUT_BUFFER_CAPACITY);

	/**
	 * NETWORK CONFIGURATION
	 */
	private static final int SERVER_PORT = 9750;
	private static final byte[] SERVER_IP = { (byte) 192, (byte) 168, (byte) 1,
			(byte) 10 }; // 192.168.1.10
	/**
	 * END NETWORK CONFIGURATION
	 */

	private Socket clientSocket = null;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	private boolean failed = false;

	/**
	 * Pushes a network message to the output buffer to be sent at the earliest
	 * opportunity. Will overwrite old messages if the buffer is full (such as
	 * when the connection is down).
	 * <p>
	 * Does nothing if the network is not connected.
	 * 
	 * @param message
	 *            the message to send in the packet
	 */
	public void sendMessage(final String message) {
		if (clientSocket == null) {
			return;
		}
		if (outputBuffer.size() == OUTPUT_BUFFER_CAPACITY) {
			outputBuffer.remove();
		}
		outputBuffer.add(new IntelliGridPacket(message, new Date()));
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
		return clientSocket != null;
	}

	private Socket connect() {
		final Socket connection;
		try {
			final InetAddress serverAddress = InetAddress
					.getByAddress(SERVER_IP);
			connection = new Socket(serverAddress, SERVER_PORT);
		} catch (UnknownHostException e1) {
			Logger.getGlobal().log(Level.SEVERE, e1.getMessage());
			return null;
		} catch (IOException e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage());
			return null;
		}

		return connection;
	}

	private class XBeeReader implements Runnable {

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted() && !failed) {
				if (clientSocket == null || reader == null) {
					continue;
				}

				final String in;
				try {
					in = reader.readLine();
				} catch (IOException e) {
					Logger.getGlobal().log(Level.SEVERE, e.getMessage());
					failed = true;
					break;
				}

				if (in != null) {
					Logger.getGlobal()
							.log(Level.SEVERE, "Read: \"" + in + "\"");
					if (inputBuffer.size() == INPUT_BUFFER_CAPACITY) {
						inputBuffer.remove();
					}
					inputBuffer.add(new IntelliGridPacket(in, new Date()));
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

		while (!Thread.currentThread().isInterrupted() && !failed) {
			if (clientSocket == null) {
				Logger.getGlobal()
						.log(Level.SEVERE, "Attempting connection...");
				clientSocket = connect();
				if (clientSocket == null) {
					continue;
				}
				Logger.getGlobal().log(
						Level.SEVERE,
						"Connected to "
								+ clientSocket.getInetAddress().getHostName());

				try {
					reader = new BufferedReader(new InputStreamReader(
							clientSocket.getInputStream()), 65536);
					writer = new BufferedWriter(new OutputStreamWriter(
							clientSocket.getOutputStream()), 65536);
				} catch (IOException e) {
					Logger.getGlobal().log(Level.SEVERE, e.getMessage());
					failed = true;
					break;
				}
			}

			if (writer != null) {
				final IntelliGridPacket packet = outputBuffer.poll();

				if (packet != null) {
					final String out = packet.message;
					Logger.getGlobal().log(Level.SEVERE,
							"Sending \"" + out + "\"");
					try {
						writer.write(out);
					} catch (IOException e) {
						Logger.getGlobal().log(Level.SEVERE, e.getMessage());
						failed = true;
						break;
					}
				}
			}
		}
	}
}
