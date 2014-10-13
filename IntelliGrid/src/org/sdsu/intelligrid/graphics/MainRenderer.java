package org.sdsu.intelligrid.graphics;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.sdsu.intelligrid.Global;

import static android.opengl.GLES20.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;

public class MainRenderer implements GLSurfaceView.Renderer {

	private static final Map<String, Integer> textureTable = new HashMap<>();

	// Later: multi-thread this for batch processing
	public static boolean loadTextures(List<String> textures) {
		IntBuffer buffer = IntBuffer.allocate(textures.size());
		glGenTextures(textures.size(), buffer);

		for (String textureID : textures) {
			int texture = buffer.get();
			Bitmap texMap = BitmapFactory.decodeFile(textureID);
			int width = Math.max(texMap.getWidth(), 64);
			int height = Math.max(texMap.getHeight(), 64);
			ByteBuffer texBuffer = ByteBuffer.allocateDirect(Math.max(
					texMap.getByteCount(), width * height * 4));
			texMap.copyPixelsToBuffer(texBuffer);

			glBindTexture(GL_TEXTURE_2D, texture);
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA,
					GL_UNSIGNED_BYTE, texBuffer);
			glGenerateMipmap(GL_TEXTURE_2D);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER,
					GL_LINEAR_MIPMAP_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

			textureTable.put(textureID, texture);
		}
		return true;
	}

	public static int getTexture(String textureID) {
		return textureTable.get(textureID);
	}

	@Override
	public void onSurfaceCreated(GL10 unused, EGLConfig config) {
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	}

	private long lastms;

	private static final int FRAME_RATE = 63; // maximum frames per second, set
												// slightly higher than 60
												// because we're rebels

	@Override
	public void onDrawFrame(GL10 unused) {
		long beginms, endms, leftms;

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

	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {
		glViewport(0, 0, width, height);
	}

	private void draw(float amount) {
		// Test
		// Should flash blue and then white for slower frames
		glClearColor(Math.min(amount, 1f), Math.min(amount * 2f, 1f),
				Math.min(amount * 3f, 1f), 1.0f);
		glClear(GL_COLOR_BUFFER_BIT);
	}
}
