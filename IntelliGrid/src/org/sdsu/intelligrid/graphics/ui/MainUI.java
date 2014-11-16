// Copyright 2014 Kysa Tran, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.graphics.TextSprite;
import org.sdsu.intelligrid.simulation.Simulation;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * User interface class for the application.
 */
public class MainUI {

	private final List<Clickable> clickableList = new ArrayList<>();

	// Please fill this in, Kysa
	public final static Map<Integer, Vector2f> ledPositionMap = new HashMap<>();
	static {
		// Use this format; just have 177 lines placing the pixel locations for
		// each of the LEDs
		ledPositionMap.put(1, pixelsToCoords(123, 456));
		ledPositionMap.put(2, pixelsToCoords(789, 666));

		// Delete below once you've placed them in the right spots. The
		// animation will look wrong if they're in the wrong spots, so it should
		// be easy to test.
		float a = -1.6f;
		float b = -1f;
		for (int i = 1; i <= 177; i++) {
			ledPositionMap.put(i, new Vector2f(a, b));
			a += 0.1f;
			if (a >= 1.6f) {
				a = -1.6f;
				b += 0.1f;
			}
		}
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
	 * This is the initialization function for the interface. Load textures
	 * here.
	 */
	public void init() {
		final List<Integer> resources = new ArrayList<>();
		resources.add(R.drawable.background);
		resources.add(R.drawable.paths);
		resources.add(R.drawable.intelligrid);
		resources.add(R.drawable.settings);
		resources.add(R.drawable.info);
		resources.add(R.drawable.faults);
		resources.add(R.drawable.play);
		resources.add(R.drawable.play2);
		resources.add(R.drawable.play3);
		resources.add(R.drawable.pause);
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
		resources.add(R.drawable.business2copy2);
		resources.add(R.drawable.condo);
		resources.add(R.drawable.condo2);
		resources.add(R.drawable.store);
		resources.add(R.drawable.museum);
		resources.add(R.drawable.stadium);
		resources.add(R.drawable.midway);
		resources.add(R.drawable.solarpanel);
		resources.add(R.drawable.turbine);
		resources.add(R.drawable.turbine2);
		resources.add(R.drawable.substation);
		resources.add(R.drawable.transformer);
		resources.add(R.drawable.transformer2);
		resources.add(R.drawable.transformer3);
		resources.add(R.drawable.transformer4);
		resources.add(R.drawable.transformer5);
		resources.add(R.drawable.transformer6);
		resources.add(R.drawable.switch1);
		resources.add(R.drawable.switch2);
		resources.add(R.drawable.switch3);
		resources.add(R.drawable.switch4);
		resources.add(R.drawable.switch5);
		resources.add(R.drawable.switch6);
		resources.add(R.drawable.tie);
		resources.add(R.drawable.trackhoe);
		resources.add(R.drawable.orb);
		Global.getRenderer().loadTextures(resources);
	}

	public class SimInfo {
		public double PowPlant;
		public double Load1;
	}

	/**
	 * This runs on the first frame.
	 */
	public void postInit() {
		Sprite background = new Sprite(new Vector2f(), Integer.MAX_VALUE, 0f,
				new Vector2f(1.28f, 1.28f), new Color(255, 255, 255),
				R.drawable.background);
		background.setRelativeScale();
		Global.getRenderer().addDrawable(background);

		Sprite paths = new Sprite(new Vector2f(), 2, 0f, new Vector2f(1f, 1f),
				new Color(255, 255, 255), R.drawable.paths);
		background.setRelativeScale();
		Global.getRenderer().addDrawable(paths);

		Sprite intelligrid = new Sprite(pixelsToCoords(195, 1555), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.intelligrid);
		Global.getRenderer().addDrawable(intelligrid);

		Sprite settings = new Sprite(pixelsToCoords(2485, 75), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.settings);
		Global.getRenderer().addDrawable(settings);

		Sprite info = new Sprite(pixelsToCoords(2335, 75), 1, 0f, new Vector2f(
				1f, 1f), new Color(255, 255, 255), R.drawable.info);
		Global.getRenderer().addDrawable(info);

		Sprite faults = new Sprite(pixelsToCoords(2185, 75), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.faults);
		Global.getRenderer().addDrawable(faults);

		Sprite play = new Sprite(pixelsToCoords(2210, 1550), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255), R.drawable.play);
		Global.getRenderer().addDrawable(play);

		Sprite play2 = new Sprite(pixelsToCoords(2300, 1550), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.play2);
		Global.getRenderer().addDrawable(play2);

		Sprite play3 = new Sprite(pixelsToCoords(2400, 1550), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.play3);
		Global.getRenderer().addDrawable(play3);

		Sprite pause = new Sprite(pixelsToCoords(2500, 1550), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.pause);
		Global.getRenderer().addDrawable(pause);

		Sprite house1 = new Sprite(pixelsToCoords(155, 120), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.house1);
		Global.getRenderer().addDrawable(house1);

		Sprite house1copy = new Sprite(pixelsToCoords(375, 270), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.house1copy);
		Global.getRenderer().addDrawable(house1copy);

		Sprite house1copy2 = new Sprite(pixelsToCoords(615, 270), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.house1copy2);
		Global.getRenderer().addDrawable(house1copy2);

		Sprite house2 = new Sprite(pixelsToCoords(135, 500), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.house2);
		Global.getRenderer().addDrawable(house2);

		Sprite house2copy = new Sprite(pixelsToCoords(135, 830), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.house2copy);
		Global.getRenderer().addDrawable(house2copy);

		Sprite house2copy2 = new Sprite(pixelsToCoords(430, 830), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.house2copy2);
		Global.getRenderer().addDrawable(house2copy2);

		Sprite business1 = new Sprite(pixelsToCoords(1500, 480), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.business1);
		Global.getRenderer().addDrawable(business1);

		Sprite business1copy = new Sprite(pixelsToCoords(1920, 1000), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.business1copy);
		Global.getRenderer().addDrawable(business1copy);

		Sprite business2 = new Sprite(pixelsToCoords(1900, 580), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.business2);
		Global.getRenderer().addDrawable(business2);

		Sprite business2copy = new Sprite(pixelsToCoords(2145, 775), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.business2copy);
		Global.getRenderer().addDrawable(business2copy);

		Sprite business2copy2 = new Sprite(pixelsToCoords(2300, 900), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.business2copy2);
		Global.getRenderer().addDrawable(business2copy2);

		Sprite condo = new Sprite(pixelsToCoords(870, 1070), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.condo);
		Global.getRenderer().addDrawable(condo);

		Sprite condo2 = new Sprite(pixelsToCoords(1080, 1190), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.condo2);
		Global.getRenderer().addDrawable(condo2);

		Sprite store = new Sprite(pixelsToCoords(1070, 860), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.store);
		Global.getRenderer().addDrawable(store);

		Sprite museum = new Sprite(pixelsToCoords(310, 1280), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.museum);
		Global.getRenderer().addDrawable(museum);

		Sprite stadium = new Sprite(pixelsToCoords(2350, 1180), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.stadium);
		Global.getRenderer().addDrawable(stadium);

		Sprite midway = new Sprite(pixelsToCoords(1722, 125), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.midway);
		Global.getRenderer().addDrawable(midway);

		Sprite turbine = new Sprite(pixelsToCoords(900, 1420), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.turbine);
		Global.getRenderer().addDrawable(turbine);

		Sprite turbine2 = new Sprite(pixelsToCoords(1040, 1435), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.turbine2);
		Global.getRenderer().addDrawable(turbine2);

		Sprite solarpanel = new Sprite(pixelsToCoords(2270, 1440), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.solarpanel);
		Global.getRenderer().addDrawable(solarpanel);

		Sprite substation = new Sprite(pixelsToCoords(1500, 1150), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.substation);
		Global.getRenderer().addDrawable(substation);

		Sprite tie = new Sprite(pixelsToCoords(1050, 115), 1, 0f, new Vector2f(
				1f, 1f), new Color(255, 255, 255), R.drawable.tie);
		Global.getRenderer().addDrawable(tie);

		Sprite transformer = new Sprite(pixelsToCoords(770, 115), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.transformer);
		Global.getRenderer().addDrawable(transformer);

		Sprite transformer2 = new Sprite(pixelsToCoords(520, 640), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.transformer2);
		Global.getRenderer().addDrawable(transformer2);

		Sprite transformer3 = new Sprite(pixelsToCoords(1200, 1000), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.transformer3);
		Global.getRenderer().addDrawable(transformer3);

		Sprite transformer4 = new Sprite(pixelsToCoords(1800, 1150), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.transformer4);
		Global.getRenderer().addDrawable(transformer4);

		Sprite transformer5 = new Sprite(pixelsToCoords(1800, 800), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.transformer5);
		Global.getRenderer().addDrawable(transformer5);

		Sprite transformer6 = new Sprite(pixelsToCoords(1350, 335), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.transformer6);
		Global.getRenderer().addDrawable(transformer6);

		Sprite switch1 = new Sprite(pixelsToCoords(870, 115), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.switch1);
		Global.getRenderer().addDrawable(switch1);

		Sprite switch2 = new Sprite(pixelsToCoords(870, 450), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.switch2);
		Global.getRenderer().addDrawable(switch2);

		Sprite switch3 = new Sprite(pixelsToCoords(1300, 1000), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.switch3);
		Global.getRenderer().addDrawable(switch3);

		Sprite switch4 = new Sprite(pixelsToCoords(1700, 1150), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.switch4);
		Global.getRenderer().addDrawable(switch4);

		Sprite switch5 = new Sprite(pixelsToCoords(1700, 800), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.switch5);
		Global.getRenderer().addDrawable(switch5);

		Sprite switch6 = new Sprite(pixelsToCoords(1250, 335), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.switch6);
		Global.getRenderer().addDrawable(switch6);

		Sprite trackhoe = new Sprite(pixelsToCoords(1310, 550), 1, 0f,
				new Vector2f(1f, 1f), new Color(255, 255, 255),
				R.drawable.trackhoe);
		Global.getRenderer().addDrawable(trackhoe);

		TextSprite PowPlant = new TextSprite("" + Simulation.SimInfo.Load6,
				pixelsToCoords(2100, 1200), 40, Typeface.DEFAULT, 1000f, 0, 0,
				new Vector2f(1f, 1f), new Color(255, 255, 255));
		Global.getRenderer().addDrawable(PowPlant);
	}

	private boolean first = true;

	private LightAnimation lights;

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
			lights = new LightAnimation();
			return;
		}

		lights.advance(amount);
	}
}
