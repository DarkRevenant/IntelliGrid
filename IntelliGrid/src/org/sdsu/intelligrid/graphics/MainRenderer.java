package org.sdsu.intelligrid.graphics;

import java.util.concurrent.TimeUnit;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.sdsu.intelligrid.Global;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

public class MainRenderer implements GLSurfaceView.Renderer {

	public void onSurfaceCreated(GL10 unused, EGLConfig config) {
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	}

	private long lastms;

	private static final int FRAME_RATE = 63; // maximum frames per second, set
												// slightly higher than 60
												// because we're rebels

	@Override
	public void onDrawFrame(GL10 unused) {
		long beginms, endms, leftms;

		beginms = System.currentTimeMillis();

		float amount = (float) (beginms - lastms) / 1000f;

		Global.getGlobalSimulation().advance(amount);
		draw(amount);

		lastms = beginms;

		endms = System.currentTimeMillis() - beginms;

		leftms = (1000L / FRAME_RATE) - endms;

		// avoid spinning
		if (leftms < 5) {
			leftms = 5;
		}

		try {
			TimeUnit.MILLISECONDS.sleep(leftms);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {
		GLES20.glViewport(0, 0, width, height);
	}

	private void draw(float amount) {
		// Test
		// Should flash blue and then white for slower frames
		GLES20.glClearColor(Math.min(amount, 1f), Math.min(amount * 2f, 1f),
				Math.min(amount * 3f, 1f), 1.0f);
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
	}
}
