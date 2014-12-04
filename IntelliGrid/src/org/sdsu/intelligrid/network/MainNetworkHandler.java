// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.network;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.graphics.ui.LightAnimation;

/**
 * Main network handler class for the application.
 */
public class MainNetworkHandler {

	private NetworkInterface network;

	public static enum PacketTypes {

		SOLAR_GENERATION_LEVEL("S", new SolarGenHandler(), 3), WIND_GENERATION_LEVEL(
				"W", new WindTurbineHandler(), 2), BATTERY_STORAGE_LEVEL("B",
				new BatteryHandler(), 2), TIME_OF_DAY("T", new TimeHandler(), 2), POWER_OUTAGE(
				"P", new OutageHandler(), 3), CAR_DETECT("E",
				new ElectricCarHandler(), 3), SOLAR_DETECT("R",
				new SolarPanelHandler(), 3), BALLOON_DETECT_RESET("M",
				new MylarBalloonHandler(), 2), DIG_DETECT_RESET("D",
				new DigFaultHandler(), 2), LIGHT_ANIMATION("L",
				new LEDHandler(), 178);

		private final String prefix;
		private final PacketHandler handler;

		public final int expectedLength;

		private PacketTypes(final String prefix, final PacketHandler handler,
				final int expectedLength) {
			this.prefix = prefix;
			this.handler = handler;
			this.expectedLength = expectedLength;
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
			if (message.length() < 2) {
				return;
			}

			char code = message.charAt(1);
			final double solarLevel;
			switch (code) {
			case '0':
				solarLevel = 0.0;
				break;
			case '1':
				solarLevel = 1.0 / 3.0;
				break;
			case '2':
				solarLevel = 2.0 / 3.0;
				break;
			case '3':
				solarLevel = 1.0;
				break;
			default:
				return;
			}

			code = message.charAt(0);
			switch (code) {
			case '0':
				Global.getGlobalSimulation().data.lowerSolarLevel
						.changeOverTime(solarLevel, 2.0, false);
				break;
			case '1':
				Global.getGlobalSimulation().data.middleSolarLevel
						.changeOverTime(solarLevel, 2.0, false);
				break;
			case '2':
				Global.getGlobalSimulation().data.renewableSolarLevel
						.changeOverTime(solarLevel, 2.0, false);
				break;
			default:
				return;
			}
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
			case '0':
				windLevel = 0.0;
				break;
			case '1':
				windLevel = 1.0 / 3.0;
				break;
			case '2':
				windLevel = 2.0 / 3.0;
				break;
			case '3':
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
			case 4:
				out = "4";
				break;
			case 5:
				out = "5";
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

		// param == boolean; true means night, false means day
		@Override
		public String output(final Object param) {
			final boolean night = (boolean) param;
			final String out = night ? "1" : "0";

			return out;
		}
	}

	public static final class OutageData {

		int load;
		boolean on;

		public OutageData(final int load, final boolean on) {
			this.load = load;
			this.on = on;
		}
	}

	private static final class OutageHandler extends BasePacketHandler {

		// param == OutageData object
		@Override
		public String output(final Object param) {
			final OutageData data = (OutageData) param;
			String out = "";
			if (data.on) {
				out = out + "1";
			} else {
				out = out + "0";
			}

			switch (data.load) {
			case 1:
				out = out + "1";
				break;
			case 2:
				out = out + "2";
				break;
			case 3:
				out = out + "3";
				break;
			case 4:
				out = out + "4";
				break;
			case 5:
				out = out + "5";
				break;
			case 6:
				out = out + "6";
				break;
			default:
				return null;
			}

			return out;
		}
	}

	private static final class ElectricCarHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			if (message.length() < 2) {
				return;
			}

			char code = message.charAt(1);
			final double state;
			switch (code) {
			case '0':
				state = 0.0;
				break;
			case '1':
				state = 1.0;
				break;
			default:
				return;
			}

