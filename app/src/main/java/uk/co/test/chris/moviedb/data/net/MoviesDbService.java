package uk.co.test.chris.moviedb.data.net;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import uk.co.test.chris.moviedb.data.entitys.ConfigurationEntity;
import uk.co.test.chris.moviedb.data.entitys.FullMovieEntity;
import uk.co.test.chris.moviedb.data.entitys.FullPersonEntity;
import uk.co.test.chris.moviedb.data.entitys.FullTvEntity;
import uk.co.test.chris.moviedb.data.entitys.MovieListEntity;
import uk.co.test.chris.moviedb.data.entitys.PersonListEntity;
import uk.co.test.chris.moviedb.data.entitys.TvListEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MoviesDbService {

	String ENDPOINT = "http://api.themoviedb.org/3/";

	@GET("configuration")
	Call<ConfigurationEntity> getConfiguration();

	@GET("movie/popular")
	Call<MovieListEntity> getPopularMovies();

	@GET("movie/{id}")
	Call<FullMovieEntity> getMovie(@Path("id") Integer movieId);

	@GET("tv/popular")
	Call<TvListEntity> getPopularTvShows();

	@GET("tv/{id}")
	Call<FullTvEntity> getTvShow(@Path("id") Integer tvShowId);

	@GET("person/popular")
	Call<PersonListEntity> getPopularPeople();

	@GET("person/{id}")
	Call<FullPersonEntity> getPerson(@Path("id") Integer personId);

	/******** Factory class that sets up a new MoviesDB service *******/
	class Factory {

		public static MoviesDbService makeMovieDbService(Retrofit retrofit) {
			return retrofit.create(MoviesDbService.class);
		}
	}
}
