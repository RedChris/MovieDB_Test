package uk.co.test.chris.moviedb.ui.tvdetail;

import android.support.v4.util.Pair;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.classes.DetailedTvShow;
import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.TvShowManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public class TvDetailPresenter extends BasePresenter<TvDetailView> {

	private ConfigurationManager mConfigurationManager;
	private TvShowManager mTvShowManager;

	@Inject
	public TvDetailPresenter(TvDetailView mvpView, ConfigurationManager configurationManager, TvShowManager tvShowManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
		mTvShowManager = tvShowManager;
	}

	public void userWantsToViewTvShow(Integer tvShowId) {
		getView().showLoadingState();
		getView().hideContent();
		mTvShowManager.getTvShow(tvShowId, new GenericRequestCallback<DetailedTvShow>() {
			@Override
			public void onComplete(DetailedTvShow tvShow) {
				getView().hideLoadingState();
				getView().showContent();
				setupUiWithTvShow(tvShow);
			}

			@Override
			public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
				getView().hideLoadingState();
				getView().displayError(errorPair.first, errorPair.second);
			}
		});
	}

	private void setupUiWithTvShow(DetailedTvShow tvShow) {
		getView().setName(tvShow.getName());
		getView().setOverview(tvShow.getOverview());
		getView().setBackdrop(mConfigurationManager.buildStandardImageUrlForBackdrop(tvShow.getBackdropPath()));
		getView().setStatus(tvShow.getStatus());
		getView().setPoster(mConfigurationManager.buildStandardImageUrlForPoster(tvShow.getPosterPath()));
		getView().setNumberOfSeasons(tvShow.getNumberOfSeasons());
		getView().setNumberOfEpisodes(tvShow.getNumberOfEpisodes());
		getView().setFirstAirDate(tvShow.getFirstAirDate());
		getView().setRuntime(tvShow.getEpisodeRunTime());
		getView().setGenre(tvShow.getGenres());
		getView().setOriginCountry(tvShow.getOriginCountry());
		getView().setProductionCompany(tvShow.getProductionCompanies());
		getView().setCreatedBy(tvShow.getCreatedBy());
		getView().setLanguages(tvShow.getLanguages());
	}
}
