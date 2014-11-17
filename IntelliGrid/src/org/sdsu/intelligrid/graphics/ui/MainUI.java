// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.graphics.Drawable;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.graphics.TextSprite;
import org.sdsu.intelligrid.simulation.Simulation;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;
import org.sdsu.intelligrid.simulation.Simulation.SimInfo;


/**
 * User interface class for the application.
 */
public class MainUI {

	private final List<Clickable> clickableList = new ArrayList<>();

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
     * This is the initialization function for the interface. Load textures here.
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
        Global.getRenderer().loadTextures(resources);
    }

    public static class UIInfo {
        public static TextSprite Load1;
        public static TextSprite Load2;
        public static TextSprite Load3;
        public static TextSprite Load4;
        public static TextSprite Load5;
        public static TextSprite Load6;
        public static TextSprite Load1r;
        public static TextSprite Load2r;
        public static TextSprite Load3r;
        public static TextSprite Load4r;
        public static TextSprite Load5r;
        public static TextSprite Load6r;
        public static TextSprite Load1a;
        public static TextSprite Load2a;
        public static TextSprite Load3a;
        public static TextSprite Load4a;
        public static TextSprite Load5a;
        public static TextSprite Load6a;
        public static TextSprite trA;
        public static TextSprite trB;
        public static TextSprite trC;
        public static TextSprite trD;
        public static TextSprite trE;
        public static TextSprite trF;
        public static TextSprite trG;
        public static TextSprite trH;
        public static TextSprite trI;
        public static TextSprite trJ;
        public static TextSprite trK;
        public static TextSprite trL;
        public static TextSprite trM;
        public static TextSprite PowPlant;
        public static TextSprite WindTurbines;
        public static TextSprite BatteryStorage;
        public static TextSprite transTotal;
        public static TextSprite SDGE;
        public static TextSprite capacity;
        public static TextSprite currentTime;
    }

    /**
     * This runs on the first frame.
     */
    public void postInit() {
        Sprite background = new Sprite(new Vector2f(), Integer.MAX_VALUE, 0f, new Vector2f(1.28f, 1.28f),
                new Color(255, 255, 255), R.drawable.background);
        background.setRelativeScale();
        Global.getRenderer().addDrawable(background);

        Sprite paths = new Sprite(new Vector2f(), 2, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.paths);
        background.setRelativeScale();
        Global.getRenderer().addDrawable(paths);

        Sprite intelligrid = new Sprite(pixelsToCoords(195, 1555), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.intelligrid);
        Global.getRenderer().addDrawable(intelligrid);

        Sprite settings = new Sprite(pixelsToCoords(2485, 75), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.settings);
        Global.getRenderer().addDrawable(settings);

        Sprite info = new Sprite(pixelsToCoords(2335, 75), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.info);
        Global.getRenderer().addDrawable(info);

        Sprite faults = new Sprite(pixelsToCoords(2185, 75), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faults);
        Global.getRenderer().addDrawable(faults);

        Sprite play = new Sprite(pixelsToCoords(2210, 1550), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play);
        Global.getRenderer().addDrawable(play);

        Sprite play2 = new Sprite(pixelsToCoords(2300, 1550), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play2);
        Global.getRenderer().addDrawable(play2);

        Sprite play3 = new Sprite(pixelsToCoords(2400, 1550), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play3);
        Global.getRenderer().addDrawable(play3);

        Sprite pause = new Sprite(pixelsToCoords(2500, 1550), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.pause);
        Global.getRenderer().addDrawable(pause);

        Sprite house1 = new Sprite(pixelsToCoords(155, 120), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1);
        Global.getRenderer().addDrawable(house1);

        Sprite house1copy = new Sprite(pixelsToCoords(375, 270), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1copy);
        Global.getRenderer().addDrawable(house1copy);

        Sprite house1copy2 = new Sprite(pixelsToCoords(615, 270), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1copy2);
        Global.getRenderer().addDrawable(house1copy2);

        Sprite house2 = new Sprite(pixelsToCoords(135, 500), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2);
        Global.getRenderer().addDrawable(house2);

        Sprite house2copy = new Sprite(pixelsToCoords(135, 830), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2copy);
        Global.getRenderer().addDrawable(house2copy);

        Sprite house2copy2 = new Sprite(pixelsToCoords(430, 830), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2copy2);
        Global.getRenderer().addDrawable(house2copy2);

        Sprite business1 = new Sprite(pixelsToCoords(1500, 480), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1);
        Global.getRenderer().addDrawable(business1);

        Sprite business1copy = new Sprite(pixelsToCoords(1920, 1000), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1copy);
        Global.getRenderer().addDrawable(business1copy);

        Sprite business2 = new Sprite(pixelsToCoords(1900, 580), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2);
        Global.getRenderer().addDrawable(business2);

        Sprite business2copy = new Sprite(pixelsToCoords(2145, 775), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copy);
        Global.getRenderer().addDrawable(business2copy);

        Sprite business2copy2 = new Sprite(pixelsToCoords(2300, 900), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copy2);
        Global.getRenderer().addDrawable(business2copy2);

        Sprite condo = new Sprite(pixelsToCoords(870, 1070), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.condo);
        Global.getRenderer().addDrawable(condo);

        Sprite condo2 = new Sprite(pixelsToCoords(1080, 1190), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.condo2);
        Global.getRenderer().addDrawable(condo2);

        Sprite store = new Sprite(pixelsToCoords(1070, 860), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.store);
        Global.getRenderer().addDrawable(store);

        Sprite museum = new Sprite(pixelsToCoords(310, 1280), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.museum);
        Global.getRenderer().addDrawable(museum);

        Sprite stadium = new Sprite(pixelsToCoords(2350, 1180), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.stadium);
        Global.getRenderer().addDrawable(stadium);

        Sprite midway = new Sprite(pixelsToCoords(1722, 125), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.midway);
        Global.getRenderer().addDrawable(midway);

        Sprite turbine = new Sprite(pixelsToCoords(900, 1420), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine);
        Global.getRenderer().addDrawable(turbine);

        Sprite turbine2 = new Sprite(pixelsToCoords(1040, 1435), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine2);
        Global.getRenderer().addDrawable(turbine2);

        Sprite solarpanel = new Sprite(pixelsToCoords(2270, 1440), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.solarpanel);
        Global.getRenderer().addDrawable(solarpanel);

        Sprite substation = new Sprite(pixelsToCoords(1500, 1150), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.substation);
        Global.getRenderer().addDrawable(substation);

        Sprite tie = new Sprite(pixelsToCoords(1050, 115), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.tie);
        Global.getRenderer().addDrawable(tie);

        Sprite transformer = new Sprite(pixelsToCoords(1200, 1000), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer);
        Global.getRenderer().addDrawable(transformer);

        Sprite transformer2 = new Sprite(pixelsToCoords(520, 640), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer2);
        Global.getRenderer().addDrawable(transformer2);

        Sprite transformer3 = new Sprite(pixelsToCoords(770, 115), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer3);
        Global.getRenderer().addDrawable(transformer3);

        Sprite transformer4 = new Sprite(pixelsToCoords(1350, 335), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer4);
        Global.getRenderer().addDrawable(transformer4);

        Sprite transformer5 = new Sprite(pixelsToCoords(1800, 800), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer5);
        Global.getRenderer().addDrawable(transformer5);

        Sprite transformer6 = new Sprite(pixelsToCoords(1800, 1150), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer6);
        Global.getRenderer().addDrawable(transformer6);

        Sprite switch1 = new Sprite(pixelsToCoords(1300, 1000), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(switch1);

        Sprite switch2 = new Sprite(pixelsToCoords(870, 450), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch2);
        Global.getRenderer().addDrawable(switch2);

        Sprite switch3 = new Sprite(pixelsToCoords(870, 115), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch3);
        Global.getRenderer().addDrawable(switch3);

        Sprite switch4 = new Sprite(pixelsToCoords(1250, 335), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch4);
        Global.getRenderer().addDrawable(switch4);

        Sprite switch5 = new Sprite(pixelsToCoords(1700, 800), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch5);
        Global.getRenderer().addDrawable(switch5);

        Sprite switch6 = new Sprite(pixelsToCoords(1700, 1150), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch6);
        Global.getRenderer().addDrawable(switch6);

        Sprite trackhoe = new Sprite(pixelsToCoords(1310, 550), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.trackhoe);
        Global.getRenderer().addDrawable(trackhoe);

        UIInfo.Load1 = new TextSprite("" + SimInfo.Load1,
                pixelsToCoords(1080, 1045), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load1);

        UIInfo.Load1r = new TextSprite("" + SimInfo.Load1r,
                pixelsToCoords(1080, 1025), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load1r);

        UIInfo.Load1a = new TextSprite("" + SimInfo.Load1a,
                pixelsToCoords(1080, 1005), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load1a);

        UIInfo.Load2 = new TextSprite("" + SimInfo.Load2,
                pixelsToCoords(305, 700), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load2);

        UIInfo.Load2r = new TextSprite("" + SimInfo.Load2r,
                pixelsToCoords(305, 680), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load2r);

        UIInfo.Load2a = new TextSprite("" + SimInfo.Load2a,
                pixelsToCoords(305, 660), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load2a);

        UIInfo.Load3 = new TextSprite("" + SimInfo.Load3,
                pixelsToCoords(500, 80), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load3);

        UIInfo.Load3r = new TextSprite("" + SimInfo.Load3r,
                pixelsToCoords(500, 60), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load3r);

        UIInfo.Load3a = new TextSprite("" + SimInfo.Load3a,
                pixelsToCoords(500, 40), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load3a);

        UIInfo.Load4 = new TextSprite("" + SimInfo.Load4,
                pixelsToCoords(1700, 350), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load4);

        UIInfo.Load4r = new TextSprite("" + SimInfo.Load4r,
                pixelsToCoords(1700, 330), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load4r);

        UIInfo.Load4a = new TextSprite("" + SimInfo.Load4a,
                pixelsToCoords(1700, 310), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load4a);

        UIInfo.Load5 = new TextSprite("" + SimInfo.Load5,
                pixelsToCoords(1980, 855), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load5);

        UIInfo.Load5r = new TextSprite("" + SimInfo.Load5r,
                pixelsToCoords(1980, 835), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load5r);

        UIInfo.Load5a = new TextSprite("" + SimInfo.Load5a,
                pixelsToCoords(1980, 815), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load5a);

        UIInfo.Load6 = new TextSprite("" + SimInfo.Load6,
                pixelsToCoords(2070, 1200), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load6);

        UIInfo.Load6r = new TextSprite("" + SimInfo.Load6r,
                pixelsToCoords(2070, 1180), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load6r);

        UIInfo.Load6a = new TextSprite("" + SimInfo.Load6a,
                pixelsToCoords(2070, 1160), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load6a);

        UIInfo.trA = new TextSprite("" + SimInfo.trA,
                pixelsToCoords(1450, 990), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trA);

        UIInfo.trB = new TextSprite("" + SimInfo.trB,
                pixelsToCoords(1250, 945), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trB);

        UIInfo.trC = new TextSprite("" + SimInfo.trC,
                pixelsToCoords(1015, 450), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trC);

        UIInfo.trD = new TextSprite("" + SimInfo.trD,
                pixelsToCoords(675, 640), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trD);

        UIInfo.trE = new TextSprite("" + SimInfo.trE,
                pixelsToCoords(930, 150), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trE);

        UIInfo.trF = new TextSprite("" + SimInfo.trF,
                pixelsToCoords(850, 60), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trF);

        UIInfo.trG = new TextSprite("" + SimInfo.trG,
                pixelsToCoords(1105, 100), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trG);

        UIInfo.trH = new TextSprite("" + SimInfo.trH,
                pixelsToCoords(1410, 285), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trH);

        UIInfo.trI = new TextSprite("" + SimInfo.trI,
                pixelsToCoords(1140, 320), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trI);

        UIInfo.trJ = new TextSprite("" + SimInfo.trJ,
                pixelsToCoords(1880, 750), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trJ);

        UIInfo.trK = new TextSprite("" + SimInfo.trK,
                pixelsToCoords(1580, 780), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trK);

        UIInfo.trL = new TextSprite("" + SimInfo.trL,
                pixelsToCoords(1885, 1100), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trL);

        UIInfo.trM = new TextSprite("" + SimInfo.trM,
                pixelsToCoords(1760, 1185), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trM);

        UIInfo.WindTurbines = new TextSprite("" + SimInfo.WindTurbines,
                pixelsToCoords(1250, 1400), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.WindTurbines);

        UIInfo.PowPlant = new TextSprite("" + SimInfo.PowPlant,
                pixelsToCoords(1950, 1400), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.PowPlant);

        UIInfo.transTotal = new TextSprite("" + SimInfo.transTotal,
                pixelsToCoords(1515, 1060), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.transTotal);

        UIInfo.SDGE = new TextSprite("" + SimInfo.SDGE,
                pixelsToCoords(1530, 1480), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.SDGE);

        UIInfo.currentTime = new TextSprite("" + SimInfo.currentTime,
                pixelsToCoords(1000, 1550), 40, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.currentTime);
    }

    private boolean first = true;

    private static float TEXT_UPDATE_INTERVAL = 0.5f;
    private float textUpdateTimer = TEXT_UPDATE_INTERVAL;

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

        textUpdateTimer -= amount;
        if (textUpdateTimer <= 0f) {

            UIInfo.Load1.setText("" + Simulation.SimInfo.Load1 + " MW",
                    UIInfo.Load1.getFontSize(), UIInfo.Load1.getFont(),
                    UIInfo.Load1.getMaxLineWidth());
            UIInfo.Load1r.setText("" + Simulation.SimInfo.Load1r + " MVAR",
                    UIInfo.Load1r.getFontSize(), UIInfo.Load1r.getFont(),
                    UIInfo.Load1r.getMaxLineWidth());
            UIInfo.Load1a.setText("" + Simulation.SimInfo.Load1a + " MVA",
                    UIInfo.Load1a.getFontSize(), UIInfo.Load1a.getFont(),
                    UIInfo.Load1a.getMaxLineWidth());

            UIInfo.Load2.setText("" + Simulation.SimInfo.Load2 + " MW",
                    UIInfo.Load2.getFontSize(), UIInfo.Load2.getFont(),
                    UIInfo.Load2.getMaxLineWidth());
            UIInfo.Load2r.setText("" + Simulation.SimInfo.Load2r + " MVAR",
                    UIInfo.Load2r.getFontSize(), UIInfo.Load2r.getFont(),
                    UIInfo.Load2r.getMaxLineWidth());
            UIInfo.Load2a.setText("" + Simulation.SimInfo.Load2a + " MVA",
                    UIInfo.Load2a.getFontSize(), UIInfo.Load2a.getFont(),
                    UIInfo.Load2a.getMaxLineWidth());

            UIInfo.Load3.setText("" + Simulation.SimInfo.Load3 + " MW",
                    UIInfo.Load3.getFontSize(), UIInfo.Load3.getFont(),
                    UIInfo.Load3.getMaxLineWidth());
            UIInfo.Load3r.setText("" + Simulation.SimInfo.Load3r + " MVAR",
                    UIInfo.Load3r.getFontSize(), UIInfo.Load3r.getFont(),
                    UIInfo.Load3r.getMaxLineWidth());
            UIInfo.Load3a.setText("" + Simulation.SimInfo.Load3a + " MVA",
                    UIInfo.Load3a.getFontSize(), UIInfo.Load3a.getFont(),
                    UIInfo.Load3a.getMaxLineWidth());

            UIInfo.Load4.setText("" + Simulation.SimInfo.Load4 + " MW",
                    UIInfo.Load4.getFontSize(), UIInfo.Load4.getFont(),
                    UIInfo.Load4.getMaxLineWidth());
            UIInfo.Load4r.setText("" + Simulation.SimInfo.Load4r + " MVAR",
                    UIInfo.Load4r.getFontSize(), UIInfo.Load4r.getFont(),
                    UIInfo.Load4r.getMaxLineWidth());
            UIInfo.Load4a.setText("" + Simulation.SimInfo.Load4a + " MVA",
                    UIInfo.Load4a.getFontSize(), UIInfo.Load4a.getFont(),
                    UIInfo.Load4a.getMaxLineWidth());

            UIInfo.Load5.setText("" + Simulation.SimInfo.Load5 + " MW",
                    UIInfo.Load5.getFontSize(), UIInfo.Load5.getFont(),
                    UIInfo.Load5.getMaxLineWidth());
            UIInfo.Load5r.setText("" + Simulation.SimInfo.Load5r + " MVAR",
                    UIInfo.Load5r.getFontSize(), UIInfo.Load5r.getFont(),
                    UIInfo.Load5r.getMaxLineWidth());
            UIInfo.Load5a.setText("" + Simulation.SimInfo.Load5a + " MVA",
                    UIInfo.Load5a.getFontSize(), UIInfo.Load5a.getFont(),
                    UIInfo.Load5a.getMaxLineWidth());

            UIInfo.Load6.setText("" + Simulation.SimInfo.Load6 + " MW",
                    UIInfo.Load6.getFontSize(), UIInfo.Load6.getFont(),
                    UIInfo.Load6.getMaxLineWidth());
            UIInfo.Load6r.setText("" + Simulation.SimInfo.Load6r + " MVAR",
                    UIInfo.Load6r.getFontSize(), UIInfo.Load6r.getFont(),
                    UIInfo.Load6r.getMaxLineWidth());
            UIInfo.Load6a.setText("" + Simulation.SimInfo.Load6a + " MVA",
                    UIInfo.Load6a.getFontSize(), UIInfo.Load6a.getFont(),
                    UIInfo.Load6a.getMaxLineWidth());

            UIInfo.trA.setText("" + Simulation.SimInfo.trA + " %",
                    UIInfo.trA.getFontSize(), UIInfo.trA.getFont(),
                    UIInfo.trA.getMaxLineWidth());
            UIInfo.trB.setText("" + Simulation.SimInfo.trB + " %",
                    UIInfo.trB.getFontSize(), UIInfo.trB.getFont(),
                    UIInfo.trB.getMaxLineWidth());
            UIInfo.trC.setText("" + Simulation.SimInfo.trC + " %",
                    UIInfo.trC.getFontSize(), UIInfo.trC.getFont(),
                    UIInfo.trC.getMaxLineWidth());
            UIInfo.trD.setText("" + Simulation.SimInfo.trD + " %",
                    UIInfo.trD.getFontSize(), UIInfo.trD.getFont(),
                    UIInfo.trD.getMaxLineWidth());
            UIInfo.trE.setText("" + Simulation.SimInfo.trE + " %",
                    UIInfo.trE.getFontSize(), UIInfo.trE.getFont(),
                    UIInfo.trE.getMaxLineWidth());
            UIInfo.trF.setText("" + Simulation.SimInfo.trF + " %",
                    UIInfo.trF.getFontSize(), UIInfo.trF.getFont(),
                    UIInfo.trF.getMaxLineWidth());
            UIInfo.trG.setText("" + Simulation.SimInfo.trG + " %",
                    UIInfo.trG.getFontSize(), UIInfo.trG.getFont(),
                    UIInfo.trG.getMaxLineWidth());
            UIInfo.trH.setText("" + Simulation.SimInfo.trH + " %",
                    UIInfo.trH.getFontSize(), UIInfo.trH.getFont(),
                    UIInfo.trH.getMaxLineWidth());
            UIInfo.trI.setText("" + Simulation.SimInfo.trI + " %",
                    UIInfo.trI.getFontSize(), UIInfo.trI.getFont(),
                    UIInfo.trI.getMaxLineWidth());
            UIInfo.trJ.setText("" + Simulation.SimInfo.trJ + " %",
                    UIInfo.trJ.getFontSize(), UIInfo.trJ.getFont(),
                    UIInfo.trJ.getMaxLineWidth());
            UIInfo.trK.setText("" + Simulation.SimInfo.trK + " %",
                    UIInfo.trK.getFontSize(), UIInfo.trK.getFont(),
                    UIInfo.trK.getMaxLineWidth());
            UIInfo.trL.setText("" + Simulation.SimInfo.trL + " %",
                    UIInfo.trL.getFontSize(), UIInfo.trL.getFont(),
                    UIInfo.trL.getMaxLineWidth());
            UIInfo.trM.setText("" + Simulation.SimInfo.trM + " %",
                    UIInfo.trM.getFontSize(), UIInfo.trM.getFont(),
                    UIInfo.trM.getMaxLineWidth());

            UIInfo.WindTurbines.setText("" + Simulation.SimInfo.WindTurbines + " MW",
                    UIInfo.WindTurbines.getFontSize(), UIInfo.WindTurbines.getFont(),
                    UIInfo.WindTurbines.getMaxLineWidth());

            UIInfo.PowPlant.setText("" + Simulation.SimInfo.PowPlant + " MW",
                    UIInfo.PowPlant.getFontSize(), UIInfo.PowPlant.getFont(),
                    UIInfo.PowPlant.getMaxLineWidth());

            UIInfo.transTotal.setText("" + Simulation.SimInfo.transTotal + " MVA",
                    UIInfo.transTotal.getFontSize(), UIInfo.transTotal.getFont(),
                    UIInfo.transTotal.getMaxLineWidth());

            UIInfo.SDGE.setText("" + Simulation.SimInfo.SDGE + " MW",
                    UIInfo.SDGE.getFontSize(), UIInfo.SDGE.getFont(),
                    UIInfo.SDGE.getMaxLineWidth());

            UIInfo.currentTime.setText("Time: " + "" + Simulation.SimInfo.currentTime,
                    UIInfo.currentTime.getFontSize(), UIInfo.currentTime.getFont(),
                    UIInfo.currentTime.getMaxLineWidth());

            textUpdateTimer += TEXT_UPDATE_INTERVAL;
        }
	}
}
