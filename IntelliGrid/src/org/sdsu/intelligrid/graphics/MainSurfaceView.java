// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import org.sdsu.intelligrid.util.Vector2f;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * The interface Surface for the application.
 */
public class MainSurfaceView extends GLSurfaceView {

	private MainRenderer mainRenderer;

	public MainSurfaceView(final Context context, final MainRenderer renderer) {
		super(context);

		mainRenderer = renderer;

		setEGLContextClientVersion(2);
		setRenderer(mainRenderer);
	}

	/**
	 * Example of an event function
	 **/
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		switch (e.getAction()) {
		case (MotionEvent.ACTION_DOWN):
			performClick();
			tapLocation(e.getX(0), e.getY(0));
			break;
		case (MotionEvent.ACTION_MOVE):
			tapLocation(e.getX(0), e.getY(0));
			break;
		default:
		}
		return true;
	}

	/**
	 * Example of an event handler
	 **/
	@Override
	public boolean performClick() {
		super.performClick();
		queueEvent(new Runnable() {
			public void run() {
				// mainRenderer.handleDpadCenter();
			}
		});
		return true;
	}

	public boolean tapLocation(final float x, final float y) {
		super.performClick();
		queueEvent(new Runnable() {
			public void run() {
				mainRenderer.setSpriteLocation(new Vector2f((x
						/ (float) mainRenderer.getScreenWidth() * 2f - 1f)
						* (float) mainRenderer.getScreenWidth()
						/ (float) mainRenderer.getScreenHeight(), -(y
						/ (float) mainRenderer.getScreenHeight() * 2f - 1f)));
			}
		});
		return true;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
}
