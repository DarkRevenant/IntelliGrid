package org.sdsu.intelligrid;

import org.sdsu.intelligrid.simulation.Simulation;

import android.app.Activity;

public class Global {
	
	protected static Activity mainActivity;
	protected static Simulation simulation;

	/**
	 * Returns the primary instance of MainActivity for this application.
	 * 
	 * @return This application's Activity, as defined by MainActivity.java.
	 */
	public static Activity getMainActivity() {
		return mainActivity;
	}

	/**
	 * Returns the primary instance of Simulation for this application.
	 * 
	 * @return This application's primary Simulation object, as defined by Simulation.java.
	 */
	public static Simulation getGlobalSimulation() {
		return simulation;
	}
}