			code = message.charAt(0);
			switch (code) {
			case '0':
				Global.getGlobalSimulation().data.electricVehicleL1
						.changeOverTime(state, 1.0, false);
				break;
			case '1':
				Global.getGlobalSimulation().data.electricVehicleL2
						.changeOverTime(state, 1.0, false);
				break;
			case '2':
				Global.getGlobalSimulation().data.electricVehicleL3
						.changeOverTime(state, 1.0, false);
				break;
			default:
				return;
			}
		}
	}

	private static final class SolarPanelHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			if (message.length() < 2) {
				return;
			}

			char code = message.charAt(1);
			final double state;
			switch (code) {
			case '0':
				state = 0.0;
				break;
			case '1':
				state = 1.0;
				break;
			default:
				return;
			}

			code = message.charAt(0);
			switch (code) {
			case '0':
				Global.getGlobalSimulation().data.solarPanelM1.changeOverTime(
						state, 1.0, false);
				break;
			case '1':
				Global.getGlobalSimulation().data.solarPanelM2.changeOverTime(
						state, 1.0, false);
				break;
			case '2':
				Global.getGlobalSimulation().data.solarPanelL1.changeOverTime(
						state, 1.0, false);
				break;
			case '3':
				Global.getGlobalSimulation().data.solarPanelL2.changeOverTime(
						state, 1.0, false);
				break;
			case '4':
				Global.getGlobalSimulation().data.solarPanelL3.changeOverTime(
						state, 1.0, false);
				break;
			default:
				return;
			}
		}
	}

	private static final class MylarBalloonHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			Global.getGlobalSimulation().faultManager.startBalloonFault();
		}

		// param == boolean; true means start fault, false means end fault
		@Override
		public String output(final Object param) {
			final boolean start = (boolean) param;
			final String out = start ? "1" : "0";

			return out;
		}
	}

	private static final class DigFaultHandler extends BasePacketHandler {

		@Override
		public void input(final String message) {
			Global.getGlobalSimulation().faultManager.startDigFault();
		}

		// param == boolean; true means start fault, false means end fault
		@Override
		public String output(final Object param) {
			final boolean start = (boolean) param;
			final String out = start ? "1" : "0";

			return out;
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

	private String partialMessage = "";

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

			String packetMessage = partialMessage + packet.message;
			Logger.getGlobal().log(Level.INFO,
					"Parsing packet: " + packetMessage);
			partialMessage = "";

			while (true) {
				String message = null;
				PacketTypes type = null;
				for (PacketTypes prefix : PacketTypes.values()) {
					if (packetMessage.startsWith(prefix.getPrefix())) {
						if (packetMessage.length() < prefix.expectedLength) {
							partialMessage = packetMessage;
							Logger.getGlobal().log(
									Level.INFO,
									"Message broken between lines (done parsing): "
											+ partialMessage);
							break;
						} else {
							message = packetMessage.substring(prefix
									.getPrefix().length(),
									prefix.expectedLength);
							Logger.getGlobal().log(Level.INFO,
									"Parsing message: " + message);
						}
						type = prefix;
						if (packetMessage.length() <= prefix.expectedLength) {
							packetMessage = null;
						} else {
							packetMessage = packetMessage
									.substring(prefix.expectedLength);
						}
					}
				}
				if (message == null) {
					break;
				}

				Logger.getGlobal().log(Level.INFO,
						"Running input type " + type.name());
				type.input(message);

				if (packetMessage == null || packetMessage.isEmpty()) {
					Logger.getGlobal().log(Level.INFO, "Done parsing");
					break;
				}
				Logger.getGlobal().log(Level.INFO,
						"Remaining packet: " + packetMessage);
			}
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
		if (out != null && !out.isEmpty()
				&& Global.getNetworkInterface().isConnected()) {
			Global.getNetworkInterface().sendMessage(type.getPrefix() + out);
		}
	}
}
