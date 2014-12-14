// Copyright 2014 Harrison Snodgrass and San Diego Gas and Electric, all rights reserved

package org.sdsu.intelligrid.network;

import java.util.Date;

/**
 * Packet class for the network API.
 */
public class IntelliGridPacket {

	public final String message;
	public final Date date;
	public int repeat;

	public IntelliGridPacket(final String message, final Date date,
			final int repeat) {
		this.message = message;
		this.date = date;
		this.repeat = repeat;
	}
}
