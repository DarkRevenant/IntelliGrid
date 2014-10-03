package org.sdsu.intelligrid.graphics;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class MainSurfaceView extends GLSurfaceView {

	private MainRenderer mainRenderer;

	public MainSurfaceView(Context context) {
		super(context);

		mainRenderer = new MainRenderer();

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
		default:
		}
		return true;
	}
	
	/**
	 * Example of an event function
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
}
