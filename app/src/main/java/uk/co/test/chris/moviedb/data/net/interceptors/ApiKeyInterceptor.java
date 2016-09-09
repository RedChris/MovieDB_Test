package uk.co.test.chris.moviedb.data.net.interceptors;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import uk.co.test.chris.moviedb.BuildConfig;

/**
 * Created by Chris on 09/09/2016.
 */

public class ApiKeyInterceptor implements Interceptor {
	@Override
	public Response intercept(Chain chain) throws IOException {
		Request original = chain.request();
		HttpUrl originalHttpUrl = original.url();

		HttpUrl url = originalHttpUrl.newBuilder()
				.addQueryParameter("api_key", BuildConfig.MOVIE_DB_API_KEY)
				.build();

		Request.Builder requestBuilder = original.newBuilder().url(url);
		Request request = requestBuilder.build();

		return chain.proceed(request);
	}
}
