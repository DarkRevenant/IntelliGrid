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
import org.sdsu.intelligrid.simulation.Simulation;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * User interface class for the application.
 */
public class MainUI {

    private final List<Clickable> clickableList = new ArrayList<>();

    public final static Map<Integer, Vector2f> ledPositionMap = new HashMap<>();

    static {
        // Use this format; just have 177 lines placing the pixel locations for
        // each of the LEDs
        ledPositionMap.put(1, pixelsToCoords(1500, 1150));
        ledPositionMap.put(2, pixelsToCoords(1450, 1150));
        ledPositionMap.put(3, pixelsToCoords(1450, 1140));
        ledPositionMap.put(4, pixelsToCoords(1450, 1130));
        ledPositionMap.put(5, pixelsToCoords(1450, 1120));
        ledPositionMap.put(6, pixelsToCoords(1450, 1110));
        ledPositionMap.put(7, pixelsToCoords(1440, 1110));
        ledPositionMap.put(8, pixelsToCoords(1430, 1110));
        ledPositionMap.put(9, pixelsToCoords(1420, 1110));
        ledPositionMap.put(10, pixelsToCoords(1410, 1110));
        ledPositionMap.put(11, pixelsToCoords(1410, 1120));
        ledPositionMap.put(12, pixelsToCoords(1410, 1130));
        ledPositionMap.put(13, pixelsToCoords(1400, 1110));
        ledPositionMap.put(14, pixelsToCoords(1390, 1110));
        ledPositionMap.put(15, pixelsToCoords(1410, 1100));
        ledPositionMap.put(16, pixelsToCoords(1410, 1090));
        ledPositionMap.put(17, pixelsToCoords(1450, 1100));
        ledPositionMap.put(18, pixelsToCoords(1450, 1090));
        ledPositionMap.put(19, pixelsToCoords(1450, 1080));
        ledPositionMap.put(20, pixelsToCoords(1450, 1070));
        ledPositionMap.put(21, pixelsToCoords(1450, 1060));
        ledPositionMap.put(22, pixelsToCoords(1440, 1140));
        ledPositionMap.put(23, pixelsToCoords(1430, 1130));
        ledPositionMap.put(24, pixelsToCoords(1420, 1120));
        ledPositionMap.put(25, pixelsToCoords(1410, 1110));
        ledPositionMap.put(26, pixelsToCoords(1400, 1100));
        ledPositionMap.put(27, pixelsToCoords(1390, 1090));
        ledPositionMap.put(28, pixelsToCoords(1380, 1080));
        ledPositionMap.put(29, pixelsToCoords(1370, 1070));
        ledPositionMap.put(30, pixelsToCoords(1360, 1060));
        ledPositionMap.put(31, pixelsToCoords(1350, 1050));
        ledPositionMap.put(32, pixelsToCoords(1340, 1040));
        ledPositionMap.put(33, pixelsToCoords(1330, 1030));
        ledPositionMap.put(34, pixelsToCoords(1320, 1020));
        ledPositionMap.put(35, pixelsToCoords(1310, 1010));
        ledPositionMap.put(36, pixelsToCoords(1300, 1000));
        ledPositionMap.put(37, pixelsToCoords(1290, 1090));
        ledPositionMap.put(38, pixelsToCoords(1280, 1080));
        ledPositionMap.put(39, pixelsToCoords(1270, 1070));
        ledPositionMap.put(40, pixelsToCoords(1260, 1060));
        ledPositionMap.put(41, pixelsToCoords(1250, 1050));
        ledPositionMap.put(42, pixelsToCoords(1240, 1040));
        ledPositionMap.put(43, pixelsToCoords(1230, 1030));
        ledPositionMap.put(44, pixelsToCoords(1220, 1020));
        ledPositionMap.put(45, pixelsToCoords(1210, 1010));
        ledPositionMap.put(46, pixelsToCoords(1200, 1000));
        ledPositionMap.put(47, pixelsToCoords(1190, 1090));
        ledPositionMap.put(48, pixelsToCoords(1180, 1080));
        ledPositionMap.put(49, pixelsToCoords(1170, 1070));
        ledPositionMap.put(50, pixelsToCoords(1160, 1060));
        ledPositionMap.put(51, pixelsToCoords(1150, 1050));
        ledPositionMap.put(52, pixelsToCoords(1140, 1040));
        ledPositionMap.put(53, pixelsToCoords(1130, 1030));
        ledPositionMap.put(54, pixelsToCoords(1120, 1020));
        ledPositionMap.put(55, pixelsToCoords(1110, 1010));
        ledPositionMap.put(56, pixelsToCoords(1100, 1000));
        ledPositionMap.put(57, pixelsToCoords(1090, 990));
        ledPositionMap.put(58, pixelsToCoords(1080, 980));
        ledPositionMap.put(59, pixelsToCoords(1070, 970));
        ledPositionMap.put(60, pixelsToCoords(1060, 960));
        ledPositionMap.put(61, pixelsToCoords(1050, 950));
        ledPositionMap.put(62, pixelsToCoords(1040, 940));
        ledPositionMap.put(63, pixelsToCoords(1030, 930));
        ledPositionMap.put(64, pixelsToCoords(1020, 920));
        ledPositionMap.put(65, pixelsToCoords(1010, 910));
        ledPositionMap.put(66, pixelsToCoords(1000, 900));
        ledPositionMap.put(67, pixelsToCoords(990, 890));
        ledPositionMap.put(68, pixelsToCoords(980, 880));
        ledPositionMap.put(69, pixelsToCoords(970, 870));
        ledPositionMap.put(70, pixelsToCoords(960, 860));
        ledPositionMap.put(71, pixelsToCoords(950, 850));
        ledPositionMap.put(72, pixelsToCoords(940, 840));
        ledPositionMap.put(73, pixelsToCoords(930, 830));
        ledPositionMap.put(74, pixelsToCoords(920, 820));
        ledPositionMap.put(75, pixelsToCoords(910, 810));
        ledPositionMap.put(76, pixelsToCoords(900, 800));
        ledPositionMap.put(77, pixelsToCoords(890, 790));
        ledPositionMap.put(78, pixelsToCoords(880, 780));
        ledPositionMap.put(79, pixelsToCoords(870, 770));
        ledPositionMap.put(80, pixelsToCoords(860, 760));
        ledPositionMap.put(81, pixelsToCoords(850, 750));
        ledPositionMap.put(82, pixelsToCoords(840, 740));
        ledPositionMap.put(83, pixelsToCoords(10, 1150));
        ledPositionMap.put(84, pixelsToCoords(20, 1150));
        ledPositionMap.put(85, pixelsToCoords(30, 1150));
        ledPositionMap.put(86, pixelsToCoords(40, 1150));
        ledPositionMap.put(87, pixelsToCoords(50, 1150));
        ledPositionMap.put(88, pixelsToCoords(60, 1150));
        ledPositionMap.put(89, pixelsToCoords(70, 1150));
        ledPositionMap.put(90, pixelsToCoords(80, 1150));
        ledPositionMap.put(91, pixelsToCoords(90, 1150));
        ledPositionMap.put(92, pixelsToCoords(100, 1150));
        ledPositionMap.put(93, pixelsToCoords(110, 1150));
        ledPositionMap.put(94, pixelsToCoords(120, 1150));
        ledPositionMap.put(95, pixelsToCoords(130, 1150));
        ledPositionMap.put(96, pixelsToCoords(140, 1150));
        ledPositionMap.put(97, pixelsToCoords(150, 1150));
        ledPositionMap.put(98, pixelsToCoords(160, 1150));
        ledPositionMap.put(99, pixelsToCoords(170, 1150));
        ledPositionMap.put(100, pixelsToCoords(180, 1150));
        ledPositionMap.put(101, pixelsToCoords(190, 1150));
        ledPositionMap.put(102, pixelsToCoords(200, 1150));
        ledPositionMap.put(103, pixelsToCoords(210, 1150));
        ledPositionMap.put(104, pixelsToCoords(220, 1150));
        ledPositionMap.put(105, pixelsToCoords(230, 1150));
        ledPositionMap.put(106, pixelsToCoords(240, 1150));
        ledPositionMap.put(107, pixelsToCoords(250, 1150));
        ledPositionMap.put(108, pixelsToCoords(260, 1150));
        ledPositionMap.put(109, pixelsToCoords(270, 1150));
        ledPositionMap.put(110, pixelsToCoords(280, 1150));
        ledPositionMap.put(111, pixelsToCoords(290, 1150));
        ledPositionMap.put(112, pixelsToCoords(300, 1150));
        ledPositionMap.put(113, pixelsToCoords(310, 1150));
        ledPositionMap.put(114, pixelsToCoords(320, 1150));
        ledPositionMap.put(115, pixelsToCoords(330, 1150));
        ledPositionMap.put(116, pixelsToCoords(340, 1150));
        ledPositionMap.put(117, pixelsToCoords(350, 1150));
        ledPositionMap.put(118, pixelsToCoords(360, 1150));
        ledPositionMap.put(119, pixelsToCoords(370, 1150));
        ledPositionMap.put(120, pixelsToCoords(380, 1150));
        ledPositionMap.put(121, pixelsToCoords(390, 1150));
        ledPositionMap.put(122, pixelsToCoords(400, 1150));
        ledPositionMap.put(123, pixelsToCoords(410, 1150));
        ledPositionMap.put(124, pixelsToCoords(420, 1150));
        ledPositionMap.put(125, pixelsToCoords(730, 1150));
        ledPositionMap.put(126, pixelsToCoords(740, 1150));
        ledPositionMap.put(127, pixelsToCoords(750, 1150));
        ledPositionMap.put(128, pixelsToCoords(760, 1150));
        ledPositionMap.put(129, pixelsToCoords(770, 1150));
        ledPositionMap.put(130, pixelsToCoords(780, 1150));
        ledPositionMap.put(131, pixelsToCoords(790, 1150));
        ledPositionMap.put(132, pixelsToCoords(800, 1150));
        ledPositionMap.put(133, pixelsToCoords(810, 1150));
        ledPositionMap.put(134, pixelsToCoords(820, 1150));
        ledPositionMap.put(135, pixelsToCoords(830, 1150));
        ledPositionMap.put(136, pixelsToCoords(840, 1150));
        ledPositionMap.put(137, pixelsToCoords(850, 1150));
        ledPositionMap.put(138, pixelsToCoords(860, 1150));
        ledPositionMap.put(139, pixelsToCoords(870, 1150));
        ledPositionMap.put(140, pixelsToCoords(880, 1150));
        ledPositionMap.put(141, pixelsToCoords(890, 1150));
        ledPositionMap.put(142, pixelsToCoords(900, 1150));
        ledPositionMap.put(143, pixelsToCoords(910, 1150));
        ledPositionMap.put(144, pixelsToCoords(920, 1150));
        ledPositionMap.put(145, pixelsToCoords(930, 1150));
        ledPositionMap.put(146, pixelsToCoords(940, 1150));
        ledPositionMap.put(147, pixelsToCoords(950, 1150));
        ledPositionMap.put(148, pixelsToCoords(960, 1150));
        ledPositionMap.put(149, pixelsToCoords(970, 1150));
        ledPositionMap.put(150, pixelsToCoords(980, 1150));
        ledPositionMap.put(151, pixelsToCoords(990, 1150));
        ledPositionMap.put(152, pixelsToCoords(1000, 1150));
        ledPositionMap.put(153, pixelsToCoords(1010, 1150));
        ledPositionMap.put(154, pixelsToCoords(1020, 1150));
        ledPositionMap.put(155, pixelsToCoords(1030, 1150));
        ledPositionMap.put(156, pixelsToCoords(1040, 1150));
        ledPositionMap.put(157, pixelsToCoords(1050, 1150));
        ledPositionMap.put(158, pixelsToCoords(1060, 1150));
        ledPositionMap.put(159, pixelsToCoords(1070, 1150));
        ledPositionMap.put(160, pixelsToCoords(1080, 1150));
        ledPositionMap.put(161, pixelsToCoords(1090, 1150));
        ledPositionMap.put(162, pixelsToCoords(1100, 1150));
        ledPositionMap.put(163, pixelsToCoords(1110, 1150));
        ledPositionMap.put(164, pixelsToCoords(1120, 1150));
        ledPositionMap.put(165, pixelsToCoords(1130, 1150));
        ledPositionMap.put(166, pixelsToCoords(1140, 1150));
        ledPositionMap.put(167, pixelsToCoords(1150, 1150));
        ledPositionMap.put(168, pixelsToCoords(1160, 1150));
        ledPositionMap.put(169, pixelsToCoords(1170, 1150));
        ledPositionMap.put(170, pixelsToCoords(1180, 1150));
        ledPositionMap.put(171, pixelsToCoords(1190, 1150));
        ledPositionMap.put(172, pixelsToCoords(1200, 1150));
        ledPositionMap.put(173, pixelsToCoords(1210, 1150));
        ledPositionMap.put(174, pixelsToCoords(1220, 1150));
        ledPositionMap.put(175, pixelsToCoords(1230, 1150));
        ledPositionMap.put(176, pixelsToCoords(1240, 1150));
        ledPositionMap.put(177, pixelsToCoords(1250, 1150));

        // Delete below once you've placed them in the right spots. The
        // animation will look wrong if they're in the wrong spots, so it should
        // be easy to test.
//        float a = -1.6f;
//        float b = -1f;
//        for (int i = 1; i <= 177; i++) {
//            ledPositionMap.put(i, new Vector2f(a, b));
//            a += 0.1f;
//            if (a >= 1.6f) {
//                a = -1.6f;
//                b += 0.1f;
//            }
//        }
    }

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
        resources.add(R.drawable.orb);
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

