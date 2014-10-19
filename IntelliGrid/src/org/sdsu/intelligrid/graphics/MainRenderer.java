package org.sdsu.intelligrid.graphics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.util.StringUtils;

import static android.opengl.GLES20.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;

public class MainRenderer implements GLSurfaceView.Renderer {

	private final Map<Integer, Integer> textureTable = new HashMap<>();
	private final List<Integer> toLoad = Collections
			.synchronizedList(new ArrayList<Integer>());

	/**
	 * Loads every resource in the given list as mapped OpenGL textures. After
	 * calling this function, each resource specified will be available for
	 * rendering. Do not load the same resource multiple times, as it will waste
	 * memory.
	 * <p>
	 * Use {@link #getTexture(resource)} to grab the generated OpenGL texture
	 * name for a previously-loaded resource.
	 * <p>
	 * Remember that OpenGL is threaded in this application; the textures will
	 * load at the start of the next frame, so don't count on them being
	 * available right after calling this function!
	 * 
	 * @param resources
	 *            the list of resources to load
	 */
	public void loadTextures(List<Integer> resources) {
		toLoad.addAll(resources);
	}

	/**
	 * Gets the OpenGL texture name associated with <tt>resource</tt>. This
	 * resource must have already been loaded with
	 * {@link #loadTextures(resources)}.
	 * 
	 * @param resource
	 *            the resource to get the texture name for
	 * @return the texture name associated with <tt>resource</tt>
	 */
	public int getTexture(int resource) {
		return textureTable.get(resource);
	}

	private void loadTextures() {
		if (toLoad.isEmpty()) {
			return;
		}

		IntBuffer buffer = IntBuffer.allocate(toLoad.size());
		glGenTextures(toLoad.size(), buffer);

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

			bitmap.recycle();

			textureTable.put(resource, texture);
		}

