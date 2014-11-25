// Copyright 2014 Kysa Tran, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.graphics.TextSprite;
import org.sdsu.intelligrid.network.MainNetworkHandler;
import org.sdsu.intelligrid.network.MainNetworkHandler.PacketTypes;
import org.sdsu.intelligrid.simulation.Simulation;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * User interface class for the application.
 */
public class MainUI {

    private final List<Clickable> clickableList = new ArrayList<>();

    public final static Map<Integer, Vector2f> ledPositionMap = new HashMap<>();

    /**
     * Returns the on-screen openGL coordinates of the position returned from a
     * MotionEvent.
     *
     * @param x the x-axis value of the MotionEvent position
     * @param y the y-axis value of the MotionEvent position
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
     * @param clickable the clickable object to add
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
     * {@link org.sdsu.intelligrid.graphics.ui.Clickable Clickable}
     * objects currently added to the input handler
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

    public static Vector2f sizeToCoords(final float x, final float y) {
        return new Vector2f(2f * x / (float) Global.getRenderer().getScreenHeight(), 2f * y
                / (float) Global.getRenderer().getScreenHeight());
    }

    /**
     * This is the initialization function for the interface. Load textures here.
     */
    public void init() {
        final List<Integer> resources = new ArrayList<>();
        resources.add(R.drawable.background);
        resources.add(R.drawable.backgroundnight);
        resources.add(R.drawable.paths);
        resources.add(R.drawable.intelligrid);
        resources.add(R.drawable.faults);
        resources.add(R.drawable.faultspage);
        resources.add(R.drawable.graphs);
        resources.add(R.drawable.graphspage);
        resources.add(R.drawable.info);
        resources.add(R.drawable.infopage);
        resources.add(R.drawable.exit);
        resources.add(R.drawable.play);
        resources.add(R.drawable.play2);
        resources.add(R.drawable.play3);
        resources.add(R.drawable.pause);
        resources.add(R.drawable.house1solar);
        resources.add(R.drawable.house1solarnight);
        resources.add(R.drawable.house1solar2);
        resources.add(R.drawable.house1solar2night);
        resources.add(R.drawable.house1solar3);
        resources.add(R.drawable.house1solar3night);
        resources.add(R.drawable.house2solar);
        resources.add(R.drawable.house2solarnight);
        resources.add(R.drawable.house2solar2);
        resources.add(R.drawable.house2solar2night);
        resources.add(R.drawable.house2solar3);
        resources.add(R.drawable.house2solar3night);
        resources.add(R.drawable.business1);
        resources.add(R.drawable.business1night);
        resources.add(R.drawable.business1copy);
        resources.add(R.drawable.business1copynight);
        resources.add(R.drawable.business2);
        resources.add(R.drawable.business2night);
        resources.add(R.drawable.business2copy);
        resources.add(R.drawable.business1copynight);
        resources.add(R.drawable.business2copy2);
        resources.add(R.drawable.business2copy2night);
        resources.add(R.drawable.house3);
        resources.add(R.drawable.house3night);
        resources.add(R.drawable.house3copy);
        resources.add(R.drawable.house3copynight);
        resources.add(R.drawable.house3copy2);
        resources.add(R.drawable.house3copy2night);
        resources.add(R.drawable.museum);
        resources.add(R.drawable.museumnight);
        resources.add(R.drawable.stadium);
        resources.add(R.drawable.stadiumnight);
        resources.add(R.drawable.midway);
        resources.add(R.drawable.midwaynight);
        resources.add(R.drawable.solarpanel);
        resources.add(R.drawable.solarpanelnight);
        resources.add(R.drawable.battery);
        resources.add(R.drawable.batterynight);
        resources.add(R.drawable.turbine);
        resources.add(R.drawable.turbinenight);
        resources.add(R.drawable.turbine2);
        resources.add(R.drawable.turbine2night);
        resources.add(R.drawable.substation);
        resources.add(R.drawable.substationnight);
        resources.add(R.drawable.transformer);
        resources.add(R.drawable.transformernight);
        resources.add(R.drawable.transformer2);
        resources.add(R.drawable.transformer2night);
        resources.add(R.drawable.transformer3);
        resources.add(R.drawable.transformer3night);
        resources.add(R.drawable.transformer4);
        resources.add(R.drawable.transformer4night);
        resources.add(R.drawable.transformer5);
        resources.add(R.drawable.transformer5night);
        resources.add(R.drawable.transformer6);
        resources.add(R.drawable.transformer6night);
        resources.add(R.drawable.switch1);
        resources.add(R.drawable.switch1night);
        resources.add(R.drawable.switch2);
        resources.add(R.drawable.switch2night);
        resources.add(R.drawable.switch3);
        resources.add(R.drawable.switch3night);
        resources.add(R.drawable.switch4);
        resources.add(R.drawable.switch4night);
        resources.add(R.drawable.switch5);
        resources.add(R.drawable.switch5night);
        resources.add(R.drawable.switch6);
        resources.add(R.drawable.switch6night);
        resources.add(R.drawable.tie);
        resources.add(R.drawable.tienight);
        resources.add(R.drawable.trackhoe);
        resources.add(R.drawable.orb);
        resources.add(R.drawable.loadstats);
        resources.add(R.drawable.load1statsclick);
        resources.add(R.drawable.load2statsclick);
        resources.add(R.drawable.load3statsclick);
        resources.add(R.drawable.load4statsclick);
        resources.add(R.drawable.load5statsclick);
        resources.add(R.drawable.load6statsclick);
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
        public static TextSprite currentTime;
    }

    public static class ClickableObjects {
        public static ClickableSprite background;
        public static ClickableSprite infopage;
        public static ClickableSprite exitinfo;
        public static ClickableSprite graphspage;
        public static ClickableSprite exitgraphs;
        public static ClickableSprite faultspage;
        public static ClickableSprite exitfaults;
        public static ClickableSprite load1stats;
        public static ClickableSprite load2stats;
        public static ClickableSprite load3stats;
        public static ClickableSprite load4stats;
        public static ClickableSprite load5stats;
        public static ClickableSprite load6stats;
    }

