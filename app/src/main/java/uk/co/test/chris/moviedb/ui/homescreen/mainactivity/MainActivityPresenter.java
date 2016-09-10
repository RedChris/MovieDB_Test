package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import android.os.Handler;
import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.classes.BasicMovie;
import uk.co.test.chris.moviedb.domain.classes.BasicPerson;
import uk.co.test.chris.moviedb.domain.classes.BasicTvShow;
import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.MovieManager;
import uk.co.test.chris.moviedb.domain.managers.PersonManager;
import uk.co.test.chris.moviedb.domain.managers.TvShowManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.model.PhotoListItemModel;
import uk.co.test.chris.moviedb.ui.moviedetail.MovieDetailActivity;
import uk.co.test.chris.moviedb.ui.persondetail.PersonDetailActivity;
import uk.co.test.chris.moviedb.ui.tvdetail.TvDetailActivity;
import uk.co.test.chris.moviedb.util.BasicCompletionCallback;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;
import uk.co.test.chris.moviedb.util.NavigationAction;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public class MainActivityPresenter extends BasePresenter<MainActivityView> {

	private ConfigurationManager mConfigurationManager;
	private MovieManager mMovieManager;
	private TvShowManager mTvShowManager;
	private PersonManager mPersonManager;

	private List<PhotoListItemModel> mMovieList = new ArrayList<>();
	private List<PhotoListItemModel> mTvShowList = new ArrayList<>();
	private List<PhotoListItemModel> mPersonList = new ArrayList<>();

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
		startLoadingData();
	}

	private void startLoadingData() {
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
				public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
					getView().hideLoadingState();
					getView().displayError(errorPair.first, errorPair.second);
				}
			});
		}
	}

	private void loadData() {
		final Handler handler = new Handler();
		Runnable requestRunnable = () -> {
			Pair<StringResHolder, StringResHolder> error = startDataRequests();
			handler.post(() -> {
				setListData();
				MainActivityPresenter.this.getView().hideLoadingState();
				if (error != null) {
					getView().displayError(error.first, error.second);
				}

			});
		};
		new Thread(requestRunnable).start();
	}

	private void setListData() {
		getView().setUpdatedMovieList(mMovieList);
		getView().setUpdatedTvShowList(mTvShowList);
		getView().setUpdatedPersonList(mPersonList);
	}

	private Pair<StringResHolder, StringResHolder> startDataRequests() {

		CountDownLatch countDownLatch = new CountDownLatch(3);
		AtomicReference<Pair<StringResHolder, StringResHolder>> displayError = new AtomicReference<>(null);

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

				countDownLatch.countDown();

			}

			@Override
			public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
				if (displayError.get() != null) {
					displayError.set(errorPair);
				}
				countDownLatch.countDown();
			}

		});

		mTvShowManager.getPopularTvShows(new GenericRequestCallback<List<BasicTvShow>>() {
			@Override
			public void onComplete(List<BasicTvShow> tvShowList) {
				mTvShowList.clear();
				for (BasicTvShow tvShow : tvShowList) {
					PhotoListItemModel model = new PhotoListItemModel(tvShow.getId(),
							tvShow.getName(),
							mConfigurationManager.buildStandardImageUrlForPoster(tvShow.getPosterPath()));
					mTvShowList.add(model);
				}

				countDownLatch.countDown();
			}

			@Override
			public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
				if (displayError.get() != null) {
					displayError.set(errorPair);
				}
				countDownLatch.countDown();
			}
		});

		mPersonManager.getPopularPeople(new GenericRequestCallback<List<BasicPerson>>() {
			@Override
			public void onComplete(List<BasicPerson> movieList) {
				mPersonList.clear();
				for (BasicPerson person : movieList) {
					PhotoListItemModel model = new PhotoListItemModel(person.getId(),
							person.getName(),
							mConfigurationManager.buildStandardImageUrlForPoster(person.getProfilePath()));
					mPersonList.add(model);
				}

				countDownLatch.countDown();
			}

			@Override
			public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
				if (displayError.get() != null) {
					displayError.set(errorPair);
				}
				countDownLatch.countDown();
			}
		});

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return displayError.get();
	}

	public void userWantsToViewMovieDetail(Integer movieId) {
		getView().moveToPage(
				NavigationAction.navigateTo(MovieDetailActivity.class).withInt(BasicMovie.KEY_BASIC_MOVIE_ID, movieId));
	}

	public void userWantsToViewTvDetail(Integer tvShowId) {
		getView().moveToPage(
				NavigationAction.navigateTo(TvDetailActivity.class).withInt(BasicTvShow.KEY_BASIC_TV_SHOW_ID, tvShowId));

	}

	public void userWantsToViewPersonDetail(Integer personId) {
		getView().moveToPage(
				NavigationAction.navigateTo(PersonDetailActivity.class).withInt(BasicPerson.KEY_BASIC_PERSON_ID, personId));
	}

	public void userWantsToRetryLoadingData() {
		startLoadingData();
	}
}
