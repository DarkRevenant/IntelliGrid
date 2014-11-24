// Copyright 2014 Edmond Basilan, all rights reserved

package org.sdsu.intelligrid.simulation;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.network.MainNetworkHandler;
import org.sdsu.intelligrid.network.MainNetworkHandler.PacketTypes;


/**
 * Container for electrical simulation.
 */
public class Simulation {

    public static class SimulationData {
        //Solar Panels
        public static double[] Solar = {0, 0, 0, 0, 0, 0, 0, 0.336, 1, 1.2, 1.4, 1.6, 1.6, 1.6, 1.6, 1.6, 1.4, 1.2, 1, 0.336, 0, 0, 0, 0};

        // Power Plant
        public static double[] PowerPlant = {0, 0, 0, 0, 0, 0, 0, 0.6014736, 1.7901, 2.14812, 2.50614, 2.86416,
                2.86416, 2.86416, 2.86416, 2.86416, 2.50614, 2.14812, 1.7901, 0.6014736, 0, 0, 0, 0};

        //Wind Farm
        public static double[] WindFarm = {1.68, 1.6945, 1.7584, 1.7895, 1.8452, 1.825, 1.752, 1.325, 0.895, 0.785, 0.6845, 0.6948,
                0.6894, 0.7548, 1.025, 1.2548, 1.458, 1.785, 1.885, 1.96, 1.92, 1.88, 1.84, 1.8};

        // Battery Charge
        public static double[] Battery = {-0.133, -0.267, -0.35, -0.3, -0.25, -0.2, -0.15, -0.1, -0.05, -0.01, -0.01, -0.01,
                -0.01, -0.01, -0.01, -0.01, -0.01, 0.5, 1.3, -0.01, -0.01, -0.01, -0.01, -0.01};
        
        // Need battery storage level array

        //REAL POWER
        public static double[] res1 =
                {1.2656, 1.125, 1.1025, 1.121, 1.211, 1.2014, 1.425, 1.755, 2.01254, 1.8544, 1.548, 1.3548,
                        1.3215, 1.3345, 1.364, 1.548, 1.654, 2.54414, 2.9945, 2.854, 2.548, 2.15, 1.854, 1.2894};
        public static double[] res2 =
                {1.39216, 1.3, 1.21275, 1.2331, 1.3321, 1.41, 1.5675, 2.015, 2.1045, 1.854, 1.648, 1.49028,
                        1.45365, 1.46795, 1.398, 1.7028, 2.015, 2.798554, 3.29395, 3.321, 2.8028, 2.365, 1.895, 1.41834};
        public static double[] res3 =
                {1.07576, 0.95625, 0.937125, 1.02, 1.02935, 1.02119, 1.295, 1.589, 1.786, 1.57624, 1.256, 1.15158,
                        1.123275, 1.134325, 1.1594, 1.258, 1.4059, 2.228, 2.598, 2.625, 2.354, 1.8275, 1.5759, 1.09599};
        public static double[] comm1 =
                {2.996, 3, 2.978, 2.98, 3, 3.08, 3.458, 4.85, 5.48, 5.558, 5.548, 5.485,
                        5.684, 5.642, 5.584, 5.897, 5.684, 5.485, 4.85, 3.56, 3.46, 3.458, 3.18, 3.08};
        public static double[] comm2 =
                {3.35552, 3.334, 3.33536, 3.1845, 3.36, 3.458, 3.778, 5.489, 6.1376, 5.895, 6.21376, 6.0158, 6.36608,
                        6.284, 5.845, 6.458, 6.36608, 5.89, 6.015, 3.9872, 3.602, 3.598, 3.5616, 3.4496};
        public static double[] comm3 =
                {5.25, 5.03, 4.81, 4.69, 4.59, 5.031, 5.46, 5.9, 6.34, 6.78, 7.43, 7.65, 7.87, 8.31,
                        8.75, 9.18, 9.623, 9.618, 9.622, 8.96, 7.87, 6.78, 6.12, 5.25};

