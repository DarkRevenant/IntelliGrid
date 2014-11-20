// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.graphics.ui.LightAnimation;

/**
 * Main network handler class for the application.
 */
public class MainNetworkHandler {

	private NetworkInterface network;

	public static enum PacketTypes {

		SOLAR_GENERATION_LEVEL("S", new SolarGenHandler()), WIND_GENERATION_LEVEL(
				"W", new WindTurbineHandler()), BATTERY_STORAGE_LEVEL("B",
				new BatteryHandler()), TIME_OF_DAY("T", new TimeHandler()), CAR_DETECT(
				"E", new ElectricCarHandler()), SOLAR_DETECT("R",
				new SolarPanelHandler()), BALLOON_DETECT_RESET("M",
				new MylarBalloonHandler()), DIG_DETECT_RESET("D",
				new DigFaultHandler()), LIGHT_ANIMATION("L", new LEDHandler());

		private final String prefix;
		private final PacketHandler handler;

		private PacketTypes(final String prefix, final PacketHandler handler) {
			this.prefix = prefix;
			this.handler = handler;
		}

		public String getPrefix() {
			return new String(prefix);
		}

		public void input(final String message) {
			handler.input(message);
		}

		public String output(final Object param) {
			return handler.output(param);
		}
	}

	private static interface PacketHandler {

		public void input(final String message);

		public String output(final Object param);
	}

	private static final class SolarGenHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output(final Object param) {
			return null;
		}
	}

	private static final class WindTurbineHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output(final Object param) {
			// Stub
			return " ";
		}
	}

	private static final class BatteryHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output(final Object param) {
			// Stub
			return " ";
		}
	}

	private static final class TimeHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output(final Object param) {
			// Stub
			return " ";
		}
	}

	private static final class ElectricCarHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output(final Object param) {
			return null;
		}
	}

	private static final class SolarPanelHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output(final Object param) {
			// Stub
			return " ";
		}
	}

	private static final class MylarBalloonHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output(final Object param) {
			// Stub
			return " ";
		}
	}

	private static final class DigFaultHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output(final Object param) {
			// Stub
			return " ";
		}
	}

	private static final class LEDHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output(final Object param) {
			String out = PacketTypes.LIGHT_ANIMATION.getPrefix();
			for (int i = 1; i <= 177; i++) {
				out = out + LightAnimation.getState(i).signal;
			}
			return out;
		}
	}

	/**
	 * This is the initialization function for the handler.
	 */
	public void init() {
		network = Global.getNetworkInterface();
	}

	/**
	 * This is the primary step driver for the handler. Call all time-based
	 * functions from here.
	 * 
	 * @param amount
	 *            the amount of time that has passed since the previous frame,
	 *            in seconds
	 */
	public void advance(final float amount) {
		// Retrieve packets
		while (true) {
			final IntelliGridPacket packet = network.retrieveMessage();
			if (packet == null) {
				break;
			}

			String message = null;
			String pre = "";
			PacketTypes type = null;
			for (PacketTypes prefix : PacketTypes.values()) {
				if (packet.message.startsWith(prefix.getPrefix())
						&& prefix.getPrefix().length() > pre.length()) {
					message = packet.message.substring(prefix.getPrefix()
							.length());
					pre = prefix.getPrefix();
					type = prefix;
				}
			}
			if (message == null) {
				continue;
			}

			type.input(message);
		}
	}

	/**
	 * Constructs a packet for the network to send to the model.
	 * 
	 * @param type
	 *            the type of packet to be sending
	 * @param param
	 *            custom parameters for the packet; define individual packet
	 *            code accordingly
	 */
	public static void constructAndSendPacket(final PacketTypes type,
			final Object param) {
		final String out = type.output(param);
		if (out != null && !out.isEmpty()) {
			Global.getNetworkInterface().sendMessage(out);
		}
	}
}
