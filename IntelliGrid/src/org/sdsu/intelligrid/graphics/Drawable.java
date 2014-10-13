package org.sdsu.intelligrid.graphics;

import org.sdsu.intelligrid.util.Vector2f;

/**
 * Interface container for programmable drawable objects.
 */
public interface Drawable {

	/**
	 * Gets the drawable object's scene location (0,0 is the top left while
	 * 2560x1600 is the bottom right).
	 * 
	 * @return the drawable object's current location
	 */
	public Vector2f getLocation();

	public void advance(float amount);

	public void draw();
}
