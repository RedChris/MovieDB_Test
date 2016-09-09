package uk.co.test.chris.moviedb.domain.managers;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.test.chris.moviedb.data.entitys.ConfigurationEntity;
import uk.co.test.chris.moviedb.data.net.MoviesDbService;
import uk.co.test.chris.moviedb.domain.classes.Configuration;
import uk.co.test.chris.moviedb.util.BasicCompletionCallback;

/**
 * Created by Chris on 09/09/2016.
 */
public class ConfigurationManager {

	private MoviesDbService mMoviesDbService;
	private String mBaseUrl;
	private List<String> mBackdropSizes = new ArrayList<>();
	private List<String> mPosterSizes = new ArrayList<>();
	private List<String> mProfileSizes = new ArrayList<>();
	private boolean mConfigIsSetup = false;

	public ConfigurationManager(MoviesDbService moviesDbService) {
		mMoviesDbService = moviesDbService;
	}

	@WorkerThread
	public void initConfigData(@NonNull BasicCompletionCallback completionInterface) {
		mMoviesDbService.getConfiguration().enqueue(new Callback<ConfigurationEntity>() {
			@Override
			public void onResponse(Call<ConfigurationEntity> call, Response<ConfigurationEntity> response) {
				if (response.isSuccessful()) {
					setConfigData(new Configuration(response.body()));
					completionInterface.onComplete();
				} else {
					completionInterface.onFailure();
				}
			}

			@Override
			public void onFailure(Call<ConfigurationEntity> call, Throwable t) {
				completionInterface.onFailure();
			}
		});
	}

	private void setConfigData(Configuration configuration) {
		mBaseUrl = configuration.getBaseUrl();
		mBackdropSizes = configuration.getBackdropSizes();
		mPosterSizes = configuration.getPosterSizes();
		mProfileSizes = configuration.getProfileSizes();
		mConfigIsSetup = true;
	}

	public boolean isConfigSetup() {
		return mConfigIsSetup;
	}

	public String buildStandardImageUrlForPoster(String resource) {
		return MessageFormat.format("{0}{1}/{2}", mBaseUrl, mPosterSizes.get(0), resource);
	}
}
