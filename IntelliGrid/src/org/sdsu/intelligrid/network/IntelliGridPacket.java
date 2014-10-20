// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

/**
 * Packet class for the network API.
 */
public class IntelliGridPacket {

	public final String message;

	public IntelliGridPacket(final String message) {
		this.message = message;
	}
}
