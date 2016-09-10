package uk.co.test.chris.moviedb.util;

import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chris on 10/09/2016.
 */
public class UtilDate {

	public static DateFormat serverDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static DateFormat displayDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Nullable
	public static String convertServerDateToDisplayDate(String serverDate) {
		Date date = null;
		try {
			date = serverDateFormat.parse(serverDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return displayDateFormat.format(date);
	}
}