        ClickableSprite settings = new ClickableSprite(pixelsToCoords(2485, 75), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.settings, pixelsToCoords(2485,55), pixelsToCoords(2505,75), "settings");
        Global.getRenderer().addDrawable(settings);

        ClickableSprite info = new ClickableSprite(pixelsToCoords(2335, 75), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.info, pixelsToCoords(2335,55), pixelsToCoords(2355,75), "info");
        Global.getRenderer().addDrawable(info);

        ClickableSprite faults = new ClickableSprite(pixelsToCoords(2185, 75), 1, 0f, new Vector2f(1f, 1f),
                new Color(255, 255, 255), R.drawable.faults, pixelsToCoords(2185,55), pixelsToCoords(2205,75), "faults");
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

        UIInfo.Load1 = new TextSprite("",
                pixelsToCoords(1080, 1020), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load1);

        UIInfo.Load2 = new TextSprite("",
                pixelsToCoords(305, 670), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load2);

        UIInfo.Load3 = new TextSprite("",
                pixelsToCoords(500, 50), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load3);

        UIInfo.Load4 = new TextSprite("",
                pixelsToCoords(1730, 350), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load4);

        UIInfo.Load5 = new TextSprite("",
                pixelsToCoords(1980, 825), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load5);

        UIInfo.Load6 = new TextSprite("",
                pixelsToCoords(2070, 1175), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.Load6);