        //REACTIVE POWER
        public static double[] res1r =
                {0.6129583499, 0.5448626293, 0.5339653767, 0.54292534, 0.5865143503, 0.5818648559, 0.6901593305, 0.8499857018, 0.9747180765, 0.8981273421, 0.749730978, 0.6561599024, 0.6400319686,
                        0.646328159, 0.6606156679, 0.749730978, 0.8010691457, 1.232183831, 1.450303239, 1.38225595, 1.234053315, 1.041293025, 0.8979336131, 0.6244852216};
        public static double[] res2r =
                {0.6742541849, 0.6296190383, 0.5873619144, 0.597217874, 0.6451657854, 0.6828944954, 0.7591752635, 0.9759095094, 1.019256359, 0.8979336131, 0.7981632117, 0.7217758927,
                        0.7040351655, 0.7109609749, 0.6770826274, 0.8247040758, 0.9759095094, 1.355402214, 1.595333563, 1.608434482, 1.357458647, 1.145422327, 0.917790829, 0.6869337437};

        public static double[] res3r =
                {0.5210145975, 0.4631332349, 0.4538705702, 0.4940087839, 0.4985371978, 0.4945851275, 0.6271974267, 0.7695881938, 0.8649996942, 0.7634082408, 0.6083088555, 0.5577359171,
                        0.5440271733, 0.5493789351, 0.5615233177, 0.6092775002, 0.6809087739, 1.079070167, 1.258269432, 1.271346135, 1.140094782, 0.8850990712, 0.7632435712, 0.5308124383};
        public static double[] comm1r =
                {1.451029722, 1.452967012, 1.44231192, 1.443280565, 1.452967012, 1.491712799, 1.674786642, 2.348963335, 2.654086408, 2.69186355, 2.687020327, 2.656508019,
                        2.752888165, 2.732546626, 2.704455931, 2.856048822, 2.752888165, 2.656508019, 2.348963335, 1.72418752, 1.675755287, 1.674786642, 1.540145032, 1.491712799};
        public static double[] comm2r =
                {1.625153289, 1.614730672, 1.615389351, 1.542324483, 1.627323053, 1.674786642, 1.82976979, 2.658445309, 2.972576777, 2.855080178, 3.009462766, 2.913586316,
                        3.083234744, 3.043481567, 2.830864061, 3.127753654, 3.083234744, 2.852658566, 2.913198858, 1.931090023, 1.744529059, 1.742591769, 1.724962436, 1.670718334};
        public static double[] comm3r =
                {2.54269227, 2.436141356, 2.329590442, 2.271471761, 2.223039528, 2.436625678, 2.644399961, 2.857501789, 3.070603618, 3.283705446, 3.598514965, 3.705065879,
                        3.811616794, 4.024718622, 4.23782045, 4.446079055, 4.660633851, 4.658212239, 4.660149528, 4.339528141, 3.811616794, 3.283705446, 2.964052704, 2.54269227};
        
        //Electric Vehicles
        public double EV = 1;  //electric vehicle load (per vehicle)

        //Weather for Solar Panels
        public static double[] weather = {1, .8, .6, .4, .2}; //Sunny to cloudy
        public double w = 0;

        //Fault Selection
        public String fault = "";

        //Transformer Capacity
        public double capacity = 30;

        //Time Scale
        public double timeScale = 500.0; // ex. timeScale 100 = 1 second of application time is 100 seconds of simulation
        public double time = 0; // in Hours

        //Solar Multipliers (set by model)
        public MutableValue renewableSolarLevel = new MutableValue(1.0);
        public MutableValue lowerSolarLevel = new MutableValue(1.0);
        public MutableValue middleSolarLevel = new MutableValue(1.0);
        
        //Solar Enables (set by model)
        // todo: add UI control to add/remove (only if model is not connected)
        public MutableValue solarPanelM1 = new MutableValue(1.0);
        public MutableValue solarPanelM2 = new MutableValue(0.0);
        public MutableValue solarPanelL1 = new MutableValue(1.0);
        public MutableValue solarPanelL2 = new MutableValue(0.0);
        public MutableValue solarPanelL3 = new MutableValue(0.0);
        
        //Wind Turbine Multiplier (set by model)
        // todo: add UI control
        // todo: make model override UI control for a certain period of time
        // todo: make UI control override model for a certain period of time
        public MutableValue windGenerationLevel = new MutableValue(1.0);
        
