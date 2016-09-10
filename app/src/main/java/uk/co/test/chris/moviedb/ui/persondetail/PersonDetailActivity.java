package uk.co.test.chris.moviedb.ui.persondetail;

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
import uk.co.test.chris.moviedb.domain.classes.BasicPerson;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseActivity;
import uk.co.test.chris.moviedb.util.StringResHolder;
import uk.co.test.chris.moviedb.util.UtilDialog;

/**
 * Created by Chris on 09/09/2016.
 */
public class PersonDetailActivity extends BaseActivity implements PersonDetailView {

	@Inject PersonDetailPresenter mPersonDetailPresenter;

	private ActionBar mActionBar;
	@BindView(R.id.content) FrameLayout mContent;
	@BindView(R.id.profile) ImageView mProfile;
	@BindView(R.id.biography) TextView mBiography;
	@BindView(R.id.birthday) TextView mBirthday;
	@BindView(R.id.gender) TextView mGender;

	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_detail);
		ButterKnife.bind(this);

		final Integer personId = getIntent().getIntExtra(BasicPerson.KEY_BASIC_PERSON_ID, -1);
		if (personId == -1) {
			AlertDialog noIdDialog = UtilDialog.createMessageDialog(this,
					getString(R.string.person_error_fetching_by_id_title),
					getString(R.string.person_error_fetching_by_id_message),
					(dialogInterface, i) -> {
						finish();
					});
			noIdDialog.setCancelable(false);
			noIdDialog.show();
		} else {
			initUi();
			mPersonDetailPresenter.onViewReady();
			mPersonDetailPresenter.userWantsToViewPerson(personId);
		}
	}

	private void initUi() {
		mActionBar = getSupportActionBar();
	}

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new PersonDetailComponenet.PersonDetailActivityModule(this)).inject(this);
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
	public void setBiography(String biography) {
		mBiography.setText(biography);
	}

	@Override
	public void setProfileUrl(String profilePath) {
		Picasso.with(this).load(profilePath).resize(150, 200).centerCrop().into(mProfile);
	}

	@Override
	public void setBirthday(String birthday) {
		mBirthday.setText(birthday);
	}

	@Override
	public void setGender(String gender) {
		mGender.setText(gender);
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
