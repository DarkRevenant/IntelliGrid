// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.util;

/**
 * 2d vector class, useful for calculations and declarations involving vectors.
 */
public class Vector2f {

	private static final double PI2 = Math.PI * 2.0;

	public float x, y;

	public Vector2f() {
		this.x = 0f;
		this.y = 0f;
	}

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the vector to be a copy of the given vector.
	 * 
	 * @param src
	 *            the vector to copy
	 * @return the local vector
	 */
	public Vector2f set(Vector2f src) {
		this.x = src.x;
		this.y = src.y;
		return this;
	}

	/**
	 * Adds two vectors.
	 * 
	 * @param left
	 *            the left-hand side of the equation
	 * @param right
	 *            the right-hand side of the equation
	 * @param dst
	 *            the destination vector; may be null
	 * @return the result of <tt>left + right</tt>
	 */
	public static Vector2f add(Vector2f left, Vector2f right, Vector2f dst) {
		if (dst == null) {
			return new Vector2f(left.x + right.x, left.y + right.y);
		} else {
			dst.x = left.x + right.x;
			dst.y = left.y + right.y;
			return dst;
		}
	}

	/**
	 * Subtracts two vectors.
	 * 
	 * @param left
	 *            the left-hand side of the equation
	 * @param right
	 *            the right-hand side of the equation
	 * @param dst
	 *            the destination vector; may be null
	 * @return the result of <tt>left - right</tt>
	 */
	public static Vector2f sub(Vector2f left, Vector2f right, Vector2f dst) {
		if (dst == null) {
			return new Vector2f(left.x - right.x, left.y - right.y);
		} else {
			dst.x = left.x - right.x;
			dst.y = left.y - right.y;
			return dst;
		}
	}

	/**
	 * Rotates the vector by the angle given in radians.
	 * 
	 * @param angle
	 *            the angle to rotate the vector by, in radians.
	 * @return the local vector
	 */
	public Vector2f rotate(float angle) {
		final double cs = Math.cos(angle);
		final double sn = Math.sin(angle);
		final double px = this.x * cs - this.y * sn;
		this.y = (float) (this.x * sn + this.y * cs);
		this.x = (float) px;
		return this;
	}

	/**
	 * Scales the vector by the given factor.
	 * 
	 * @param factor
	 *            the factor by which to multiply the vector
	 * @return the local vector
	 */
	public Vector2f scale(float factor) {
		this.x *= factor;
		this.y *= factor;
		return this;
	}

	/**
	 * Normalises the vector and places the result in <tt>dst</tt>. The local
	 * vector is not modified.
	 * 
	 * @param dst
	 *            the destination vector; may be null
	 * @return the result of normalization
	 */
	public Vector2f normalise(Vector2f dst) {
		final float r = (float) (1.0 / Math.sqrt(this.x * this.x + this.y * this.y));
		if (dst == null) {
			return new Vector2f(this.x * r, this.y * r);
		} else {
			dst.x = this.x * r;
			dst.y = this.y * r;
			return dst;
		}
	}

	/**
	 * Calculates the actual length of the vector.
	 * 
	 * @return the length of the vector
	 */
	public float length() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/**
	 * Calculates the squared length of the vector. Less expensive than
	 * {@link #length()}.
	 * 
	 * @return the square of the length of the vector
	 */
	public float lengthSquared() {
		return this.x * this.x + this.y * this.y;
	}

	/**
	 * Negates the vector.
	 * 
	 * @return the local vector
	 */
	public Vector2f negate() {
		this.x = -this.x;
		this.y = -this.y;
		return this;
	}

	/**
	 * Negates the vector. The local vector is not modified.
	 * 
	 * @param dst
	 *            the destination vector; may be null
	 * @return the negation of the vector
	 */
	public Vector2f negate(Vector2f dst) {
		if (dst == null) {
			return new Vector2f(-this.x, -this.y);
		} else {
			dst.x = -this.x;
			dst.y = -this.y;
			return dst;
		}
	}

	/**
	 * Calculates the angle between two vectors, in radians.
	 * 
	 * @return the angle of <tt>b</tt> relative to <tt>a</tt>, in radians.
	 */
	public static float angle(Vector2f a, Vector2f b) {
		double angle = Math.atan2(b.y, b.x) - Math.atan2(a.y, a.x);
		if (angle > Math.PI) {
			angle -= PI2;
		} else if (angle < -Math.PI) {
			angle += PI2;
		}
		return (float) angle;
	}

	/**
	 * Calculates the dot product of two vectors.
	 * 
	 * @param left
	 *            the left-hand side of the equation
	 * @param right
	 *            the right-hand side of the equation
	 * @return the dot product: <tt>left.x * right.x + left.y * right.y</tt>
	 */
	public static float dot(Vector2f left, Vector2f right) {
		return left.x * right.x + left.y * right.y;
	}
}
