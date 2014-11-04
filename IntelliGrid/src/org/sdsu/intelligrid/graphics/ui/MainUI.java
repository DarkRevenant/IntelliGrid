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
	 *            the x-axis value of the MotionEvent position
	 * @param y
	 *            the y-axis value of the MotionEvent position
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

    public static Vector2f pixelsToCoords(final float x, final float y) {
        return new Vector2f((x / (float) Global.getRenderer().getScreenWidth()
                * 2f - 1f)
                * (float) Global.getRenderer().getScreenWidth()
                / (float) Global.getRenderer().getScreenHeight(), y
                / (float) Global.getRenderer().getScreenHeight() * 2f - 1f);
    }

    /**
     * This is the initialization function for the interface. Load textures here.
     */
    public void init() {
        final List<Integer> resources = new ArrayList<>();
        resources.add(R.drawable.background);
        resources.add(R.drawable.intelligrid);
        resources.add(R.drawable.house1);
        resources.add(R.drawable.house1copy);
        resources.add(R.drawable.house1copy2);
        resources.add(R.drawable.house2);
        resources.add(R.drawable.house2copy);
        resources.add(R.drawable.house2copy2);
        resources.add(R.drawable.business1);
        resources.add(R.drawable.business1copy);
        resources.add(R.drawable.business2);
        resources.add(R.drawable.business2copy);
        resources.add(R.drawable.condo);
        resources.add(R.drawable.condocopy);
        resources.add(R.drawable.store);
        Global.getRenderer().loadTextures(resources);
    }

    /**
     * This runs on the first frame.
     */
    public void postInit() {
        Sprite background = new Sprite(new Vector2f(), Integer.MAX_VALUE, 0f, new Vector2f(1.28f, 1.28f),
                new Color(255, 255, 255), R.drawable.background);
        background.setRelativeScale();
        Global.getRenderer().addDrawable(background);

        Sprite house1 = new Sprite(pixelsToCoords(500, 500), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1);
        Global.getRenderer().addDrawable(house1);

        Sprite house1copy = new Sprite(pixelsToCoords(500, 600), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1copy);
        Global.getRenderer().addDrawable(house1copy);

        Sprite house1copy2 = new Sprite(pixelsToCoords(600, 700), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1copy2);
        Global.getRenderer().addDrawable(house1copy2);

        Sprite house2 = new Sprite(pixelsToCoords(125, 500), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2);
        Global.getRenderer().addDrawable(house2);

        Sprite house2copy = new Sprite(pixelsToCoords(125, 830), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2copy);
        Global.getRenderer().addDrawable(house2copy);

        Sprite house2copy2 = new Sprite(pixelsToCoords(430, 830), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2copy2);
        Global.getRenderer().addDrawable(house2copy2);

        Sprite business1 = new Sprite(pixelsToCoords(1500, 800), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1);
        Global.getRenderer().addDrawable(business1);

        Sprite business1copy = new Sprite(pixelsToCoords(1600, 900), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1copy);
        Global.getRenderer().addDrawable(business1copy);

        Sprite business2 = new Sprite(pixelsToCoords(2000, 800), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2);
        Global.getRenderer().addDrawable(business2);

        Sprite business2copy = new Sprite(pixelsToCoords(2100, 900), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copy);
        Global.getRenderer().addDrawable(business2copy);

        Sprite condo = new Sprite(pixelsToCoords(870, 1070), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.condo);
        Global.getRenderer().addDrawable(condo);

        Sprite condocopy = new Sprite(pixelsToCoords(1070, 1190), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.condocopy);
        Global.getRenderer().addDrawable(condocopy);

        Sprite store = new Sprite(pixelsToCoords(900, 800), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.store);
        Global.getRenderer().addDrawable(store);

        Sprite intelligrid = new Sprite(pixelsToCoords(195, 1555), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.intelligrid);
        Global.getRenderer().addDrawable(intelligrid);
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
