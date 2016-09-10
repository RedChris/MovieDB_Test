package uk.co.test.chris.moviedb.ui.persondetail;

import android.support.v4.util.Pair;

import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 10/09/2016.
 */
public class UtilPersonErrorString {

	public static final Pair<StringResHolder, StringResHolder> GENERIC_PERSON_ERROR_STRING_PAIR = new Pair<>(
			new StringResHolder(R.string.generic_person_error_title),
			new StringResHolder(R.string.generic_person_error_message));

	public static final Pair<StringResHolder, StringResHolder> ERROR_FETCHING_PERSON_BY_ID = new Pair<>(
			new StringResHolder(R.string.person_error_fetching_by_id_title),
			new StringResHolder(R.string.person_error_fetching_by_id_message));
}