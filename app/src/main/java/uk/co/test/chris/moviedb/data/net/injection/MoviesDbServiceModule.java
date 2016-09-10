package uk.co.test.chris.moviedb.data.net.injection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.test.chris.moviedb.BuildConfig;
import uk.co.test.chris.moviedb.data.net.MoviesDbService;
import uk.co.test.chris.moviedb.data.net.interceptors.ApiKeyInterceptor;

/**
 * Created by Chris on 09/09/2016.
 */

@Module
public class MoviesDbServiceModule {

	@Provides
	@Singleton
	static OkHttpClient provideOkHttpClient() {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
				: HttpLoggingInterceptor.Level.NONE);

		return new OkHttpClient.Builder()
				.addNetworkInterceptor(logging)
				.addInterceptor(new ApiKeyInterceptor())
				.build();
	}

	@Provides
	@Singleton
	static Retrofit provideRetrofit(OkHttpClient okHttpClient) {

		Gson gson = new GsonBuilder().create();

		return new Retrofit.Builder()
				.baseUrl(MoviesDbService.ENDPOINT)
				.client(okHttpClient)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();
	}

	@Provides
	@Singleton
	static MoviesDbService provideService(Retrofit retrofit) {
		return MoviesDbService.Factory.makeMovieDbService(retrofit);
	}
}
