// Copyright 2014 Harrison Snodgrass, all rights reserved

package org.sdsu.intelligrid.graphics;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.sdsu.intelligrid.Global;

import static android.opengl.GLES20.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;

/**
 * Renderer class for the application.
 */
public class MainRenderer implements GLSurfaceView.Renderer {

	private final Map<Integer, Texture> textureTable = new HashMap<>();
	final List<Drawable> drawableList = new ArrayList<>();
	private final List<Integer> toLoad = Collections
			.synchronizedList(new ArrayList<Integer>());
	private final List<Drawable> toDraw = Collections
			.synchronizedList(new ArrayList<Drawable>());
	private final List<Drawable> toRemove = Collections
			.synchronizedList(new ArrayList<Drawable>());

	private int screenWidth;
	private int screenHeight;

	private final float[] viewMatrix = new float[16];
	private final float[] projectionMatrix = new float[16];

	private long lastms;
	private static final int FRAME_RATE = 63; // maximum frames per second, set
												// slightly higher than 60
												// because we're rebels

	@Override
	public void onDrawFrame(GL10 unused) {
		final long beginms, endms;
		long leftms;

		beginms = System.currentTimeMillis();

		float amount = (float) (beginms - lastms) / 1000f;

		lastms = beginms;

		endms = System.currentTimeMillis() - beginms;

		leftms = (1000L / FRAME_RATE) - endms;

		// avoid catchup
		if (leftms > 1000) {
			leftms = 1000;
		}
		if (amount > 0.1f) {
			amount = 0.1f;
		}

		advance(amount);
		draw(amount);

		/*try {
			TimeUnit.MILLISECONDS.sleep(leftms);
		} catch (InterruptedException e) {
		}*/
	}

	/**
	 * Loads every resource in the given list as formal OpenGL textures. After
	 * calling this function, each resource specified will be available for
	 * rendering. Do not load the same resource multiple times, as it will waste
	 * memory.
	 * <p>
	 * Use {@link #getTexture(resource)} to grab the generated {@link Texture}
	 * for a previously-loaded resource.
	 * <p>
	 * Remember that OpenGL is threaded in this application; the textures will
	 * load at the end of the current frame, so don't count on them being
	 * available right after calling this function!
	 * 
	 * @param resources
	 *            the list of resources to load
	 */
	public void loadTextures(final List<Integer> resources) {
		toLoad.addAll(resources);
	}

	/**
	 * Adds a {@link org.sdsu.intelligrid.graphics.Drawable Drawable} to the
	 * rendering list. After calling this function, the added
	 * {@link org.sdsu.intelligrid.graphics.Drawable Drawable} members
	 * {@link org.sdsu.intelligrid.graphics.Drawable#advance(amount) advance}
	 * and {@link org.sdsu.intelligrid.graphics.Drawable#draw() draw} will begin
	 * to be called automatically.
	 * 
	 * @param drawable
	 *            the drawable object to add
	 */
	public void addDrawable(final Drawable drawable) {
		toDraw.add(drawable);
	}

	/**
	 * Removes a {@link org.sdsu.intelligrid.graphics.Drawable Drawable} from
	 * the rendering list.
	 * 
	 * @param drawable
	 *            the drawable object to remove
	 */
	public void removeDrawable(final Drawable drawable) {
		toRemove.add(drawable);
	}

	/**
	 * Gets the {@link Texture} associated with <tt>resource</tt>. This resource
	 * must have already been loaded with {@link #loadTextures(resources)}.
	 * 
	 * @param resource
	 *            the resource to get the {@link Texture} for
	 * @return the {@link Texture} associated with <tt>resource</tt>
	 */
	public Texture getTexture(final int resource) {
		return textureTable.get(resource);
	}

