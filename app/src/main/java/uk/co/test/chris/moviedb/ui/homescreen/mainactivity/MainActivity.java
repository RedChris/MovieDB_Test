package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.domain.classes.BasicMovie;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseActivity;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.MovieTabFragment;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.model.PhotoListItemModel;
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
		mTabsLayout.setupWithViewPager(mViewPager);
	}

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new MainActivityComponent.MainActivityModule(this)).inject(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setUpdatedMovieList(List<PhotoListItemModel> movieList) {
		mCategoryPagerAdapter.updateMovieList(movieList);
	}

	@Override
	public void showLoadingState() {
		if(mProgressDialog ==  null) {
			mProgressDialog = UtilDialog.createProgressDialog(this,"", "");
		}
		mProgressDialog.show();
	}

	@Override
	public void hideLoadingState() {
		if (mProgressDialog != null) {
			mProgressDialog.hide();
		}
	}

	public class CategoryPagerAdapter extends FragmentPagerAdapter {

		private MovieTabFragment mMovieTabFragment;
		private MovieTabFragment mTvTabFragment;
		private MovieTabFragment mPersonTabFragment;

		public CategoryPagerAdapter(FragmentManager fm) {
			super(fm);
			mMovieTabFragment = MovieTabFragment.newInstance();
			mTvTabFragment = MovieTabFragment.newInstance();
			mPersonTabFragment = MovieTabFragment.newInstance();
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class below).

			if (position == 0) {
				return mMovieTabFragment;
			} else if (position == 1) {
				return mTvTabFragment;
			} else if (position == 2) {
				 return mPersonTabFragment;
			} else  {
				// error
				return null;
			}
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
				case 0:
					return "SECTION 1";
				case 1:
					return "SECTION 2";
				case 2:
					return "SECTION 3";
			}
			return null;
		}

		public void updateMovieList(List<PhotoListItemModel> movieList) {
			mMovieTabFragment.updateMovies(movieList);
		}

		public void updateTvList(List<PhotoListItemModel> movieList) {
			mTvTabFragment.updateMovies(movieList);
		}

		public void updatePersonList(List<PhotoListItemModel> movieList) {
			mPersonTabFragment.updateMovies(movieList);
		}
	}
}
