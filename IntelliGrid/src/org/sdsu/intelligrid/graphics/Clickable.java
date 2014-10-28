// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import org.sdsu.intelligrid.util.Vector2f;

/**
 * Interface for encapsulating clickable objects.
 * 
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
	public Vector2f getLLBound();

	/**
	 * Gets the clickable object's upper right corner of its clickable bounds.
	 * 
	 * @return the clickable object's upper right bounds
	 */
	public Vector2f getURBound();
}
