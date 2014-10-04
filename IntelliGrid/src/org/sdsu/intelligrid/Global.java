package org.sdsu.intelligrid;

import org.sdsu.intelligrid.network.MainNetworkInterface;
import org.sdsu.intelligrid.simulation.Simulation;

public class Global {

	protected static MainActivity mainActivity;
	protected static Simulation simulation;
	protected static MainNetworkInterface networkInterface;

	/**
	 * Returns the primary instance of MainActivity for this application.
	 * 
	 * @return this application's Activity, as defined by MainActivity.java.
	 */
	public static MainActivity getMainActivity() {
		return mainActivity;
	}

	/**
	 * Returns the primary instance of Simulation for this application.
	 * 
	 * @return this application's primary Simulation object, as defined by
	 *         Simulation.java.
	 */
	public static Simulation getGlobalSimulation() {
		return simulation;
	}

	/**
	 * Returns the primary instance of MainNetworkInterface for this
	 * application.
	 * 
	 * @return this application's primary network interface object, as defined
	 *         by MainNetworkInterface.java.
	 */
	public static MainNetworkInterface getNetworkInterface() {
		return networkInterface;
	}
}
