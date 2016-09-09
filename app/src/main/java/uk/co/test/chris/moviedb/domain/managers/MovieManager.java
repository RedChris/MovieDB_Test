package uk.co.test.chris.moviedb.domain.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
		// check memory
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
}
