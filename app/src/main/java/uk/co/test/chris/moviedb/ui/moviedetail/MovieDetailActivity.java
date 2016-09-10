package uk.co.test.chris.moviedb.ui.moviedetail;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.domain.classes.BasicMovie;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseActivity;
import uk.co.test.chris.moviedb.util.StringResHolder;
import uk.co.test.chris.moviedb.util.UtilDialog;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieDetailActivity extends BaseActivity implements MovieDetailView {

	@Inject MovieDetailPresenter mMovieDetailPresenter;

	private ActionBar mActionBar;
	@BindView(R.id.content) FrameLayout mContent;
	@BindView(R.id.backdrop) ImageView mBackdrop;
	@BindView(R.id.poster) ImageView mPoster;
	@BindView(R.id.overview) TextView mOverView;
	@BindView(R.id.tagline) TextView mTagline;
	@BindView(R.id.genre) TextView mGenre;
	@BindView(R.id.runtime) TextView mRuntime;
	@BindView(R.id.release_date) TextView mReleaseDate;
	@BindView(R.id.budget) TextView mBudget;
	@BindView(R.id.revenue) TextView mRevenue;
	@BindView(R.id.countries) TextView mCountries;
	@BindView(R.id.companies) TextView mCompanies;

	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie_detail);
		ButterKnife.bind(this);

		final Integer movieId = getIntent().getIntExtra(BasicMovie.KEY_BASIC_MOVIE_ID, -1);
		if (movieId == -1) {
			AlertDialog noIdDialog = UtilDialog.createMessageDialog(this,
					getString(R.string.movie_error_fetching_by_id_title),
					getString(R.string.movie_error_fetching_by_id_message),
					(dialogInterface, i) -> {
						finish();
					});
			noIdDialog.setCancelable(false);
			noIdDialog.show();
		} else {
			initUi();
			mMovieDetailPresenter.onViewReady();
			mMovieDetailPresenter.userWantsToViewMovie(movieId);
		}
	}

	private void initUi() {
		mActionBar = getSupportActionBar();
	}

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new MovieDetailComponent.MovieDetailActivityModule(this)).inject(this);
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
	public void showContent() {
		mContent.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideContent() {
		mContent.setVisibility(View.INVISIBLE);
	}

	@Override
	public void setTitle(String title) {
		mActionBar.setTitle(title);
	}

	@Override
	public void setBackdrop(String backdropUrl) {
		Picasso.with(this).load(backdropUrl).fit().centerCrop().into(mBackdrop);
	}

	@Override
	public void setTagline(String tagline) {
		mTagline.setText(tagline);
	}

	@Override
	public void setPoster(String posterPath) {
		Picasso.with(this).load(posterPath).resize(150, 200).centerCrop().into(mPoster);
	}

	@Override
	public void setOverview(String overview) {
		mOverView.setText(overview);
	}

	@Override
	public void setBudget(String budget) {
		mBudget.setText(budget);
	}

	@Override
	public void setRunTime(String runtime) {
		mRuntime.setText(runtime);
	}

	@Override
	public void setRevenue(String revenue) {
		mRevenue.setText(revenue);
	}

	@Override
	public void setReleaseData(String releaseDate) {
		mReleaseDate.setText(releaseDate);
	}

	@Override
	public void setGenre(String genres) {
		mGenre.setText(genres);
	}

	@Override
	public void setProductionCountry(String productionCountries) {
		mCountries.setText(productionCountries);
	}

	@Override
	public void setProductionCompany(String productionCompanies) {
		mCompanies.setText(productionCompanies);
	}

	@Override
	public void displayError(StringResHolder title, StringResHolder message) {
		AlertDialog errorDialog = UtilDialog.createMessageDialog(this,
				getString(R.string.movie_error_fetching_by_id_title),
				getString(R.string.movie_error_fetching_by_id_message),
				(dialogInterface, i) -> {
					finish();
				});
		errorDialog.setCancelable(false);
		errorDialog.show();
	}
}
