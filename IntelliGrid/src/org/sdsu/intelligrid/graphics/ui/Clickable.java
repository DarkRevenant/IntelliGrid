// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.graphics.Drawable;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * Interface for encapsulating clickable objects.
 * <p>
 * The dimensions are in openGL coordinates, so bounds of <tt>[-0.1,-0.1]</tt>
 * to <tt>[0.1,0.1]</tt> defines a clickable 160-pixel square (on our device)
 * centered on the object.
 */
public interface Clickable extends Drawable {

	/**
	 * Gets the clickable object's lower left corner of its clickable bounds.
	 * 
	 * @return the clickable object's lower left bounds
	 */
	public Vector2f getBoundLL();

	/**
	 * Gets the clickable object's upper right corner of its clickable bounds.
	 * 
	 * @return the clickable object's upper right bounds
	 */
	public Vector2f getBoundUR();

	/**
	 * Gets the clickable object's identifier. This is designed for internal use
	 * in InputHook, so you don't have to extend different classes for every
	 * single button.
	 * 
	 * @return the clickable object's identifier
	 */
	public String getId();

	/**
	 * Gets the clickable object's interface depth. A lower depth means the
	 * object's click priority is higher (reflecting a more frontward location
	 * on the screen).
	 * 
	 * @return the clickable object's interface depth
	 */
	public int getDepth();

	/**
	 * Gets the clickable object's location, in openGL coordinates (
	 * <tt>[0,0]</tt> is the center of the screen). The clickable bounds are
	 * centered on this location.
	 * 
	 * @return the clickable object's location
	 */
	public Vector2f getLocation();
}
