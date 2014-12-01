// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid;

import org.sdsu.intelligrid.graphics.MainRenderer;
import org.sdsu.intelligrid.graphics.MainSurfaceView;
import org.sdsu.intelligrid.graphics.ui.MainUI;
import org.sdsu.intelligrid.graphs.GraphsPage;
import org.sdsu.intelligrid.network.MainNetworkHandler;
import org.sdsu.intelligrid.network.NetworkInterface;
import org.sdsu.intelligrid.simulation.Simulation;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
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

		final GraphsPage graphs = new GraphsPage();
		FragmentTransaction trans = getFragmentManager().beginTransaction();
		trans.add(graphs, "graphs").commit();
		Global.graphs = graphs;

//        (findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startGraphActivity(GraphsPage.class);
//            }
//        });
//
//    private void startGraphActivity(Class<? extends Activity> activity) {
//        Intent intent = new Intent(MainActivity.this, activity);

		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				| View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);

		final Simulation simulation = new Simulation();
		Global.simulation = simulation;

		final NetworkInterface networkInterface = new NetworkInterface();
		Global.networkInterface = networkInterface;

		final MainNetworkHandler networkHandler = new MainNetworkHandler();
		Global.networkHandler = networkHandler;

		final MainUI mainUI = new MainUI();
		Global.mainUI = mainUI;

		new Thread(networkInterface).start();

		simulation.init();
		networkHandler.init();
		mainUI.init();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();

		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
				| View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
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
