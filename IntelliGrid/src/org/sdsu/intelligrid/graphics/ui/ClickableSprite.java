// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.graphics.Clickable;
import org.sdsu.intelligrid.graphics.MainRenderer;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * A Class that extends Sprite with Clickable capabilities.
 */
public class ClickableSprite extends Sprite implements Clickable {

	private final Vector2f boundLL;
	private final Vector2f boundUR;

	/**
	 * A Class that extends Sprite with Clickable capabilities.
	 * 
	 * The dimensions are in openGL coordinates, so bounds of
	 * <tt>[-0.1,-0.1]</tt> to <tt>[0.1,0.1]</tt> defines a clickable 160-pixel
	 * square (on our device) centered on the object.
	 * 
	 * @param location
	 *            the location of the sprite, in OpenGL coordinates (
	 *            <tt>[0.0,0.0]</tt> is the default position)
	 * @param rotation
	 *            the rotation of the sprite, in radians (<tt>0.0</tt> means it
	 *            is facing in the default direction)
	 * @param scale
	 *            the scale of the sprite (<tt>[1.0,1.0]</tt> is the default
	 *            scale)
	 * @param color
	 *            the color factor of the sprite
	 * @param resource
	 *            the resource ID that the sprite should display (make sure it
	 *            has been already loaded with
	 *            {@link MainRenderer#loadTextures(resources)})
	 * @param boundLL
	 *            the lower left bounds of the clickable object, where
	 *            <tt>[0,0]</tt> is the center of the object
	 * @param boundUR
	 *            the upper right bounds of the clickable object, where
	 *            <tt>[0,0]</tt> is the center of the object
	 */
	public ClickableSprite(final Vector2f location, final float rotation,
			final Vector2f scale, final Color color, final int resource,
			final Vector2f boundLL, final Vector2f boundUR) {
		super(location, rotation, scale, color, resource);
		this.boundLL = new Vector2f(boundLL);
		this.boundUR = new Vector2f(boundUR);
	}

	/**
	 * Gets the clickable object's lower left corner of its clickable bounds.
	 * 
	 * @return the clickable object's lower left bounds
	 */
	@Override
	public Vector2f getLLBound() {
		return boundLL;
	}

	/**
	 * Gets the clickable object's upper right corner of its clickable bounds.
	 * 
	 * @return the clickable object's upper right bounds
	 */
	@Override
	public Vector2f getURBound() {
		return boundUR;
	}

	/**
	 * Sets the clickable object's lower left corner of its clickable bounds.
	 * 
	 * @param boundLL
	 *            the lower left bounds to set for the clickable object
	 */
	public void setLLBound(final Vector2f boundLL) {
		this.boundLL.set(boundLL);
	}

	/**
	 * Sets the clickable object's upper right corner of its clickable bounds.
	 * 
	 * @param boundUR
	 *            the upper right bounds to set for the clickable object
	 */
	public void setURBound(final Vector2f boundUR) {
		this.boundUR.set(boundUR);
	}
}
