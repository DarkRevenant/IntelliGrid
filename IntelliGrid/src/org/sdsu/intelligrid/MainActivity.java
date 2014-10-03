package org.sdsu.intelligrid;

import org.sdsu.intelligrid.graphics.MainSurfaceView;
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

		GLView = new MainSurfaceView(this);
		setContentView(GLView);
		
		Simulation simulation = new Simulation();
		Global.simulation = simulation;
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
