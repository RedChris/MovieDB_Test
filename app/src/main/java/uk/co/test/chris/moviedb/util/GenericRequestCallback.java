package uk.co.test.chris.moviedb.util;

/**
 * Created by Chris on 09/09/2016.
 */
public interface GenericRequestCallback<T> {

	void onComplete(T object);

	void onFailure();
}
