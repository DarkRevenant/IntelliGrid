// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid;

import org.sdsu.intelligrid.graphics.MainRenderer;
import org.sdsu.intelligrid.graphics.MainSurfaceView;
import org.sdsu.intelligrid.graphics.ui.MainUI;
import org.sdsu.intelligrid.network.MainNetworkInterface;
import org.sdsu.intelligrid.simulation.Simulation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * The Activity for the application.
 */
public class MainActivity extends Activity {

	private MainSurfaceView GLView;

	public MainActivity() {
		super();

		Global.mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		final MainRenderer renderer = new MainRenderer();
		Global.renderer = renderer;
		GLView = new MainSurfaceView(this, renderer);
		getWindow().setContentView(GLView);
		Global.surface = GLView;

		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				| View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);

		final Simulation simulation = new Simulation();
		Global.simulation = simulation;

		final MainNetworkInterface networkInterface = new MainNetworkInterface();
		Global.networkInterface = networkInterface;

		final MainUI mainUI = new MainUI();
		Global.mainUI = mainUI;

		simulation.init();
		mainUI.init();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
		super.onStart();

		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				| View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
	}
}
