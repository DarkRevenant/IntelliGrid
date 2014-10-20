// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.util;

/**
 * Color container class.
 */
public class Color {

	final float[] color = new float[4];

	/**
	 * Color container class. The default color is <tt>[255,255,255,255]</tt>.
	 */
	public Color() {
		color[0] = 1.0f;
		color[1] = 1.0f;
		color[2] = 1.0f;
		color[3] = 1.0f;
	}

	/**
	 * Color container class.
	 * 
	 * @param color
	 *            the desired color, as specified in 0-1 RGB or RGBA form
	 */
	public Color(final float[] color) {
		setColor(color);
	}

	/**
	 * Color container class. Alpha is <tt>1</tt>.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-1 float value
	 * @param green
	 *            the desired green channel, as specified in 0-1 float value
	 * @param blue
	 *            the desired blue channel, as specified in 0-1 float value
	 */
	public Color(final float red, final float green, final float blue) {
		setColor(red, green, blue);
	}

	/**
	 * Color container class.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-1 float value
	 * @param green
	 *            the desired green channel, as specified in 0-1 float value
	 * @param blue
	 *            the desired blue channel, as specified in 0-1 float value
	 * @param alpha
	 *            the desired alpha channel, as specified in 0-1 float value
	 */
	public Color(final float red, final float green, final float blue,
			final float alpha) {
		setColor(red, green, blue, alpha);
	}

	/**
	 * Color container class. Alpha is <tt>255</tt>.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-255 integer value
	 * @param green
	 *            the desired green channel, as specified in 0-255 integer value
	 * @param blue
	 *            the desired blue channel, as specified in 0-255 integer value
	 */
	public Color(final int red, final int green, final int blue) {
		setColor(red, green, blue);
	}

	/**
	 * Color container class.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-255 integer value
	 * @param green
	 *            the desired green channel, as specified in 0-255 integer value
	 * @param blue
	 *            the desired blue channel, as specified in 0-255 integer value
	 * @param alpha
	 *            the desired alpha channel, as specified in 0-255 integer value
	 */
	public Color(final int red, final int green, final int blue, final int alpha) {
		setColor(red, green, blue, alpha);
	}

	/**
	 * Color container class.
	 * 
	 * @param src
	 *            the color to copy
	 */
	public Color(final Color src) {
		setColor(src);
	}

	/**
	 * Sets the color in this object.
	 * 
	 * @param color
	 *            the desired color, as specified in 0-1 RGB or RGBA form
	 */
	public void setColor(final float[] color) {
		this.color[0] = Math.max(Math.min(color[0], 1.0f), 0.0f); // red
		this.color[1] = Math.max(Math.min(color[1], 1.0f), 0.0f); // green
		this.color[2] = Math.max(Math.min(color[2], 1.0f), 0.0f); // blue
		if (color.length >= 4) {
			this.color[3] = Math.max(Math.min(color[3], 1.0f), 0.0f); // alpha
		} else {
			this.color[3] = 1.0f; // alpha
		}
	}

	/**
	 * Sets the color in this object. Alpha is <tt>1</tt>.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-1 float value
	 * @param green
	 *            the desired green channel, as specified in 0-1 float value
	 * @param blue
	 *            the desired blue channel, as specified in 0-1 float value
	 */
	public void setColor(final float red, final float green, final float blue) {
		color[0] = Math.max(Math.min(red, 1.0f), 0.0f); // red
		color[1] = Math.max(Math.min(green, 1.0f), 0.0f); // green
		color[2] = Math.max(Math.min(blue, 1.0f), 0.0f); // blue
		color[3] = 1.0f; // alpha
	}

	/**
	 * Sets the color in this object.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-1 float value
	 * @param green
	 *            the desired green channel, as specified in 0-1 float value
	 * @param blue
	 *            the desired blue channel, as specified in 0-1 float value
	 * @param alpha
	 *            the desired alpha channel, as specified in 0-1 float value
	 */
	public void setColor(final float red, final float green, final float blue,
			final float alpha) {
		color[0] = Math.max(Math.min(red, 1.0f), 0.0f); // red
		color[1] = Math.max(Math.min(green, 1.0f), 0.0f); // green
		color[2] = Math.max(Math.min(blue, 1.0f), 0.0f); // blue
		color[3] = Math.max(Math.min(alpha, 1.0f), 0.0f); // alpha
	}

	/**
	 * Sets the color in this object. Alpha is <tt>255</tt>.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-255 integer value
	 * @param green
	 *            the desired green channel, as specified in 0-255 integer value
	 * @param blue
	 *            the desired blue channel, as specified in 0-255 integer value
	 */
	public void setColor(final int red, final int green, final int blue) {
		color[0] = Math.max(Math.min((float) red / 255f, 1.0f), 0.0f); // red
		color[1] = Math.max(Math.min((float) green / 255f, 1.0f), 0.0f); // green
		color[2] = Math.max(Math.min((float) blue / 255f, 1.0f), 0.0f); // blue
		color[3] = 1.0f; // alpha
	}

	/**
	 * Sets the color in this object.
	 * 
	 * @param red
	 *            the desired red channel, as specified in 0-255 integer value
	 * @param green
	 *            the desired green channel, as specified in 0-255 integer value
	 * @param blue
	 *            the desired blue channel, as specified in 0-255 integer value
	 * @param alpha
	 *            the desired alpha channel, as specified in 0-255 integer value
	 */
	public void setColor(final int red, final int green, final int blue,
			final int alpha) {
		color[0] = Math.max(Math.min((float) red / 255f, 1.0f), 0.0f); // red
		color[1] = Math.max(Math.min((float) green / 255f, 1.0f), 0.0f); // green
		color[2] = Math.max(Math.min((float) blue / 255f, 1.0f), 0.0f); // blue
		color[3] = Math.max(Math.min((float) alpha / 255f, 1.0f), 0.0f); // alpha
	}

	/**
	 * Sets the color in this object.
	 * 
	 * @param src
	 *            the color to copy
	 */
	public void setColor(final Color src) {
		color[0] = Math.max(Math.min(src.color[0], 1.0f), 0.0f); // red
		color[1] = Math.max(Math.min(src.color[1], 1.0f), 0.0f); // green
		color[2] = Math.max(Math.min(src.color[2], 1.0f), 0.0f); // blue
		color[3] = Math.max(Math.min(src.color[3], 1.0f), 0.0f); // alpha
	}

	/**
	 * Gets a 4-dimensional float array containing the OpenGL-formatted color
	 * contained in this object.
	 * 
	 * @return a 4-dimensional float array containing the OpenGL-formatted color
	 *         contained in this object
	 */
	public float[] getArray() {
		return color.clone();
	}

	/**
	 * Gets the red channel of the color contained in this object.
	 * 
	 * @return a 0-255 integer value representing the red color channel of this
	 *         object
	 */
	public int getRed() {
		return (int) (color[0] * 255f);
	}

	/**
	 * Gets the green channel of the color contained in this object.
	 * 
	 * @return a 0-255 integer value representing the green color channel of
	 *         this object
	 */
	public int getGreen() {
		return (int) (color[1] * 255f);
	}

	/**
	 * Gets the blue channel of the color contained in this object.
	 * 
	 * @return a 0-255 integer value representing the blue color channel of this
	 *         object
	 */
	public int getBlue() {
		return (int) (color[2] * 255f);
	}

	/**
	 * Gets the alpha channel of the color contained in this object.
	 * 
	 * @return a 0-255 integer value representing the alpha color channel of
	 *         this object
	 */
	public int getAlpha() {
		return (int) (color[3] * 255f);
	}
}
