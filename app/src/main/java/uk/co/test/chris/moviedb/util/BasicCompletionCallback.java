package uk.co.test.chris.moviedb.util;

import android.support.v4.util.Pair;

/**
 * Created by Chris on 09/09/2016.
 */
public interface BasicCompletionCallback {

	void onComplete();

	void onFailure(Pair<StringResHolder, StringResHolder> errorPair);
}