		toLoad.clear();
	}

	private int spriteShader;
	private int[] spriteShaderParams = new int[5];

	private float[] viewMatrix = new float[16];

	@Override
	public void onSurfaceCreated(GL10 unused, EGLConfig config) {
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

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

		// Load the vertex shader text
		String vert;
		vert = StringUtils.rawResourceToString(Global.getResources(),
				org.sdsu.intelligrid.R.raw.spritevert);

		// Load the fragment shader text
		String frag = new String();
		frag = StringUtils.rawResourceToString(Global.getResources(),
				org.sdsu.intelligrid.R.raw.spritefrag);

		// Load and compile the shader
		spriteShader = loadShader(vert, frag);

		spriteShaderParams[0] = glGetUniformLocation(spriteShader,
				"u_MVPMatrix");
		spriteShaderParams[1] = glGetAttribLocation(spriteShader, "a_Position");
		spriteShaderParams[2] = glGetAttribLocation(spriteShader, "a_Color");
		spriteShaderParams[3] = glGetAttribLocation(spriteShader,
				"a_TexCoordinate");
		spriteShaderParams[4] = glGetUniformLocation(spriteShader, "u_Texture");

		init();
	}

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

		Global.getGlobalSimulation().advance(amount);
		draw(amount);

		lastms = beginms;

		endms = System.currentTimeMillis() - beginms;

		leftms = (1000L / FRAME_RATE) - endms;

		// avoid spinning
		if (leftms < 5) {
			leftms = 5;
		}

		try {
			TimeUnit.MILLISECONDS.sleep(leftms);
		} catch (InterruptedException e) {
		}
	}

	private float[] projectionMatrix = new float[16];

	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {
		glViewport(0, 0, width, height);

		final float ratio = (float) width / height;
		final float left = -ratio;
		final float right = ratio;
		final float bottom = -1.0f;
		final float top = 1.0f;
		final float near = 1.0f;
		final float far = 10.0f;

		Matrix.orthoM(projectionMatrix, 0, left, right, bottom, top, near, far);
	}

	private float[] modelMatrix = new float[16];

	private void draw(float amount) {
		// First load any unloaded textures
		loadTextures();

		// Activate our general sprite drawing shader
		glUseProgram(spriteShader);

		// Clear the screen
		glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);

		glEnable(GL_TEXTURE_2D);

		Matrix.setIdentityM(modelMatrix, 0);
		Matrix.rotateM(modelMatrix, 0, 0.0f, 0.0f, 0.0f, 1.0f);
		drawTriangle(mTriangle1Vertices, mCubeTextureCoordinates);
	}

	private FloatBuffer mTriangle1Vertices;
	private FloatBuffer mCubeTextureCoordinates;

	private static final int BYTES_PER_FLOAT = 4;

	private void init() {
		final float[] triangle1VerticesData = {
				// X, Y, Z, R, G, B, A
				-0.5f, -0.5f, 0.0f, 1.0f, 0.1f, 0.1f, 1.0f,

				-0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 0.1f, 1.0f,

				0.5f, 0.5f, 0.0f, 0.1f, 1.0f, 0.1f, 1.0f,

				0.5f, 0.5f, 0.0f, 0.1f, 1.0f, 0.1f, 1.0f,

				0.5f, -0.5f, 0.0f, 0.1f, 0.1f, 0.1f, 1.0f,

				-0.5f, -0.5f, 0.0f, 1.0f, 0.1f, 0.1f, 1.0f };

		mTriangle1Vertices = ByteBuffer
				.allocateDirect(triangle1VerticesData.length * BYTES_PER_FLOAT)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();

		mTriangle1Vertices.put(triangle1VerticesData).position(0);

		final float[] cubeTextureCoordinateData = {
				// S, T (X, Y)
				// Front face
				0.0f, 1.0f,

				0.0f, 0.0f,

				1.0f, 0.0f,

				1.0f, 0.0f,

				1.0f, 1.0f,

				0.0f, 1.0f };

		mCubeTextureCoordinates = ByteBuffer
				.allocateDirect(
						cubeTextureCoordinateData.length * BYTES_PER_FLOAT)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();

		mCubeTextureCoordinates.put(cubeTextureCoordinateData).position(0);
	}

	private float[] MVPMatrix = new float[16];

	private static final int POSITION_OFFSET = 0;
	private static final int POSITION_DATA_SIZE = 3;
	private static final int COLOR_OFFSET = 3;
	private static final int COLOR_DATA_SIZE = 4;
	private static final int TEXTURE_COORDINATE_OFFSET = 0;
	private static final int TEXTURE_COORDINATE_DATA_SIZE = 2;

	private void drawTriangle(FloatBuffer triangleBuffer, FloatBuffer cubeBuffer) {
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D,
				textureTable.get(org.sdsu.intelligrid.R.drawable.dominator));
		glUniform1i(spriteShaderParams[4], 0);

		triangleBuffer.position(POSITION_OFFSET);
		glVertexAttribPointer(spriteShaderParams[1], POSITION_DATA_SIZE,
				GL_FLOAT, false, 7 * BYTES_PER_FLOAT, triangleBuffer);

		glEnableVertexAttribArray(spriteShaderParams[1]);

		triangleBuffer.position(COLOR_OFFSET);
		glVertexAttribPointer(spriteShaderParams[2], COLOR_DATA_SIZE, GL_FLOAT,
				false, 7 * BYTES_PER_FLOAT, triangleBuffer);

		glEnableVertexAttribArray(spriteShaderParams[2]);

		cubeBuffer.position(TEXTURE_COORDINATE_OFFSET);
		glVertexAttribPointer(spriteShaderParams[3],
				TEXTURE_COORDINATE_DATA_SIZE, GL_FLOAT, false,
				2 * BYTES_PER_FLOAT, cubeBuffer);

		glEnableVertexAttribArray(spriteShaderParams[3]);

		Matrix.multiplyMM(MVPMatrix, 0, viewMatrix, 0, modelMatrix, 0);
		Matrix.multiplyMM(MVPMatrix, 0, projectionMatrix, 0, MVPMatrix, 0);

		glUniformMatrix4fv(spriteShaderParams[0], 1, false, MVPMatrix, 0);
		glDrawArrays(GL_TRIANGLES, 0, 6);
	}

	/**
	 * Compiles the given shader. Does NOT validate the shader.
	 * 
	 * @param vert
	 *            The vertex shader, given as a String.
	 * @param frag
	 *            The fragment shader, given as a String.
	 * 
	 * @return The shader program ID corresponding to the newly-compiled shader.
	 *         Returns 0 on error.
	 */
	public static int loadShader(String vert, String frag) {
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

	private static int createShader(String source, int shaderType)
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
}
