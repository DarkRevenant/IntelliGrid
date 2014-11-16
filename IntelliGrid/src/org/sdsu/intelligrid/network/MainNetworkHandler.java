// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

import org.sdsu.intelligrid.Global;

/**
 * Main network handler class for the application.
 */
public class MainNetworkHandler {

	private NetworkInterface network;

	private static enum PacketPrefices {

		SOLAR_PANEL("S", new SolarPanelHandler()), WIND_TURBINE("W",
				new WindTurbineHandler()), BATTERY("B", new BatteryHandler()), ELECTRIC_CAR(
				"E", new ElectricCarHandler()), MYLAR_BALLOON("M",
				new MylarBalloonHandler()), DIG_FAULT("D",
				new DigFaultHandler()), LED("L", new LEDHandler()), LCD_DISPLAY(
				"C", new LCDHandler());

		private final String prefix;
		private final PacketHandler handler;

		private PacketPrefices(final String prefix, final PacketHandler handler) {
			this.prefix = prefix;
			this.handler = handler;
		}

		public String getPrefix() {
			return new String(prefix);
		}

		public void input(final String message) {
			handler.input(message);
		}

		public String output() {
			return handler.output();
		}
	}

	private static interface PacketHandler {

		public void input(final String message);

		public String output();
	}

	private static final class SolarPanelHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output() {
			return null;
		}
	}

	private static final class WindTurbineHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output() {
			// Stub
			return " ";
		}
	}

	private static final class BatteryHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output() {
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
		public String output() {
			return null;
		}
	}

	private static final class MylarBalloonHandler implements PacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}

		@Override
		public String output() {
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
		public String output() {
			// Stub
			return " ";
		}
	}

	private static final class LEDHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output() {
			// Stub
			return " ";
		}
	}

	private static final class LCDHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output() {
			// Stub
			return " ";
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
			PacketPrefices type = null;
			for (PacketPrefices prefix : PacketPrefices.values()) {
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
}
