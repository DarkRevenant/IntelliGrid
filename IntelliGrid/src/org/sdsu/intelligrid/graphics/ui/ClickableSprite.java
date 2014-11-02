// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.graphics.MainRenderer;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * A class that extends Sprite with Clickable capabilities.
 */
public class ClickableSprite extends Sprite implements Clickable {

	private final Vector2f boundLL;
	private final Vector2f boundUR;
	private String id;

	/**
	 * A Class that extends Sprite with Clickable capabilities.
	 * <p>
	 * The dimensions are in openGL coordinates, so bounds of
	 * <tt>[-0.1,-0.1]</tt> to <tt>[0.1,0.1]</tt> defines a clickable 160-pixel
	 * square (on our device) centered on the object.
	 * 
	 * @param location
	 *            the location of the sprite, in OpenGL coordinates (
	 *            <tt>[0.0,0.0]</tt> is the default position)
	 * @param depth
	 *            the scene and interface depth of the sprite
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
	 * @param id
	 *            the identifier for the clickable object
	 */
	public ClickableSprite(final Vector2f location, final int depth,
			final float rotation, final Vector2f scale, final Color color,
			final int resource, final Vector2f boundLL, final Vector2f boundUR,
			final String id) {
		super(location, depth, rotation, scale, color, resource);
		this.boundLL = new Vector2f(boundLL);
		this.boundUR = new Vector2f(boundUR);
		this.id = id;
		super.setDepth(depth);
	}

	/**
	 * Gets the clickable object's lower left corner of its clickable bounds.
	 * <p>
	 * Clickable bounds do not respect sprite rotation or scale. If you rotate
	 * or scale the sprite, the bounds will NOT change.
	 * 
	 * @return the clickable object's lower left bounds
	 */
	@Override
	public Vector2f getBoundLL() {
		return boundLL;
	}

	/**
	 * Gets the clickable object's upper right corner of its clickable bounds.
	 * <p>
	 * Clickable bounds do not respect sprite rotation or scale. If you rotate
	 * or scale the sprite, the bounds will NOT change.
	 * 
	 * @return the clickable object's upper right bounds
	 */
	@Override
	public Vector2f getBoundUR() {
		return boundUR;
	}

	/**
	 * Sets the clickable object's lower left corner of its clickable bounds.
	 * <p>
	 * Clickable bounds do not respect sprite rotation or scale. If you rotate
	 * or scale the sprite, the bounds will NOT change.
	 * 
	 * @param boundLL
	 *            the lower left bounds to set for the clickable object
	 */
	public void setBoundLL(final Vector2f boundLL) {
		this.boundLL.set(boundLL);
	}

	/**
	 * Sets the clickable object's upper right corner of its clickable bounds.
	 * <p>
	 * Clickable bounds do not respect sprite rotation or scale. If you rotate
	 * or scale the sprite, the bounds will NOT change.
	 * 
	 * @param boundUR
	 *            the upper right bounds to set for the clickable object
	 */
	public void setBoundUR(final Vector2f boundUR) {
		this.boundUR.set(boundUR);
	}

	@Override
	public String getId() {
		return id;
	}

	/**
	 * Sets the clickable object's identifier. This is designed for internal use
	 * in InputHook, so you don't have to extend different classes for every
	 * single button.
	 * 
	 * @param id
	 *            the desired identifier for the clickable object
	 */
	public void setId(final String id) {
		this.id = id;
	}
}