        UIInfo.trA = new TextSprite("",
                pixelsToCoords(1390, 990), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trA);

        UIInfo.trB = new TextSprite("",
                pixelsToCoords(1210, 945), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trB);

        UIInfo.trC = new TextSprite("",
                pixelsToCoords(950, 440), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trC);

        UIInfo.trD = new TextSprite("",
                pixelsToCoords(610, 630), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trD);

        UIInfo.trE = new TextSprite("",
                pixelsToCoords(930, 110), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trE);

        UIInfo.trF = new TextSprite("",
                pixelsToCoords(810, 55), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trF);

        UIInfo.trG = new TextSprite("",
                pixelsToCoords(1105, 100), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trG);

        UIInfo.trH = new TextSprite("",
                pixelsToCoords(1390, 280), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trH);

        UIInfo.trI = new TextSprite("",
                pixelsToCoords(1200, 320), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trI);

        UIInfo.trJ = new TextSprite("",
                pixelsToCoords(1850, 740), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trJ);

        UIInfo.trK = new TextSprite("",
                pixelsToCoords(1640, 780), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trK);

        UIInfo.trL = new TextSprite("",
                pixelsToCoords(1850, 1090), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trL);

        UIInfo.trM = new TextSprite("",
                pixelsToCoords(1740, 1185), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.trM);