	/**
	 * Gets the absolute <tt>x</tt> position of the left screen edge, in OpenGL
	 * coordinates.
	 * 
	 * @return the <tt>x</tt> position of the left screen edge
	 */
	public float getLeftEdge() {
		final float ratio = (float) screenWidth / (float) screenHeight;
		final float left = -ratio;
		return left;
	}

	/**
	 * Gets the absolute <tt>x</tt> position of the right screen edge, in OpenGL
	 * coordinates.
	 * 
	 * @return the <tt>x</tt> position of the right screen edge
	 */
	public float getRightEdge() {
		final float ratio = (float) screenWidth / (float) screenHeight;
		final float right = ratio;
		return right;
	}

	/**
	 * Gets the absolute <tt>y</tt> position of the bottom screen edge, in
	 * OpenGL coordinates.
	 * 
	 * @return the <tt>y</tt> position of the bottom screen edge
	 */
	public float getBottomEdge() {
		final float bottom = -1.0f;
		return bottom;
	}

	/**
	 * Gets the absolute <tt>y</tt> position of the top screen edge, in OpenGL
	 * coordinates.
	 * 
	 * @return the <tt>y</tt> position of the top screen edge
	 */
	public float getTopEdge() {
		final float top = 1.0f;
		return top;
	}

	/**
	 * Gets the width of the visible screen, in pixels.
	 * 
	 * @return the width of the visible screen, in pixels
	 */
	public int getScreenWidth() {
		return screenWidth;
	}

	/**
	 * Gets the height of the visible screen, in pixels.
	 * 
	 * @return the height of the visible screen, in pixels
	 */
	public int getScreenHeight() {
		return screenHeight;
	}

	@Override
	public void onSurfaceCreated(GL10 unused, EGLConfig config) {
		glClearColor(0.2f, 0.3f, 0.4f, 1.0f);

		// Set up camera
		final float eyeX = 0.0f;
		final float eyeY = 0.0f;
		final float eyeZ = 1.0f;

		final float lookX = 0.0f;
		final float lookY = 0.0f;
		final float lookZ = -1.0f;

		final float upX = 0.0f;
		final float upY = 1.0f;
		final float upZ = 0.0f;

		Matrix.setLookAtM(viewMatrix, 0, eyeX, eyeY, eyeZ, lookX, lookY, lookZ,
				upX, upY, upZ);
	}

	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {
		screenWidth = width;
		screenHeight = height;

		glViewport(0, 0, width, height);

		// Set the orthographic projection of the screen
		// The screen, on this device, spans [-1.6,-1.0] on the bottom left to
		// [1.6,1.0] on the top right
		final float ratio = (float) width / (float) height;
		final float left = -ratio;
		final float right = ratio;
		final float bottom = -1.0f;
		final float top = 1.0f;
		final float near = 1.0f;
		final float far = 10.0f;

		Matrix.orthoM(projectionMatrix, 0, left, right, bottom, top, near, far);
	}

	private boolean first = true;

	/**
	 * Primary simulation hook
	 */
	private void advance(final float amount) {
		// Add any unadded drawables
		addDrawables();
		removeDrawables();

		if (!first) {
			// Increment the simulation
			Global.getGlobalSimulation().advance(amount);

			// Handle the network
			Global.getNetworkHandler().advance(amount);

			// Increment the user interface
			Global.getMainUI().advance(amount);
		} else {
			first = false;
		}

		// Call each Drawable's advance function
		for (Drawable drawable : drawableList) {
			drawable.advance(amount);
		}
	}

	/**
	 * Primary rendering hook
	 */
	private void draw(final float amount) {
		// Add any unadded drawables
		addDrawables();
		removeDrawables();

		// Load any unloaded textures
		loadTextures();

		// Clear the screen
		glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);