        //Electric Vehicle Enables (set by model)
        // todo: add UI control (only if model is not connected)
        public MutableValue electricVehicleL1 = new MutableValue(0.0);
        public MutableValue electricVehicleL2 = new MutableValue(0.0);
        public MutableValue electricVehicleL3 = new MutableValue(0.0);
    }

	/**
	 * This allows values to change over time after a one-time function call.
	 * Should be used by the network and the UI. Can be extended to have other
	 * time-based effects.
	 */
	public static class MutableValue {
    	
    	private double time;
    	private double value;
    	
    	private double interpolateStart;
    	private double interpolateEnd;
    	private double interpolateEndTime;
    	private boolean isInterpolating = false;
    	private boolean simulationTimeInterpolation;
    	
    	public MutableValue(final double value) {
    		this.value = value;
    	}
    	
    	public double get() {
    		return value;
    	}
    	
    	public void set(final double value) {
    		this.value = value;
    	}
    	
    	public void changeOverTime(final double toValue, final double time, final boolean simulationTimeInterpolation) {
    		interpolateEndTime = time;
    		this.time = 0f;
    		interpolateStart = value;
    		interpolateEnd = toValue;
    		this.simulationTimeInterpolation = simulationTimeInterpolation;
    		
    		isInterpolating = true;
    	}
    	
    	protected void advance(final double amount, final double hours) {
    		if (!isInterpolating) {
    			return;
    		}
    		
    		if (simulationTimeInterpolation) {
    			time += hours;
    		} else {
    			time += amount;
    		}
    		
    		if (time >= interpolateEndTime) {
    			value = interpolateEnd;
    			isInterpolating = false;
    		} else {
    			final double progress = time / interpolateEndTime;
    			value = interpolateStart * (1.0 - progress) + interpolateEnd * progress;
    		}
    	}
    }
	
	public static final class FaultManager {
		
		public static final double BALLOON_FAULT_TIME = 1.0;
		public static final double DIG_FAULT_TIME = 6.0;
		public static final double GENERIC_FAULT_TIME = 6.0;
		
		public static final double AUTOMATIC_FAULT_TIME = 0.5;
		
		private static final double LOAD_THRESHOLD = 0.95;
		private static final double DESIRED_BUFFER = 0.05;
		
		private String currentFault = "";
		private String genericFault = "";
		private String automaticFault = "";
		private double balloonFaultTimeOut = 0.0;
		private double digFaultTimeOut = 0.0;
		private double genericFaultTimeOut = 0.0;
		
		private double automaticFaultTimeOut = 0.0;
		private boolean automaticFaultOn = false;
		
		private void advance(final double hours) {
			if (balloonFaultTimeOut > 0.0) {
				balloonFaultTimeOut -= hours;
				if (balloonFaultTimeOut <= 0.0) {
					Global.getMainUI().reportBalloonFaultEnded();
					MainNetworkHandler.constructAndSendPacket(PacketTypes.BALLOON_DETECT_RESET, false);
				}
			}
			if (digFaultTimeOut > 0.0) {
				digFaultTimeOut -= hours;
				if (digFaultTimeOut <= 0.0) {
					Global.getMainUI().reportDigFaultEnded();
					MainNetworkHandler.constructAndSendPacket(PacketTypes.DIG_DETECT_RESET, false);
				}
			}
			if (genericFaultTimeOut > 0.0) {
				genericFaultTimeOut -= hours;
				if (genericFaultTimeOut <= 0.0) {
					Global.getMainUI().reportGenericFaultEnded(genericFault);
				}
			}
			if (automaticFaultTimeOut > 0.0) {
				automaticFaultTimeOut -= hours;
			}
			refreshFaultState();
		}
		
