package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.graphics.TextSprite;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

import android.graphics.Typeface;
import android.view.MotionEvent;

/**
 * A hook containing static methods that are called when input events happen.
 */
public class InputHook {

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
		// Test
		final TextSprite text = new TextSprite(
				"This is a test paragraph designed to demonstrate the multi-line capabilities of the text rendering system. There are no word-processor features for this system; carriage returns do not work and word wrap does not exist. Please note that this system is slow to initialize new strings; do not change them too often. Do not vary font, size, or line width on strings that do change, such as energy readouts.",
				new Vector2f(0f, 0f), 60, Typeface.DEFAULT, 1000f, 0, 0,
				new Vector2f(1f, 1f), new Color(255, 255, 255));
		Global.getRenderer().addDrawable(text);
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
