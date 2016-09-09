package uk.co.test.chris.moviedb.ui.moviedetail;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;
import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.domain.classes.BasicMovie;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseActivity;
import uk.co.test.chris.moviedb.util.UtilDialog;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieDetailActivity extends BaseActivity implements MovieDetailView {

	@Inject MovieDetailPresenter mMovieDetailPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie_detail);
		ButterKnife.bind(this);

		final Integer movieId = getIntent().getIntExtra(BasicMovie.KEY_BASIC_MOVIE_ID, -1);
		if (movieId == -1) {
			/*AlertDialog noIdDialog = UtilDialog.createMessageDialog(this,
					getString(R.string.product_detail_no_id_error_title),
					getString(R.string.product_detail_no_id_error_message),
					(dialogInterface, i) -> {
						finish();
					});
			noIdDialog.setCancelable(false);
			noIdDialog.show();*/
		} else {
			initUi();
			mMovieDetailPresenter.onViewReady();
			mMovieDetailPresenter.userWantsToViewMovie(movieId);
		}
	}

	private void initUi() {

	}

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {

	}

	@Override
	public void showLoadingView() {

	}

	@Override
	public void hideLoadingView() {

	}
}
