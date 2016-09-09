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
import uk.co.test.chris.moviedb.util.GenericRequestCallback;

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
					callback.onFailure();
				}
			}

			@Override
			public void onFailure(Call<MovieListEntity> call, Throwable t) {
				callback.onFailure();
			}
		});
	}

	public void getMovie(Integer movieId, GenericRequestCallback<Void> genericRequestCallback) {
		mMoviesDbService.getMovie(movieId).enqueue(new Callback<FullMovieEntity>() {
			@Override
			public void onResponse(Call<FullMovieEntity> call, Response<FullMovieEntity> response) {
				if (response.isSuccessful()) {
					genericRequestCallback.onComplete(null);
				} else {
					genericRequestCallback.onFailure();
				}
			}

			@Override
			public void onFailure(Call<FullMovieEntity> call, Throwable t) {
				genericRequestCallback.onFailure();
			}
		});
	}
}
