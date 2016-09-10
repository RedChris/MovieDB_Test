package uk.co.test.chris.moviedb.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import uk.co.test.chris.moviedb.MyApplication;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;


/**
 * Created by Chris on 18/08/2016.
 */
public abstract class BaseFragment extends DialogFragment {

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupActivityComponent(MyApplication.get(getActivity()).getComponent());
	}

	protected abstract void setupActivityComponent(ApplicationComponent appComponent);
}
