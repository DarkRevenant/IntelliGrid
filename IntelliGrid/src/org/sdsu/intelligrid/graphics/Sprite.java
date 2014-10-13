package org.sdsu.intelligrid.graphics;

import org.sdsu.intelligrid.util.Vector2f;

/**
 * A simple drawable object designed to render a single static sprite.
 */
public class Sprite implements Drawable {

	private final Vector2f loc = new Vector2f();
	private int texture;
	private String textureID;

	public Sprite(Vector2f loc, String textureID) {
		this.loc.set(loc);
		this.textureID = textureID;
		texture = MainRenderer.getTexture(textureID);
	}

	@Override
	public Vector2f getLocation() {
		return loc;
	}

	public void setLocation(Vector2f loc) {
		this.loc.set(loc);
	}

	public void setTexture(String textureID) {
		this.textureID = textureID;
		texture = MainRenderer.getTexture(textureID);
	}

	public String getTexture() {
		return textureID;
	}

	@Override
	public void advance(float amount) {
	}

	@Override
	public void draw() {
	}
}
