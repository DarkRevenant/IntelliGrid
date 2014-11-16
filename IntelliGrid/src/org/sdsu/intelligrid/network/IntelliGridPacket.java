// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

import java.util.Date;

/**
 * Packet class for the network API.
 */
public class IntelliGridPacket {

	public final String message;
	public final Date date;

	public IntelliGridPacket(final String message, final Date date) {
		this.message = message;
		this.date = date;
	}
}
