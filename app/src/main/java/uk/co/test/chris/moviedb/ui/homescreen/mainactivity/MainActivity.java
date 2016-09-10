package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseActivity;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.GridListFragment;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.model.PhotoListItemModel;
import uk.co.test.chris.moviedb.util.NavigationAction;
import uk.co.test.chris.moviedb.util.StringResHolder;
import uk.co.test.chris.moviedb.util.UtilDialog;

public class MainActivity extends BaseActivity implements MainActivityView {

	@Inject MainActivityPresenter mMainActivityPresenter;
	@BindView(R.id.toolbar) Toolbar mToolbar;
	@BindView(R.id.tabs) TabLayout mTabsLayout;
	@BindView(R.id.container) ViewPager mViewPager;

	private CategoryPagerAdapter mCategoryPagerAdapter;
	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		initUi();
		mMainActivityPresenter.onViewReady();
	}

	private void initUi() {
		setSupportActionBar(mToolbar);

		mCategoryPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager());

		mViewPager.setAdapter(mCategoryPagerAdapter);
		mViewPager.setOffscreenPageLimit(3);
		mTabsLayout.setupWithViewPager(mViewPager);

	}

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new MainActivityComponent.MainActivityModule(this)).inject(this);
	}

	@Override
	public void setUpdatedMovieList(List<PhotoListItemModel> movieList) {
		mCategoryPagerAdapter.updateMovieList(movieList);
	}

	@Override
	public void setUpdatedTvShowList(List<PhotoListItemModel> tvShowList) {
		mCategoryPagerAdapter.updateTvShowList(tvShowList);
	}

	@Override
	public void setUpdatedPersonList(List<PhotoListItemModel> personList) {
		mCategoryPagerAdapter.updatePeopleList(personList);
	}

	@Override
	public void showLoadingState() {
		if(mProgressDialog ==  null) {
			mProgressDialog = UtilDialog.createProgressDialog(this,getString(R.string.standard_loading), "");
		}
		mProgressDialog.show();
	}

	@Override
	public void hideLoadingState() {
		if (mProgressDialog != null) {
			mProgressDialog.hide();
		}
	}

	@Override
	public void moveToPage(NavigationAction navigationAction) {
		navigationAction.start(this);
	}

	@Override
	public void displayError(StringResHolder title, StringResHolder message) {
		UtilDialog.createMessageDialog(this, title.getString(this), message.getString(this), getString(R.string.standard_retry), (dialogInterface, i) -> mMainActivityPresenter.userWantsToRetryLoadingData()).show();
	}

	public class CategoryPagerAdapter extends FragmentPagerAdapter {

		public static final int TAB_MOVIE = 0;
		public static final int TAB_TV = 1;
		public static final int TAB_PERSON = 2;

		private GridListFragment mMovieListFragment;
		private GridListFragment mTvTabFragment;
		private GridListFragment mPersonTabFragment;

		public CategoryPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return GridListFragment.newInstance();
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Fragment createdFragment = (Fragment) super.instantiateItem(container, position);

			switch (position) {
				case TAB_MOVIE:
					mMovieListFragment = (GridListFragment) createdFragment;
					mMovieListFragment.setOnItemClickedListener(itemId -> mMainActivityPresenter.userWantsToViewMovieDetail(itemId));
					break;
				case TAB_TV:
					mTvTabFragment = (GridListFragment) createdFragment;
					mTvTabFragment.setOnItemClickedListener(itemId -> mMainActivityPresenter.userWantsToViewTvDetail(itemId));
					break;
				case TAB_PERSON:
					mPersonTabFragment = (GridListFragment) createdFragment;
					mPersonTabFragment.setOnItemClickedListener(itemId -> mMainActivityPresenter.userWantsToViewPersonDetail(itemId));
					break;
			}
			return createdFragment;
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case TAB_MOVIE:
					return getString(R.string.main_activity_tab_movies);
				case TAB_TV:
					return getString(R.string.main_activity_tab_tv);
				case TAB_PERSON:
					return getString(R.string.main_activity_tab_people);
			}
			return null;
		}

		public void updateMovieList(List<PhotoListItemModel> movieList) {
			if (mMovieListFragment != null) {
				mMovieListFragment.updateItems(movieList);
			}
		}

		public void updateTvShowList(List<PhotoListItemModel> tvShowList) {
			if (mTvTabFragment != null) {
				mTvTabFragment.updateItems(tvShowList);
			}
		}

		public void updatePeopleList(List<PhotoListItemModel> personList) {
			if (mPersonTabFragment != null) {
				mPersonTabFragment.updateItems(personList);
			}
		}
	}
}
