// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.simulation;

import java.util.Arrays;

/**
 * Container for electrical simulation.
 */
public class Simulation {

	public Simulation() {

	}

    public static class SimulationData {
        //Solar
        public static double[] Solar = {0, 0, 0, 0, 0, 0, 0, 0.336, 1, 1.2, 1.4, 1.6, 1.6, 1.6, 1.6, 1.6, 1.4, 1.2, 1, 0.336, 0, 0, 0, 0};

        // Solar Farm
        public static double[] SolarFarm = {0, 0, 0, 0, 0, 0, 0, 0.6014736, 1.7901, 2.14812, 2.50614, 2.86416,
                2.86416, 2.86416, 2.86416, 2.86416, 2.50614, 2.14812, 1.7901, 0.6014736, 0, 0, 0, 0};

        //Wind Farm

        public static double[] WindFarm = {1.68, 1.6945, 1.7584, 1.7895, 1.8452, 1.825, 1.752, 1.325, 0.895, 0.785, 0.6845, 0.6948,
                0.6894, 0.7548, 1.025, 1.2548, 1.458, 1.785, 1.885, 1.96, 1.92, 1.88, 1.84, 1.8};

        // Battery Charge
        public static double[] Battery = {-0.133, -0.267, -0.35, -0.3, -0.25, -0.2, -0.15, -0.1, -0.05, -0.01, -0.01, -0.01,
                -0.01, -0.01, -0.01, -0.01, -0.01, 0.5, 1.3, -0.01, -0.01, -0.01, -0.01, -0.01};

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
        public static double[] ind1 =
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
        public static double[] ind1r =
                {2.54269227, 2.436141356, 2.329590442, 2.271471761, 2.223039528, 2.436625678, 2.644399961, 2.857501789, 3.070603618, 3.283705446, 3.598514965, 3.705065879,
                        3.811616794, 4.024718622, 4.23782045, 4.446079055, 4.660633851, 4.658212239, 4.660149528, 4.339528141, 3.811616794, 3.283705446, 2.964052704, 2.54269227};

        //Electric Vehicles
        double numEV = 1; //number of electric vehicles
        double EV = 1;  //sample number

        //Weather
        double[] weather = {1, .8, .6, .4, .2};
        double w = 0;                    //Sunny to very cloudy

        //Electric Vehicle & Solar Panel Enables
        //On = 1 Off = 0
        double L1EV = 0;
        double L2EV = 0;
        double L3EV = 0;
        //Solar Panel
        double L1SL = 1;
        double L2SL = 1;
        double L3SL = 0;

        //Fault Selection
        String fault = "";

        double capacity = 30;
        
        double timeScale = 100.0; // ex. timeScale 100 = 1 second of application time is 100 seconds of simulation
        
        double time = 12; // in Hours
    }

    public static double linear(final double[] array, double d) {
        while (d > array.length - 1) {
            d -= array.length;
        }
        while (d < 0) {
            d += array.length;
        }
        final int ceil = (int) Math.ceil(d);
        final int floor = (int) Math.floor(d);
        final double lint = d - floor;
        return array[ceil] * lint + array[floor] * (1.0 - lint);
    }

    public SimulationData data;

