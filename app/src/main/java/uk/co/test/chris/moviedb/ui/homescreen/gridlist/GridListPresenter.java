package uk.co.test.chris.moviedb.ui.homescreen.gridlist;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;

/**
 * Created by Chris on 09/09/2016.
 */
public class GridListPresenter extends BasePresenter<GridListView> {

	private ConfigurationManager mConfigurationManager;

	@Inject
	public GridListPresenter(GridListView mvpView, ConfigurationManager configurationManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
	}

	public void dosumin() {
		mConfigurationManager.isConfigSetup();
	}
}
