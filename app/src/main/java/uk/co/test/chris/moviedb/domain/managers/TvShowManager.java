package uk.co.test.chris.moviedb.domain.managers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.test.chris.moviedb.data.entitys.FullTvEntity;
import uk.co.test.chris.moviedb.data.entitys.MovieEntity;
import uk.co.test.chris.moviedb.data.entitys.MovieListEntity;
import uk.co.test.chris.moviedb.data.entitys.TvEntity;
import uk.co.test.chris.moviedb.data.entitys.TvListEntity;
import uk.co.test.chris.moviedb.data.net.MoviesDbService;
import uk.co.test.chris.moviedb.domain.classes.BasicTvShow;
import uk.co.test.chris.moviedb.domain.classes.DetailedTvShow;
import uk.co.test.chris.moviedb.ui.tvdetail.UtilTvShowErrorString;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;
import uk.co.test.chris.moviedb.util.UtilErrorString;

/**
 * Created by Chris on 09/09/2016.
 */
public class TvShowManager {

	private MoviesDbService mMoviesDbService;
	private List<BasicTvShow> mTvShowList = new ArrayList<>();

	public TvShowManager(MoviesDbService moviesDbService) {
		mMoviesDbService = moviesDbService;
	}

	public void getPopularTvShows(GenericRequestCallback<List<BasicTvShow>> callback) {
		if (!mTvShowList.isEmpty()) {
			callback.onComplete(mTvShowList);
		} else {
			getFreshPopularTvShows(callback);
		}
	}

	public void getFreshPopularTvShows(GenericRequestCallback<List<BasicTvShow>> callback) {
		mMoviesDbService.getPopularTvShows().enqueue(new Callback<TvListEntity>() {
			@Override
			public void onResponse(Call<TvListEntity> call, Response<TvListEntity> response) {
				if (response.isSuccessful()) {

					List<TvEntity> tvEntities = response.body().getResults();

					mTvShowList.clear();
					for (TvEntity tvEntity : tvEntities) {
						mTvShowList.add(new BasicTvShow(tvEntity));
					}

					callback.onComplete(mTvShowList);
				} else {
					callback.onFailure(UtilTvShowErrorString.GENERIC_TV_SHOW_ERROR_STRING_PAIR);
				}
			}

			@Override
			public void onFailure(Call<TvListEntity> call, Throwable t) {
				callback.onFailure(UtilErrorString.getGenericErrorString(t));
			}
		});
	}

	public void getTvShow(Integer tvShowId, GenericRequestCallback<DetailedTvShow> genericRequestCallback) {
		mMoviesDbService.getTvShow(tvShowId).enqueue(new Callback<FullTvEntity>() {
			@Override
			public void onResponse(Call<FullTvEntity> call, Response<FullTvEntity> response) {
				if (response.isSuccessful()) {
					genericRequestCallback.onComplete(new DetailedTvShow(response.body()));
				} else {
					genericRequestCallback.onFailure(UtilTvShowErrorString.ERROR_FETCHING_TV_SHOW_BY_ID);
				}
			}

			@Override
			public void onFailure(Call<FullTvEntity> call, Throwable t) {
				genericRequestCallback.onFailure(UtilErrorString.getGenericErrorString(t));
			}
		});
	}
}
