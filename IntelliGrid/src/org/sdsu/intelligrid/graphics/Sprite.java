// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.util.Vector2f;

/**
 * A simple drawable object designed to render a single static sprite.
 */
public class Sprite implements Drawable {

	private final Vector2f loc = new Vector2f();
	private int texture;
	private int resource;

	public Sprite(Vector2f loc, int resource) {
		this.loc.set(loc);
		this.resource = resource;
		texture = Global.getRenderer().getTexture(resource);
	}

	@Override
	public Vector2f getLocation() {
		return loc;
	}

	public void setLocation(Vector2f loc) {
		this.loc.set(loc);
	}

	public void setResource(int resource) {
		this.resource = resource;
		texture = Global.getRenderer().getTexture(resource);
	}

	public int getResource() {
		return resource;
	}

	@Override
	public void advance(float amount) {
	}

	@Override
	public void draw() {
	}
}
