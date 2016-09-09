package uk.co.test.chris.moviedb.ui.moviedetail;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.MovieManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieDetailPresenter extends BasePresenter<MovieDetailView> {

	private ConfigurationManager mConfigurationManager;
	private MovieManager mMovieManager;

	@Inject
	public MovieDetailPresenter(MovieDetailView mvpView, ConfigurationManager configurationManager, MovieManager movieManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
		mMovieManager = movieManager;
	}

	public void userWantsToViewMovie(Integer movieId) {
		getView().showLoadingView();
		mMovieManager.getMovie(movieId, new GenericRequestCallback<Void>() {
			@Override
			public void onComplete(Void object) {
				getView().hideLoadingView();
				setupUiWithMovie(object);
			}

			@Override
			public void onFailure() {
				getView().hideLoadingView();
				//show error
			}
		});
	}

	private void setupUiWithMovie(Void object) {

	}
}
