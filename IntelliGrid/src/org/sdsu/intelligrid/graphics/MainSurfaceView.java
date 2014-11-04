// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.graphics.ui.Clickable;
import org.sdsu.intelligrid.graphics.ui.InputHook;
import org.sdsu.intelligrid.graphics.ui.MainUI;
import org.sdsu.intelligrid.util.Vector2f;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * The interface Surface for the application.
 */
public class MainSurfaceView extends GLSurfaceView {

	private MainRenderer mainRenderer;

	public MainSurfaceView(final Context context, final MainRenderer renderer) {
		super(context);

		mainRenderer = renderer;

		setEGLContextClientVersion(2);
		super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
		setRenderer(mainRenderer);
	}

	@Override
	public boolean onTouchEvent(final MotionEvent e) {
		final int index;
		Vector2f coords;
		int id;
		switch (e.getActionMasked()) {
		case (AccessibilityNodeInfo.ACTION_CLICK):
			performClick();
			break;
		case (MotionEvent.ACTION_DOWN):
			index = 0;
			id = e.getPointerId(index);
			coords = MainUI.eventPosToCoords(e.getX(index), e.getY(index));
			downOnLocation(coords, e, id);
			break;
		case (MotionEvent.ACTION_MOVE):
			for (int i = 0; i < e.getPointerCount(); i++) {
				id = e.getPointerId(i);
				coords = MainUI.eventPosToCoords(e.getX(i), e.getY(i));
				moveToLocation(coords, e, id);
			}
			break;
		case (MotionEvent.ACTION_UP):
			index = 0;
			id = e.getPointerId(index);
			coords = MainUI.eventPosToCoords(e.getX(index), e.getY(index));
			upFromLocation(coords, e, id);
			break;
		case (MotionEvent.ACTION_CANCEL):
			index = 0;
			id = e.getPointerId(index);
			coords = MainUI.eventPosToCoords(e.getX(index), e.getY(index));
			cancelFromLocation(coords, e, id);
			break;
		case (MotionEvent.ACTION_POINTER_DOWN):
			index = e.getActionIndex();
			id = e.getPointerId(index);
			coords = MainUI.eventPosToCoords(e.getX(index), e.getY(index));
			downOnLocation(coords, e, id);
			break;
		case (MotionEvent.ACTION_POINTER_UP):
			index = e.getActionIndex();
			id = e.getPointerId(index);
			coords = MainUI.eventPosToCoords(e.getX(index), e.getY(index));
			upFromLocation(coords, e, id);
			break;
		default:
			return false;
		}
		return true;
	}

	@Override
	public boolean performClick() {
		super.performClick();
		return true;
		// Don't question it
	}

	private boolean downOnLocation(final Vector2f coords, final MotionEvent e,
			final int id) {
		queueEvent(new Runnable() {
			public void run() {
				final List<Clickable> clickables = Global.getMainUI()
						.getClickablesList();
				final List<Clickable> candidates = new ArrayList<>();

				Vector2f actualBoundLL, actualBoundUR;
				for (Clickable clickable : clickables) {
					actualBoundLL = Vector2f.add(clickable.getBoundLL(),
							clickable.getLocation(), null);
					actualBoundUR = Vector2f.add(clickable.getBoundUR(),
							clickable.getLocation(), null);
					if (coords.x >= actualBoundLL.x
							&& coords.x <= actualBoundUR.x
							&& coords.y >= actualBoundLL.y
							&& coords.y <= actualBoundUR.y) {
						candidates.add(clickable);
					}
				}

				if (candidates.size() > 0) {
					Collections.sort(candidates, DEPTH_ASCENDING);
					InputHook.reportDownOnObject(candidates.get(0), coords, e,
							id);
				}

				InputHook.reportDown(coords, e, id);
			}
		});
		return true;
	}

	private boolean moveToLocation(final Vector2f coords, final MotionEvent e,
			final int id) {
		queueEvent(new Runnable() {
			public void run() {
				final List<Clickable> clickables = Global.getMainUI()
						.getClickablesList();
				final List<Clickable> candidates = new ArrayList<>();

				Vector2f actualBoundLL, actualBoundUR;
				for (Clickable clickable : clickables) {
					actualBoundLL = Vector2f.add(clickable.getBoundLL(),
							clickable.getLocation(), null);
					actualBoundUR = Vector2f.add(clickable.getBoundUR(),
							clickable.getLocation(), null);
					if (coords.x >= actualBoundLL.x
							&& coords.x <= actualBoundUR.x
							&& coords.y >= actualBoundLL.y
							&& coords.y <= actualBoundUR.y) {
						candidates.add(clickable);
					}
				}

				if (candidates.size() > 0) {
					Collections.sort(candidates, DEPTH_ASCENDING);
					InputHook.reportMoveOverObject(candidates.get(0), coords,
							e, id);
				}

				InputHook.reportMove(coords, e, id);
			}
		});
		return true;
	}

	private boolean upFromLocation(final Vector2f coords, final MotionEvent e,
			final int id) {
		queueEvent(new Runnable() {
			public void run() {
				final List<Clickable> clickables = Global.getMainUI()
						.getClickablesList();
				final List<Clickable> candidates = new ArrayList<>();

				Vector2f actualBoundLL, actualBoundUR;
				for (Clickable clickable : clickables) {
					actualBoundLL = Vector2f.add(clickable.getBoundLL(),
							clickable.getLocation(), null);
					actualBoundUR = Vector2f.add(clickable.getBoundUR(),
							clickable.getLocation(), null);
					if (coords.x >= actualBoundLL.x
							&& coords.x <= actualBoundUR.x
							&& coords.y >= actualBoundLL.y
							&& coords.y <= actualBoundUR.y) {
						candidates.add(clickable);
					}
				}

				if (candidates.size() > 0) {
					Collections.sort(candidates, DEPTH_ASCENDING);
					InputHook.reportUpFromObject(candidates.get(0), coords, e,
							id);
				}

				InputHook.reportUp(coords, e, id);
			}
		});
		return true;
	}

	private boolean cancelFromLocation(final Vector2f coords,
			final MotionEvent e, final int id) {
		queueEvent(new Runnable() {
			public void run() {
				final List<Clickable> clickables = Global.getMainUI()
						.getClickablesList();
				final List<Clickable> candidates = new ArrayList<>();

				Vector2f actualBoundLL, actualBoundUR;
				for (Clickable clickable : clickables) {
					actualBoundLL = Vector2f.add(clickable.getBoundLL(),
							clickable.getLocation(), null);
					actualBoundUR = Vector2f.add(clickable.getBoundUR(),
							clickable.getLocation(), null);
					if (coords.x >= actualBoundLL.x
							&& coords.x <= actualBoundUR.x
							&& coords.y >= actualBoundLL.y
							&& coords.y <= actualBoundUR.y) {
						candidates.add(clickable);
					}
				}

				if (candidates.size() > 0) {
					Collections.sort(candidates, DEPTH_ASCENDING);
					InputHook.reportCancelFromObject(candidates.get(0), coords,
							e, id);
				}

				InputHook.reportCancel(coords, e, id);
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

	private final static Comparator<Clickable> DEPTH_ASCENDING = new Comparator<Clickable>() {
		@Override
		public int compare(Clickable c1, Clickable c2) {
			return c1.getDepth() - c2.getDepth();
		}
	};
}