    /**
     * This is the initialization function for the simulation.
     */
    public void init() {
        data = new SimulationData();
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
        final double amt = (double) amount;

        data.time += amt * data.timeScale / 3600.0;
        final double time = data.time;

        double Load1 = linear(data.res1, time) + (data.L1EV * (data.numEV * data.EV)) - (data.L1SL * (linear(data.Solar, time) * linear(data.weather, data.w)));
        /*double Load2 = res2[i] + (L2EV * (numEV * EV)) - (L2SL * (Solar[i] * weather[w]));
        double Load3 = res3[i] + (L3EV * (numEV * EV)) - (L3SL * (Solar[i] * weather[w]));
        double Load6 = ind1[i];
        double Load4 = comm2[i];
        double Load5 = comm1[i];


        double trB = Math.sqrt((Load1 * Load1) + (res1r[i] * res1r[i])) / capacity;
        double trD = Math.sqrt((Load2 * Load2) + (res2r[i] * res2r[i])) / capacity;
        double trE = Math.sqrt((Load3 * Load3) + (res3r[i] * res3r[i])) / capacity;
        double trF = Math.sqrt((Load3 * Load3) + (res3r[i] * res3r[i])) / capacity;
        double trH = Math.sqrt((Load4 * Load4) + (comm2r[i] * comm2r[i])) / capacity;
        double trI = Math.sqrt((Load4 * Load4) + (comm2r[i] * comm2r[i])) / capacity;
        double trJ = Math.sqrt((Load5 * Load5) + (comm1r[i] * comm1r[i])) / capacity;
        double trL = Math.sqrt((Load6 * Load6) + (ind1r[i] * ind1r[i])) / capacity;

        double trG = 0;

        double trC = trD + trE;
        double trA = trB + trC;
        double trK = trI + trJ;
        double trM = trK + trL;
        double transTotal = (trA + trM) * capacity;

        if (fault.equals("A")) {

            trG = trE + trF;
            trC = trB;
            trE = trD + trC;
            trA = 0;
            trI = trH + trG;
            trK = trI + trJ;
            trM = trK + trL;
        }
        if (fault == "B") {
            Load1 = 0;
            res1r[i] = 0;
            trB = 0;
            trC = trD + trE;
            trA = trB + trC;
            trK = trI + trJ;
            trM = trK + trL;
            transTotal = (trA + trM) * capacity;
        }
        if (fault == "C") {
            trG = trE + trF;
            trC = 0;
            trE = trD;
            trA = trB + trC;
            trI = trH + trG;
            trK = trI + trJ;
            trM = trK + trL;
        }
        if (fault == "D") {
            Load2 = 0;
            res2r[i] = 0;
            trD = 0;
            trC = trD + trE;
            trA = trB + trC;
            trK = trI + trJ;
            trM = trK + trL;
            transTotal = (trA + trM) * capacity;
        }
        if (fault == "E") {
            trE = 0;
            trG = trE + trF;
            trC = trD;
            trA = trB + trC;
            trI = trH + trG;
            trK = trI + trJ;
            trM = trK + trL;
        }
        if (fault == "F") {
            Load3 = 0;
            res3r[i] = 0;
            trF = 0;
            trC = trD + trE;
            trA = trB + trC;
            trK = trI + trJ;
            trM = trK + trL;
            transTotal = (trA + trM) * capacity;
        }
        if (fault == "H") {
            Load4 = 0;
            comm2r[i] = 0;
            trH = 0;
            trC = trD + trE;
            trA = trB + trC;
            trK = trI + trJ;
            trM = trK + trL;
            transTotal = (trA + trM) * 28;
        }
        if (fault == "I") {
            trI = 0;
            trG = trH;
            trE = trF + trG;
            trC = trD + trE;
            trA = trB + trC;
            trK = trJ;
            trM = trK + trL;
        }
        if (fault == "J") {
            Load5 = 0;
            comm1r[i] = 0;
            trJ = 0;
            trC = trD + trE;
            trA = trB + trC;
            trK = trI + trJ;
            trM = trK + trL;
            transTotal = (trA + trM) * capacity;
        }
        if (fault == "K") {

            trG = trI + trH;
            trE = trF + trG;
            trC = trD + trE;
            trA = trB + trC;
            trI = trJ;
            trK = 0;
            trM = trK + trL;
        }
        if (fault == "L") {
            Load6 = 0;
            ind1r[i] = 0;
            trL = 0;
            trC = trD + trE;
            trA = trB + trC;
            trK = trI + trJ;
            trM = trK + trL;
            transTotal = (trA + trM) * capacity;
        }

        if (fault == "M") {

            trG = trH + trI;
            trE = trF + trG;
            trC = trD + trE;
            trA = trB + trC;
            trI = trJ + trK;
            trK = trL;
            trM = 0;
        }

        double SolFarm = SolarFarm[i] * weather[w];
        double SDGE = transTotal - SolFarm - WindFarm[i] + Battery[i];*/
	}
}



