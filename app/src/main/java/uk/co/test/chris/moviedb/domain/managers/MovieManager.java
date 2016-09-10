package uk.co.test.chris.moviedb.domain.managers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import uk.co.test.chris.moviedb.data.entitys.FullMovieEntity;
import uk.co.test.chris.moviedb.data.entitys.MovieEntity;
import uk.co.test.chris.moviedb.data.entitys.MovieListEntity;
import uk.co.test.chris.moviedb.data.net.MoviesDbService;
import uk.co.test.chris.moviedb.domain.classes.BasicMovie;
import uk.co.test.chris.moviedb.domain.classes.DetailedMovie;
import uk.co.test.chris.moviedb.ui.moviedetail.UtilMovieErrorString;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;
import uk.co.test.chris.moviedb.util.UtilErrorString;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieManager {

	private MoviesDbService mMoviesDbService;
	private List<BasicMovie> mMovieList = new ArrayList<>();

	public MovieManager(MoviesDbService moviesDbService) {
		mMoviesDbService = moviesDbService;
	}

	public void getPopularMovies(GenericRequestCallback<List<BasicMovie>> callback) {
		if (!mMovieList.isEmpty()) {
			callback.onComplete(mMovieList);
		} else {
			getFreshPopularMovies(callback);
		}
	}

	public void getFreshPopularMovies(GenericRequestCallback<List<BasicMovie>> callback) {
		mMoviesDbService.getPopularMovies().enqueue(new Callback<MovieListEntity>() {
			@Override
			public void onResponse(Call<MovieListEntity> call, Response<MovieListEntity> response) {
				if (response.isSuccessful()) {

					List<MovieEntity> movieEntities = response.body().getResults();

					mMovieList.clear();
					for (MovieEntity movieEntity : movieEntities) {
						mMovieList.add(new BasicMovie(movieEntity));
					}

					callback.onComplete(mMovieList);
				} else {
					callback.onFailure(UtilMovieErrorString.GENERIC_MOVIE_ERROR_STRING_PAIR);
				}
			}

			@Override
			public void onFailure(Call<MovieListEntity> call, Throwable t) {
				callback.onFailure(UtilErrorString.getGenericErrorString(t));
			}
		});
	}

	public void getMovie(Integer movieId, GenericRequestCallback<DetailedMovie> genericRequestCallback) {
		mMoviesDbService.getMovie(movieId).enqueue(new Callback<FullMovieEntity>() {
			@Override
			public void onResponse(Call<FullMovieEntity> call, Response<FullMovieEntity> response) {
				if (response.isSuccessful()) {
					genericRequestCallback.onComplete(new DetailedMovie(response.body()));
				} else {
					genericRequestCallback.onFailure(UtilMovieErrorString.ERROR_FETCHING_MOVIE_BY_ID);
				}
			}

			@Override
			public void onFailure(Call<FullMovieEntity> call, Throwable t) {
				genericRequestCallback.onFailure(UtilErrorString.getGenericErrorString(t));
			}
		});
	}
}
