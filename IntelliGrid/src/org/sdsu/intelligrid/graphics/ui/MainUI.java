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
        resources.add(R.drawable.faulta);
        resources.add(R.drawable.faultb);
        resources.add(R.drawable.faultc);
        resources.add(R.drawable.faultd);
        resources.add(R.drawable.faulte);
        resources.add(R.drawable.faultf);
        resources.add(R.drawable.faulth);
        resources.add(R.drawable.faulti);
        resources.add(R.drawable.faultj);
        resources.add(R.drawable.faultk);
        resources.add(R.drawable.faultl);
        resources.add(R.drawable.faultm);
        resources.add(R.drawable.nofault);
        resources.add(R.drawable.background);
        resources.add(R.drawable.backgroundnight);
        resources.add(R.drawable.balloon);
        resources.add(R.drawable.balloonnight);
        resources.add(R.drawable.battery1);
        resources.add(R.drawable.battery1night);
        resources.add(R.drawable.battery2);
        resources.add(R.drawable.battery2night);
        resources.add(R.drawable.battery3);
        resources.add(R.drawable.battery3night);
        resources.add(R.drawable.business1);
        resources.add(R.drawable.business1night);
        resources.add(R.drawable.business2);
        resources.add(R.drawable.business2night);
        resources.add(R.drawable.coal);
        resources.add(R.drawable.coalnight);
        resources.add(R.drawable.exit);
        resources.add(R.drawable.faults);
        resources.add(R.drawable.faultspage);
        resources.add(R.drawable.graphs);
        resources.add(R.drawable.graphsnight);
        resources.add(R.drawable.graphspage);
        resources.add(R.drawable.house1solar);
        resources.add(R.drawable.house1solarnight);
        resources.add(R.drawable.house2solar);
        resources.add(R.drawable.house2solarnight);
        resources.add(R.drawable.house3);
        resources.add(R.drawable.house3night);
        resources.add(R.drawable.info);
        resources.add(R.drawable.infonight);
        resources.add(R.drawable.infopage);
        resources.add(R.drawable.intelligrid);
        resources.add(R.drawable.load1statsclick);
        resources.add(R.drawable.load2statsclick);
        resources.add(R.drawable.load3statsclick);
        resources.add(R.drawable.load4statsclick);
        resources.add(R.drawable.load5statsclick);
        resources.add(R.drawable.load6statsclick);
        resources.add(R.drawable.loadstats);
        resources.add(R.drawable.midway);
        resources.add(R.drawable.midwaynight);
        resources.add(R.drawable.museum);
        resources.add(R.drawable.museumnight);
        resources.add(R.drawable.orb);
        resources.add(R.drawable.paths);
        resources.add(R.drawable.pause);
        resources.add(R.drawable.pausedown);
        resources.add(R.drawable.play);
        resources.add(R.drawable.play2);
        resources.add(R.drawable.play2down);
        resources.add(R.drawable.play3);
        resources.add(R.drawable.play3down);
        resources.add(R.drawable.playdown);
        resources.add(R.drawable.solarpanel);
        resources.add(R.drawable.solarpanelnight);
        resources.add(R.drawable.stadium);
        resources.add(R.drawable.stadiumnight);
        resources.add(R.drawable.store);
        resources.add(R.drawable.storenight);
        resources.add(R.drawable.substation);
        resources.add(R.drawable.substationnight);
        resources.add(R.drawable.switch1);
        resources.add(R.drawable.switch1night);
        resources.add(R.drawable.switchbottom);
        resources.add(R.drawable.switchbottomnight);
        resources.add(R.drawable.switchmiddle);
        resources.add(R.drawable.switchmiddlenight);
        resources.add(R.drawable.switchtop);
        resources.add(R.drawable.switchtopnight);
        resources.add(R.drawable.tie);
        resources.add(R.drawable.tienight);
        resources.add(R.drawable.tieopen);
        resources.add(R.drawable.tieopennight);
        resources.add(R.drawable.trackhoe);
        resources.add(R.drawable.trackhoenight);
        resources.add(R.drawable.transformer1);
        resources.add(R.drawable.transformer1night);
        resources.add(R.drawable.turbine);
        resources.add(R.drawable.turbinenight);
        resources.add(R.drawable.xout);
        Global.getRenderer().loadTextures(resources);
    }

    public static class UIInfo {
        public static TextSprite Load1;
        public static TextSprite Load2;
        public static TextSprite Load3;
        public static TextSprite Load4;
        public static TextSprite Load5;
        public static TextSprite Load6;
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
        public static ClickableSprite faulta;
        public static ClickableSprite faultb;
        public static ClickableSprite faultc;
        public static ClickableSprite faultd;
        public static ClickableSprite faulte;
        public static ClickableSprite faultf;
        public static ClickableSprite faulth;
        public static ClickableSprite faulti;
        public static ClickableSprite faultj;
        public static ClickableSprite faultk;
        public static ClickableSprite faultl;
        public static ClickableSprite faultm;
        public static ClickableSprite nofault;
        public static ClickableSprite background;
        public static ClickableSprite infopage;
        public static ClickableSprite exitinfo;
        public static ClickableSprite graphspage;
        public static ClickableSprite exitgraphs;
        public static ClickableSprite faultspage;
        public static ClickableSprite exitfaults;
        public static ClickableSprite load1stats;
        public static ClickableSprite load1statsclick;
        public static ClickableSprite load2stats;
        public static ClickableSprite load2statsclick;
        public static ClickableSprite load3stats;
        public static ClickableSprite load3statsclick;
        public static ClickableSprite load4stats;
        public static ClickableSprite load4statsclick;
        public static ClickableSprite load5stats;
        public static ClickableSprite load5statsclick;
        public static ClickableSprite load6stats;
        public static ClickableSprite load6statsclick;
        public static ClickableSprite faults;
        public static ClickableSprite graphs;
        public static ClickableSprite info;
        public static ClickableSprite play;
        public static ClickableSprite play2;
        public static ClickableSprite play3;
        public static ClickableSprite pause;
        public static ClickableSprite house1solar1;
        public static ClickableSprite house1solar2;
        public static ClickableSprite house1solar3;
        public static ClickableSprite house2solar1;
        public static ClickableSprite house2solar2;
        public static ClickableSprite house3a;
        public static ClickableSprite house3b;
        public static ClickableSprite house3c;
        public static ClickableSprite business1a;
        public static ClickableSprite business1b;
        public static ClickableSprite business2a;
        public static ClickableSprite business2b;
        public static ClickableSprite business2c;
        public static ClickableSprite store;
    }

    public static class Objects {
        public static Sprite battery1;
        public static Sprite battery2;
        public static Sprite battery3;
        public static Sprite balloon;
        public static Sprite midway;
        public static Sprite museum;
        public static Sprite solarpanel;
        public static Sprite stadium;
        public static Sprite substation;
        public static Sprite switch1;
        public static Sprite switch1top;
        public static Sprite switch1middle;
        public static Sprite switch1bottom;
        public static Sprite switch2;
        public static Sprite switch2top;
        public static Sprite switch2middle;
        public static Sprite switch2bottom;
        public static Sprite switch3;
        public static Sprite switch3top;
        public static Sprite switch3middle;
        public static Sprite switch3bottom;
        public static Sprite switch4;
        public static Sprite switch4top;
        public static Sprite switch4middle;
        public static Sprite switch4bottom;
        public static Sprite switch5;
        public static Sprite switch5top;
        public static Sprite switch5middle;
        public static Sprite switch5bottom;
        public static Sprite switch6;
        public static Sprite switch6top;
        public static Sprite switch6middle;
        public static Sprite switch6bottom;
        public static Sprite tie;
        public static Sprite tieopen;
        public static Sprite transformer1;
        public static Sprite transformer2;
        public static Sprite transformer3;
        public static Sprite transformer4;
        public static Sprite transformer5;
        public static Sprite transformer6;
        public static Sprite turbine;
        public static Sprite turbine2;
        public static Sprite play;
        public static Sprite playdown;
        public static Sprite play2;
        public static Sprite play2down;
        public static Sprite play3;
        public static Sprite play3down;
        public static Sprite pause;
        public static Sprite pausedown;
        public static Sprite paths;
        public static Sprite intelligrid;
        public static Sprite trackhoe;
        public static Sprite coal;
        public static Sprite xouta;
        public static Sprite xoutb;
        public static Sprite xoutc;
        public static Sprite xoutd;
        public static Sprite xoute;
        public static Sprite xoutf;
        public static Sprite xouth;
        public static Sprite xouti;
        public static Sprite xoutj;
        public static Sprite xoutk;
        public static Sprite xoutl;
        public static Sprite xoutm;
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

        Objects.paths = new Sprite(new Vector2f(), 2, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.paths);
        Global.getRenderer().addDrawable(Objects.paths);

        Objects.intelligrid = new Sprite(pixelsToCoords(195, 1555), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.intelligrid);
        Global.getRenderer().addDrawable(Objects.intelligrid);

        ClickableObjects.faults = new ClickableSprite(pixelsToCoords(2185, 75), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faults, sizeToCoords(-64,-64), sizeToCoords(64,64), "faults");
        Global.getRenderer().addDrawable(ClickableObjects.faults);
        addClickable(ClickableObjects.faults);

        ClickableObjects.faultspage = new ClickableSprite(pixelsToCoords(1280, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultspage, sizeToCoords(0,0), sizeToCoords(0,0), "faultspage");
        Global.getRenderer().addDrawable(ClickableObjects.faultspage);
        addClickable(ClickableObjects.faultspage);

        ClickableObjects.exitfaults = new ClickableSprite(pixelsToCoords(2280, 1380), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.exit, sizeToCoords(-50,-50), sizeToCoords(50,50), "exitfaults");
        Global.getRenderer().addDrawable(ClickableObjects.exitfaults);
        addClickable(ClickableObjects.exitfaults);

        ClickableObjects.graphs = new ClickableSprite(pixelsToCoords(2335, 75), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.graphs, sizeToCoords(-64,-64), sizeToCoords(64,64), "graphs");
        Global.getRenderer().addDrawable(ClickableObjects.graphs);
        addClickable(ClickableObjects.graphs);

        ClickableObjects.graphspage = new ClickableSprite(pixelsToCoords(1280, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.graphspage, sizeToCoords(0,0), sizeToCoords(0,0), "graphspage");
        Global.getRenderer().addDrawable(ClickableObjects.graphspage);
        addClickable(ClickableObjects.graphspage);

        ClickableObjects.exitgraphs = new ClickableSprite(pixelsToCoords(2280, 1380), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.exit, sizeToCoords(-40,-40), sizeToCoords(40,40), "exitgraphs");
        Global.getRenderer().addDrawable(ClickableObjects.exitgraphs);
        addClickable(ClickableObjects.exitgraphs);

        ClickableObjects.info = new ClickableSprite(pixelsToCoords(2485, 75), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.info, sizeToCoords(-50,-50), sizeToCoords(50,50), "info");
        Global.getRenderer().addDrawable(ClickableObjects.info);
        addClickable(ClickableObjects.info);

        ClickableObjects.infopage = new ClickableSprite(pixelsToCoords(1280, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.infopage, sizeToCoords(0,0), sizeToCoords(0,0), "infopage");
        Global.getRenderer().addDrawable(ClickableObjects.infopage);
        addClickable(ClickableObjects.infopage);

        ClickableObjects.exitinfo = new ClickableSprite(pixelsToCoords(2280, 1380), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.exit, sizeToCoords(-40,-40), sizeToCoords(40,40), "exitinfo");
        Global.getRenderer().addDrawable(ClickableObjects.exitinfo);
        addClickable(ClickableObjects.exitinfo);

        ClickableObjects.play = new ClickableSprite(pixelsToCoords(2200, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play, sizeToCoords(-32,-32), sizeToCoords(32,32), "play");
        Global.getRenderer().addDrawable(ClickableObjects.play);
        addClickable(ClickableObjects.play);

        Objects.playdown = new Sprite(pixelsToCoords(2200, 1550), -1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.playdown);
        Global.getRenderer().addDrawable(Objects.playdown);

        ClickableObjects.play2 = new ClickableSprite(pixelsToCoords(2290, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play2, sizeToCoords(-32,-32), sizeToCoords(32,32), "play2");
        Global.getRenderer().addDrawable(ClickableObjects.play2);
        addClickable(ClickableObjects.play2);

        Objects.play2down = new Sprite(pixelsToCoords(2290, 1550), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play2down);
        Global.getRenderer().addDrawable(Objects.play2down);

        ClickableObjects.play3 = new ClickableSprite(pixelsToCoords(2390, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play3, sizeToCoords(-32,-32), sizeToCoords(32,32), "play3");
        Global.getRenderer().addDrawable(ClickableObjects.play3);
        addClickable(ClickableObjects.play3);

        Objects.play3down = new Sprite(pixelsToCoords(2390, 1550), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.play3down);
        Global.getRenderer().addDrawable(Objects.play3down);

        ClickableObjects.pause = new ClickableSprite(pixelsToCoords(2500, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.pause, sizeToCoords(-32,-32), sizeToCoords(32,32), "pause");
        Global.getRenderer().addDrawable(ClickableObjects.pause);
        addClickable(ClickableObjects.pause);

        Objects.pausedown = new Sprite(pixelsToCoords(2500, 1550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.pausedown);
        Global.getRenderer().addDrawable(Objects.pausedown);

        ClickableObjects.faulta = new ClickableSprite(pixelsToCoords(500, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faulta, sizeToCoords(-56,-60), sizeToCoords(56,60), "faulta");
        Global.getRenderer().addDrawable(ClickableObjects.faulta);
        addClickable(ClickableObjects.faulta);

        ClickableObjects.faultb = new ClickableSprite(pixelsToCoords(650, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultb, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultb");
        Global.getRenderer().addDrawable(ClickableObjects.faultb);
        addClickable(ClickableObjects.faultb);

        ClickableObjects.faultc = new ClickableSprite(pixelsToCoords(800, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultc, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultc");
        Global.getRenderer().addDrawable(ClickableObjects.faultc);
        addClickable(ClickableObjects.faultc);

        ClickableObjects.faultd = new ClickableSprite(pixelsToCoords(950, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultd, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultd");
        Global.getRenderer().addDrawable(ClickableObjects.faultd);
        addClickable(ClickableObjects.faultd);

        ClickableObjects.faulte = new ClickableSprite(pixelsToCoords(1100, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faulte, sizeToCoords(-56,-60), sizeToCoords(56,60), "faulte");
        Global.getRenderer().addDrawable(ClickableObjects.faulte);
        addClickable(ClickableObjects.faulte);

        ClickableObjects.faultf = new ClickableSprite(pixelsToCoords(1250, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultf, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultf");
        Global.getRenderer().addDrawable(ClickableObjects.faultf);
        addClickable(ClickableObjects.faultf);

        ClickableObjects.faulth = new ClickableSprite(pixelsToCoords(500, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faulth, sizeToCoords(-56,-60), sizeToCoords(56,60), "faulth");
        Global.getRenderer().addDrawable(ClickableObjects.faulth);
        addClickable(ClickableObjects.faulth);

        ClickableObjects.faulti = new ClickableSprite(pixelsToCoords(650, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faulti, sizeToCoords(-56,-60), sizeToCoords(56,60), "faulti");
        Global.getRenderer().addDrawable(ClickableObjects.faulti);
        addClickable(ClickableObjects.faulti);

        ClickableObjects.faultj = new ClickableSprite(pixelsToCoords(800, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultj, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultj");
        Global.getRenderer().addDrawable(ClickableObjects.faultj);
        addClickable(ClickableObjects.faultj);

        ClickableObjects.faultk = new ClickableSprite(pixelsToCoords(950, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultk, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultk");
        Global.getRenderer().addDrawable(ClickableObjects.faultk);
        addClickable(ClickableObjects.faultk);

        ClickableObjects.faultl = new ClickableSprite(pixelsToCoords(1100, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultl, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultl");
        Global.getRenderer().addDrawable(ClickableObjects.faultl);
        addClickable(ClickableObjects.faultl);

        ClickableObjects.faultm = new ClickableSprite(pixelsToCoords(1250, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faultm, sizeToCoords(-56,-60), sizeToCoords(56,60), "faultm");
        Global.getRenderer().addDrawable(ClickableObjects.faultm);
        addClickable(ClickableObjects.faultm);

        ClickableObjects.nofault = new ClickableSprite(pixelsToCoords(1400, 500), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.nofault, sizeToCoords(-76,-60), sizeToCoords(76,60), "nofault");
        Global.getRenderer().addDrawable(ClickableObjects.nofault);
        addClickable(ClickableObjects.nofault);

        ClickableObjects.house1solar1 = new ClickableSprite(pixelsToCoords(155, 120), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar, sizeToCoords(-60,-62), sizeToCoords(60,62), "house1solar1");
        Global.getRenderer().addDrawable(ClickableObjects.house1solar1);
        addClickable(ClickableObjects.house1solar1);

        ClickableObjects.house1solar2 = new ClickableSprite(pixelsToCoords(375, 270), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar, sizeToCoords(-60,-62), sizeToCoords(60,62), "house1solar2");
        Global.getRenderer().addDrawable(ClickableObjects.house1solar2);
        addClickable(ClickableObjects.house1solar2);

        ClickableObjects.house1solar3 = new ClickableSprite(pixelsToCoords(615, 270), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house1solar, sizeToCoords(-60,-62), sizeToCoords(60,62), "house1solar3");
        Global.getRenderer().addDrawable(ClickableObjects.house1solar3);
        addClickable(ClickableObjects.house1solar3);

        ClickableObjects.store = new ClickableSprite(pixelsToCoords(135, 490), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.store, sizeToCoords(-84,-64), sizeToCoords(84, 64), "store");
        Global.getRenderer().addDrawable(ClickableObjects.store);
        addClickable(ClickableObjects.store);

        ClickableObjects.house2solar1 = new ClickableSprite(pixelsToCoords(135, 830), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar, sizeToCoords(-69,-68), sizeToCoords(69,68), "house2solar1");
        Global.getRenderer().addDrawable(ClickableObjects.house2solar1);
        addClickable(ClickableObjects.house2solar1);

        ClickableObjects.house2solar2 = new ClickableSprite(pixelsToCoords(430, 830), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house2solar, sizeToCoords(-69,-68), sizeToCoords(69,68), "house2solar2");
        Global.getRenderer().addDrawable(ClickableObjects.house2solar2);
        addClickable(ClickableObjects.house2solar2);

        ClickableObjects.business1a = new ClickableSprite(pixelsToCoords(1500, 480), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1, sizeToCoords(-101,-100), sizeToCoords(101,100), "business1a");
        Global.getRenderer().addDrawable(ClickableObjects.business1a);
        addClickable(ClickableObjects.business1a);

        ClickableObjects.business1b = new ClickableSprite(pixelsToCoords(1920, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business1, sizeToCoords(-101,-100), sizeToCoords(101,100), "business1b");
        Global.getRenderer().addDrawable(ClickableObjects.business1b);
        addClickable(ClickableObjects.business1b);

        ClickableObjects.business2a = new ClickableSprite(pixelsToCoords(1900, 580), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2, sizeToCoords(-71,-118), sizeToCoords(71,118), "business2a");
        Global.getRenderer().addDrawable(ClickableObjects.business2a);
        addClickable(ClickableObjects.business2a);

        ClickableObjects.business2b = new ClickableSprite(pixelsToCoords(2145, 775), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2, sizeToCoords(-71,-118), sizeToCoords(71,118), "business2b");
        Global.getRenderer().addDrawable(ClickableObjects.business2b);
        addClickable(ClickableObjects.business2b);

        ClickableObjects.business2c = new ClickableSprite(pixelsToCoords(2300, 900), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.business2, sizeToCoords(-71,-118), sizeToCoords(71,118), "business2c");
        Global.getRenderer().addDrawable(ClickableObjects.business2c);
        addClickable(ClickableObjects.business2c);

        ClickableObjects.house3a = new ClickableSprite(pixelsToCoords(845, 1023), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3, sizeToCoords(-94,-70), sizeToCoords(94,70), "house3a");
        Global.getRenderer().addDrawable(ClickableObjects.house3a);
        addClickable(ClickableObjects.house3a);

        ClickableObjects.house3b = new ClickableSprite(pixelsToCoords(1061, 1152), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3, sizeToCoords(-94,-70), sizeToCoords(94,70), "house3b");
        Global.getRenderer().addDrawable(ClickableObjects.house3b);
        addClickable(ClickableObjects.house3b);

        ClickableObjects.house3c = new ClickableSprite(pixelsToCoords(1060, 856), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.house3, sizeToCoords(-94,-70), sizeToCoords(94,70), "house3c");
        Global.getRenderer().addDrawable(ClickableObjects.house3c);
        addClickable(ClickableObjects.house3c);

        Objects.museum = new Sprite(pixelsToCoords(310, 1280), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.museum);
        Global.getRenderer().addDrawable(Objects.museum);

        Objects.stadium = new Sprite(pixelsToCoords(2350, 1180), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.stadium);
        Global.getRenderer().addDrawable(Objects.stadium);

        Objects.midway = new Sprite(pixelsToCoords(1722, 125), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.midway);
        Global.getRenderer().addDrawable(Objects.midway);

        Objects.turbine = new Sprite(pixelsToCoords(900, 1420), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine);
        Global.getRenderer().addDrawable(Objects.turbine);

        Objects.turbine2 = new Sprite(pixelsToCoords(1040, 1435), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.turbine);
        Global.getRenderer().addDrawable(Objects.turbine2);

        Objects.balloon = new Sprite(pixelsToCoords(300, 680), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.balloon);
        Global.getRenderer().addDrawable(Objects.balloon);

        Objects.trackhoe = new Sprite(pixelsToCoords(1305, 550), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.trackhoe);
        Global.getRenderer().addDrawable(Objects.trackhoe);

        Objects.battery1 = new Sprite(pixelsToCoords(1500, 1055), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.battery1);
        Global.getRenderer().addDrawable(Objects.battery1);

        Objects.battery2 = new Sprite(pixelsToCoords(1500, 1055), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.battery2);
        Global.getRenderer().addDrawable(Objects.battery2);

        Objects.battery3 = new Sprite(pixelsToCoords(1500, 1055), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.battery3);
        Global.getRenderer().addDrawable(Objects.battery3);

        Objects.solarpanel = new Sprite(pixelsToCoords(2275, 1415), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.solarpanel);
        Global.getRenderer().addDrawable(Objects.solarpanel);

        Objects.substation = new Sprite(pixelsToCoords(1500, 1150), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.substation);
        Global.getRenderer().addDrawable(Objects.substation);

        Objects.coal = new Sprite(pixelsToCoords(1520, 1462), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.coal);
        Global.getRenderer().addDrawable(Objects.coal);

        Objects.transformer1 = new Sprite(pixelsToCoords(1200, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer1);
        Global.getRenderer().addDrawable(Objects.transformer1);

        Objects.transformer2 = new Sprite(pixelsToCoords(520, 640), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer1);
        Global.getRenderer().addDrawable(Objects.transformer2);

        Objects.transformer3 = new Sprite(pixelsToCoords(770, 115), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer1);
        Global.getRenderer().addDrawable(Objects.transformer3);

        Objects.transformer4 = new Sprite(pixelsToCoords(1350, 335), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer1);
        Global.getRenderer().addDrawable(Objects.transformer4);

        Objects.transformer5 = new Sprite(pixelsToCoords(1800, 800), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer1);
        Global.getRenderer().addDrawable(Objects.transformer5);

        Objects.transformer6 = new Sprite(pixelsToCoords(1800, 1150), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.transformer1);
        Global.getRenderer().addDrawable(Objects.transformer6);

        Objects.switch1 = new Sprite(pixelsToCoords(1300, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(Objects.switch1);

        Objects.switch1top = new Sprite(pixelsToCoords(1300, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchtop);
        Global.getRenderer().addDrawable(Objects.switch1top);

        Objects.switch1middle = new Sprite(pixelsToCoords(1300, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchmiddle);
        Global.getRenderer().addDrawable(Objects.switch1middle);

        Objects.switch1bottom = new Sprite(pixelsToCoords(1300, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchbottom);
        Global.getRenderer().addDrawable(Objects.switch1bottom);

        Objects.switch2 = new Sprite(pixelsToCoords(870, 450), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(Objects.switch2);

        Objects.switch2top = new Sprite(pixelsToCoords(870, 450), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchtop);
        Global.getRenderer().addDrawable(Objects.switch2top);

        Objects.switch2middle = new Sprite(pixelsToCoords(870, 450), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchmiddle);
        Global.getRenderer().addDrawable(Objects.switch2middle);

        Objects.switch2bottom = new Sprite(pixelsToCoords(870, 450), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchbottom);
        Global.getRenderer().addDrawable(Objects.switch2bottom);

        Objects.switch3 = new Sprite(pixelsToCoords(870, 115), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(Objects.switch3);

        Objects.switch3top = new Sprite(pixelsToCoords(870, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchtop);
        Global.getRenderer().addDrawable(Objects.switch3top);

        Objects.switch3middle = new Sprite(pixelsToCoords(870, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchmiddle);
        Global.getRenderer().addDrawable(Objects.switch3middle);

        Objects.switch3bottom = new Sprite(pixelsToCoords(870, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchbottom);
        Global.getRenderer().addDrawable(Objects.switch3bottom);

        Objects.switch4 = new Sprite(pixelsToCoords(1250, 335), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(Objects.switch4);

        Objects.switch4top = new Sprite(pixelsToCoords(1250, 335), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchtop);
        Global.getRenderer().addDrawable(Objects.switch4top);

        Objects.switch4middle = new Sprite(pixelsToCoords(1250, 335), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchmiddle);
        Global.getRenderer().addDrawable(Objects.switch4middle);

        Objects.switch4bottom = new Sprite(pixelsToCoords(1250, 335), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchbottom);
        Global.getRenderer().addDrawable(Objects.switch4bottom);

        Objects.switch5 = new Sprite(pixelsToCoords(1700, 800), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(Objects.switch5);

        Objects.switch5top = new Sprite(pixelsToCoords(1700, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchtop);
        Global.getRenderer().addDrawable(Objects.switch5top);

        Objects.switch5middle = new Sprite(pixelsToCoords(1700, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchmiddle);
        Global.getRenderer().addDrawable(Objects.switch5middle);

        Objects.switch5bottom = new Sprite(pixelsToCoords(1700, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchbottom);
        Global.getRenderer().addDrawable(Objects.switch5bottom);

        Objects.switch6 = new Sprite(pixelsToCoords(1700, 1043), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switch1);
        Global.getRenderer().addDrawable(Objects.switch6);

        Objects.switch6top = new Sprite(pixelsToCoords(1700, 1043), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchtop);
        Global.getRenderer().addDrawable(Objects.switch6top);

        Objects.switch6middle = new Sprite(pixelsToCoords(1700, 1043), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchmiddle);
        Global.getRenderer().addDrawable(Objects.switch6middle);

        Objects.switch6bottom = new Sprite(pixelsToCoords(1700, 1043), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.switchbottom);
        Global.getRenderer().addDrawable(Objects.switch6bottom);

        Objects.tie = new Sprite(pixelsToCoords(1050, 115), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.tie);
        Global.getRenderer().addDrawable(Objects.tie);

        Objects.tieopen = new Sprite(pixelsToCoords(1050, 115), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.tieopen);
        Global.getRenderer().addDrawable(Objects.tieopen);

        UIInfo.Load1 = new TextSprite("",
                pixelsToCoords(1000, 1000), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load1);

        ClickableObjects.load1statsclick = new ClickableSprite(pixelsToCoords(980, 1000), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load1statsclick, sizeToCoords(-312,-313), sizeToCoords(312,313), "load1statsclick");
        Global.getRenderer().addDrawable(ClickableObjects.load1statsclick);
        addClickable(ClickableObjects.load1statsclick);

        ClickableObjects.load1stats = new ClickableSprite(pixelsToCoords(1000, 1000), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load1stats");
        Global.getRenderer().addDrawable(ClickableObjects.load1stats);
        addClickable(ClickableObjects.load1stats);

        UIInfo.Load2 = new TextSprite("",
                pixelsToCoords(295, 675), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load2);

        ClickableObjects.load2statsclick = new ClickableSprite(pixelsToCoords(295, 655), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load2statsclick, sizeToCoords(-76,-80), sizeToCoords(76,80), "load2statsclick");
        Global.getRenderer().addDrawable(ClickableObjects.load2statsclick);
        addClickable(ClickableObjects.load2statsclick);

        ClickableObjects.load2stats = new ClickableSprite(pixelsToCoords(295, 675), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load2stats");
        Global.getRenderer().addDrawable(ClickableObjects.load2stats);
        addClickable(ClickableObjects.load2stats);

        UIInfo.Load3 = new TextSprite("",
                pixelsToCoords(400, 190), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load3);

        ClickableObjects.load3statsclick = new ClickableSprite(pixelsToCoords(400, 190), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load3statsclick, sizeToCoords(-119,-52), sizeToCoords(119,52), "load3statsclick");
        Global.getRenderer().addDrawable(ClickableObjects.load3statsclick);
        addClickable(ClickableObjects.load3statsclick);

        ClickableObjects.load3stats = new ClickableSprite(pixelsToCoords(400, 190), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load3stats");
        Global.getRenderer().addDrawable(ClickableObjects.load3stats);
        addClickable(ClickableObjects.load3stats);

        UIInfo.Load4 = new TextSprite("",
                pixelsToCoords(1530, 420), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load4);

        ClickableObjects.load4statsclick = new ClickableSprite(pixelsToCoords(1550, 310), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load4statsclick, sizeToCoords(-225,-330), sizeToCoords(225,330), "load4statsclick");
        Global.getRenderer().addDrawable(ClickableObjects.load4statsclick);
        addClickable(ClickableObjects.load4statsclick);

        ClickableObjects.load4stats = new ClickableSprite(pixelsToCoords(1530, 420), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load4stats");
        Global.getRenderer().addDrawable(ClickableObjects.load4stats);
        addClickable(ClickableObjects.load4stats);

        UIInfo.Load5 = new TextSprite("",
                pixelsToCoords(1980, 720), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load5);

        ClickableObjects.load5statsclick = new ClickableSprite(pixelsToCoords(2100, 600), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load5statsclick, sizeToCoords(-310,-250), sizeToCoords(310,250), "load5statsclick");
        Global.getRenderer().addDrawable(ClickableObjects.load5statsclick);
        addClickable(ClickableObjects.load5statsclick);

        ClickableObjects.load5stats = new ClickableSprite(pixelsToCoords(1980, 720), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load5stats");
        Global.getRenderer().addDrawable(ClickableObjects.load5stats);
        addClickable(ClickableObjects.load5stats);

        UIInfo.Load6 = new TextSprite("",
                pixelsToCoords(2010, 1140), 20, Typeface.DEFAULT, 1000f, 11, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load6);

        ClickableObjects.load6statsclick = new ClickableSprite(pixelsToCoords(2170, 1090), 0, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255, 0), R.drawable.load6statsclick, sizeToCoords(-370,-110), sizeToCoords(370,110), "load6statsclick");
        Global.getRenderer().addDrawable(ClickableObjects.load6statsclick);
        addClickable(ClickableObjects.load6statsclick);

        ClickableObjects.load6stats = new ClickableSprite(pixelsToCoords(2010, 1140), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.loadstats, sizeToCoords(-211,-140), sizeToCoords(211,140), "load6stats");
        Global.getRenderer().addDrawable(ClickableObjects.load6stats);
        addClickable(ClickableObjects.load6stats);

        UIInfo.trA = new TextSprite("",
                pixelsToCoords(1370, 1200), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trA);

        Objects.xouta = new Sprite(pixelsToCoords(1350, 1150), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xouta);

        UIInfo.trB = new TextSprite("",
                pixelsToCoords(1230, 945), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trB);

        Objects.xoutb = new Sprite(pixelsToCoords(1063, 1005), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutb);

        UIInfo.trC = new TextSprite("",
                pixelsToCoords(960, 670), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trC);

        Objects.xoutc = new Sprite(pixelsToCoords(885, 747), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutc);

        UIInfo.trD = new TextSprite("",
                pixelsToCoords(620, 640), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trD);

        Objects.xoutd = new Sprite(pixelsToCoords(350, 647), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutd);

        UIInfo.trE = new TextSprite("",
                pixelsToCoords(960, 300), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trE);

        Objects.xoute = new Sprite(pixelsToCoords(870, 290), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoute);

        UIInfo.trF = new TextSprite("",
                pixelsToCoords(800, 60), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trF);

        Objects.xoutf = new Sprite(pixelsToCoords(470, 120), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutf);

        UIInfo.trG = new TextSprite("",
                pixelsToCoords(1145, 110), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trG);

        UIInfo.trH = new TextSprite("",
                pixelsToCoords(1370, 280), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trH);

        Objects.xouth = new Sprite(pixelsToCoords(1500, 336), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xouth);

        UIInfo.trI = new TextSprite("",
                pixelsToCoords(1500, 650), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trI);

        Objects.xouti = new Sprite(pixelsToCoords(1500, 620), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xouti);

        UIInfo.trJ = new TextSprite("",
                pixelsToCoords(1820, 745), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trJ);

        Objects.xoutj = new Sprite(pixelsToCoords(1898, 800), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutj);

        UIInfo.trK = new TextSprite("",
                pixelsToCoords(1635, 910), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trK);

        Objects.xoutk = new Sprite(pixelsToCoords(1700, 920), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutk);

        UIInfo.trL = new TextSprite("",
                pixelsToCoords(1820, 1095), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trL);

        Objects.xoutl = new Sprite(pixelsToCoords(1922, 1150), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutl);

        UIInfo.trM = new TextSprite("",
                pixelsToCoords(1680, 1200), 30, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trM);

        Objects.xoutm = new Sprite(pixelsToCoords(1647, 1150), 11, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.xout);
        Global.getRenderer().addDrawable(Objects.xoutm);

        UIInfo.WindTurbines = new TextSprite("",
                pixelsToCoords(1250, 1370), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.WindTurbines);

        UIInfo.PowPlant = new TextSprite("",
                pixelsToCoords(1930, 1370), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.PowPlant);

//        UIInfo.transTotal = new TextSprite("",
//                pixelsToCoords(1515, 1060), 20, Typeface.DEFAULT, 1000f, 0, 0,
//                new Vector2f(1f, 1f), new Color(0, 0, 0));
//        Global.getRenderer().addDrawable(UIInfo.transTotal);

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
        ledPositionMap.put(131, pixelsToCoords(1698, 915));
        ledPositionMap.put(132, pixelsToCoords(1698, 930));
        ledPositionMap.put(133, pixelsToCoords(1698, 950));
        ledPositionMap.put(134, pixelsToCoords(1698, 980));
        ledPositionMap.put(135, pixelsToCoords(1698, 1010));
        ledPositionMap.put(136, pixelsToCoords(1698, 1040));
        ledPositionMap.put(137, pixelsToCoords(1698, 1100));
        ledPositionMap.put(138, pixelsToCoords(1720, 1040));
        ledPositionMap.put(139, pixelsToCoords(1735, 1090));
        ledPositionMap.put(140, pixelsToCoords(1735, 1140));
        ledPositionMap.put(141, pixelsToCoords(1780, 1150));
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
        ledPositionMap.put(152, pixelsToCoords(1690, 1130));
        ledPositionMap.put(153, pixelsToCoords(1680, 1150));
        ledPositionMap.put(154, pixelsToCoords(1620, 1150));
        ledPositionMap.put(155, pixelsToCoords(1540, 1230));
        ledPositionMap.put(156, pixelsToCoords(1540, 1300));
        ledPositionMap.put(157, pixelsToCoords(1540, 1400));
        ledPositionMap.put(158, pixelsToCoords(1540, 1410));
        ledPositionMap.put(159, pixelsToCoords(1590, 1410));
        ledPositionMap.put(160, pixelsToCoords(1640, 1410));
        ledPositionMap.put(161, pixelsToCoords(1680, 1410));
        ledPositionMap.put(162, pixelsToCoords(1710, 1410));
        ledPositionMap.put(163, pixelsToCoords(1780, 1410));
        ledPositionMap.put(164, pixelsToCoords(1820, 1410));
        ledPositionMap.put(165, pixelsToCoords(1870, 1410));
        ledPositionMap.put(166, pixelsToCoords(1910, 1410));
        ledPositionMap.put(167, pixelsToCoords(2057, 1410));
        ledPositionMap.put(168, pixelsToCoords(1508, 1410));
        ledPositionMap.put(169, pixelsToCoords(1400, 1410));
        ledPositionMap.put(170, pixelsToCoords(1300, 1410));
        ledPositionMap.put(171, pixelsToCoords(1200, 1410));
        ledPositionMap.put(172, pixelsToCoords(1150, 1410));
        ledPositionMap.put(173, pixelsToCoords(1130, 1410));
        ledPositionMap.put(174, pixelsToCoords(1100, 1410));
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
    private boolean night = false;

    private LightAnimation lightAnimation;

    private static final float TEXT_UPDATE_INTERVAL = 0.1f;
    private static final double TEXT_UPDATE_CHANCE = 0.25;

    private double textUpdateChance = 1.0;
    private float textUpdateTimer = TEXT_UPDATE_INTERVAL;
    
    private static final float LIGHT_PACKET_INTERVAL = (float) (1.0 / 9.0);
    private float lightPacketTimer = LIGHT_PACKET_INTERVAL;

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

        // Battery Levels
        if (Simulation.SimInfo.BatteryLevel == 1) {
            Objects.battery1.setDepth(-1);
            Objects.battery2.setDepth(11);
            Objects.battery3.setDepth(11);
        }
        else if (Simulation.SimInfo.BatteryLevel == 2) {
            Objects.battery1.setDepth(11);
            Objects.battery2.setDepth(-1);
            Objects.battery3.setDepth(11);
        }
        else if (Simulation.SimInfo.BatteryLevel == 3) {
            Objects.battery1.setDepth(11);
            Objects.battery2.setDepth(11);
            Objects.battery3.setDepth(-1);
        }

        // Night Time Mode
        if ((Simulation.SimInfo.currentTime > 18.00 || Simulation.SimInfo.currentTime < 6.00) && !night) {
            night = true;
            ClickableObjects.background.setResource(R.drawable.backgroundnight);
            ClickableObjects.graphs.setResource(R.drawable.graphsnight);
            ClickableObjects.info.setResource(R.drawable.infonight);
            ClickableObjects.business1a.setResource(R.drawable.business1night);
            ClickableObjects.business1b.setResource(R.drawable.business1night);
            ClickableObjects.business2a.setResource(R.drawable.business2night);
            ClickableObjects.business2b.setResource(R.drawable.business2night);
            ClickableObjects.business2c.setResource(R.drawable.business2night);
            ClickableObjects.house1solar1.setResource(R.drawable.house1solarnight);
            ClickableObjects.house1solar2.setResource(R.drawable.house1solarnight);
            ClickableObjects.house1solar3.setResource(R.drawable.house1solarnight);
            ClickableObjects.house2solar1.setResource(R.drawable.house2solarnight);
            ClickableObjects.house2solar2.setResource(R.drawable.house2solarnight);
            ClickableObjects.store.setResource(R.drawable.storenight);
            ClickableObjects.house3a.setResource(R.drawable.house3night);
            ClickableObjects.house3b.setResource(R.drawable.house3night);
            ClickableObjects.house3c.setResource(R.drawable.house3night);
            Objects.coal.setResource(R.drawable.coalnight);
            Objects.battery1.setResource(R.drawable.battery1night);
            Objects.battery2.setResource(R.drawable.battery2night);
            Objects.battery3.setResource(R.drawable.battery3night);
            Objects.midway.setResource(R.drawable.midwaynight);
            Objects.museum.setResource(R.drawable.museumnight);
            Objects.solarpanel.setResource(R.drawable.solarpanelnight);
            Objects.stadium.setResource(R.drawable.stadiumnight);
            Objects.substation.setResource(R.drawable.substationnight);
            Objects.coal.setResource(R.drawable.coalnight);
            Objects.switch1top.setResource(R.drawable.switchtopnight);
            Objects.switch1middle.setResource(R.drawable.switchmiddlenight);
            Objects.switch1bottom.setResource(R.drawable.switchbottomnight);
            Objects.switch2top.setResource(R.drawable.switchtopnight);
            Objects.switch2middle.setResource(R.drawable.switchmiddlenight);
            Objects.switch2bottom.setResource(R.drawable.switchbottomnight);
            Objects.switch3top.setResource(R.drawable.switchtopnight);
            Objects.switch3middle.setResource(R.drawable.switchmiddlenight);
            Objects.switch3bottom.setResource(R.drawable.switchbottomnight);
            Objects.switch4top.setResource(R.drawable.switchtopnight);
            Objects.switch4middle.setResource(R.drawable.switchmiddlenight);
            Objects.switch4bottom.setResource(R.drawable.switchbottomnight);
            Objects.switch5top.setResource(R.drawable.switchtopnight);
            Objects.switch5middle.setResource(R.drawable.switchmiddlenight);
            Objects.switch5bottom.setResource(R.drawable.switchbottomnight);
            Objects.switch6top.setResource(R.drawable.switchtopnight);
            Objects.switch6middle.setResource(R.drawable.switchmiddlenight);
            Objects.switch6bottom.setResource(R.drawable.switchbottomnight);
            Objects.switch1.setResource(R.drawable.switch1night);
            Objects.switch2.setResource(R.drawable.switch1night);
            Objects.switch3.setResource(R.drawable.switch1night);
            Objects.switch4.setResource(R.drawable.switch1night);
            Objects.switch5.setResource(R.drawable.switch1night);
            Objects.switch6.setResource(R.drawable.switch1night);
            Objects.tie.setResource(R.drawable.tienight);
            Objects.tieopen.setResource(R.drawable.tieopennight);
            Objects.transformer1.setResource(R.drawable.transformer1night);
            Objects.transformer2.setResource(R.drawable.transformer1night);
            Objects.transformer3.setResource(R.drawable.transformer1night);
            Objects.transformer4.setResource(R.drawable.transformer1night);
            Objects.transformer5.setResource(R.drawable.transformer1night);
            Objects.transformer6.setResource(R.drawable.transformer1night);
            Objects.turbine.setResource(R.drawable.turbinenight);
            Objects.turbine2.setResource(R.drawable.turbinenight);
            Objects.balloon.setResource(R.drawable.balloonnight);
            Objects.trackhoe.setResource(R.drawable.trackhoenight);
            UIInfo.trA.setColor(new Color(255, 255, 255));
            UIInfo.trB.setColor(new Color(255, 255, 255));
            UIInfo.trC.setColor(new Color(255, 255, 255));
            UIInfo.trD.setColor(new Color(255, 255, 255));
            UIInfo.trE.setColor(new Color(255, 255, 255));
            UIInfo.trF.setColor(new Color(255, 255, 255));
            UIInfo.trG.setColor(new Color(255, 255, 255));
            UIInfo.trH.setColor(new Color(255, 255, 255));
            UIInfo.trI.setColor(new Color(255, 255, 255));
            UIInfo.trJ.setColor(new Color(255, 255, 255));
            UIInfo.trK.setColor(new Color(255, 255, 255));
            UIInfo.trL.setColor(new Color(255, 255, 255));
            UIInfo.trM.setColor(new Color(255, 255, 255));
            UIInfo.PowPlant.setColor(new Color(255, 255, 255));
            UIInfo.WindTurbines.setColor(new Color(255, 255, 255));
        }

        // Day Time Mode
        if ((Simulation.SimInfo.currentTime <= 18.00 && Simulation.SimInfo.currentTime >= 6.00) && night) {
            night = false;
            ClickableObjects.background.setResource(R.drawable.background);
            ClickableObjects.business1a.setResource(R.drawable.business1);
            ClickableObjects.business1b.setResource(R.drawable.business1);
            ClickableObjects.business2a.setResource(R.drawable.business2);
            ClickableObjects.business2b.setResource(R.drawable.business2);
            ClickableObjects.business2c.setResource(R.drawable.business2);
            ClickableObjects.graphs.setResource(R.drawable.graphs);
            ClickableObjects.info.setResource(R.drawable.info);
            ClickableObjects.house1solar1.setResource(R.drawable.house1solar);
            ClickableObjects.house1solar2.setResource(R.drawable.house1solar);
            ClickableObjects.house1solar3.setResource(R.drawable.house1solar);
            ClickableObjects.house2solar1.setResource(R.drawable.house2solar);
            ClickableObjects.house2solar2.setResource(R.drawable.house2solar);
            ClickableObjects.store.setResource(R.drawable.store);
            ClickableObjects.house3a.setResource(R.drawable.house3);
            ClickableObjects.house3b.setResource(R.drawable.house3);
            ClickableObjects.house3c.setResource(R.drawable.house3);
            Objects.coal.setResource(R.drawable.coal);
            Objects.battery1.setResource(R.drawable.battery1);
            Objects.battery2.setResource(R.drawable.battery2);
            Objects.battery3.setResource(R.drawable.battery3);
            Objects.midway.setResource(R.drawable.midway);
            Objects.midway.setResource(R.drawable.midway);
            Objects.museum.setResource(R.drawable.museum);
            Objects.solarpanel.setResource(R.drawable.solarpanel);
            Objects.stadium.setResource(R.drawable.stadium);
            Objects.substation.setResource(R.drawable.substation);
            Objects.switch1top.setResource(R.drawable.switchtop);
            Objects.switch1middle.setResource(R.drawable.switchmiddle);
            Objects.switch1bottom.setResource(R.drawable.switchbottom);
            Objects.switch2top.setResource(R.drawable.switchtop);
            Objects.switch2middle.setResource(R.drawable.switchmiddle);
            Objects.switch2bottom.setResource(R.drawable.switchbottom);
            Objects.switch3top.setResource(R.drawable.switchtop);
            Objects.switch3middle.setResource(R.drawable.switchmiddle);
            Objects.switch3bottom.setResource(R.drawable.switchbottom);
            Objects.switch4top.setResource(R.drawable.switchtop);
            Objects.switch4middle.setResource(R.drawable.switchmiddle);
            Objects.switch4bottom.setResource(R.drawable.switchbottom);
            Objects.switch5top.setResource(R.drawable.switchtop);
            Objects.switch5middle.setResource(R.drawable.switchmiddle);
            Objects.switch5bottom.setResource(R.drawable.switchbottom);
            Objects.switch6top.setResource(R.drawable.switchtop);
            Objects.switch6middle.setResource(R.drawable.switchmiddle);
            Objects.switch6bottom.setResource(R.drawable.switchbottom);
            Objects.switch1.setResource(R.drawable.switch1);
            Objects.switch2.setResource(R.drawable.switch1);
            Objects.switch3.setResource(R.drawable.switch1);
            Objects.switch4.setResource(R.drawable.switch1);
            Objects.switch5.setResource(R.drawable.switch1);
            Objects.switch6.setResource(R.drawable.switch1);
            Objects.tie.setResource(R.drawable.tie);
            Objects.tieopen.setResource(R.drawable.tieopen);
            Objects.transformer1.setResource(R.drawable.transformer1);
            Objects.transformer2.setResource(R.drawable.transformer1);
            Objects.transformer3.setResource(R.drawable.transformer1);
            Objects.transformer4.setResource(R.drawable.transformer1);
            Objects.transformer5.setResource(R.drawable.transformer1);
            Objects.transformer6.setResource(R.drawable.transformer1);
            Objects.turbine.setResource(R.drawable.turbine);
            Objects.turbine2.setResource(R.drawable.turbine);
            Objects.balloon.setResource(R.drawable.balloon);
            Objects.trackhoe.setResource(R.drawable.trackhoe);
            UIInfo.trA.setColor(new Color(0, 0, 0));
            UIInfo.trB.setColor(new Color(0, 0, 0));
            UIInfo.trC.setColor(new Color(0, 0, 0));
            UIInfo.trD.setColor(new Color(0, 0, 0));
            UIInfo.trE.setColor(new Color(0, 0, 0));
            UIInfo.trF.setColor(new Color(0, 0, 0));
            UIInfo.trG.setColor(new Color(0, 0, 0));
            UIInfo.trH.setColor(new Color(0, 0, 0));
            UIInfo.trI.setColor(new Color(0, 0, 0));
            UIInfo.trJ.setColor(new Color(0, 0, 0));
            UIInfo.trK.setColor(new Color(0, 0, 0));
            UIInfo.trL.setColor(new Color(0, 0, 0));
            UIInfo.trM.setColor(new Color(0, 0, 0));
            UIInfo.PowPlant.setColor(new Color(0, 0, 0));
            UIInfo.WindTurbines.setColor(new Color(0, 0, 0));
        }

        textUpdateTimer -= amount;
        if (textUpdateTimer <= 0f) {
            if (Math.random() < textUpdateChance)
                UIInfo.Load1.setText("\t" + "Residential 1" + "\n"
                                + "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load1) + " MW" + "\n"
                                + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load1r) + " MVAR" + "\n"
                                + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load1a) + " MVA",
                        UIInfo.Load1.getFontSize(), UIInfo.Load1.getFont(),
                        UIInfo.Load1.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load2.setText("\t" + "Residential 1" + "\n"
                                + "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load2) + " MW" + "\n"
                                + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load2r) + " MVAR" + "\n"
                                + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load2a) + " MVA",
                        UIInfo.Load2.getFontSize(), UIInfo.Load2.getFont(),
                        UIInfo.Load2.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load3.setText("\t" + "Residential 1" + "\n"
                                + "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load3) + " MW" + "\n"
                                + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load3r) + " MVAR" + "\n"
                                + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load3a) + " MVA",
                        UIInfo.Load3.getFontSize(), UIInfo.Load3.getFont(),
                        UIInfo.Load3.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load4.setText("\t" + "Residential 1" + "\n"
                                + "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load4) + " MW" + "\n"
                                + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load4r) + " MVAR" + "\n"
                                + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load4a) + " MVA",
                        UIInfo.Load4.getFontSize(), UIInfo.Load4.getFont(),
                        UIInfo.Load4.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load5.setText("\t" + "Residential 1" + "\n"
                                + "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load5) + " MW" + "\n"
                                + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load5r) + " MVAR" + "\n"
                                + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load5a) + " MVA",
                        UIInfo.Load5.getFontSize(), UIInfo.Load5.getFont(),
                        UIInfo.Load5.getMaxLineWidth());

            if (Math.random() < textUpdateChance)
                UIInfo.Load6.setText("\t" + "Residential 1" + "\n"
                                + "Real Power: " + "" + String.format("%.2f", Simulation.SimInfo.Load6) + " MW" + "\n"
                                + "Reactive Power: " + String.format("%.2f", Simulation.SimInfo.Load6r) + " MVAR" + "\n"
                                + "Apparent Power: " + String.format("%.2f", Simulation.SimInfo.Load6a) + " MVA",
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

//            if (Math.random() < textUpdateChance)
//                UIInfo.transTotal.setText("" + String.format("%.2f", Simulation.SimInfo.transTotal) + " MVA",
//                        UIInfo.transTotal.getFontSize(), UIInfo.transTotal.getFont(),
//                        UIInfo.transTotal.getMaxLineWidth());

//            if (Math.random() < textUpdateChance)
//                UIInfo.SDGE.setText("" + String.format("%.2f", Simulation.SimInfo.SDGE) + " MW",
//                        UIInfo.SDGE.getFontSize(), UIInfo.SDGE.getFont(),
//                        UIInfo.SDGE.getMaxLineWidth());

            UIInfo.currentTime.setText("Time: " + "" + String.format("%.2f", Simulation.SimInfo.currentTime),
                    UIInfo.currentTime.getFontSize(), UIInfo.currentTime.getFont(),
                    UIInfo.currentTime.getMaxLineWidth());

            textUpdateTimer += TEXT_UPDATE_INTERVAL;
        }

        lightPacketTimer -= amount;
        lightAnimation.advance(amount);
        if (lightPacketTimer <= 0f) {
            lightAnimation.advanceState(amount);
            MainNetworkHandler.constructAndSendPacket(PacketTypes.LIGHT_ANIMATION, null);
            lightPacketTimer = LIGHT_PACKET_INTERVAL;
        }

        textUpdateChance = TEXT_UPDATE_CHANCE;
    }
}