        UIInfo.WindTurbines = new TextSprite("",
                pixelsToCoords(1250, 1400), 20, Typeface.DEFAULT, 1000f, 0, 0,
                new Vector2f(1f, 1f), new Color(0, 0, 0));
        Global.getRenderer().addDrawable(UIInfo.WindTurbines);

        UIInfo.PowPlant = new TextSprite("",
                pixelsToCoords(1950, 1400), 20, Typeface.DEFAULT, 1000f, 0, 0,
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
    }

    private boolean first = true;

    private LightAnimation lightAnimation;

    private static final float TEXT_UPDATE_INTERVAL = 0.1f;
    private static final double TEXT_UPDATE_CHANCE = 0.1;

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

        textUpdateTimer -= amount;
        if (textUpdateTimer <= 0f) {

            if (Math.random() < textUpdateChance)
                UIInfo.Load1.setText("" + String.format("%.2f", Simulation.SimInfo.Load1) + " MW"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load1r) + " MVAR"
                                + "\n" + String.format("%.2f", Simulation.SimInfo.Load1a) + " MVA",
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
                UIInfo.PowPlant.setText("" + String.format("%.2f", Simulation.SimInfo.PowPlant) + " MW",
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

        textUpdateChance = TEXT_UPDATE_CHANCE;
    }
}
