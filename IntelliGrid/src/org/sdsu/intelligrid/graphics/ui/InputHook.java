package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
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

		if(object.getId().equals("background")) {
		    MainUI.ClickableObjects.graphspage.setDepth(11);
		    MainUI.ClickableObjects.exitgraphs.setDepth(11);
		    MainUI.ClickableObjects.infopage.setDepth(11);
		    MainUI.ClickableObjects.exitinfo.setDepth(11);
		    MainUI.ClickableObjects.faultspage.setDepth(11);
		    MainUI.ClickableObjects.exitfaults.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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

		if (object.getId().equals("info")) {
			MainUI.ClickableObjects.infopage.setDepth(-1);
			MainUI.ClickableObjects.exitinfo.setDepth(-2);
			MainUI.ClickableObjects.load1stats.setDepth(11);
			MainUI.ClickableObjects.load1statsclick.setDepth(11);
			MainUI.UIInfo.Load1.setDepth(11);
			MainUI.ClickableObjects.load2stats.setDepth(11);
			MainUI.ClickableObjects.load2statsclick.setDepth(11);
			MainUI.UIInfo.Load2.setDepth(11);
			MainUI.ClickableObjects.load3stats.setDepth(11);
			MainUI.ClickableObjects.load3statsclick.setDepth(11);
			MainUI.UIInfo.Load3.setDepth(11);
			MainUI.ClickableObjects.load4stats.setDepth(11);
			MainUI.ClickableObjects.load4statsclick.setDepth(11);
			MainUI.UIInfo.Load4.setDepth(11);
			MainUI.ClickableObjects.load5stats.setDepth(11);
			MainUI.ClickableObjects.load5statsclick.setDepth(11);
			MainUI.UIInfo.Load5.setDepth(11);
			MainUI.ClickableObjects.load6stats.setDepth(11);
			MainUI.ClickableObjects.load6statsclick.setDepth(11);
			MainUI.UIInfo.Load6.setDepth(11);
		}
		if (object.getId().equals("exitinfo")) {
			MainUI.ClickableObjects.infopage.setDepth(11);
			MainUI.ClickableObjects.exitinfo.setDepth(11);
			MainUI.ClickableObjects.load1statsclick.setDepth(0);
			MainUI.ClickableObjects.load2statsclick.setDepth(0);
			MainUI.ClickableObjects.load3statsclick.setDepth(0);
			MainUI.ClickableObjects.load4statsclick.setDepth(0);
			MainUI.ClickableObjects.load5statsclick.setDepth(0);
			MainUI.ClickableObjects.load6statsclick.setDepth(0);
		}

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
            MainUI.ClickableObjects.load6statsclick.setDepth(11);
			MainUI.ClickableObjects.load1stats.setDepth(11);
			MainUI.ClickableObjects.load1statsclick.setDepth(11);
			MainUI.UIInfo.Load1.setDepth(11);
			MainUI.ClickableObjects.load2stats.setDepth(11);
			MainUI.ClickableObjects.load2statsclick.setDepth(11);
			MainUI.UIInfo.Load2.setDepth(11);
			MainUI.ClickableObjects.load3stats.setDepth(11);
			MainUI.ClickableObjects.load3statsclick.setDepth(11);
			MainUI.UIInfo.Load3.setDepth(11);
			MainUI.ClickableObjects.load4stats.setDepth(11);
			MainUI.ClickableObjects.load4statsclick.setDepth(11);
			MainUI.UIInfo.Load4.setDepth(11);
			MainUI.ClickableObjects.load5stats.setDepth(11);
			MainUI.ClickableObjects.load5statsclick.setDepth(11);
			MainUI.UIInfo.Load5.setDepth(11);
			MainUI.ClickableObjects.load6stats.setDepth(11);
			MainUI.ClickableObjects.load6statsclick.setDepth(11);
			MainUI.UIInfo.Load6.setDepth(11);

//			currentFault++;
//			if (currentFault == 16) {
//				currentFault = 0;
//			}
//			String fault;
//			switch (currentFault) {
//			case 1:
//				fault = "A";
//				break;
//			case 2:
//				fault = "B";
//				break;
//			case 3:
//				fault = "C";
//				break;
//			case 4:
//				fault = "D";
//				break;
//			case 5:
//				fault = "E";
//				break;
//			case 6:
//				fault = "F";
//				break;
//			case 7:
//				fault = "H";
//				break;
//			case 8:
//				fault = "I";
//				break;
//			case 9:
//				fault = "J";
//				break;
//			case 10:
//				fault = "K";
//				break;
//			case 11:
//				fault = "L";
//				break;
//			case 12:
//				fault = "M";
//				break;
//			case 13:
//				fault = "DI";
//				break;
//			case 14:
//				fault = "ACE";
//				break;
//			case 15:
//				fault = "MKI";
//				break;
//			default:
//				fault = "";
//			}
//			try {
//				Global.getGlobalSimulation().data.fault = fault;
//			} catch (Exception ex) {
//				// do nothing
//			}
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
        }
        if (object.getId().equals("balloonfault")) {
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
        }
        if (object.getId().equals("digfault")) {
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
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
			MainUI.ClickableObjects.load1statsclick.setDepth(0);
			MainUI.ClickableObjects.load2statsclick.setDepth(0);
			MainUI.ClickableObjects.load3statsclick.setDepth(0);
			MainUI.ClickableObjects.load4statsclick.setDepth(0);
			MainUI.ClickableObjects.load5statsclick.setDepth(0);
			MainUI.ClickableObjects.load6statsclick.setDepth(0);
		}

		if (object.getId().equals("load1statsclick")) {
			MainUI.ClickableObjects.load1stats.setDepth(-1);
			MainUI.UIInfo.Load1.setDepth(-2);
		}
		if (object.getId().equals("load1stats")) {
			MainUI.ClickableObjects.load1stats.setDepth(11);
			MainUI.UIInfo.Load1.setDepth(11);
		}
		if (object.getId().equals("house3a")) {
			MainUI.ClickableObjects.load1stats.setDepth(-1);
			MainUI.UIInfo.Load1.setDepth(-2);
		}
		if (object.getId().equals("house3b")) {
			MainUI.ClickableObjects.load1stats.setDepth(-1);
			MainUI.UIInfo.Load1.setDepth(-2);
		}
		if (object.getId().equals("house3c")) {
			MainUI.ClickableObjects.load1stats.setDepth(-1);
			MainUI.UIInfo.Load1.setDepth(-2);
		}

		if (object.getId().equals("load2statsclick")) {
			MainUI.ClickableObjects.load2stats.setDepth(-1);
			MainUI.UIInfo.Load2.setDepth(-2);
		}
		if (object.getId().equals("load2stats")) {
			MainUI.ClickableObjects.load2stats.setDepth(11);
			MainUI.UIInfo.Load2.setDepth(11);
		}
		if (object.getId().equals("house2solar1")) {
			MainUI.ClickableObjects.load2stats.setDepth(-1);
			MainUI.UIInfo.Load2.setDepth(-2);
		}
		if (object.getId().equals("house2solar2")) {
			MainUI.ClickableObjects.load2stats.setDepth(-1);
			MainUI.UIInfo.Load2.setDepth(-2);
		}
		if (object.getId().equals("store")) {
			MainUI.ClickableObjects.load2stats.setDepth(-1);
			MainUI.UIInfo.Load2.setDepth(-2);
		}

		if (object.getId().equals("load3statsclick")) {
			MainUI.ClickableObjects.load3stats.setDepth(-1);
			MainUI.UIInfo.Load3.setDepth(-2);
		}
		if (object.getId().equals("load3stats")) {
			MainUI.ClickableObjects.load3stats.setDepth(11);
			MainUI.UIInfo.Load3.setDepth(11);
		}
		if (object.getId().equals("house1solar1")) {
			MainUI.ClickableObjects.load3stats.setDepth(-1);
			MainUI.UIInfo.Load3.setDepth(-2);
		}
		if (object.getId().equals("house1solar2")) {
			MainUI.ClickableObjects.load3stats.setDepth(-1);
			MainUI.UIInfo.Load3.setDepth(-2);
		}
		if (object.getId().equals("house1solar3")) {
			MainUI.ClickableObjects.load3stats.setDepth(-1);
			MainUI.UIInfo.Load3.setDepth(-2);
		}

		if (object.getId().equals("load4statsclick")) {
			MainUI.ClickableObjects.load4stats.setDepth(-1);
			MainUI.UIInfo.Load4.setDepth(-2);
		}
		if (object.getId().equals("load4stats")) {
			MainUI.ClickableObjects.load4stats.setDepth(11);
			MainUI.UIInfo.Load4.setDepth(11);
		}
		if (object.getId().equals("business1a")) {
			MainUI.ClickableObjects.load4stats.setDepth(-1);
			MainUI.UIInfo.Load4.setDepth(-2);
		}
        if (object.getId().equals("midway")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }

		if (object.getId().equals("load5statsclick")) {
			MainUI.ClickableObjects.load5stats.setDepth(-1);
			MainUI.UIInfo.Load5.setDepth(-2);
		}
		if (object.getId().equals("load5stats")) {
			MainUI.ClickableObjects.load5stats.setDepth(11);
			MainUI.UIInfo.Load5.setDepth(11);
		}
		if (object.getId().equals("business2a")) {
			MainUI.ClickableObjects.load5stats.setDepth(-1);
			MainUI.UIInfo.Load5.setDepth(-2);
		}
		if (object.getId().equals("business2b")) {
			MainUI.ClickableObjects.load5stats.setDepth(-1);
			MainUI.UIInfo.Load5.setDepth(-2);
		}
		if (object.getId().equals("business2c")) {
			MainUI.ClickableObjects.load5stats.setDepth(-1);
			MainUI.UIInfo.Load5.setDepth(-2);
		}

		if (object.getId().equals("load6statsclick")) {
			MainUI.ClickableObjects.load6stats.setDepth(-1);
			MainUI.UIInfo.Load6.setDepth(-2);
		}
		if (object.getId().equals("load6stats")) {
			MainUI.ClickableObjects.load6stats.setDepth(11);
			MainUI.UIInfo.Load6.setDepth(11);
		}
		if (object.getId().equals("business1b")) {
			MainUI.ClickableObjects.load6stats.setDepth(-1);
			MainUI.UIInfo.Load6.setDepth(-2);
		}
        if (object.getId().equals("stadium")) {
            MainUI.ClickableObjects.load6stats.setDepth(-1);
            MainUI.UIInfo.Load6.setDepth(-2);
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
