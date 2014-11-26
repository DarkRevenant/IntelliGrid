// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid;

import org.sdsu.intelligrid.graphics.MainRenderer;
import org.sdsu.intelligrid.graphics.MainSurfaceView;
import org.sdsu.intelligrid.graphics.ui.MainUI;
import org.sdsu.intelligrid.graphs.GraphsPage;
import org.sdsu.intelligrid.network.MainNetworkHandler;
import org.sdsu.intelligrid.network.NetworkInterface;
import org.sdsu.intelligrid.simulation.Simulation;

import android.content.res.Resources;

/**
 * Container of global variables.
 */
public class Global {

	static MainActivity mainActivity;
	static Simulation simulation;
	static NetworkInterface networkInterface;
	static MainNetworkHandler networkHandler;
	static MainSurfaceView surface;
	static MainRenderer renderer;
	static MainUI mainUI;
	static GraphsPage graphs;

	/**
	 * Returns the primary instance of MainActivity for this application.
	 * 
	 * @return this application's Activity, as defined by MainActivity.java.
	 */
	public static MainActivity getMainActivity() {
		return mainActivity;
	}

	/**
	 * Returns the application's resources structure. Use this any time you need
	 * to access internal files, such as textures.
	 * 
	 * @return this application's Resources.
	 */
	public static Resources getResources() {
		return mainActivity.getResources();
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
	 * Returns the primary instance of NetworkInterface for this application.
	 * 
	 * @return this application's primary network interface object, as defined
	 *         by NetworkInterface.java.
	 */
	public static NetworkInterface getNetworkInterface() {
		return networkInterface;
	}

	/**
	 * Returns the primary instance of MainNetworkHandler for this application.
	 * 
	 * @return this application's primary network handler object, as defined by
	 *         MainNetworkHandler.java.
	 */
	public static MainNetworkHandler getNetworkHandler() {
		return networkHandler;
	}

	/**
	 * Returns the primary instance of GLSurfaceView for this application.
	 * 
	 * @return this application's primary surface object, as defined by
	 *         MainSurfaceView.java.
	 */
	public static MainSurfaceView getSurface() {
		return surface;
	}

	/**
	 * Returns the primary instance of MainRenderer for this application.
	 * 
	 * @return this application's primary renderer object, as defined by
	 *         MainRenderer.java.
	 */
	public static MainRenderer getRenderer() {
		return renderer;
	}

	/**
	 * Returns the primary instance of MainUI for this application.
	 * 
	 * @return this application's primary user interface object, as defined by
	 *         MainUI.java.
	 */
	public static MainUI getMainUI() {
		return mainUI;
	}

	/**
	 * Returns the GraphsPage fragment.
	 * 
	 * @return this application's GraphsPage fragment.
	 */
	public static GraphsPage getGraphFragment() {
		return graphs;
	}
}
