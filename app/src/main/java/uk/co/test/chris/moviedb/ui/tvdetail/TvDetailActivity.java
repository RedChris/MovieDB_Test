package uk.co.test.chris.moviedb.ui.tvdetail;

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
import uk.co.test.chris.moviedb.domain.classes.BasicTvShow;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseActivity;
import uk.co.test.chris.moviedb.util.StringResHolder;
import uk.co.test.chris.moviedb.util.UtilDialog;

/**
 * Created by Chris on 09/09/2016.
 */
public class TvDetailActivity extends BaseActivity implements TvDetailView {

	@Inject TvDetailPresenter mTvDetailPresenter;

	private ActionBar mActionBar;
	@BindView(R.id.content) FrameLayout mContent;
	@BindView(R.id.backdrop) ImageView mBackdrop;
	@BindView(R.id.poster) ImageView mPoster;
	@BindView(R.id.overview) TextView mOverView;
	@BindView(R.id.status) TextView mstatus;
	@BindView(R.id.genre) TextView mGenre;
	@BindView(R.id.runtime) TextView mRuntime;
	@BindView(R.id.first_aired) TextView mFirstAired;
	@BindView(R.id.episodes) TextView mEpisodes;
	@BindView(R.id.seasons) TextView mSeasons;
	@BindView(R.id.languages) TextView mLanguages;
	@BindView(R.id.created_by) TextView mCreatedBy;
	@BindView(R.id.origin) TextView mCountryOrigin;
	@BindView(R.id.companies) TextView mCompanies;

	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tv_show_detail);
		ButterKnife.bind(this);

		final Integer tvShowId = getIntent().getIntExtra(BasicTvShow.KEY_BASIC_TV_SHOW_ID, -1);
		if (tvShowId == -1) {
			AlertDialog noIdDialog = UtilDialog.createMessageDialog(this,
					getString(R.string.tv_show_error_fetching_by_id_title),
					getString(R.string.tv_show_error_fetching_by_id_message),
					(dialogInterface, i) -> {
						finish();
					});
			noIdDialog.setCancelable(false);
			noIdDialog.show();
		} else {
			initUi();
			mTvDetailPresenter.onViewReady();
			mTvDetailPresenter.userWantsToViewTvShow(tvShowId);
		}
	}

	private void initUi() {
		mActionBar = getSupportActionBar();
	}

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new TvDetailComponent.TvDetailActivityModule(this)).inject(this);
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
	public void setName(String name) {
		mActionBar.setTitle(name);
	}

	@Override
	public void setOverview(String overview) {
		mOverView.setText(overview);
	}

	@Override
	public void setBackdrop(String backdropUrl) {
		Picasso.with(this).load(backdropUrl).fit().centerCrop().into(mBackdrop);
	}

	@Override
	public void setStatus(String status) {
		mstatus.setText(status);
	}

	@Override
	public void setPoster(String url) {
		Picasso.with(this).load(url).resize(150, 200).centerCrop().into(mPoster);
	}

	@Override
	public void setNumberOfSeasons(String numberOfSeasons) {
		mSeasons.setText(numberOfSeasons);
	}

	@Override
	public void setNumberOfEpisodes(String numberOfEpisodes) {
		mEpisodes.setText(numberOfEpisodes);
	}

	@Override
	public void setFirstAirDate(String firstAirDate) {
		mFirstAired.setText(firstAirDate);
	}

	@Override
	public void setRuntime(String episodeRunTime) {
		mRuntime.setText(episodeRunTime);
	}

	@Override
	public void setGenre(String genres) {
		mGenre.setText(genres);
	}

	@Override
	public void setOriginCountry(String originCountry) {
		mCountryOrigin.setText(originCountry);
	}

	@Override
	public void setProductionCompany(String productionCompanies) {
		mCompanies.setText(productionCompanies);
	}

	@Override
	public void setCreatedBy(String createdBy) {
		mCreatedBy.setText(createdBy);
	}

	@Override
	public void setLanguages(String languages) {
		mLanguages.setText(languages);
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
