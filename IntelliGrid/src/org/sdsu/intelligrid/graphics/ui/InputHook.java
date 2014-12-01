package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.network.MainNetworkHandler;
import org.sdsu.intelligrid.network.MainNetworkHandler.PacketTypes;
import org.sdsu.intelligrid.simulation.Simulation;
import org.sdsu.intelligrid.util.Vector2f;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/**
 * A hook containing static methods that are called when input events happen.
 */
public class InputHook {

    public static Vector2f pixelsToCoords(final float x, final float y) {
        return new Vector2f((x / (float) Global.getRenderer().getScreenWidth()
                * 2f - 1f)
                * (float) Global.getRenderer().getScreenWidth()
                / (float) Global.getRenderer().getScreenHeight(), y
                / (float) Global.getRenderer().getScreenHeight() * 2f - 1f);
    }

    public static Vector2f sizeToCoords(final float x, final float y) {
        return new Vector2f(x / (float) Global.getRenderer().getScreenHeight(),
                y / (float) Global.getRenderer().getScreenHeight());
    }

    private static boolean graphsOn = false;

    /**
     * This function is called when a pointer goes down and touches the screen
     * on a clickable object.
     * <p>
     * This function is called before
     * {@link #reportDown(Vector2f, MotionEvent, int) reportDown}.
     *
     * @param object
     *            the clickable object that the event triggered on
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent
     */
    public static synchronized void reportDownOnObject(final Clickable object,
                                                       final Vector2f coords, final MotionEvent e, final int id) {

        // Play Buttons
        if (object.getId().equals("play")) {
            LightAnimation.setPaused(false);
            Global.getGlobalSimulation().data.timeScale = 288;
            MainUI.Objects.playdown.setDepth(-1);
            MainUI.Objects.play2down.setDepth(11);
            MainUI.Objects.play3down.setDepth(11);
            MainUI.Objects.pausedown.setDepth(11);
        }
        if (object.getId().equals("play2")) {
            LightAnimation.setPaused(false);
            Global.getGlobalSimulation().data.timeScale = 720;
            MainUI.Objects.playdown.setDepth(11);
            MainUI.Objects.play2down.setDepth(-1);
            MainUI.Objects.play3down.setDepth(11);
            MainUI.Objects.pausedown.setDepth(11);
        }
        if (object.getId().equals("play3")) {
            LightAnimation.setPaused(false);
            Global.getGlobalSimulation().data.timeScale = 1920;
            MainUI.Objects.playdown.setDepth(11);
            MainUI.Objects.play2down.setDepth(11);
            MainUI.Objects.play3down.setDepth(-1);
            MainUI.Objects.pausedown.setDepth(11);
        }
        if (object.getId().equals("pause")) {
            LightAnimation.setPaused(true);
            Global.getGlobalSimulation().data.timeScale = 0;
            MainUI.Objects.playdown.setDepth(11);
            MainUI.Objects.play2down.setDepth(11);
            MainUI.Objects.play3down.setDepth(11);
            MainUI.Objects.pausedown.setDepth(-1);
        }

        // Background
        if(object.getId().equals("background")) {
            MainUI.ClickableObjects.graphspage.setDepth(11);
            MainUI.ClickableObjects.exitgraphs.setDepth(11);
            MainUI.ClickableObjects.infopage.setDepth(11);
            MainUI.ClickableObjects.exitinfo.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
        }

        // Info Page
        if (object.getId().equals("info")) {
            MainUI.ClickableObjects.infopage.setDepth(-1);
            MainUI.ClickableObjects.exitinfo.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if (object.getId().equals("exitinfo")) {
            MainUI.ClickableObjects.infopage.setDepth(11);
            MainUI.ClickableObjects.exitinfo.setDepth(11);
        }

        // Graphs Page
        if (object.getId().equals("graphs")) {
            if (!graphsOn) {
                Global.getMainActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        LayoutParams params = new LayoutParams(Global
                                .getRenderer().getScreenWidth(), Global
                                .getRenderer().getScreenHeight());
                        Global.getMainActivity().addContentView(
                                Global.getGraphFragment().getView(), params);
                        Global.getGraphFragment()
                                .getView()
                                .setBackgroundColor(
                                        android.graphics.Color.TRANSPARENT);
                    }
                });
                graphsOn = true;
            } else {
                Global.getMainActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        ((ViewGroup) Global.getGraphFragment().getView()
                                .getParent()).removeView(Global
                                .getGraphFragment().getView());
                    }
                });
                graphsOn = false;
            }
        }

        // Faults Page
        if (object.getId().equals("faults")) {
            MainUI.ClickableObjects.faultspage.setDepth(-1);
            MainUI.ClickableObjects.exitfaults.setDepth(-2);
            MainUI.ClickableObjects.fault_a.setDepth(-2);
            MainUI.ClickableObjects.fault_b.setDepth(-2);
            MainUI.ClickableObjects.fault_c.setDepth(-2);
            MainUI.ClickableObjects.fault_d.setDepth(-2);
            MainUI.ClickableObjects.fault_e.setDepth(-2);
            MainUI.ClickableObjects.fault_f.setDepth(-2);
            MainUI.ClickableObjects.fault_h.setDepth(-2);
            MainUI.ClickableObjects.fault_i.setDepth(-2);
            MainUI.ClickableObjects.fault_j.setDepth(-2);
            MainUI.ClickableObjects.fault_k.setDepth(-2);
            MainUI.ClickableObjects.fault_l.setDepth(-2);
            MainUI.ClickableObjects.fault_m.setDepth(-2);
            MainUI.ClickableObjects.balloonfault.setDepth(-2);
            MainUI.ClickableObjects.digfault.setDepth(-2);
            MainUI.ClickableObjects.nofault.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if (object.getId().equals("faulta")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("A");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultb")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("B");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultc")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("C");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultd")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("D");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faulte")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("E");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultf")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("F");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faulth")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("H");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faulti")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("I");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultj")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("J");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultk")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("K");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultl")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("L");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("faultm")) {
            Global.getGlobalSimulation().faultManager.startGenericFault("M");
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("balloonfault")) {
            MainNetworkHandler.constructAndSendPacket(PacketTypes.BALLOON_DETECT_RESET, true);
            Global.getGlobalSimulation().faultManager.startBalloonFault();
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("digfault")) {
            MainNetworkHandler.constructAndSendPacket(PacketTypes.DIG_DETECT_RESET, true);
            Global.getGlobalSimulation().faultManager.startDigFault();
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("nofault")) {
            Global.getGlobalSimulation().faultManager.endFaults();
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }
        if (object.getId().equals("exitfaults")) {
            MainUI.ClickableObjects.fault_a.setDepth(11);
            MainUI.ClickableObjects.fault_b.setDepth(11);
            MainUI.ClickableObjects.fault_c.setDepth(11);
            MainUI.ClickableObjects.fault_d.setDepth(11);
            MainUI.ClickableObjects.fault_e.setDepth(11);
            MainUI.ClickableObjects.fault_f.setDepth(11);
            MainUI.ClickableObjects.fault_h.setDepth(11);
            MainUI.ClickableObjects.fault_i.setDepth(11);
            MainUI.ClickableObjects.fault_j.setDepth(11);
            MainUI.ClickableObjects.fault_k.setDepth(11);
            MainUI.ClickableObjects.fault_l.setDepth(11);
            MainUI.ClickableObjects.fault_m.setDepth(11);
            MainUI.ClickableObjects.balloonfault.setDepth(11);
            MainUI.ClickableObjects.digfault.setDepth(11);
            MainUI.ClickableObjects.nofault.setDepth(11);
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
        }

        // If Network is NOT Connected
        if (Global.getNetworkInterface().isConnected() == false) {
            // Residential 2
            if (object.getId().equals("house2a")) {
                MainUI.ClickableObjects.house2apopup.setDepth(-1);
                MainUI.ClickableObjects.house2asolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house2asolarcheckoff")) {
                Global.getGlobalSimulation().data.solarPanelM1.set(1.0);
                MainUI.ClickableObjects.house2asolarcheck.setDepth(-2);
                MainUI.ClickableObjects.house2asolarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house2asolar")) {
                MainUI.ClickableObjects.house2apopup.setDepth(-1);
                MainUI.ClickableObjects.house2asolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house2asolarcheck")) {
                Global.getGlobalSimulation().data.solarPanelM1.set(1.0);
                MainUI.ClickableObjects.house2asolarcheck.setDepth(11);
                MainUI.ClickableObjects.house2asolarcheckoff.setDepth(0);
            }
            if (object.getId().equals("house2apopup")) {
                MainUI.ClickableObjects.house2apopup.setDepth(11);
                MainUI.ClickableObjects.house2asolarcheck.setDepth(11);
                MainUI.ClickableObjects.house2asolarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house2b")) {
                MainUI.ClickableObjects.house2bpopup.setDepth(-1);
                MainUI.ClickableObjects.house2bsolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house2asolarcheckoff")) {
                Global.getGlobalSimulation().data.solarPanelM2.set(1.0);
                MainUI.ClickableObjects.house2bsolarcheck.setDepth(-2);
                MainUI.ClickableObjects.house2bsolarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house2bsolar")) {
                MainUI.ClickableObjects.house2bpopup.setDepth(-1);
                MainUI.ClickableObjects.house2bsolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house2bsolarcheck")) {
                Global.getGlobalSimulation().data.solarPanelM1.set(0.0);
                MainUI.ClickableObjects.house2bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house2bsolarcheckoff.setDepth(0);
            }
            if (object.getId().equals("house2bpopup")) {
                MainUI.ClickableObjects.house2bpopup.setDepth(11);
                MainUI.ClickableObjects.house2bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house2bsolarcheckoff.setDepth(11);
            }
            // Residential 3
            if (object.getId().equals("house1a")) {
                MainUI.ClickableObjects.house1apopup.setDepth(-1);
                MainUI.ClickableObjects.house1asolarcheckoff.setDepth(-2);
                MainUI.ClickableObjects.house1acarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1asolar")) {
                MainUI.ClickableObjects.house1apopup.setDepth(-1);
                MainUI.ClickableObjects.house1asolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1acar")) {
                MainUI.ClickableObjects.house1apopup.setDepth(-1);
                MainUI.ClickableObjects.house1asolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1aboth")) {
                MainUI.ClickableObjects.house1apopup.setDepth(-1);
                MainUI.ClickableObjects.house1asolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1asolarcheckoff")) {
                Global.getGlobalSimulation().data.solarPanelL1.set(1.0);
                MainUI.ClickableObjects.house1asolarcheck.setDepth(-2);
                MainUI.ClickableObjects.house1asolarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house1asolarcheck")) {
                Global.getGlobalSimulation().data.solarPanelL1.set(0.0);
                MainUI.ClickableObjects.house2bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house2bsolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1acarcheckoff")) {
                Global.getGlobalSimulation().data.electricVehicleL1.set(1.0);
                MainUI.ClickableObjects.house1acarcheck.setDepth(-2);
                MainUI.ClickableObjects.house1acarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house1acarcheck")) {
                Global.getGlobalSimulation().data.electricVehicleL1.set(0.0);
                MainUI.ClickableObjects.house2bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house2bsolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1apopup")) {
                MainUI.ClickableObjects.house1apopup.setDepth(11);
                MainUI.ClickableObjects.house1asolarcheckoff.setDepth(11);
                MainUI.ClickableObjects.house1asolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1acarcheckoff.setDepth(11);
                MainUI.ClickableObjects.house1acarcheck.setDepth(11);
            }
            if (object.getId().equals("house1b")) {
                MainUI.ClickableObjects.house1bpopup.setDepth(-1);
                MainUI.ClickableObjects.house1bsolarcheckoff.setDepth(-2);
                MainUI.ClickableObjects.house1bcarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1bsolar")) {
                MainUI.ClickableObjects.house1bpopup.setDepth(-1);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1bcar")) {
                MainUI.ClickableObjects.house1bpopup.setDepth(-1);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1aboth")) {
                MainUI.ClickableObjects.house1bpopup.setDepth(-1);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1bsolarcheckoff")) {
                Global.getGlobalSimulation().data.solarPanelL2.set(1.0);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(-2);
                MainUI.ClickableObjects.house1bsolarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house1bsolarcheck")) {
                Global.getGlobalSimulation().data.solarPanelL2.set(0.0);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1bsolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1bcarcheckoff")) {
                Global.getGlobalSimulation().data.electricVehicleL2.set(1.0);
                MainUI.ClickableObjects.house1bcarcheck.setDepth(-2);
                MainUI.ClickableObjects.house1bcarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house1bcarcheck")) {
                Global.getGlobalSimulation().data.electricVehicleL2.set(0.0);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1bsolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1bpopup")) {
                MainUI.ClickableObjects.house1bpopup.setDepth(11);
                MainUI.ClickableObjects.house1bsolarcheckoff.setDepth(11);
                MainUI.ClickableObjects.house1bsolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1bcarcheckoff.setDepth(11);
                MainUI.ClickableObjects.house1bcarcheck.setDepth(11);
            }
            if (object.getId().equals("house1c")) {
                MainUI.ClickableObjects.house1cpopup.setDepth(-1);
                MainUI.ClickableObjects.house1csolarcheckoff.setDepth(-2);
                MainUI.ClickableObjects.house1ccarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1csolar")) {
                MainUI.ClickableObjects.house1cpopup.setDepth(-1);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1ccar")) {
                MainUI.ClickableObjects.house1cpopup.setDepth(-1);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1cboth")) {
                MainUI.ClickableObjects.house1cpopup.setDepth(-1);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(-2);
            }
            if (object.getId().equals("house1csolarcheckoff")) {
                Global.getGlobalSimulation().data.solarPanelL3.set(1.0);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(-2);
                MainUI.ClickableObjects.house1csolarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house1csolarcheck")) {
                Global.getGlobalSimulation().data.solarPanelL3.set(0.0);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1csolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1ccarcheckoff")) {
                Global.getGlobalSimulation().data.electricVehicleL3.set(1.0);
                MainUI.ClickableObjects.house1ccarcheck.setDepth(-2);
                MainUI.ClickableObjects.house1ccarcheckoff.setDepth(11);
            }
            if (object.getId().equals("house1ccarcheck")) {
                Global.getGlobalSimulation().data.electricVehicleL3.set(0.0);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1csolarcheckoff.setDepth(-2);
            }
            if (object.getId().equals("house1cpopup")) {
                MainUI.ClickableObjects.house1cpopup.setDepth(11);
                MainUI.ClickableObjects.house1csolarcheckoff.setDepth(11);
                MainUI.ClickableObjects.house1csolarcheck.setDepth(11);
                MainUI.ClickableObjects.house1ccarcheckoff.setDepth(11);
                MainUI.ClickableObjects.house1ccarcheck.setDepth(11);
            }



        }

        // Load Displays
        if (object.getId().equals("transformer1")) {
            MainUI.ClickableObjects.load1stats.setDepth(-1);
            MainUI.UIInfo.Load1.setDepth(-2);
        }
        if (object.getId().equals("load1stats")) {
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
        }
        if (object.getId().equals("transformer2")) {
            MainUI.ClickableObjects.load2stats.setDepth(-1);
            MainUI.UIInfo.Load2.setDepth(-2);
        }
        if (object.getId().equals("load2stats")) {
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
        }
        if (object.getId().equals("transformer3")) {
            MainUI.ClickableObjects.load3stats.setDepth(-1);
            MainUI.UIInfo.Load3.setDepth(-2);
        }
        if (object.getId().equals("load3stats")) {
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
        }
        if (object.getId().equals("transformer4")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }
        if (object.getId().equals("load4stats")) {
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
        }
        if (object.getId().equals("transformer5")) {
            MainUI.ClickableObjects.load5stats.setDepth(-1);
            MainUI.UIInfo.Load5.setDepth(-2);
        }
        if (object.getId().equals("load5stats")) {
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
        }
        if (object.getId().equals("transformer6")) {
            MainUI.ClickableObjects.load6stats.setDepth(-1);
            MainUI.UIInfo.Load6.setDepth(-2);
        }
        if (object.getId().equals("load6stats")) {
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
    }

    /**
     * This function is called when a pointer moves over a clickable object.
     * <p>
     * This function is called before
     * {@link #reportMove(Vector2f, MotionEvent, int) reportMove}.
     *
     * @param object
     *            the clickable object that the event triggered on
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent
     */
    public static synchronized void reportMoveOverObject(
            final Clickable object, final Vector2f coords, final MotionEvent e,
            final int id) {
    }

    /**
     * This function is called when a pointer comes up and leaves the screen
     * from a clickable object.
     * <p>
     * This function is called before
     * {@link #reportUp(Vector2f, MotionEvent, int) reportUp}.
     *
     * @param object
     *            the clickable object that the event triggered on
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent
     */
    public static synchronized void reportUpFromObject(final Clickable object,
                                                       final Vector2f coords, final MotionEvent e, final int id) {
    }

    /**
     * This function is called when the main pointer's event is cancelled in
     * some way (on top of a clickable object). This behaves like
     * reportUpFromObject, except it shouldn't activate any buttons or
     * functionality.
     * <p>
     * This function is called before
     * {@link #reportCancel(Vector2f, MotionEvent, int) reportCancel}.
     *
     * @param object
     *            the clickable object that the event triggered on
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent (however, only the
     *            main pointer can generate this event)
     */
    public static synchronized void reportCancelFromObject(
            final Clickable object, final Vector2f coords, final MotionEvent e,
            final int id) {
    }

//	static int currentFault = 0;

    /**
     * This function is called when a pointer goes down and touches the screen.
     *
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent
     */
    public static synchronized void reportDown(final Vector2f coords,
                                               final MotionEvent e, final int id) {
    }

    /**
     * This function is called when a pointer moves around the screen.
     *
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent
     */
    public static synchronized void reportMove(final Vector2f coords,
                                               final MotionEvent e, final int id) {
    }

    /**
     * This function is called when a pointer comes up and leaves the screen.
     *
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent
     */
    public static synchronized void reportUp(final Vector2f coords,
                                             final MotionEvent e, final int id) {
    }

    /**
     * This function is called when the main pointer's event is cancelled in
     * some way. This behaves like reportUp, except it shouldn't activate any
     * buttons or functionality.
     *
     * @param coords
     *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
     *            the center of the screen)
     * @param e
     *            the MotionEvent that caused this function to be called
     * @param id
     *            the pointer identifier of the MotionEvent (however, only the
     *            main pointer can generate this event)
     */
    public static synchronized void reportCancel(final Vector2f coords,
                                                 final MotionEvent e, final int id) {
    }
}
