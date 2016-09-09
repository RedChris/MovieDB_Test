package uk.co.test.chris.moviedb.util;

import android.content.res.Resources;

import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class Util {

	public static int dpToPx(int dp) {
		return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
	}

	public static int pxToDp(int px) {
		return (int) (px / Resources.getSystem().getDisplayMetrics().density);
	}

	public static String getCommaSeparatedString(List<String> strings) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < strings.size(); i++) {
			stringBuilder.append(strings.get(i));

			if (i + 1 != strings.size()) {
				stringBuilder.append(", ");
			}
		}
		return stringBuilder.toString();
	}

	public static String getLineSeparatedString(List<String> strings) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < strings.size(); i++) {
			stringBuilder.append(strings.get(i));

			if (i + 1 != strings.size()) {
				stringBuilder.append(",\n");
			}
		}
		return stringBuilder.toString();
	}
}
