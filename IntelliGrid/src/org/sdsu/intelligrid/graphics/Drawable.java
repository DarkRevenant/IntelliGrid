// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import org.sdsu.intelligrid.util.Vector2f;

/**
 * Interface container for programmable drawable objects.
 */
public interface Drawable {

	/**
	 * Gets the drawable object's scene location. <tt>[0,0]</tt> is the center;
	 * on our device, in landscape mode, <tt>[-1.6,-1.0]</tt> is the bottom left
	 * corner and <tt>[1.6,1.0]</tt> is the top right corner. These values can
	 * change on other aspect ratios, so you should make it a habit of using
	 * {@link MainRenderer#getLeftEdge()} and the other similar functions to get
	 * the screen dimensions.
	 * 
	 * @return the drawable object's current location
	 */
	public Vector2f getLocation();

	/**
	 * This is the primary step driver for the object. Call all time-based
	 * functions from here.
	 * 
	 * @param amount
	 *            the amount of time that has passed since the previous frame,
	 *            in seconds
	 */
	public void advance(final float amount);

	/**
	 * This is the drawing hook for the drawable object. Render the object here.
	 * 
	 * @param amount
	 *            the amount of time that has passed since the previous frame,
	 *            in seconds
	 * @param viewMatrix
	 *            the current view matrix used in rendering
	 * @param projectionMatrix
	 *            the current projection matrix used in rendering
	 */
	public void draw(final float amount, final float[] viewMatrix,
			final float[] projectionMatrix);
}
