package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import java.util.List;

import uk.co.test.chris.moviedb.ui.base.MvpView;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.model.PhotoListItemModel;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MainActivityView extends MvpView {
	void setUpdatedMovieList(List<PhotoListItemModel> movieList);

	void showLoadingState();

	void hideLoadingState();
}
