// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Network API for the application.
 */
public class NetworkInterface implements Runnable {

	private static final int BUFFER_CAPACITY = 10000;

	private final Queue<IntelliGridPacket> outputBuffer = new ArrayBlockingQueue<>(
			BUFFER_CAPACITY);
	private final Queue<IntelliGridPacket> inputBuffer = new ArrayBlockingQueue<>(
			BUFFER_CAPACITY);

	/**
	 * NETWORK CONFIGURATION
	 */
	private static final int SERVER_PORT = 6000;
	private static final byte[] CLIENT_IP = { (byte) 128, (byte) 128,
			(byte) 128, (byte) 128 }; // 128.128.128.128
	/**
	 * END NETWORK CONFIGURATION
	 */

	private ServerSocket serverSocket;
	private Socket clientSocket = null;
	private BufferedReader reader = null;
	private BufferedWriter writer = null;

	private boolean failed = false;

	/**
	 * Pushes a network message to the output buffer to be sent at the earliest
	 * opportunity. Will overwrite old messages if the buffer is full (such as
	 * when the connection is down).
	 * 
	 * @param message
	 *            the message to send in the packet
	 */
	public void sendMessage(final String message) {
		if (outputBuffer.size() == BUFFER_CAPACITY) {
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

	private boolean initialize() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			failed = true;
			return false;
		}
	}

	private Socket connect() {
		final Socket connection;
		try {
			connection = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
			failed = true;
			return null;
		}

		final InetAddress address = connection.getInetAddress();
		if (!(address instanceof Inet4Address)) {
			try {
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
				failed = true;
			}
			return null; // No/invalid connection
		}

		for (int i = 0; i < 4; i++) {
			if (CLIENT_IP[i] != address.getAddress()[i]) {
				try {
					connection.close();
				} catch (IOException e) {
					e.printStackTrace();
					failed = true;
				}
				return null; // Not the right IP
			}
		}

		return connection;
	}

	@Override
	public void run() {
		if (!initialize()) {
			return; // We tried, we failed, we left
		}

		while (!Thread.currentThread().isInterrupted() && !failed) {
			if (clientSocket == null) {
				clientSocket = connect();

				try {
					reader = new BufferedReader(new InputStreamReader(
							clientSocket.getInputStream()), 65536);
					writer = new BufferedWriter(new OutputStreamWriter(
							clientSocket.getOutputStream()), 65536);
				} catch (IOException e) {
					e.printStackTrace();
					failed = true;
					break;
				}
			}

			if (reader != null) {
				final String in;
				try {
					in = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					failed = true;
					break;
				}

				if (in != null) {
					if (inputBuffer.size() == BUFFER_CAPACITY) {
						inputBuffer.remove();
					}
					inputBuffer.add(new IntelliGridPacket(in, new Date()));
				}
			}

			if (writer != null) {
				final IntelliGridPacket packet = outputBuffer.poll();

				if (packet != null) {
					final String out = packet.message;
					try {
						writer.write(out);
					} catch (IOException e) {
						e.printStackTrace();
						failed = true;
						break;
					}
				}
			}
		}
	}
}
