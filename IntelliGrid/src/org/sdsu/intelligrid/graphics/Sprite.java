// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import static android.opengl.GLES20.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.StringUtils;
import org.sdsu.intelligrid.util.Vector2f;

import android.opengl.Matrix;

/**
 * A simple drawable object designed to render a single static sprite.
 */
public class Sprite implements Drawable {

	private static final float[] spritePositionData = {
			// X, Y, Z
			-1.0f, -1.0f, 0.0f,

			-1.0f, 1.0f, 0.0f,

			1.0f, 1.0f, 0.0f,

			1.0f, 1.0f, 0.0f,

			1.0f, -1.0f, 0.0f,

			-1.0f, -1.0f, 0.0f, };
	private static final FloatBuffer spritePositionBuffer;

	private static final float[] spriteTexCoordinateData = {
			// S, T (X, Y)
			0.0f, 1.0f,

			0.0f, 0.0f,

			1.0f, 0.0f,

			1.0f, 0.0f,

			1.0f, 1.0f,

			0.0f, 1.0f };
	private static final FloatBuffer spriteTexCoordinateBuffer;

	private static final int spriteShader;
	private static final int[] spriteShaderParams = new int[5];

	private final float[] modelMatrix = new float[16];
	private final float[] combinedMatrix = new float[16];

	private final Vector2f location = new Vector2f();
	private float rotation = 0f;
	private final Vector2f scale = new Vector2f(1.0f, 1.0f);
	private final Vector2f scaleFactor = new Vector2f();
	private float[] color;
	private boolean absoluteScale = true;
	private boolean additive = false;

	private int texture;
	private int resource;
	private int texture2;
	private int resource2;

	private float time = 1f;
	private float progress = 1f;

	private int width;
	private int height;

	private int depth;

	private static final int BYTES_PER_FLOAT = 4;

	static {
		// Load information into buffers
		spritePositionBuffer = ByteBuffer
				.allocateDirect(spritePositionData.length * BYTES_PER_FLOAT)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();

		spritePositionBuffer.put(spritePositionData).position(0);

		spriteTexCoordinateBuffer = ByteBuffer
				.allocateDirect(
						spriteTexCoordinateData.length * BYTES_PER_FLOAT)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();

		spriteTexCoordinateBuffer.put(spriteTexCoordinateData).position(0);

		// Load the vertex shader text
		String vert;
		vert = StringUtils.rawResourceToString(Global.getResources(),
				org.sdsu.intelligrid.R.raw.spritevert);

		// Load the fragment shader text
		String frag;
		frag = StringUtils.rawResourceToString(Global.getResources(),
				org.sdsu.intelligrid.R.raw.spritefrag);

		// Load and compile the shader
		spriteShader = MainRenderer.loadShader(vert, frag);

		// Define absolute positions for each shader parameter
		spriteShaderParams[0] = glGetUniformLocation(spriteShader,
				"u_MVPMatrix");
		spriteShaderParams[1] = glGetUniformLocation(spriteShader, "u_Texture");
		spriteShaderParams[2] = glGetUniformLocation(spriteShader, "a_Color");
		spriteShaderParams[3] = glGetAttribLocation(spriteShader, "a_Position");
		spriteShaderParams[4] = glGetAttribLocation(spriteShader,
				"a_TexCoordinate");
	}

	/**
	 * A simple drawable object designed to render a single static sprite.
	 * 
	 * @param location
	 *            the location of the sprite, in OpenGL coordinates (
	 *            <tt>[0.0,0.0]</tt> is the default position)
	 * @param depth
	 *            the scene depth of the sprite
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
	 */
	public Sprite(final Vector2f location, final int depth,
			final float rotation, final Vector2f scale, final Color color,
			final int resource) {
		if (location != null) {
			this.location.set(location);
		}
		this.rotation = rotation;
		if (scale != null) {
			this.scale.set(scale);
		}
		setResource(resource);

		this.depth = depth;

		this.color = color.getArray();
	}

	@Override
	public Vector2f getLocation() {
		return location;
	}

	/**
	 * Sets the drawable object's scene location. <tt>[0,0]</tt> is the center;
	 * on our device, in landscape mode, <tt>[-1.6,-1.0]</tt> is the bottom left
	 * corner and <tt>[1.6,1.0]</tt> is the top right corner. These values can
	 * change on other aspect ratios, so you should make it a habit of using
	 * {@link MainRenderer#getLeftEdge()} and the other similar functions to get
	 * the screen dimensions.
	 * 
	 * @param location
	 *            the desired location for the drawable object
	 */
	public void setLocation(final Vector2f location) {
		this.location.set(location);
	}

