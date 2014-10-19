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
	 * change on other aspect ratios, but that shouldn't be an issue right now.
	 * 
	 * @return the drawable object's current location
	 */
	public Vector2f getLocation();

	public void advance(float amount);

	public void draw();
}
