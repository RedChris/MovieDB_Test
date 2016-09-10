package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import java.util.List;

import uk.co.test.chris.moviedb.ui.base.MvpView;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.model.PhotoListItemModel;
import uk.co.test.chris.moviedb.util.NavigationAction;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MainActivityView extends MvpView {
	void setUpdatedMovieList(List<PhotoListItemModel> movieList);

	void setUpdatedTvShowList(List<PhotoListItemModel> tvShowList);

	void setUpdatedPersonList(List<PhotoListItemModel> personList);

	void showLoadingState();

	void hideLoadingState();

	void moveToPage(NavigationAction navigationAction);

	void displayError(StringResHolder title, StringResHolder message);
}