		// Call each Drawable's draw function
		Collections.sort(drawableList, DEPTH_DESCENDING);
		for (Drawable drawable : drawableList) {
			drawable.draw(amount, viewMatrix, projectionMatrix);
		}
	}

	/**
	 * Compiles the given shader. Does NOT validate the shader.
	 * 
	 * @param vert
	 *            the vertex shader, given as a String
	 * @param frag
	 *            the fragment shader, given as a String
	 * 
	 * @return the shader program ID corresponding to the newly-compiled shader.
	 *         Returns 0 on error
	 */
	public static int loadShader(final String vert, final String frag) {
		final int vertShader, fragShader;

		try {
			vertShader = createShader(vert, GL_VERTEX_SHADER);
			fragShader = createShader(frag, GL_FRAGMENT_SHADER);
		} catch (RuntimeException exc) {
			Logger.getGlobal().log(Level.SEVERE, exc.getMessage());
			return 0;
		}

		if (vertShader == 0 || fragShader == 0) {
			return 0;
		}

		final int prog = glCreateProgram();

		if (prog == 0) {
			return 0;
		}

		glAttachShader(prog, vertShader);
		glAttachShader(prog, fragShader);

		glLinkProgram(prog);
		final int[] linkStatus = new int[1];
		glGetProgramiv(prog, GL_LINK_STATUS, linkStatus, 0);

		if (linkStatus[0] == GL_FALSE) {
			Logger.getGlobal().log(Level.SEVERE, glGetProgramInfoLog(prog));
			glDeleteProgram(prog);
			glDeleteShader(vertShader);
			glDeleteShader(fragShader);
			return 0;
		}

		return prog;
	}

	private static int createShader(final String source, final int shaderType)
			throws RuntimeException {
		int shader = 0;
		try {
			shader = glCreateShader(shaderType);

			if (shader == 0) {
				return 0;
			}

			glShaderSource(shader, source);
			glCompileShader(shader);

			final int[] compileStatus = new int[1];
			glGetShaderiv(shader, GL_COMPILE_STATUS, compileStatus, 0);

			if (compileStatus[0] == GL_FALSE) {
				throw new RuntimeException("Error creating shader: "
						+ glGetShaderInfoLog(shader));
			}

			return shader;
		} catch (RuntimeException exc) {
			glDeleteShader(shader);
			throw exc;
		}
	}

	private void addDrawables() {
		if (toDraw.isEmpty()) {
			return;
		}

		synchronized (toDraw) {
			for (Drawable drawable : toDraw) {
				drawableList.add(drawable);
			}
		}

		toDraw.clear();
	}

	private void removeDrawables() {
		if (toRemove.isEmpty()) {
			return;
		}

		synchronized (toRemove) {
			for (Drawable drawable : toRemove) {
				drawableList.remove(drawable);
			}
		}

		toRemove.clear();
	}

	private void loadTextures() {
		if (toLoad.isEmpty()) {
			return;
		}

		final IntBuffer buffer = IntBuffer.allocate(toLoad.size());
		glGenTextures(toLoad.size(), buffer);

		synchronized (toLoad) {
			for (int resource : toLoad) {
				final int texture = buffer.get();
				final Bitmap bitmap = BitmapFactory.decodeResource(Global
						.getMainActivity().getResources(), resource);

				glBindTexture(GL_TEXTURE_2D, texture);
				GLUtils.texImage2D(GL_TEXTURE_2D, 0, bitmap, 0);
				glGenerateMipmap(GL_TEXTURE_2D);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER,
						GL_LINEAR_MIPMAP_LINEAR);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

				textureTable.put(resource, new Texture(resource, texture,
						bitmap.getWidth(), bitmap.getHeight()));

				bitmap.recycle();
			}
		}

		toLoad.clear();
	}

	private final static Comparator<Drawable> DEPTH_DESCENDING = new Comparator<Drawable>() {
		@Override
		public int compare(Drawable c1, Drawable c2) {
			if (c2.getDepth() == c1.getDepth()) {
				return c2.hashCode() - c1.hashCode();
			} else {
				return c2.getDepth() - c1.getDepth();
			}
		}
	};
}
