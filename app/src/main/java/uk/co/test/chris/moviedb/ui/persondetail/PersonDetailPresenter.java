package uk.co.test.chris.moviedb.ui.persondetail;

import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.TvShowManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;

/**
 * Created by Chris on 09/09/2016.
 */
public class PersonDetailPresenter extends BasePresenter<PersonDetailView> {

	private final ConfigurationManager mConfigurationManager;
	private final TvShowManager mTvShowManager;

	public PersonDetailPresenter(PersonDetailView mvpView, ConfigurationManager configurationManager, TvShowManager tvShowManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
		mTvShowManager = tvShowManager;
	}
}
