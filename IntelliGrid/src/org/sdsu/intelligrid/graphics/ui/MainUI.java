// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import java.util.ArrayList;
import java.util.List;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * User interface class for the application.
 */
public class MainUI {

	private final List<Clickable> clickableList = new ArrayList<>();

	public MainUI() {

	}

	/**
	 * Returns the on-screen openGL coordinates of the position returned from a
	 * MotionEvent.
	 * 
	 * @param x
	 *            the x-axis alue of the MotionEvent position
	 * @param y
	 *            the y-axis alue of the MotionEvent position
	 * @return the openGL coordinates of the given MotionEvent position
	 */
	public static Vector2f eventPosToCoords(final float x, final float y) {
		return new Vector2f((x / (float) Global.getRenderer().getScreenWidth()
				* 2f - 1f)
				* (float) Global.getRenderer().getScreenWidth()
				/ (float) Global.getRenderer().getScreenHeight(), -(y
				/ (float) Global.getRenderer().getScreenHeight() * 2f - 1f));
	}

	/**
	 * Adds a {@link org.sdsu.intelligrid.graphics.ui.Clickable Clickable} to
	 * the input handler.
	 * 
	 * @param clickable
	 *            the clickable object to add
	 */
	public void addClickable(final Clickable clickable) {
		if (!clickableList.contains(clickable)) {
			clickableList.add(clickable);
		}
	}

	/**
	 * Returns the list of all
	 * {@link org.sdsu.intelligrid.graphics.ui.Clickable Clickable} objects
	 * currently added to the input handler.
	 * 
	 * @return the list of all
	 *         {@link org.sdsu.intelligrid.graphics.ui.Clickable Clickable}
	 *         objects currently added to the input handler
	 */
	public List<Clickable> getClickablesList() {
		return clickableList;
	}

    /**
     * This is the initialization function for the interface. Load textures here.
     */
    public void init() {
        final List<Integer> resources = new ArrayList<>();
        resources.add(R.drawable.background);
        Global.getRenderer().loadTextures(resources);
    }

    /**
     * This runs on the first frame.
     */
    public void postInit() {
        Sprite background = new Sprite(new Vector2f(), Integer.MAX_VALUE, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.background);
        background.setRelativeScale();
        Global.getRenderer().addDrawable(background);
    }

    private boolean first = true;

	/**
	 * This is the primary step driver for the interface. Call all time-based
	 * functions from here.
	 * 
	 * @param amount
	 *            the amount of time that has passed since the previous frame,
	 *            in seconds
	 */
	public void advance(final float amount) {
        if (first) {
            first = false;
            postInit();
            return;
        }
	}
}
