package org.sdsu.intelligrid.graphics;

import static android.opengl.GLES20.*;

import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLUtils;

class TextTextureManager {

	private static final Map<String, Texture> textureMap = new HashMap<>();

	private static int measureHeight(final String text, final int fontSize,
			final Typeface font, final float maxLineWidth) {
		final Paint textPaint = new Paint();
		textPaint.setTextSize(fontSize);
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(font);
		textPaint.setTextAlign(Align.LEFT);
		textPaint.setARGB(0xff, 0xff, 0xff, 0xff);

		Rect rect = new Rect();
		textPaint.getTextBounds(text, 0, text.length(), rect);
		final float lineSpacing = textPaint.getFontSpacing();
		int currentStart = 0;
		float totalHeight = rect.height();
		while (currentStart < text.length()) {
			if (currentStart != 0) {
				totalHeight += lineSpacing;
			}
			final int limit = textPaint.breakText(text.substring(currentStart),
					true, maxLineWidth, null);
			currentStart += limit;
		}
		// Logger.getGlobal().log(Level.SEVERE, "totalheight: " + totalHeight);

		return (int) totalHeight;
	}

	private static int getPowerOfTwo(final int in) {
		int x = 64;
		while (x <= 4096) {
			if (in <= x) {
				return x;
			}
			x *= 2;
		}
		return 4096;
	}

	private static Texture buildTexture(final String text, final int fontSize,
			final Typeface font, final float maxLineWidth) {
		final Paint textPaint = new Paint();
		textPaint.setTextSize(fontSize);
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(font);
		textPaint.setTextAlign(Align.LEFT);
		textPaint.setARGB(0xff, 0xff, 0xff, 0xff);

		final float lineSpacing = textPaint.getFontSpacing();
		int iterations = 0;
		int currentStart = 0;
		Rect fullRect = null;
		while (currentStart < text.length()) {
			iterations++;
			final int limit = textPaint.breakText(text.substring(currentStart),
					true, maxLineWidth, null);
			Rect rect = new Rect();
			textPaint.getTextBounds(
					text.substring(currentStart, currentStart + limit), 0,
					limit, rect);
			if (fullRect == null) {
				fullRect = new Rect(rect);
			} else {
				rect.offset(0, (int) (lineSpacing * (float) iterations));
				fullRect.union(rect);
			}
			currentStart += limit;
		}

		final Bitmap bitmap = Bitmap.createBitmap(
				getPowerOfTwo(fullRect.width()),
				getPowerOfTwo(fullRect.height()), Bitmap.Config.ARGB_8888);
		final Canvas canvas = new Canvas(bitmap);
		bitmap.eraseColor(0);

		iterations = 0;
		currentStart = 0;
		while (currentStart < text.length()) {
			iterations++;
			final int limit = textPaint.breakText(text.substring(currentStart),
					true, maxLineWidth, null);
			canvas.drawText(text.substring(currentStart, currentStart + limit),
					0, (int) (lineSpacing * (float) iterations), textPaint);
			currentStart += limit;
		}

		final IntBuffer buffer = IntBuffer.allocate(1);
		glGenTextures(1, buffer);
		final int texture = buffer.get();
		glBindTexture(GL_TEXTURE_2D, texture);

		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

		GLUtils.texImage2D(GL_TEXTURE_2D, 0, bitmap, 0);

		bitmap.recycle();

		return new Texture(-1, texture, bitmap.getWidth(), bitmap.getHeight());
	}

	static Texture getTexture(final String text, final int fontSize,
			final Typeface font, final float maxLineWidth) {
		final float height = measureHeight(text, fontSize, font, maxLineWidth);
		final String mapString = text + "$" + fontSize + "$" + font.toString()
				+ "$" + (int) height + "$";

		if (!textureMap.containsKey(mapString)) {
			final Texture texture = buildTexture(text, fontSize, font,
					maxLineWidth);
			textureMap.put(mapString, texture);
			return texture;
		} else {
			return textureMap.get(mapString);
		}
	}
}
