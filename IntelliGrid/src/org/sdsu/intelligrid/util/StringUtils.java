package org.sdsu.intelligrid.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.Resources;

public class StringUtils {

	/**
	 * Reads data from a text file defined in resources to a {@link String}.
	 * 
	 * @param resources
	 *            the resources database to use
	 * @param resourceId
	 *            the file identifier to convert to a {@link String}
	 * @return a {@link String} containing the read data, or <tt>null</tt> if an
	 *         error was encountered
	 */
	public static String rawResourceToString(Resources resources, int resourceId) {
		final InputStream inputStream = resources.openRawResource(resourceId);
		final InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream);
		final BufferedReader bufferedReader = new BufferedReader(
				inputStreamReader);

		String nextLine;
		final StringBuilder body = new StringBuilder();

		try {
			while ((nextLine = bufferedReader.readLine()) != null) {
				body.append(nextLine);
				body.append('\n');
			}
		} catch (IOException e) {
			return null;
		}

		return body.toString();
	}
}