    public static class Objects {
        public static Sprite battery;
        public static Sprite business1;
        public static Sprite business1copy;
        public static Sprite business2;
        public static Sprite business2copy;
        public static Sprite business2copy2;
        public static Sprite graphs;
        public static Sprite house1solar;
        public static Sprite house1solar2;
        public static Sprite house1solar3;
        public static Sprite house2solar;
        public static Sprite house2solar2;
        public static Sprite house2solar3;
        public static Sprite house3;
        public static Sprite house3copy;
        public static Sprite house3copy2;
        public static Sprite info;
        public static Sprite midway;
        public static Sprite museum;
        public static Sprite solarpanel;
        public static Sprite stadium;
        public static Sprite substation;
        public static Sprite switch1;
        public static Sprite switch2;
        public static Sprite switch3;
        public static Sprite switch4;
        public static Sprite switch5;
        public static Sprite switch6;
        public static Sprite tie;
        public static Sprite transformer;
        public static Sprite transformer2;
        public static Sprite transformer3;
        public static Sprite transformer4;
        public static Sprite transformer5;
        public static Sprite transformer6;
        public static Sprite turbine;
        public static Sprite turbine2;
    }

    /**
     * This runs on the first frame.
     */
    public void postInit() {
        ClickableObjects.background = new ClickableSprite(new Vector2f(), 10, 0f, new Vector2f(1.28f, 1.28f),
                new Color(255, 255, 255), R.drawable.background, sizeToCoords(-1280,-800), sizeToCoords(1280,800), "background");
        ClickableObjects.background.setRelativeScale();
        Global.getRenderer().addDrawable(ClickableObjects.background);
        addClickable(ClickableObjects.background);

        ClickableSprite backgroundnight = new ClickableSprite(new Vector2f(), 11, 0f, new Vector2f(1.28f, 1.28f),
                new Color(255, 255, 255), R.drawable.backgroundnight, sizeToCoords(-1280,-800), sizeToCoords(1280,800), "backgroundnight");
        backgroundnight.setRelativeScale();
        Global.getRenderer().addDrawable(backgroundnight);
        addClickable(backgroundnight);

        Sprite paths = new Sprite(new Vector2f(), 2, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.paths);
        Global.getRenderer().addDrawable(paths);

        Sprite intelligrid = new Sprite(pixelsToCoords(195, 1555), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.intelligrid);
        Global.getRenderer().addDrawable(intelligrid);

        ClickableSprite faults = new ClickableSprite(pixelsToCoords(2185, 75), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faults, sizeToCoords(-64,-64), sizeToCoords(64,64), "faults");
        Global.getRenderer().addDrawable(faults);
        addClickable(faults);

        ClickableObjects.faultspage = new ClickableSprite(pixelsToCoords(1280, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultspage, sizeToCoords(0,0), sizeToCoords(0,0), "faultspage");
        Global.getRenderer().addDrawable(ClickableObjects.faultspage);
        addClickable(ClickableObjects.faultspage);

        ClickableObjects.exitfaults = new ClickableSprite(pixelsToCoords(2280, 1380), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.exit, sizeToCoords(-50,-50), sizeToCoords(50,50), "exitfaults");
        Global.getRenderer().addDrawable(ClickableObjects.exitfaults);
        addClickable(ClickableObjects.exitfaults);

        ClickableSprite graphs = new ClickableSprite(pixelsToCoords(2335, 75), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.graphs, sizeToCoords(-64,-64), sizeToCoords(64,64), "graphs");
        Global.getRenderer().addDrawable(graphs);
        addClickable(graphs);

        ClickableObjects.graphspage = new ClickableSprite(pixelsToCoords(1280, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.graphspage, sizeToCoords(0,0), sizeToCoords(0,0), "graphspage");
        Global.getRenderer().addDrawable(ClickableObjects.graphspage);
        addClickable(ClickableObjects.graphspage);

        ClickableObjects.exitgraphs = new ClickableSprite(pixelsToCoords(2280, 1380), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.exit, sizeToCoords(-40,-40), sizeToCoords(40,40), "exitgraphs");
        Global.getRenderer().addDrawable(ClickableObjects.exitgraphs);
        addClickable(ClickableObjects.exitgraphs);

        ClickableSprite info = new ClickableSprite(pixelsToCoords(2485, 75), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.info, sizeToCoords(-50,-50), sizeToCoords(50,50), "info");
        Global.getRenderer().addDrawable(info);
        addClickable(info);

        ClickableObjects.infopage = new ClickableSprite(pixelsToCoords(1280, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.infopage, sizeToCoords(0,0), sizeToCoords(0,0), "infopage");
        Global.getRenderer().addDrawable(ClickableObjects.infopage);
        addClickable(ClickableObjects.infopage);

        ClickableObjects.exitinfo = new ClickableSprite(pixelsToCoords(2280, 1380), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.exit, sizeToCoords(-40,-40), sizeToCoords(40,40), "exitinfo");
        Global.getRenderer().addDrawable(ClickableObjects.exitinfo);
        addClickable(ClickableObjects.exitinfo);

        ClickableSprite play = new ClickableSprite(pixelsToCoords(2210, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play, sizeToCoords(-14,-20), sizeToCoords(14,20), "play");
        Global.getRenderer().addDrawable(play);
        addClickable(play);

        ClickableSprite play2 = new ClickableSprite(pixelsToCoords(2300, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play2, sizeToCoords(-19,-20), sizeToCoords(19,20), "play2");
        Global.getRenderer().addDrawable(play2);
        addClickable(play2);

        ClickableSprite play3 = new ClickableSprite(pixelsToCoords(2400, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play3, sizeToCoords(-33,-20), sizeToCoords(33,20), "play3");
        Global.getRenderer().addDrawable(play3);
        addClickable(play3);

        ClickableSprite pause = new ClickableSprite(pixelsToCoords(2500, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.pause, sizeToCoords(-17,-20), sizeToCoords(17,20), "pause");
        Global.getRenderer().addDrawable(pause);
        addClickable(pause);

        Sprite house1solar = new Sprite(pixelsToCoords(155, 120), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar);
        Global.getRenderer().addDrawable(house1solar);

        Sprite house1solarnight = new Sprite(pixelsToCoords(155, 120), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solarnight);
        Global.getRenderer().addDrawable(house1solarnight);

        Sprite house1solar2 = new Sprite(pixelsToCoords(375, 270), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar2);
        Global.getRenderer().addDrawable(house1solar2);

        Sprite house1solar2night = new Sprite(pixelsToCoords(375, 270), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar2night);
        Global.getRenderer().addDrawable(house1solar2night);

        Sprite house1solar3 = new Sprite(pixelsToCoords(615, 270), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar3);
        Global.getRenderer().addDrawable(house1solar3);

        Sprite house1solar3night = new Sprite(pixelsToCoords(615, 270), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar3night);
        Global.getRenderer().addDrawable(house1solar3night);

        Sprite house2solar = new Sprite(pixelsToCoords(135, 500), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar);
        Global.getRenderer().addDrawable(house2solar);

        Sprite house2solarnight = new Sprite(pixelsToCoords(135, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solarnight);
        Global.getRenderer().addDrawable(house2solarnight);

        Sprite house2solar2 = new Sprite(pixelsToCoords(135, 830), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar2);
        Global.getRenderer().addDrawable(house2solar2);

        Sprite house2solar2night = new Sprite(pixelsToCoords(135, 830), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar2night);
        Global.getRenderer().addDrawable(house2solar2night);

        Sprite house2solar3 = new Sprite(pixelsToCoords(430, 830), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar3);
        Global.getRenderer().addDrawable(house2solar3);

        Sprite house2solar3night = new Sprite(pixelsToCoords(430, 830), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar3night);
        Global.getRenderer().addDrawable(house2solar3night);

        Sprite business1 = new Sprite(pixelsToCoords(1500, 480), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1);
        Global.getRenderer().addDrawable(business1);

        Sprite business1night = new Sprite(pixelsToCoords(1500, 480), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1night);
        Global.getRenderer().addDrawable(business1night);

        Sprite business1copy = new Sprite(pixelsToCoords(1920, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1copy);
        Global.getRenderer().addDrawable(business1copy);

        Sprite business1copynight = new Sprite(pixelsToCoords(1920, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1copynight);
        Global.getRenderer().addDrawable(business1copynight);

        Sprite business2 = new Sprite(pixelsToCoords(1900, 580), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2);
        Global.getRenderer().addDrawable(business2);

        Sprite business2night = new Sprite(pixelsToCoords(1900, 580), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2night);
        Global.getRenderer().addDrawable(business2night);

        Sprite business2copy = new Sprite(pixelsToCoords(2145, 775), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copy);
        Global.getRenderer().addDrawable(business2copy);

        Sprite business2copynight = new Sprite(pixelsToCoords(2145, 775), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copynight);
        Global.getRenderer().addDrawable(business2copynight);

        Sprite business2copy2 = new Sprite(pixelsToCoords(2300, 900), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copy2);
        Global.getRenderer().addDrawable(business2copy2);

        Sprite business2copy2night = new Sprite(pixelsToCoords(2300, 900), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2copy2night);
        Global.getRenderer().addDrawable(business2copy2night);

        Sprite house3 = new Sprite(pixelsToCoords(845, 1023), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3);
        Global.getRenderer().addDrawable(house3);

        Sprite house3night = new Sprite(pixelsToCoords(845, 1023), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3night);
        Global.getRenderer().addDrawable(house3night);

        Sprite house3copy = new Sprite(pixelsToCoords(1061, 1152), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3copy);
        Global.getRenderer().addDrawable(house3copy);

        Sprite house3copynight = new Sprite(pixelsToCoords(1061, 1152), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3copynight);
        Global.getRenderer().addDrawable(house3copynight);

        Sprite house3copy2 = new Sprite(pixelsToCoords(1060, 856), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3copy2);
        Global.getRenderer().addDrawable(house3copy2);

        Sprite house3copy2night = new Sprite(pixelsToCoords(1060, 856), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3copy2night);
        Global.getRenderer().addDrawable(house3copy2night);

        Sprite museum = new Sprite(pixelsToCoords(310, 1280), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.museum);
        Global.getRenderer().addDrawable(museum);

        Sprite museumnight = new Sprite(pixelsToCoords(310, 1280), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.museumnight);
        Global.getRenderer().addDrawable(museumnight);

        Sprite stadium = new Sprite(pixelsToCoords(2350, 1180), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.stadium);
        Global.getRenderer().addDrawable(stadium);

        Sprite stadiumnight = new Sprite(pixelsToCoords(2350, 1180), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.stadiumnight);
        Global.getRenderer().addDrawable(stadiumnight);

        Sprite midway = new Sprite(pixelsToCoords(1722, 125), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.midway);
        Global.getRenderer().addDrawable(midway);

        Sprite midwaynight = new Sprite(pixelsToCoords(1722, 125), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.midwaynight);
        Global.getRenderer().addDrawable(midwaynight);

        Sprite turbine = new Sprite(pixelsToCoords(900, 1420), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine);
        Global.getRenderer().addDrawable(turbine);

        Sprite turbinenight = new Sprite(pixelsToCoords(900, 1420), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbinenight);
        Global.getRenderer().addDrawable(turbinenight);

        Sprite turbine2 = new Sprite(pixelsToCoords(1040, 1435), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine2);
        Global.getRenderer().addDrawable(turbine2);

        Sprite turbine2night = new Sprite(pixelsToCoords(1040, 1435), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine2night);
        Global.getRenderer().addDrawable(turbine2night);

        Sprite battery = new Sprite(pixelsToCoords(2120, 1440), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.battery);
        Global.getRenderer().addDrawable(battery);

        Sprite batterynight = new Sprite(pixelsToCoords(2120, 1440), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.batterynight);
        Global.getRenderer().addDrawable(batterynight);

        Sprite solarpanel = new Sprite(pixelsToCoords(2330, 1440), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.solarpanel);
        Global.getRenderer().addDrawable(solarpanel);

        Sprite solarpanelnight = new Sprite(pixelsToCoords(2330, 1440), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.solarpanelnight);
        Global.getRenderer().addDrawable(solarpanelnight);

        Sprite substation = new Sprite(pixelsToCoords(1500, 1150), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.substation);
        Global.getRenderer().addDrawable(substation);

        Sprite substationnight = new Sprite(pixelsToCoords(1500, 1150), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.substationnight);
        Global.getRenderer().addDrawable(substationnight);

        Sprite tie = new Sprite(pixelsToCoords(1050, 115), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.tie);
        Global.getRenderer().addDrawable(tie);

        Sprite tienight = new Sprite(pixelsToCoords(1050, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.tienight);
        Global.getRenderer().addDrawable(tienight);

        Sprite transformer = new Sprite(pixelsToCoords(1200, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer);
        Global.getRenderer().addDrawable(transformer);

        Sprite transformernight = new Sprite(pixelsToCoords(1200, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformernight);
        Global.getRenderer().addDrawable(transformernight);

        Sprite transformer2 = new Sprite(pixelsToCoords(520, 640), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer2);
        Global.getRenderer().addDrawable(transformer2);

        Sprite transformer2night = new Sprite(pixelsToCoords(520, 640), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer2night);
        Global.getRenderer().addDrawable(transformer2night);

        Sprite transformer3 = new Sprite(pixelsToCoords(770, 115), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer3);
        Global.getRenderer().addDrawable(transformer3);

        Sprite transformer3night = new Sprite(pixelsToCoords(770, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer3night);
        Global.getRenderer().addDrawable(transformer3night);

        Sprite transformer4 = new Sprite(pixelsToCoords(1350, 335), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer4);
        Global.getRenderer().addDrawable(transformer4);

        Sprite transformer4night = new Sprite(pixelsToCoords(1350, 335), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer4night);
        Global.getRenderer().addDrawable(transformer4night);

        Sprite transformer5 = new Sprite(pixelsToCoords(1800, 800), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer5);
        Global.getRenderer().addDrawable(transformer5);

        Sprite transformer5night = new Sprite(pixelsToCoords(1800, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer5night);
        Global.getRenderer().addDrawable(transformer5night);

        Sprite transformer6 = new Sprite(pixelsToCoords(1800, 1150), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer6);
        Global.getRenderer().addDrawable(transformer6);

        Sprite transformer6night = new Sprite(pixelsToCoords(1800, 1150), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer6night);
        Global.getRenderer().addDrawable(transformer6night);

        Sprite switch1 = new Sprite(pixelsToCoords(1300, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(switch1);

        Sprite switch1night = new Sprite(pixelsToCoords(1300, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1night);
        Global.getRenderer().addDrawable(switch1night);

        Sprite switch2 = new Sprite(pixelsToCoords(870, 450), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch2);
        Global.getRenderer().addDrawable(switch2);

        Sprite switch2night = new Sprite(pixelsToCoords(870, 450), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch2night);
        Global.getRenderer().addDrawable(switch2night);

        Sprite switch3 = new Sprite(pixelsToCoords(870, 115), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch3);
        Global.getRenderer().addDrawable(switch3);

        Sprite switch3night = new Sprite(pixelsToCoords(870, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch3night);
        Global.getRenderer().addDrawable(switch3night);

        Sprite switch4 = new Sprite(pixelsToCoords(1250, 335), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch4);
        Global.getRenderer().addDrawable(switch4);

        Sprite switch4night = new Sprite(pixelsToCoords(1250, 335), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch4night);
        Global.getRenderer().addDrawable(switch4night);

        Sprite switch5 = new Sprite(pixelsToCoords(1700, 800), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch5);
        Global.getRenderer().addDrawable(switch5);

        Sprite switch5night = new Sprite(pixelsToCoords(1700, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch5night);
        Global.getRenderer().addDrawable(switch5night);

        Sprite switch6 = new Sprite(pixelsToCoords(1700, 1150), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch6);
        Global.getRenderer().addDrawable(switch6);

        Sprite switch6night = new Sprite(pixelsToCoords(1700, 1150), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch6night);
        Global.getRenderer().addDrawable(switch6night);

        Sprite trackhoe = new Sprite(pixelsToCoords(1310, 550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.trackhoe);
        Global.getRenderer().addDrawable(trackhoe);

        UIInfo.Load1 = new TextSprite("",
                pixelsToCoords(1000, 1000), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load1);

        ClickableSprite load1statsclick = new ClickableSprite(pixelsToCoords(980, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load1statsclick, sizeToCoords(-312,-313), sizeToCoords(312,313), "load1statsclick");
        Global.getRenderer().addDrawable(load1statsclick);
        addClickable(load1statsclick);

        ClickableObjects.load1stats = new ClickableSprite(pixelsToCoords(1000, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load1stats");
        Global.getRenderer().addDrawable(ClickableObjects.load1stats);
        addClickable(ClickableObjects.load1stats);

        UIInfo.Load2 = new TextSprite("",
                pixelsToCoords(295, 675), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load2);

        ClickableSprite load2statsclick = new ClickableSprite(pixelsToCoords(295, 655), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load2statsclick, sizeToCoords(-76,-80), sizeToCoords(76,80), "load2statsclick");
        Global.getRenderer().addDrawable(load2statsclick);
        addClickable(load2statsclick);

        ClickableObjects.load2stats = new ClickableSprite(pixelsToCoords(295, 675), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load2stats");
        Global.getRenderer().addDrawable(ClickableObjects.load2stats);
        addClickable(ClickableObjects.load2stats);

        UIInfo.Load3 = new TextSprite("",
                pixelsToCoords(400, 190), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load3);

        ClickableSprite load3statsclick = new ClickableSprite(pixelsToCoords(400, 190), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load3statsclick, sizeToCoords(-119,-52), sizeToCoords(119,52), "load3statsclick");
        Global.getRenderer().addDrawable(load3statsclick);
        addClickable(load3statsclick);

        ClickableObjects.load3stats = new ClickableSprite(pixelsToCoords(400, 190), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load3stats");
        Global.getRenderer().addDrawable(ClickableObjects.load3stats);
        addClickable(ClickableObjects.load3stats);

        UIInfo.Load4 = new TextSprite("",
                pixelsToCoords(1530, 420), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load4);

        ClickableSprite load4statsclick = new ClickableSprite(pixelsToCoords(1550, 310), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load4statsclick, sizeToCoords(-225,-330), sizeToCoords(225,330), "load4statsclick");
        Global.getRenderer().addDrawable(load4statsclick);
        addClickable(load4statsclick);

        ClickableObjects.load4stats = new ClickableSprite(pixelsToCoords(1530, 420), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load4stats");
        Global.getRenderer().addDrawable(ClickableObjects.load4stats);
        addClickable(ClickableObjects.load4stats);

        UIInfo.Load5 = new TextSprite("",
                pixelsToCoords(1980, 720), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load5);

        ClickableSprite load5statsclick = new ClickableSprite(pixelsToCoords(2100, 600), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load5statsclick, sizeToCoords(-310,-250), sizeToCoords(310,250), "load5statsclick");
        Global.getRenderer().addDrawable(load5statsclick);
        addClickable(load5statsclick);

        ClickableObjects.load5stats = new ClickableSprite(pixelsToCoords(1980, 720), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load5stats");
        Global.getRenderer().addDrawable(ClickableObjects.load5stats);
        addClickable(ClickableObjects.load5stats);

        UIInfo.Load6 = new TextSprite("",
                pixelsToCoords(2010, 1140), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load6);

        ClickableSprite load6statsclick = new ClickableSprite(pixelsToCoords(2170, 1090), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load6statsclick, sizeToCoords(-370,-110), sizeToCoords(370,110), "load6statsclick");
        Global.getRenderer().addDrawable(load6statsclick);
        addClickable(load6statsclick);

        ClickableObjects.load6stats = new ClickableSprite(pixelsToCoords(2010, 1140), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load6stats");
        Global.getRenderer().addDrawable(ClickableObjects.load6stats);
        addClickable(ClickableObjects.load6stats);

        UIInfo.trA = new TextSprite("",
                pixelsToCoords(1370, 1200), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trA);

        UIInfo.trB = new TextSprite("",
                pixelsToCoords(1230, 945), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trB);

        UIInfo.trC = new TextSprite("",
                pixelsToCoords(960, 670), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trC);

        UIInfo.trD = new TextSprite("",
                pixelsToCoords(620, 640), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trD);

        UIInfo.trE = new TextSprite("",
                pixelsToCoords(960, 300), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trE);

        UIInfo.trF = new TextSprite("",
                pixelsToCoords(800, 60), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trF);

        UIInfo.trG = new TextSprite("",
                pixelsToCoords(1145, 110), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trG);

        UIInfo.trH = new TextSprite("",
                pixelsToCoords(1370, 280), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trH);

        UIInfo.trI = new TextSprite("",
                pixelsToCoords(1500, 650), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trI);

        UIInfo.trJ = new TextSprite("",
                pixelsToCoords(1820, 745), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trJ);

        UIInfo.trK = new TextSprite("",
                pixelsToCoords(1635, 965), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trK);

        UIInfo.trL = new TextSprite("",
                pixelsToCoords(1820, 1095), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trL);

        UIInfo.trM = new TextSprite("",
                pixelsToCoords(1680, 1200), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trM);

        UIInfo.WindTurbines = new TextSprite("",
                pixelsToCoords(1250, 1400), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.WindTurbines);

        UIInfo.PowPlant = new TextSprite("",
                pixelsToCoords(1930, 1400), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.PowPlant);

        UIInfo.transTotal = new TextSprite("",
                pixelsToCoords(1515, 1060), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.transTotal);

//        UIInfo.SDGE = new TextSprite("",
//                pixelsToCoords(1530, 1480), 20, Typeface.DEFAULT, 1000f, 0, 0,
//                new Vector2f(1f, 1f), new Color(0, 0, 0));
//        Global.getRenderer().addDrawable(UIInfo.SDGE);

        UIInfo.currentTime = new TextSprite("",
                pixelsToCoords(1000, 1550), 40, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.currentTime);

        ledPositionMap.put(1, pixelsToCoords(1390, 1150));
        ledPositionMap.put(2, pixelsToCoords(1315, 1150));
        ledPositionMap.put(3, pixelsToCoords(1300, 1110));
        ledPositionMap.put(4, pixelsToCoords(1300, 1070));
        ledPositionMap.put(5, pixelsToCoords(1300, 1005));
        ledPositionMap.put(6, pixelsToCoords(1300, 965));
        ledPositionMap.put(7, pixelsToCoords(1280, 1005));
        ledPositionMap.put(8, pixelsToCoords(1230, 1005));
        ledPositionMap.put(9, pixelsToCoords(1190, 1005));
        ledPositionMap.put(10, pixelsToCoords(1060, 1005));
        ledPositionMap.put(11, pixelsToCoords(1060, 1040));
        ledPositionMap.put(12, pixelsToCoords(1060, 1070));
        ledPositionMap.put(13, pixelsToCoords(1000, 1005));
        ledPositionMap.put(14, pixelsToCoords(938, 1005));
        ledPositionMap.put(15, pixelsToCoords(1060, 970));
        ledPositionMap.put(16, pixelsToCoords(1060, 935));
        ledPositionMap.put(17, pixelsToCoords(1300, 940));
        ledPositionMap.put(18, pixelsToCoords(1300, 920));
        ledPositionMap.put(19, pixelsToCoords(1300, 890));
        ledPositionMap.put(20, pixelsToCoords(1300, 860));
        ledPositionMap.put(21, pixelsToCoords(1300, 840));
        ledPositionMap.put(22, pixelsToCoords(1300, 800));
        ledPositionMap.put(23, pixelsToCoords(1280, 755));
        ledPositionMap.put(24, pixelsToCoords(1000, 755));
        ledPositionMap.put(25, pixelsToCoords(890, 755));
        ledPositionMap.put(26, pixelsToCoords(870, 700));
        ledPositionMap.put(27, pixelsToCoords(870, 450));
        ledPositionMap.put(28, pixelsToCoords(870, 420));
        ledPositionMap.put(29, pixelsToCoords(850, 450));
        ledPositionMap.put(30, pixelsToCoords(750, 450));
        ledPositionMap.put(31, pixelsToCoords(680, 450));
        ledPositionMap.put(32, pixelsToCoords(650, 465));
        ledPositionMap.put(33, pixelsToCoords(630, 475));
        ledPositionMap.put(34, pixelsToCoords(600, 530));
        ledPositionMap.put(35, pixelsToCoords(525, 645));
        ledPositionMap.put(36, pixelsToCoords(500, 645));
        ledPositionMap.put(37, pixelsToCoords(460, 645));
        ledPositionMap.put(38, pixelsToCoords(425, 645));
        ledPositionMap.put(39, pixelsToCoords(430, 680));
        ledPositionMap.put(40, pixelsToCoords(430, 740));
        ledPositionMap.put(41, pixelsToCoords(425, 645));
        ledPositionMap.put(42, pixelsToCoords(350, 645));
        ledPositionMap.put(43, pixelsToCoords(145, 645));
        ledPositionMap.put(44, pixelsToCoords(145, 680));
        ledPositionMap.put(45, pixelsToCoords(145, 740));
        ledPositionMap.put(46, pixelsToCoords(145, 630));
        ledPositionMap.put(47, pixelsToCoords(145, 620));
        ledPositionMap.put(48, pixelsToCoords(145, 610));
        ledPositionMap.put(49, pixelsToCoords(145, 565));
        ledPositionMap.put(50, pixelsToCoords(870, 390));
        ledPositionMap.put(51, pixelsToCoords(870, 360));
        ledPositionMap.put(52, pixelsToCoords(870, 330));
        ledPositionMap.put(53, pixelsToCoords(870, 290));
        ledPositionMap.put(54, pixelsToCoords(870, 250));
        ledPositionMap.put(55, pixelsToCoords(870, 200));
        ledPositionMap.put(56, pixelsToCoords(870, 120));
        ledPositionMap.put(57, pixelsToCoords(870, 70));
        ledPositionMap.put(58, pixelsToCoords(840, 120));
        ledPositionMap.put(59, pixelsToCoords(800, 120));
        ledPositionMap.put(60, pixelsToCoords(750, 120));
        ledPositionMap.put(61, pixelsToCoords(615, 120));
        ledPositionMap.put(62, pixelsToCoords(615, 130));
        ledPositionMap.put(63, pixelsToCoords(615, 170));
        ledPositionMap.put(64, pixelsToCoords(615, 195));
        ledPositionMap.put(65, pixelsToCoords(570, 120));
        ledPositionMap.put(66, pixelsToCoords(530, 120));
        ledPositionMap.put(67, pixelsToCoords(490, 120));
        ledPositionMap.put(68, pixelsToCoords(430, 120));
        ledPositionMap.put(69, pixelsToCoords(400, 120));
        ledPositionMap.put(70, pixelsToCoords(372, 120));
        ledPositionMap.put(71, pixelsToCoords(372, 130));
        ledPositionMap.put(72, pixelsToCoords(372, 170));
        ledPositionMap.put(73, pixelsToCoords(372, 195));
        ledPositionMap.put(74, pixelsToCoords(320, 120));
        ledPositionMap.put(75, pixelsToCoords(270, 120));
        ledPositionMap.put(76, pixelsToCoords(225, 120));
        ledPositionMap.put(77, pixelsToCoords(878, 50));
        ledPositionMap.put(78, pixelsToCoords(950, 50));
        ledPositionMap.put(79, pixelsToCoords(1035, 50));
        ledPositionMap.put(80, pixelsToCoords(1050, 80));
        ledPositionMap.put(81, pixelsToCoords(1052, 130));
        ledPositionMap.put(82, pixelsToCoords(1052, 150));
        ledPositionMap.put(83, pixelsToCoords(1052, 180));
        ledPositionMap.put(84, pixelsToCoords(1100, 200));
        ledPositionMap.put(85, pixelsToCoords(1150, 220));
        ledPositionMap.put(86, pixelsToCoords(1245, 255));
        ledPositionMap.put(87, pixelsToCoords(1250, 334));
        ledPositionMap.put(88, pixelsToCoords(1250, 335));
        ledPositionMap.put(89, pixelsToCoords(1250, 430));
        ledPositionMap.put(90, pixelsToCoords(1300, 335));
        ledPositionMap.put(91, pixelsToCoords(1330, 335));
        ledPositionMap.put(92, pixelsToCoords(1370, 335));
        ledPositionMap.put(93, pixelsToCoords(1420, 335));
        ledPositionMap.put(94, pixelsToCoords(1480, 335));
        ledPositionMap.put(95, pixelsToCoords(1510, 335));
        ledPositionMap.put(96, pixelsToCoords(1530, 335));
        ledPositionMap.put(97, pixelsToCoords(1655, 335));
        ledPositionMap.put(98, pixelsToCoords(1655, 330));
        ledPositionMap.put(99, pixelsToCoords(1655, 170));
        ledPositionMap.put(100, pixelsToCoords(1672, 147));
        ledPositionMap.put(101, pixelsToCoords(1685, 147));
        ledPositionMap.put(102, pixelsToCoords(1655, 360));
        ledPositionMap.put(103, pixelsToCoords(1655, 380));
        ledPositionMap.put(104, pixelsToCoords(1655, 440));
        ledPositionMap.put(105, pixelsToCoords(1623, 458));
        ledPositionMap.put(106, pixelsToCoords(1613, 458));
        ledPositionMap.put(107, pixelsToCoords(1250, 450));
        ledPositionMap.put(108, pixelsToCoords(1250, 500));
        ledPositionMap.put(109, pixelsToCoords(1250, 600));
        ledPositionMap.put(110, pixelsToCoords(1250, 610));
        ledPositionMap.put(111, pixelsToCoords(1265, 620));
        ledPositionMap.put(112, pixelsToCoords(1290, 620));
        ledPositionMap.put(113, pixelsToCoords(1450, 620));
        ledPositionMap.put(114, pixelsToCoords(1500, 620));
        ledPositionMap.put(115, pixelsToCoords(1675, 620));
        ledPositionMap.put(116, pixelsToCoords(1698, 650));
        ledPositionMap.put(117, pixelsToCoords(1698, 800));
        ledPositionMap.put(118, pixelsToCoords(1698, 900));
        ledPositionMap.put(119, pixelsToCoords(1720, 800));
        ledPositionMap.put(120, pixelsToCoords(1770, 800));
        ledPositionMap.put(121, pixelsToCoords(1810, 800));
        ledPositionMap.put(122, pixelsToCoords(1850, 800));
        ledPositionMap.put(123, pixelsToCoords(1860, 800));
        ledPositionMap.put(124, pixelsToCoords(1897, 800));
        ledPositionMap.put(125, pixelsToCoords(1897, 770));
        ledPositionMap.put(126, pixelsToCoords(1897, 740));
        ledPositionMap.put(127, pixelsToCoords(1897, 710));
        ledPositionMap.put(128, pixelsToCoords(1930, 800));
        ledPositionMap.put(129, pixelsToCoords(1950, 800));
        ledPositionMap.put(130, pixelsToCoords(2065, 800));
        ledPositionMap.put(131, pixelsToCoords(1698, 1000));
        ledPositionMap.put(132, pixelsToCoords(1698, 1050));
        ledPositionMap.put(133, pixelsToCoords(1698, 1100));
        ledPositionMap.put(134, pixelsToCoords(1698, 1130));
        ledPositionMap.put(135, pixelsToCoords(1698, 1150));
        ledPositionMap.put(136, pixelsToCoords(1698, 1150));
        ledPositionMap.put(137, pixelsToCoords(1670, 1150));
        ledPositionMap.put(138, pixelsToCoords(1690, 1150));
        ledPositionMap.put(139, pixelsToCoords(1720, 1150));
        ledPositionMap.put(140, pixelsToCoords(1750, 1150));
        ledPositionMap.put(141, pixelsToCoords(1790, 1150));
        ledPositionMap.put(142, pixelsToCoords(1820, 1150));
        ledPositionMap.put(143, pixelsToCoords(1850, 1150));
        ledPositionMap.put(144, pixelsToCoords(1870, 1150));
        ledPositionMap.put(145, pixelsToCoords(1923, 1150));
        ledPositionMap.put(146, pixelsToCoords(1923, 1130));
        ledPositionMap.put(147, pixelsToCoords(1923, 1113));
        ledPositionMap.put(148, pixelsToCoords(1970, 1150));
        ledPositionMap.put(149, pixelsToCoords(2100, 1150));
        ledPositionMap.put(150, pixelsToCoords(2150, 1150));
        ledPositionMap.put(151, pixelsToCoords(2192, 1150));
        ledPositionMap.put(152, pixelsToCoords(1650, 1150));
        ledPositionMap.put(153, pixelsToCoords(1640, 1150));
        ledPositionMap.put(154, pixelsToCoords(1620, 1150));
        ledPositionMap.put(155, pixelsToCoords(1540, 1230));
        ledPositionMap.put(156, pixelsToCoords(1540, 1300));
        ledPositionMap.put(157, pixelsToCoords(1540, 1400));
        ledPositionMap.put(158, pixelsToCoords(1540, 1445));
        ledPositionMap.put(159, pixelsToCoords(1590, 1445));
        ledPositionMap.put(160, pixelsToCoords(1640, 1445));
        ledPositionMap.put(161, pixelsToCoords(1680, 1445));
        ledPositionMap.put(162, pixelsToCoords(1710, 1445));
        ledPositionMap.put(163, pixelsToCoords(1780, 1445));
        ledPositionMap.put(164, pixelsToCoords(1820, 1445));
        ledPositionMap.put(165, pixelsToCoords(1870, 1445));
        ledPositionMap.put(166, pixelsToCoords(1910, 1445));
        ledPositionMap.put(167, pixelsToCoords(2057, 1445));
        ledPositionMap.put(168, pixelsToCoords(1508, 1445));
        ledPositionMap.put(169, pixelsToCoords(1400, 1445));
        ledPositionMap.put(170, pixelsToCoords(1300, 1445));
        ledPositionMap.put(171, pixelsToCoords(1200, 1445));
        ledPositionMap.put(172, pixelsToCoords(1150, 1445));
        ledPositionMap.put(173, pixelsToCoords(1130, 1445));
        ledPositionMap.put(174, pixelsToCoords(1100, 1445));
        ledPositionMap.put(175, pixelsToCoords(1508, 1400));
        ledPositionMap.put(176, pixelsToCoords(1508, 1300));
        ledPositionMap.put(177, pixelsToCoords(1508, 1230));
    }

    /**
     * Called when the model starts a mylar balloon fault.
     */
    public void reportBalloonFaultStarted() {
    	
    }

    /**
     * Called when the simulation ends the mylar balloon fault (time-out).
     */
    public void reportBalloonFaultEnded() {
    	
    }

    /**
     * Called when the model starts a dig fault.
     */
    public void reportDigFaultStarted() {
    	
    }

    /**
     * Called when the simulation ends the dig fault (time-out).
     */
    public void reportDigFaultEnded() {
    	
    }

    /**
     * Called when the simulation ends the generic fault (time-out).
     */
    public void reportGenericFaultEnded(final String fault) {
    	
    }

    /**
     * Called when the simulation detects a fault automatically.
     */
    public void reportAutomaticFaultStarted(final String fault) {
    	
    }

    /**
     * Called when the simulation ends an automatically-detected fault (time-out).
     */
    public void reportAutomaticFaultEnded(final String fault) {
    	
    }

    private boolean first = true;

    private LightAnimation lightAnimation;

    private static final float TEXT_UPDATE_INTERVAL = 0.1f;
    private static final double TEXT_UPDATE_CHANCE = 0.25;

    private double textUpdateChance = 1.0;
    private float textUpdateTimer = TEXT_UPDATE_INTERVAL;

    /**
     * This is the primary step driver for the interface. Call all time-based
     * functions from here.
     *
     * @param amount the amount of time that has passed since the previous frame,
     *               in seconds
     */
    public void advance(final float amount) {
        if (first) {
            first = false;
            postInit();
            lightAnimation = new LightAnimation();
            return;
        }

        if(Simulation.SimInfo.currentTime < 6.00 && Simulation.SimInfo.currentTime > 18.00) {
            ClickableObjects.background.setResource(R.drawable.backgroundnight);
            Objects.battery.setResource(R.drawable.batterynight);
            Objects.business1.setResource(R.drawable.business1night);
            Objects.business1copy.setResource(R.drawable.business1copynight);
            Objects.business2.setResource(R.drawable.business2night);
            Objects.business2copy.setResource(R.drawable.business2copynight);
            Objects.business2copy2.setResource(R.drawable.business2copy2night);
            Objects.graphs.setResource(R.drawable.graphsnight);
            Objects.house1solar.setResource(R.drawable.house1solarnight);
            Objects.house1solar2.setResource(R.drawable.house1solar2night);
            Objects.house1solar3.setResource(R.drawable.house1solar3night);
            Objects.house2solar.setResource(R.drawable.house2solarnight);
            Objects.house2solar2.setResource(R.drawable.house2solar2night);
            Objects.house2solar3.setResource(R.drawable.house2solar3night);
            Objects.house3.setResource(R.drawable.house3night);
            Objects.house3copy.setResource(R.drawable.house3copynight);
            Objects.house3copy2.setResource(R.drawable.house3copy2night);
            Objects.info.setResource(R.drawable.infonight);
            Objects.midway.setResource(R.drawable.midwaynight);
            Objects.museum.setResource(R.drawable.museumnight);
            Objects.solarpanel.setResource(R.drawable.solarpanelnight);
            Objects.stadium.setResource(R.drawable.stadiumnight);
            Objects.substation.setResource(R.drawable.substationnight);
            Objects.switch1.setResource(R.drawable.switch1night);
            Objects.switch2.setResource(R.drawable.switch2night);
            Objects.switch3.setResource(R.drawable.switch3night);
            Objects.switch4.setResource(R.drawable.switch4night);
            Objects.switch5.setResource(R.drawable.switch5night);
            Objects.switch6.setResource(R.drawable.switch6night);
            Objects.tie.setResource(R.drawable.tienight);
            Objects.transformer.setResource(R.drawable.transformernight);
            Objects.transformer2.setResource(R.drawable.transformer2night);
            Objects.transformer3.setResource(R.drawable.transformer3night);
            Objects.transformer4.setResource(R.drawable.transformer4night);
            Objects.transformer5.setResource(R.drawable.transformer5night);
            Objects.transformer6.setResource(R.drawable.transformer6night);
            Objects.turbine.setResource(R.drawable.turbinenight);
            Objects.turbine2.setResource(R.drawable.turbine2night);





/*
            public static Sprite business2copy2;
            public static Sprite graphs;
            public static Sprite house1solar;
            public static Sprite house1solar2;
            public static Sprite house1solar3;
            public static Sprite house2solar;
            public static Sprite house2solar2;
            public static Sprite house2solar3;
            public static Sprite house3;
            public static Sprite house3copy;
            public static Sprite house3copy2;
            public static Sprite info;
            public static Sprite midway;
            public static Sprite museum;
            public static Sprite solarpanel;
            public static Sprite stadium;
            public static Sprite substation;
            public static Sprite switch1;
            public static Sprite switch2;
            public static Sprite switch3;
            public static Sprite switch4;
            public static Sprite switch5;
            public static Sprite switch6;
            public static Sprite tie;
            public static Sprite transformer;
            public static Sprite transformer2;
            public static Sprite transformer3;
            public static Sprite transformer4;
            public static Sprite transformer5;
            public static Sprite transformer6;
            public static Sprite turbine;
            public static Sprite turbine2;
            */
        }

        textUpdateTimer -= amount;
        if (textUpdateTimer <= 0f) {
            if (Math.random() < textUpdateChance)
                UIInfo.Load1.setText("Residential 1" + "\n" +
                                "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load1) + " MW"
                                + "\n" + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load1r) + " MVAR"
                                + "\n" + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load1a) + " MVA",
                        UIInfo.Load1.getFontSize(), UIInfo.Load1.getFont(),
                        UIInfo.Load1.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load2.setText("" + String.format("%.2f", Simulation.SimInfo.Load2) + " MW"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load2r) + " MVAR"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load2a) + " MVA",
                        UIInfo.Load2.getFontSize(), UIInfo.Load2.getFont(),
                        UIInfo.Load2.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load3.setText("" + String.format("%.2f", Simulation.SimInfo.Load3) + " MW"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load3r) + " MVAR"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load3a) + " MVA",
                        UIInfo.Load3.getFontSize(), UIInfo.Load3.getFont(),
                        UIInfo.Load3.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load4.setText("" + String.format("%.2f", Simulation.SimInfo.Load4) + " MW"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load4r) + " MVAR"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load4a) + " MVA",
                        UIInfo.Load4.getFontSize(), UIInfo.Load4.getFont(),
                        UIInfo.Load4.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load5.setText("" + String.format("%.2f", Simulation.SimInfo.Load5) + " MW"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load5r) + " MVAR"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load5a) + " MVA",
                        UIInfo.Load5.getFontSize(), UIInfo.Load5.getFont(),
                        UIInfo.Load5.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load6.setText("" + String.format("%.2f", Simulation.SimInfo.Load6) + " MW"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load6r) + " MVAR"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load6a) + " MVA",
                        UIInfo.Load6.getFontSize(), UIInfo.Load6.getFont(),
                        UIInfo.Load6.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.trA.setText("" + String.format("%.2f", Simulation.SimInfo.trA * 100) + " %",
                        UIInfo.trA.getFontSize(), UIInfo.trA.getFont(),
                        UIInfo.trA.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trB.setText("" + String.format("%.2f", Simulation.SimInfo.trB * 100) + " %",
                        UIInfo.trB.getFontSize(), UIInfo.trB.getFont(),
                        UIInfo.trB.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trC.setText("" + String.format("%.2f", Simulation.SimInfo.trC * 100) + " %",
                        UIInfo.trC.getFontSize(), UIInfo.trC.getFont(),
                        UIInfo.trC.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trD.setText("" + String.format("%.2f", Simulation.SimInfo.trD * 100) + " %",
                        UIInfo.trD.getFontSize(), UIInfo.trD.getFont(),
                        UIInfo.trD.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trE.setText("" + String.format("%.2f", Simulation.SimInfo.trE * 100) + " %",
                        UIInfo.trE.getFontSize(), UIInfo.trE.getFont(),
                        UIInfo.trE.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trF.setText("" + String.format("%.2f", Simulation.SimInfo.trF * 100) + " %",
                        UIInfo.trF.getFontSize(), UIInfo.trF.getFont(),
                        UIInfo.trF.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trG.setText("" + String.format("%.2f", Simulation.SimInfo.trG * 100) + " %",
                        UIInfo.trG.getFontSize(), UIInfo.trG.getFont(),
                        UIInfo.trG.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trH.setText("" + String.format("%.2f", Simulation.SimInfo.trH * 100) + " %",
                        UIInfo.trH.getFontSize(), UIInfo.trH.getFont(),
                        UIInfo.trH.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trI.setText("" + String.format("%.2f", Simulation.SimInfo.trI * 100) + " %",
                        UIInfo.trI.getFontSize(), UIInfo.trI.getFont(),
                        UIInfo.trI.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trJ.setText("" + String.format("%.2f", Simulation.SimInfo.trJ * 100) + " %",
                        UIInfo.trJ.getFontSize(), UIInfo.trJ.getFont(),
                        UIInfo.trJ.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trK.setText("" + String.format("%.2f", Simulation.SimInfo.trK * 100) + " %",
                        UIInfo.trK.getFontSize(), UIInfo.trK.getFont(),
                        UIInfo.trK.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trL.setText("" + String.format("%.2f", Simulation.SimInfo.trL * 100) + " %",
                        UIInfo.trL.getFontSize(), UIInfo.trL.getFont(),
                        UIInfo.trL.getMaxLineWidth());
            if (Math.random() < textUpdateChance)
                UIInfo.trM.setText("" + String.format("%.2f", Simulation.SimInfo.trM * 100) + " %",
                        UIInfo.trM.getFontSize(), UIInfo.trM.getFont(),
                        UIInfo.trM.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.WindTurbines.setText("" + String.format("%.2f", Simulation.SimInfo.WindTurbines) + " MW",
                        UIInfo.WindTurbines.getFontSize(), UIInfo.WindTurbines.getFont(),
                        UIInfo.WindTurbines.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.PowPlant.setText("" + String.format("%.2f", Simulation.SimInfo.PowPlant + Simulation.SimInfo.BatteryStorage) + " MW",
                        UIInfo.PowPlant.getFontSize(), UIInfo.PowPlant.getFont(),
                        UIInfo.PowPlant.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.transTotal.setText("" + String.format("%.2f", Simulation.SimInfo.transTotal) + " MVA",
                        UIInfo.transTotal.getFontSize(), UIInfo.transTotal.getFont(),
                        UIInfo.transTotal.getMaxLineWidth());

//            if (Math.random() < textUpdateChance)
//                UIInfo.SDGE.setText("" + String.format("%.2f", Simulation.SimInfo.SDGE) + " MW",
//                        UIInfo.SDGE.getFontSize(), UIInfo.SDGE.getFont(),
//                        UIInfo.SDGE.getMaxLineWidth());

            UIInfo.currentTime.setText("Time: " + "" + String.format("%.2f", Simulation.SimInfo.currentTime),
                    UIInfo.currentTime.getFontSize(), UIInfo.currentTime.getFont(),
                    UIInfo.currentTime.getMaxLineWidth());

            textUpdateTimer += TEXT_UPDATE_INTERVAL;
        }

        lightAnimation.advance(amount);
        lightAnimation.advanceState(amount);
        MainNetworkHandler.constructAndSendPacket(PacketTypes.LIGHT_ANIMATION, null);

        textUpdateChance = TEXT_UPDATE_CHANCE;
    }
}
