package uk.co.test.chris.moviedb.injection;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.test.chris.moviedb.data.net.MoviesDbService;
import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.MovieManager;
import uk.co.test.chris.moviedb.domain.managers.PersonManager;
import uk.co.test.chris.moviedb.domain.managers.TvShowManager;

/**
 * Created by Chris on 09/09/2016.
 */

@Module
public class ApplicationModule {

	protected final Application mApplication;


	public ApplicationModule(Application application) {
		mApplication = application;
	}


	@Provides
	Application provideApplication() {
		return mApplication;
	}

	@Provides
	@Singleton
	static ConfigurationManager provideConfigurationManager(MoviesDbService moviesDbService) {
		return new ConfigurationManager(moviesDbService);
	}

	@Provides
	@Singleton
	static MovieManager provideMovieManager(MoviesDbService moviesDbService) {
		return new MovieManager(moviesDbService);
	}

	@Provides
	@Singleton
	static TvShowManager provideTvShowManager(MoviesDbService moviesDbService) {
		return new TvShowManager(moviesDbService);
	}

	@Provides
	@Singleton
	static PersonManager providePersonManager(MoviesDbService moviesDbService) {
		return new PersonManager(moviesDbService);
	}
}
