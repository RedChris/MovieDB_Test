package uk.co.test.chris.moviedb.ui.moviedetail;

import uk.co.test.chris.moviedb.ui.base.MvpView;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MovieDetailView extends MvpView {
	void showLoadingView();

	void hideLoadingView();
}
