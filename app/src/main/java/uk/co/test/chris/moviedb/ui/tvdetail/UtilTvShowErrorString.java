package uk.co.test.chris.moviedb.ui.tvdetail;

import android.support.v4.util.Pair;

import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 10/09/2016.
 */
public class UtilTvShowErrorString {

	public static final Pair<StringResHolder, StringResHolder> GENERIC_TV_SHOW_ERROR_STRING_PAIR = new Pair<>(
			new StringResHolder(R.string.generic_tv_show_error_title),
			new StringResHolder(R.string.generic_tv_show_error_message));

	public static final Pair<StringResHolder, StringResHolder> ERROR_FETCHING_TV_SHOW_BY_ID = new Pair<>(
			new StringResHolder(R.string.tv_show_error_fetching_by_id_title),
			new StringResHolder(R.string.tv_show_error_fetching_by_id_message));
}
