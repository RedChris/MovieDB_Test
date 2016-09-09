package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.classes.BasicMovie;
import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.MovieManager;
import uk.co.test.chris.moviedb.domain.managers.PersonManager;
import uk.co.test.chris.moviedb.domain.managers.TvShowManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.model.PhotoListItemModel;
import uk.co.test.chris.moviedb.util.BasicCompletionCallback;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;

/**
 * Created by Chris on 09/09/2016.
 */
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

	private ConfigurationManager mConfigurationManager;
	private MovieManager mMovieManager;
	private TvShowManager mTvShowManager;
	private PersonManager mPersonManager;

	private List<PhotoListItemModel> mMovieList = new ArrayList<>();

	@Inject
	public MainActivityPresenter(MainActivityView mvpView,
								 ConfigurationManager configurationManager,
								 MovieManager movieManager,
								 TvShowManager tvShowManager,
								 PersonManager personManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
		mMovieManager = movieManager;
		mTvShowManager = tvShowManager;
		mPersonManager = personManager;
	}

	@Override
	public void onViewReady() {
		super.onViewReady();
		getView().showLoadingState();
		if (mConfigurationManager.isConfigSetup()) {
			loadData();
		} else {
			mConfigurationManager.initConfigData(new BasicCompletionCallback() {
				@Override
				public void onComplete() {
					loadData();
				}

				@Override
				public void onFailure() {
					getView().hideLoadingState();
					// show error and retry
				}
			});
		}
	}

	private void loadData() {
		final Handler handler = new Handler();
		Runnable requestRunnable = () -> {
			startDataRequests();
			handler.post(() -> getView().hideLoadingState());
		};
		new Thread(requestRunnable).start();
	}

	private void startDataRequests() {

		CountDownLatch countDownLatch = new CountDownLatch(3);

		mMovieManager.getPopularMovies(new GenericRequestCallback<List<BasicMovie>>() {
			@Override
			public void onComplete(List<BasicMovie> movieList) {
				mMovieList.clear();
				for (BasicMovie movie : movieList) {
					PhotoListItemModel model = new PhotoListItemModel(movie.getId(),
							movie.getTitle(),
							mConfigurationManager.buildStandardImageUrlForPoster(movie.getPosterPath()));
					mMovieList.add(model);
				}
				getView().setUpdatedMovieList(mMovieList);

				countDownLatch.countDown();

			}

			@Override
			public void onFailure() {
				countDownLatch.countDown();

			}
		});

		mMovieManager.getPopularMovies(new GenericRequestCallback<List<BasicMovie>>() {
			@Override
			public void onComplete(List<BasicMovie> movieList) {
				mMovieList.clear();
				for (BasicMovie movie : movieList) {
					PhotoListItemModel model = new PhotoListItemModel(movie.getId(),
							movie.getTitle(),
							mConfigurationManager.buildStandardImageUrlForPoster(movie.getPosterPath()));
					mMovieList.add(model);
				}
				getView().setUpdatedMovieList(mMovieList);

				countDownLatch.countDown();
			}

			@Override
			public void onFailure() {
				countDownLatch.countDown();

			}
		});

		mMovieManager.getPopularMovies(new GenericRequestCallback<List<BasicMovie>>() {
			@Override
			public void onComplete(List<BasicMovie> movieList) {
				mMovieList.clear();
				for (BasicMovie movie : movieList) {
					PhotoListItemModel model = new PhotoListItemModel(movie.getId(),
							movie.getTitle(),
							mConfigurationManager.buildStandardImageUrlForPoster(movie.getPosterPath()));
					mMovieList.add(model);
				}
				getView().setUpdatedMovieList(mMovieList);

				countDownLatch.countDown();
			}

			@Override
			public void onFailure() {
				countDownLatch.countDown();

			}
		});

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//mTvShowManager.getPopularTvShows();
		//mPersonManager.getPopularPeople();
	}
}