		private void refreshFaultState() {
			if (balloonFaultTimeOut > 0.0 && digFaultTimeOut <= 0.0) {
				currentFault = "D";
			} else if (balloonFaultTimeOut <= 0.0 && digFaultTimeOut > 0.0) {
				currentFault = "I";
			} else if (balloonFaultTimeOut > 0.0 && digFaultTimeOut > 0.0) {
				currentFault = "DI";
			} else if (genericFaultTimeOut > 0.0) {
				currentFault = genericFault;
			} else if (currentFault.equals("")) {
				// Check to see if a feeder is overloading
				if (SimInfo.trM > LOAD_THRESHOLD) {
					final double neededPower = (SimInfo.trM - LOAD_THRESHOLD) + DESIRED_BUFFER;
					if (SimInfo.Load6 >= neededPower && SimInfo.Load6 >= SimInfo.Load4 && SimInfo.Load6 >= SimInfo.Load5) {
						// Less important
						currentFault = "L";
					} else if (SimInfo.Load5 >= neededPower && SimInfo.Load5 >= SimInfo.Load4 && SimInfo.Load5 >= SimInfo.Load6) {
						currentFault = "J";
					} else if (SimInfo.Load4 >= neededPower && SimInfo.Load4 >= SimInfo.Load5 && SimInfo.Load4 >= SimInfo.Load6) {
						// More important
						currentFault = "H";
					} else {
						// The line is well and truly screwed
						// Can't open a tie because that will just strain the other line to the breaking point
						// Just have to shut down the commercial line; power outage!
						currentFault = "LKI";
					}
					automaticFaultTimeOut = AUTOMATIC_FAULT_TIME;
					automaticFault = currentFault;
					automaticFaultOn = true;
					Global.getMainUI().reportAutomaticFaultStarted(automaticFault);
				} else if (SimInfo.trA > LOAD_THRESHOLD) {
					final double neededPower = (SimInfo.trA - LOAD_THRESHOLD) + DESIRED_BUFFER;
					if (SimInfo.Load3 >= neededPower && SimInfo.Load3 >= SimInfo.Load1 && SimInfo.Load3 >= SimInfo.Load2) {
						// Less important
						currentFault = "F";
					} else if (SimInfo.Load2 >= neededPower && SimInfo.Load2 >= SimInfo.Load1 && SimInfo.Load2 >= SimInfo.Load3) {
						currentFault = "D";
					} else if (SimInfo.Load1 >= neededPower && SimInfo.Load1 >= SimInfo.Load2 && SimInfo.Load1 >= SimInfo.Load3) {
						// More important
						currentFault = "B";
					} else {
						// The line is well and truly screwed
						// Can't open a tie because that will just strain the other line to the breaking point
						// Just have to shut down the residential line; power outage!
						currentFault = "ACE";
					}
					automaticFaultTimeOut = AUTOMATIC_FAULT_TIME;
					automaticFault = currentFault;
					automaticFaultOn = true;
					Global.getMainUI().reportAutomaticFaultStarted(automaticFault);
				} else {
					// In this scenario, it's impossible for any particular node to draw more power than the two feeders from the substation
					// Therefore, if neither A or M are at the threshold, no automatic fault can occur
					currentFault = "";
					if (automaticFaultOn) {
						automaticFaultOn = false;
						Global.getMainUI().reportAutomaticFaultEnded(automaticFault);
					}
				}
			} else {
				// Simplify matters by periodically testing the waters to see what happens
				if (automaticFaultTimeOut <= 0.0) {
					currentFault = "";
				}
			}
		}
		
		public String getCurrentFault() {
			return currentFault;
		}
		
		public void startBalloonFault() {
			balloonFaultTimeOut = BALLOON_FAULT_TIME;
			Global.getMainUI().reportBalloonFaultStarted();
			refreshFaultState();
		}
		
		public void startDigFault() {
			digFaultTimeOut = DIG_FAULT_TIME;
			Global.getMainUI().reportDigFaultStarted();
			refreshFaultState();
		}
		
		public void startGenericFault(final String location) {
			genericFaultTimeOut = GENERIC_FAULT_TIME;
			genericFault = location;
			refreshFaultState();
		}
		
		public boolean isBalloonFaultOngoing() {
			return balloonFaultTimeOut > 0.0;
		}
		
		public boolean isDigFaultOngoing() {
			return digFaultTimeOut > 0.0;
		}
		
		public boolean isGenericFaultOngoing() {
			return genericFaultTimeOut > 0.0;
		}
	}

    public static double linear(final double[] array, double d) {
        final int ceil = (int) Math.ceil(d) % array.length;
        final int floor = (int) Math.floor(d) % array.length;
        final double lint = d - floor;
        return array[ceil] * lint + array[floor] * (1.0 - lint);
    }