	@Override
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the the drawable object's scene depth. A lower depth means the
	 * object is drawn on top of higher-depth objects.
	 * 
	 * @param location
	 *            the desired depth for the drawable object
	 */
	public void setDepth(final int depth) {
		this.depth = depth;
	}

	/**
	 * Gets the sprite's rotation, in radians. <tt>0.0</tt> is the default
	 * rotation.
	 * 
	 * @return the sprite's current rotation, in radians
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * Sets the sprite's rotation, in radians.
	 * 
	 * @param rotation
	 *            the desired rotation for the sprite, in radians
	 */
	public void setRotation(final float rotation) {
		this.rotation = rotation;
	}

	/**
	 * Gets the sprite's scaling factor. <tt>[1.0,1.0]</tt> is the default
	 * scale.
	 * <p>
	 * See {@link #setAbsoluteScale()} and {@link #setRelativeScale()}.
	 * 
	 * @return the sprite's current scaling factor
	 */
	public Vector2f getScale() {
		return location;
	}

	/**
	 * Sets the sprite's scaling factor.
	 * <p>
	 * See {@link #setAbsoluteScale()} and {@link #setRelativeScale()}.
	 * 
	 * @param scale
	 *            the desired scaling factor for the sprite
	 */
	public void setScale(final Vector2f scale) {
		this.scale.set(scale);
	}

	/**
	 * Gets the sprite's color factor.
	 * 
	 * @return the sprite's current color factor
	 */
	public Color getColor() {
		return new Color(color);
	}

	/**
	 * Sets the sprite's color factor.
	 * 
	 * @param color
	 *            the desired color factor for the sprite
	 */
	public void setColor(final Color color) {
		this.color = color.getArray();
	}

	/**
	 * Gets the sprite's current resource ID.
	 * 
	 * @return the resource ID that the sprite is using
	 */
	public int getResource() {
		return resource;
	}

	/**
	 * Gets the sprite image's actual width, in texels.
	 * 
	 * @return the actual width, in texels, of the sprite image
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets the sprite image's actual height, in texels.
	 * 
	 * @return the actual height, in texels, of the sprite image
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the sprite's resource ID. Make sure it has been already loaded with
	 * {@link MainRenderer#loadTextures(java.util.List<Integer>)}.
	 * 
	 * @param resource
	 *            the resource ID that the sprite should display
	 */
	public void setResource(final int resource) {
		this.resource = resource;

		final Texture tex = Global.getRenderer().getTexture(resource);
		texture = tex.getTexture();
		width = tex.getWidth();
		height = tex.getHeight();
	}

	/**
	 * Sets the sprite's resource ID and blends it in over time. Must be the
	 * same size.
	 * 
	 * @param resource
	 *            the resource ID that the sprite should display
	 * @param time
	 *            the time to blend the sprite transition
	 */
	public void setResourceOverTime(final int resource, final float time) {
		resource2 = this.resource;
		texture2 = texture;

		this.resource = resource;
		this.time = time;
		progress = 0f;

		Texture tex = Global.getRenderer().getTexture(resource);
		texture = tex.getTexture();
		width = tex.getWidth();
		height = tex.getHeight();
	}

	/**
	 * Sets the scaling mode to <tt>absolute</tt>. This means that the sprite's
	 * size will remain consistent, in pixels, regardless of the screen size.
	 * For example, a 1280x800 image will appear to fill a quarter of the screen
	 * on a 2560x1600 display, at <tt>[1.0,1.0]</tt> scaling.
	 * <p>
	 * This is the default scaling mode for sprites.
	 */
	public void setAbsoluteScale() {
		absoluteScale = true;
	}

	/**
	 * Sets the scaling mode to <tt>relative</tt>. This means that the sprite's
	 * size will scale to the screen. For example, a 512x512 image will stretch
	 * to fill the whole vertical area of the screen on a 2560x1600 display, at
	 * <tt>[1.0,1.0]</tt> scaling.
	 */
	public void setRelativeScale() {
		absoluteScale = false;
	}

	/**
	 * Sets the sprite rendering mode to additive or standard (if <tt>false</tt>
	 * ).
	 */
	public void setAdditive(final boolean additive) {
		this.additive = additive;
	}

	@Override
	public void advance(final float amount) {
		if (progress < 1f) {
			progress += amount;
			if (progress >= 1f) {
				resource2 = -1;
				texture2 = -1;
			}
		}
	}

	private static final int POSITION_OFFSET = 0;
	private static final int POSITION_DATA_SIZE = 3;
	private static final int TEXTURE_COORDINATE_OFFSET = 0;
	private static final int TEXTURE_COORDINATE_DATA_SIZE = 2;

