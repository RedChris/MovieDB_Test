package uk.co.test.chris.moviedb.ui.moviedetail;

import android.support.v4.util.Pair;

import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public class UtilMovieErrorString {

	public static final Pair<StringResHolder, StringResHolder> GENERIC_MOVIE_ERROR_STRING_PAIR = new Pair<>(
			new StringResHolder(R.string.generic_movie_error_title),
			new StringResHolder(R.string.generic_movie_error_message));

	public static final Pair<StringResHolder, StringResHolder> ERROR_FETCHING_MOVIE_BY_ID = new Pair<>(
			new StringResHolder(R.string.movie_error_fetching_by_id_title),
			new StringResHolder(R.string.movie_error_fetching_by_id_message));
}
