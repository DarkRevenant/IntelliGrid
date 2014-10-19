package org.sdsu.intelligrid;

import java.util.ArrayList;
import java.util.List;

import org.sdsu.intelligrid.graphics.MainRenderer;
import org.sdsu.intelligrid.graphics.MainSurfaceView;
import org.sdsu.intelligrid.network.MainNetworkInterface;
import org.sdsu.intelligrid.simulation.Simulation;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

	private GLSurfaceView GLView;

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
		setContentView(GLView);

		final Simulation simulation = new Simulation();
		Global.simulation = simulation;

		final MainNetworkInterface networkInterface = new MainNetworkInterface();
		Global.networkInterface = networkInterface;

		// Test
		final List<Integer> resources = new ArrayList<>();
		resources.add(org.sdsu.intelligrid.R.drawable.dominator);
		Global.getRenderer().loadTextures(resources);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}
}
