package uk.co.test.chris.moviedb.util;

import android.support.v4.util.Pair;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import uk.co.test.chris.moviedb.R;


/**
 * Created by Chris on 03/08/2016.
 */
public class UtilErrorString {

	public static final Pair<StringResHolder, StringResHolder> GENERIC_NETWORK_ERROR_STRING_PAIR = new Pair<>(
			new StringResHolder(R.string.generic_network_error_title),
			new StringResHolder(R.string.generic_network_error_message));

	public static final Pair<StringResHolder, StringResHolder> GENERIC_ERROR_STRING_PAIR = new Pair<>(
			new StringResHolder(R.string.generic_error_title),
			new StringResHolder(R.string.generic_error_message));

	public static Pair<StringResHolder, StringResHolder> getGenericErrorString(Throwable throwable) {
		//No Internet / Network error
		if (throwable instanceof UnknownHostException || throwable instanceof SocketTimeoutException || throwable instanceof IOException) {
			return GENERIC_NETWORK_ERROR_STRING_PAIR;
		} else {
			return GENERIC_ERROR_STRING_PAIR;
		}
	}
}