	@Override
	public void draw(final float amount, final float[] viewMatrix,
			final float[] projectionMatrix) {
		if (depth > 10) {
			return;
		}

		// Update scaling factor to keep the sprite at a consistent size
		if (absoluteScale) {
			final int screenHeight = Global.getRenderer().getScreenHeight();
			scaleFactor.y = (float) height / (float) screenHeight;
			scaleFactor.x = scaleFactor.y * (float) width / (float) height;
		} else {
			scaleFactor.y = 1f;
			scaleFactor.x = (float) width / (float) height;
		}

		// Update model matrix with rotation, scale, and position
		Matrix.setIdentityM(modelMatrix, 0);
		Matrix.translateM(modelMatrix, 0, location.x, location.y, 0.0f);
		Matrix.rotateM(modelMatrix, 0, rotation, 0.0f, 0.0f, 1.0f);
		Matrix.scaleM(modelMatrix, 0, scale.x * scaleFactor.x, scale.y
				* scaleFactor.y, 1.0f);

		// Activate the general sprite drawing shader
		glUseProgram(spriteShader);

		// Set the state functions
		glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		if (additive) {
			glBlendFunc(GL_SRC_ALPHA, GL_ONE);
		} else {
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		}

		// Load in the texture
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, texture);
		glUniform1i(spriteShaderParams[1], 0);

		// Load in the color
		glUniform4fv(spriteShaderParams[2], 1, color, 0);

		// Load in the sprite model vertices
		spritePositionBuffer.position(POSITION_OFFSET);
		glVertexAttribPointer(spriteShaderParams[3], POSITION_DATA_SIZE,
				GL_FLOAT, false, 3 * BYTES_PER_FLOAT, spritePositionBuffer);
		glEnableVertexAttribArray(spriteShaderParams[3]);

		// Load in the sprite model texture coordinates
		spriteTexCoordinateBuffer.position(TEXTURE_COORDINATE_OFFSET);
		glVertexAttribPointer(spriteShaderParams[4],
				TEXTURE_COORDINATE_DATA_SIZE, GL_FLOAT, false,
				2 * BYTES_PER_FLOAT, spriteTexCoordinateBuffer);
		glEnableVertexAttribArray(spriteShaderParams[4]);

		// Create the combined movel-view-projection (MVP) matrix
		Matrix.multiplyMM(combinedMatrix, 0, viewMatrix, 0, modelMatrix, 0);
		Matrix.multiplyMM(combinedMatrix, 0, projectionMatrix, 0,
				combinedMatrix, 0);

		// Load in the MVP matrix
		glUniformMatrix4fv(spriteShaderParams[0], 1, false, combinedMatrix, 0);

		// Draw the sprite
		glDrawArrays(GL_TRIANGLES, 0, 6);

		if (progress < 1f) {
			// Load in the texture
			glActiveTexture(GL_TEXTURE0);
			glBindTexture(GL_TEXTURE_2D, texture2);
			glUniform1i(spriteShaderParams[1], 0);

			// Load in the color
			final float[] newColor = { color[0], color[1], color[2],
					(1f - progress) * color[3] };
			glUniform4fv(spriteShaderParams[2], 1, newColor, 0);

			// Load in the sprite model vertices
			spritePositionBuffer.position(POSITION_OFFSET);
			glVertexAttribPointer(spriteShaderParams[3], POSITION_DATA_SIZE,
					GL_FLOAT, false, 3 * BYTES_PER_FLOAT, spritePositionBuffer);
			glEnableVertexAttribArray(spriteShaderParams[3]);

			// Load in the sprite model texture coordinates
			spriteTexCoordinateBuffer.position(TEXTURE_COORDINATE_OFFSET);
			glVertexAttribPointer(spriteShaderParams[4],
					TEXTURE_COORDINATE_DATA_SIZE, GL_FLOAT, false,
					2 * BYTES_PER_FLOAT, spriteTexCoordinateBuffer);
			glEnableVertexAttribArray(spriteShaderParams[4]);

			// Create the combined movel-view-projection (MVP) matrix
			Matrix.multiplyMM(combinedMatrix, 0, viewMatrix, 0, modelMatrix, 0);
			Matrix.multiplyMM(combinedMatrix, 0, projectionMatrix, 0,
					combinedMatrix, 0);

			// Load in the MVP matrix
			glUniformMatrix4fv(spriteShaderParams[0], 1, false, combinedMatrix,
					0);

			// Draw the sprite
			glDrawArrays(GL_TRIANGLES, 0, 6);
		}

		// Clean up state bits that were set
		glUseProgram(0);
		glDisable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
	}
}
