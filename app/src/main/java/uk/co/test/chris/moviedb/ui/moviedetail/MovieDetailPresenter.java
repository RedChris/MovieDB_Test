package uk.co.test.chris.moviedb.ui.moviedetail;

import android.support.v4.util.Pair;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.classes.DetailedMovie;
import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.MovieManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;
import uk.co.test.chris.moviedb.util.StringResHolder;

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
		getView().showLoadingState();
		getView().hideContent();
		mMovieManager.getMovie(movieId, new GenericRequestCallback<DetailedMovie>() {
			@Override
			public void onComplete(DetailedMovie movie) {
				getView().hideLoadingState();
				getView().showContent();
				setupUiWithMovie(movie);
			}

			@Override
			public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
				getView().hideLoadingState();
				getView().displayError(errorPair.first, errorPair.second);
			}
		});
	}

	private void setupUiWithMovie(DetailedMovie movie) {
		getView().setTitle(movie.getTitle());
		getView().setOverview(movie.getOverview());
		getView().setBackdrop(mConfigurationManager.buildStandardImageUrlForBackdrop(movie.getBackdropPath()));
		getView().setTagline(movie.getTagline());
		getView().setPoster(mConfigurationManager.buildStandardImageUrlForPoster(movie.getPosterPath()));
		getView().setBudget(movie.getBudget());
		getView().setRunTime(movie.getRuntime());
		getView().setRevenue(movie.getRevenue());
		getView().setReleaseData(movie.getReleaseDate());
		getView().setGenre(movie.getGenres());
		getView().setProductionCountry(movie.getProductionCountries());
		getView().setProductionCompany(movie.getProductionCompanies());
	}
}
