package uk.co.test.chris.moviedb.data.net;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import uk.co.test.chris.moviedb.data.entitys.ConfigurationEntity;
import uk.co.test.chris.moviedb.data.entitys.MovieListEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MoviesDbService {

	String ENDPOINT = "http://api.themoviedb.org/3/";

	@GET("configuration")
	Call<ConfigurationEntity> getConfiguration();

	@GET("movie/popular")
	Call<MovieListEntity> getPopularMovies();

	@GET("tv/popular")
	Call<MovieListEntity> getPopularTvShows();

	/******** Factory class that sets up a new MoviesDB service *******/
	class Factory {

		public static MoviesDbService makeMovieDbService(Retrofit retrofit) {
			return retrofit.create(MoviesDbService.class);
		}

	}
}
