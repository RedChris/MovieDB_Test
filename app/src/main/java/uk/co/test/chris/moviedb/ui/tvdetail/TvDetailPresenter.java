package uk.co.test.chris.moviedb.ui.tvdetail;

import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.TvShowManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;

/**
 * Created by Chris on 09/09/2016.
 */
public class TvDetailPresenter extends BasePresenter<TvDetailView> {

	private ConfigurationManager mConfigurationManager;
	private TvShowManager mTvShowManager;

	public TvDetailPresenter(TvDetailView mvpView, ConfigurationManager configurationManager, TvShowManager tvShowManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
		mTvShowManager = tvShowManager;
	}
}
