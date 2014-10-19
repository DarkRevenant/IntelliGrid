package org.sdsu.intelligrid.network;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MainNetworkInterface {

	private static final int BUFFER_CAPACITY = 100;

	private final Queue<IntelliGridPacket> outputBuffer = new ArrayBlockingQueue<>(
			BUFFER_CAPACITY);
	private final Queue<IntelliGridPacket> inputBuffer = new ArrayBlockingQueue<>(
			BUFFER_CAPACITY);

	public MainNetworkInterface() {

	}

	/**
	 * Adds a network message to the output buffer to be sent at the earliest
	 * opportunity. Throws an <tt>IllegalStateException</tt> if the buffer is
	 * full.
	 * 
	 * @param message
	 *            the message to send in the packet
	 * @throws IllegalStateException
	 *             if the buffer is full
	 */
	public void sendMessage(String message) {
		outputBuffer.add(new IntelliGridPacket(message));
	}

	/**
	 * Pops off the first packet in the input buffer. Returns <tt>null</tt> if
	 * the buffer is empty.
	 * <p>
	 * Intended to be used in a loop by a formal, global handler.
	 * 
	 * @return the first packet in the input buffer, or <tt>null</tt> if the
	 *         buffer is empty.
	 */
	public String retrieveMessage() {
		if (inputBuffer.size() <= 0) {
			return null;
		} else {
			final IntelliGridPacket packet = inputBuffer.remove();
			return packet.message;
		}
	}
}
