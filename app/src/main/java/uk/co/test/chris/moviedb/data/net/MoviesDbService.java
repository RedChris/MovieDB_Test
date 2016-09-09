package uk.co.test.chris.moviedb.data.net;

import retrofit2.Retrofit;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MoviesDbService {

	String ENDPOINT = "";

	/******** Factory class that sets up a new MoviesDB service *******/
	class Factory {

		public static MoviesDbService makeAsosService(Retrofit retrofit) {
			return retrofit.create(MoviesDbService.class);
		}

	}
}
