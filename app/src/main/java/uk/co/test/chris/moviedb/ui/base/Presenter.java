package uk.co.test.chris.moviedb.ui.base;

/**
 * Created by Chris on 11/08/2016.
 */

public interface Presenter<V extends MvpView> {

	void onViewReady();

	void onDestroy();
}