    public SimulationData data;
    public FaultManager faultManager;
    
    private boolean hasConnectionBeenMade = false;

    /**
     * This is the initialization function for the simulation.
     */
    public void init() {
        data = new SimulationData();
        faultManager = new FaultManager();
    }

    /**
     * This is the primary step driver for the simulation. Call all time-based
     * functions from here.
     *
     * @param amount
     *            the amount of time that has passed since the previous frame,
     *            in seconds
     */
    public void advance(final float amount) {
        final double hours = (double) amount * data.timeScale / 3600.0;

        data.time += hours;
        double time = data.time;
        if (data.time >= 24.0) {
            data.time -= 24.0;
            time = data.time;
        }
        
        // Fault management
    	faultManager.advance(amount);
        data.fault = faultManager.getCurrentFault();
        
        // Time of Day packet (sent on day/night switch)
        if (data.time >= 6.0 && data.time - hours < 6.0) {
        	MainNetworkHandler.constructAndSendPacket(PacketTypes.TIME_OF_DAY, false);
        } else if (data.time >= 18.0 && data.time - hours < 18.0) {
        	MainNetworkHandler.constructAndSendPacket(PacketTypes.TIME_OF_DAY, true);
        }

        // Time of Day packet (sent on connect)
        if (Global.getNetworkInterface().isConnected() && !hasConnectionBeenMade) {
        	hasConnectionBeenMade = true;
            if (data.time >= 6.0 && data.time < 18.0) {
            	MainNetworkHandler.constructAndSendPacket(PacketTypes.TIME_OF_DAY, false);
            } else {
            	MainNetworkHandler.constructAndSendPacket(PacketTypes.TIME_OF_DAY, true);
            }
        } else if (!Global.getNetworkInterface().isConnected() && hasConnectionBeenMade) {
        	hasConnectionBeenMade = false;
        }

        // Update mutable values (do not touch)
        data.renewableSolarLevel.advance(amount, hours);
        data.lowerSolarLevel.advance(amount, hours);
        data.middleSolarLevel.advance(amount, hours);
        data.solarPanelM1.advance(amount, hours);
        data.solarPanelM2.advance(amount, hours);
        data.solarPanelL1.advance(amount, hours);
        data.solarPanelL2.advance(amount, hours);
        data.solarPanelL3.advance(amount, hours);
        data.windGenerationLevel.advance(amount, hours);
        data.electricVehicleL1.advance(amount, hours);
        data.electricVehicleL2.advance(amount, hours);
        data.electricVehicleL3.advance(amount, hours);

        double Load1 = linear(SimulationData.res1, time);
        double Load2 = linear(SimulationData.res2, time) - ((data.solarPanelM1.get() + data.solarPanelM2.get()) * (linear(SimulationData.Solar, time) * data.middleSolarLevel.get() * linear(SimulationData.weather, data.w)));
        double Load3 = linear(SimulationData.res3, time) + ((data.electricVehicleL1.get() + data.electricVehicleL2.get() + data.electricVehicleL3.get()) * data.EV) - ((data.solarPanelL1.get() + data.solarPanelL2.get() + data.solarPanelL3.get()) * (linear(SimulationData.Solar, time) * data.lowerSolarLevel.get() * linear(SimulationData.weather, data.w)));
        double Load4 = linear(SimulationData.comm2, time);
        double Load5 = linear(SimulationData.comm1, time);
        double Load6 = linear(SimulationData.comm3, time);

        double Load1r = linear(SimulationData.res1r, time);
        double Load2r = linear(SimulationData.res2r, time);
        double Load3r = linear(SimulationData.res3r, time);
        double Load4r = linear(SimulationData.comm2r, time);
        double Load5r = linear(SimulationData.comm1r, time);
        double Load6r = linear(SimulationData.comm3r, time);

        double Load1a = Math.sqrt((Load1 * Load1) + (linear(SimulationData.res1r, time) * linear(SimulationData.res1r, time)));
        double Load2a = Math.sqrt((Load2 * Load2) + (linear(SimulationData.res2r, time) * linear(SimulationData.res2r, time)));
        double Load3a = Math.sqrt((Load3 * Load3) + (linear(SimulationData.res3r, time) * linear(SimulationData.res3r, time)));
        double Load4a = Math.sqrt((Load4 * Load4) + (linear(SimulationData.comm2r, time) * linear(SimulationData.comm2r, time)));
        double Load5a = Math.sqrt((Load5 * Load5) + (linear(SimulationData.comm1r, time) * linear(SimulationData.comm1r, time)));
        double Load6a = Math.sqrt((Load6 * Load6) + (linear(SimulationData.comm3r, time) * linear(SimulationData.comm3r, time)));


        double trB = Load1a / data.capacity * Math.signum(Load1);
        double trD = Load2a / data.capacity * Math.signum(Load2);
        double trF = Load3a / data.capacity * Math.signum(Load3);
        double trH = Load4a / data.capacity * Math.signum(Load4);
        double trJ = Load5a / data.capacity * Math.signum(Load5);
        double trL = Load6a / data.capacity * Math.signum(Load6);

        double trG = 0;

        double trE = trF;
        double trI = trJ;
        double trC = trD + trE;
        double trA = trB + trC;
        double trK = trI + trJ;
        double trM = trK + trL;
        
        int swiABC = 0;
        int swiCDE = 0;
        int swiEFG = 3;
        int swiIHG = 3;
        int swiKJI = 0;
        int swiMLK = 0;
        boolean traB = false;
        boolean traD = false;
        boolean traF = false;
        boolean traH = false;
        boolean traJ = false;
        boolean traL = false;
        boolean tieG = true;
        
        if (data.fault.isEmpty() || data.fault.equals("")) {
        	if (trB <= 0 && trD <= 0 && trF <= 0) {
        		trA = 0;
        		trB = 0;
        		trC = 0;
        		trD = 0;
        		trE = 0;
        		trF = 0;
        	}
        }

       //Fault between Substation and Load1/Residential1
        if (data.fault.equals("A")) {
            trG = -trE - trF;
            trC = -trB;
            trE = -trD + trC;
            trA = 0;
            trI = trH - trG;
            trK = trI + trJ;
            trM = trK + trL;
            swiABC = 1;
            swiEFG = 0;
            swiIHG = 0;
            tieG = false;
        }
        //Fault at Load1/Residential1
        if (data.fault.equals("B")) {
            Load1 = 0;
            Load1r = 0;
            Load1a = 0;
            trB = 0;
            trC = trD + trE;
            if (trC <= 0) {
            	trC = 0;
            }
            trA = trC;
            if (trD <= 0 && trF <= 0) {
            	trD = 0;
            	trE = 0;
            	trF = 0;
            }
            swiABC = 2;
            traB = true;
        }
        //Fault between Load1/Residential1 and Load2/Residential2
        if (data.fault.equals("C")) {
            trG = -trE - trF;
            trC = 0;
            trE = -trD;
            if (trB <= 0) {
                trB = 0;
            }
            trA = trB;
            trI = trH - trG;
            trK = trI + trJ;
            trM = trK + trL;
            swiABC = 3;
            swiCDE = 1;
            swiEFG = 0;
            swiIHG = 0;
            tieG = false;
        }
        //Fault at Load2/Residential2
        if (data.fault.equals("D")) {
            Load2 = 0;
            Load2r = 0;
            Load2a = 0;
            trD = 0;
            if (trB <= 0 && trF <= 0) {
            	trB = 0;
            	trE = 0;
            	trF = 0;
            }
            trC = trE;
            trA = trB + trC;
            swiCDE = 2;
            traD = true;
        }
        //Mylar balloon and dig fault together
        if (data.fault.equals("DI")) {
            Load2 = 0;
            Load2r = 0;
            Load2a = 0;
            trD = 0;
            trI = 0;
            trG = trH;
            trE = trF + trG;
            trC = trE;
            trA = trB + trC;
            trK = trJ;
            trM = trK + trL;
            swiCDE = 2;
            swiKJI = 3;
            swiIHG = 1;
            traD = true;
            tieG = false;
        }
        //Fault between Load2/Residential2 and Load3/Residential3
        if (data.fault.equals("E")) {
            trE = 0;
            trG = -trF;
            if (trB <= 0 && trD <= 0) {
            	trB = 0;
            	trD = 0;
            }
            trC = trD;
            trA = trB + trC;
            trI = trH + trG;
            trK = trI + trJ;
            trM = trK + trL;
            swiCDE = 3;
            swiEFG = 1;
            swiIHG = 0;
            tieG = false;
        }
        //Fault at Load3/Residential3
        if (data.fault.equals("F")) {
            Load3 = 0;
            Load3r = 0;
            Load3a = 0;
            trF = 0;
            trE = 0;
            if (trB <= 0 && trD <= 0) {
            	trB = 0;
            	trD = 0;
            }
            trC = trD;
            trA = trB + trC;
            swiEFG = 2;
            traF = true;
        }
        //Residential line off
        if (data.fault.equals("ACE")) {
            Load1 = 0;
            Load1r = 0;
            Load1a = 0;
            Load2 = 0;
            Load2r = 0;
            Load2a = 0;
            Load3 = 0;
            Load3r = 0;
            Load3a = 0;
			trA = 0;
			trB = 0;
			trC = 0;
			trD = 0;
			trE = 0;
			trF = 0;
			swiABC = 4;
			swiCDE = 4;
			swiEFG = 4;
        }
        //Fault at Load4/Commercial2
        if (data.fault.equals("H")) {
            Load4 = 0;
            Load4r = 0;
            Load4a = 0;
            trH = 0;
            trI = 0;
        	if (trB <= 0 && trD <= 0 && trF <= 0) {
        		trA = 0;
        		trB = 0;
        		trC = 0;
        		trD = 0;
        		trE = 0;
        		trF = 0;
        	}
            trK = trI + trJ;
            trM = trK + trL;
            swiIHG = 2;
            traH = true;
        }
        //Fault between Load4/Commercial1 and Load5/Commercial2
        if (data.fault.equals("I")) {
            trI = 0;
            trG = trH;
            trE = trF + trG;
            trC = trD + trE;
            trA = trB + trC;
            trK = trJ;
            trM = trK + trL;
            swiEFG = 0;
            swiKJI = 3;
            swiIHG = 1;
            tieG = false;
        }
        //Fault at Load5/Commercial1
        if (data.fault.equals("J")) {
            Load5 = 0;
            Load5r = 0;
            Load5a = 0;
            trJ = 0;
        	if (trB <= 0 && trD <= 0 && trF <= 0) {
        		trA = 0;
        		trB = 0;
        		trC = 0;
        		trD = 0;
        		trE = 0;
        		trF = 0;
        	}
            trK = trI;
            trM = trK + trL;
            swiKJI = 2;
            traJ = true;
        }
        //Fault between Load5/Commercial1 and Load6/Industrial1
        if (data.fault.equals("K")) {
            trI = -trJ;
            trG = -trI + trH;
            trE = trF + trG;
            trC = trD + trE;
            trA = trB + trC;
            trK = 0;
            trM = trL;
            swiEFG = 0;
            swiIHG = 0;
            swiMLK = 3;
            swiKJI = 1;
            tieG = false;
        }
        //Fault at Load6/Industrial1
        if (data.fault.equals("L")) {
            Load6 = 0;
            Load6r = 0;
            Load6a = 0;
            trL = 0;
        	if (trB <= 0 && trD <= 0 && trF <= 0) {
        		trA = 0;
        		trB = 0;
        		trC = 0;
        		trD = 0;
        		trE = 0;
        		trF = 0;
        	}
            trK = trI + trJ;
            trM = trK;
            swiMLK = 2;
            traL = true;
        }
        //Fault between Load6/Industrial1 and Substation
        if (data.fault.equals("M")) {
            trK = -trL;
            trI = -trJ + trK;
            trG = trH - trI;
            trE = trF + trG;
            trC = trD + trE;
            trA = trB + trC;
            trM = 0;
            swiEFG = 0;
            swiIHG = 0;
            swiMLK = 1;
            tieG = false;
        }
        //Commercial line off
        if (data.fault.equals("MKI")) {
            Load4 = 0;
            Load4r = 0;
            Load4a = 0;
            Load5 = 0;
            Load5r = 0;
            Load5a = 0;
            Load6 = 0;
            Load6r = 0;
            Load6a = 0;
			trM = 0;
			trL = 0;
			trK = 0;
			trJ = 0;
			trI = 0;
			trH = 0;
			swiMLK = 4;
			swiKJI = 4;
			swiIHG = 4;
        }

        double transTotal = (trA + trM) * data.capacity;

        double PowPlant = linear(SimulationData.PowerPlant, time) * linear(SimulationData.weather, data.w) * data.renewableSolarLevel.get();
        double WindTurbines = linear(SimulationData.WindFarm, time) * data.windGenerationLevel.get();
        double BatteryStorage = linear(SimulationData.Battery, time);

        //Total SDGE Power
        double SDGE = transTotal - PowPlant - WindTurbines + BatteryStorage;

        double currentTime = data.time;

        SimInfo.Load1 = Load1;
        SimInfo.Load2 = Load2;
        SimInfo.Load3 = Load3;
        SimInfo.Load4 = Load4;
        SimInfo.Load5 = Load5;
        SimInfo.Load6 = Load6;

        SimInfo.Load1r = Load1r;
        SimInfo.Load2r = Load2r;
        SimInfo.Load3r = Load3r;
        SimInfo.Load4r = Load4r;
        SimInfo.Load5r = Load5r;
        SimInfo.Load6r = Load6r;

        SimInfo.Load1a = Load1a;
        SimInfo.Load2a = Load2a;
        SimInfo.Load3a = Load3a;
        SimInfo.Load4a = Load4a;
        SimInfo.Load5a = Load5a;
        SimInfo.Load6a = Load6a;

        SimInfo.trA = trA;
        SimInfo.trB = trB;
        SimInfo.trC = trC;
        SimInfo.trD = trD;
        SimInfo.trE = trE;
        SimInfo.trF = trF;
        SimInfo.trG = trG;
        SimInfo.trH = trH;
        SimInfo.trI = trI;
        SimInfo.trJ = trJ;
        SimInfo.trK = trK;
        SimInfo.trL = trL;
        SimInfo.trM = trM;

        SimInfo.PowPlant = PowPlant;
        SimInfo.WindTurbines = WindTurbines;
        SimInfo.BatteryStorage = BatteryStorage;
        SimInfo.transTotal = transTotal;
        SimInfo.SDGE = SDGE;
        SimInfo.GenScale = 1.0 / data.capacity;
        SimInfo.currentTime = currentTime;
        
        SimInfo.swiABC = swiABC;
        SimInfo.swiCDE = swiCDE;
        SimInfo.swiEFG = swiEFG;
        SimInfo.swiIHG = swiIHG;
        SimInfo.swiKJI = swiKJI;
        SimInfo.swiMLK = swiMLK;
        SimInfo.traB = traB;
        SimInfo.traD = traD;
        SimInfo.traF = traF;
        SimInfo.traH = traH;
        SimInfo.traJ = traJ;
        SimInfo.traL = traL;
        SimInfo.tieG = tieG;
    }

    public static class SimInfo {
        public static double Load1;
        public static double Load2;
        public static double Load3;
        public static double Load4;
        public static double Load5;
        public static double Load6;

        public static double Load1r;
        public static double Load2r;
        public static double Load3r;
        public static double Load4r;
        public static double Load5r;
        public static double Load6r;

        public static double Load1a;
        public static double Load2a;
        public static double Load3a;
        public static double Load4a;
        public static double Load5a;
        public static double Load6a;

        public static double trA;
        public static double trB;
        public static double trC;
        public static double trD;
        public static double trE;
        public static double trF;
        public static double trG;
        public static double trH;
        public static double trI;
        public static double trJ;
        public static double trK;
        public static double trL;
        public static double trM;

        public static double PowPlant;
        public static double WindTurbines;
        public static double BatteryStorage;
        public static double transTotal;
        public static double SDGE;
        public static double GenScale;
        public static double currentTime;
        
        public static int swiABC;
        public static int swiCDE;
        public static int swiEFG;
        public static int swiIHG;
        public static int swiKJI;
        public static int swiMLK;
        public static boolean traB;
        public static boolean traD;
        public static boolean traF;
        public static boolean traH;
        public static boolean traJ;
        public static boolean traL;
        public static boolean tieG;
    }
}
