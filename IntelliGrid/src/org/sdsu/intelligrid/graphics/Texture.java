package org.sdsu.intelligrid.graphics;

/**
 * Texture information container.
 */
public class Texture {

	private final int resource;
	private final int texture;

	private final int width;
	private final int height;

	Texture(final int resource, final int texture, final int width,
			final int height) {
		this.resource = resource;
		this.texture = texture;
		this.width = width;
		this.height = height;
	}

	/**
	 * Gets the resource ID associated with this Texture.
	 * 
	 * @return the resource ID corresponding to the Texture object
	 */
	public int getResource() {
		return resource;
	}

	/**
	 * Gets the texture name associated with this Texture.
	 * 
	 * @return the texture name corresponding to the Texture object
	 */
	public int getTexture() {
		return texture;
	}

	/**
	 * Gets the width of the Texture, in texels.
	 * 
	 * @return the width of the Texture, in texels
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets the height of the Texture, in texels.
	 * 
	 * @return the height of the Texture, in texels
	 */
	public int getHeight() {
		return height;
	}
}
