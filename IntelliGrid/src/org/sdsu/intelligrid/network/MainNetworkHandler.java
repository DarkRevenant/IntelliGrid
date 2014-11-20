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

	private static class BasePacketHandler implements PacketHandler {

		@Override
		public void input(final String message) {
		}

		@Override
		public String output(final Object param) {
			return null;
		}
	}

	private static final class SolarGenHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			if (message.length() < 1) {
				return;
			}

			final char code = message.charAt(0);
			final float solarLevel;
			switch (code) {
			case 0:
				solarLevel = 0f;
				break;
			case 1:
				solarLevel = 0.3333333f;
				break;
			case 2:
				solarLevel = 0.6666667f;
				break;
			case 3:
				solarLevel = 1f;
				break;
			default:
				return;
			}

			Global.getGlobalSimulation().data.solarGenerationLevel
					.changeOverTime(solarLevel, 2.0, false);
		}
	}

	private static final class WindTurbineHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			if (message.length() < 1) {
				return;
			}

			final char code = message.charAt(0);
			final double windLevel;
			switch (code) {
			case 0:
				windLevel = 0.0;
				break;
			case 1:
				windLevel = 1.0 / 3.0;
				break;
			case 2:
				windLevel = 2.0 / 3.0;
				break;
			case 3:
				windLevel = 1.0;
				break;
			default:
				return;
			}

			Global.getGlobalSimulation().data.windGenerationLevel
					.changeOverTime(windLevel, 2.0, false);
		}

		// param == integer representing the wind generation level
		@Override
		public String output(final Object param) {
			// This is not called anywhere yet

			final int val = (int) param;
			final String out;
			switch (val) {
			case 0:
				out = "0";
				break;
			case 1:
				out = "1";
				break;
			case 2:
				out = "2";
				break;
			case 3:
				out = "3";
				break;
			default:
				return null;
			}

			return out;
		}
	}

	private static final class BatteryHandler extends BasePacketHandler {

		// param == integer representing the battery storage level
		@Override
		public String output(final Object param) {
			// This is not called anywhere yet

			final int val = (int) param;
			final String out;
			switch (val) {
			case 0:
				out = "0";
				break;
			case 1:
				out = "1";
				break;
			case 2:
				out = "2";
				break;
			case 3:
				out = "3";
				break;
			default:
				return null;
			}

			return out;
		}
	}

	private static final class TimeHandler extends BasePacketHandler {

		// param == boolean; true means night
		@Override
		public String output(final Object param) {
			final boolean night = (boolean) param;
			final String out = night ? "1" : "0";

			return out;
		}
	}

	private static final class ElectricCarHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			// Stub
		}
	}

	private static final class SolarPanelHandler extends BasePacketHandler {

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

	private static final class MylarBalloonHandler extends BasePacketHandler {

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

	private static final class DigFaultHandler extends BasePacketHandler {

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

	private static final class LEDHandler extends BasePacketHandler {

		// param == null
		@Override
		public String output(final Object param) {
			String out = "";
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
			Global.getNetworkInterface().sendMessage(type.getPrefix() + out);
		}
	}
}
