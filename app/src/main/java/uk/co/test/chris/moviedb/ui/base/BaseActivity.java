package uk.co.test.chris.moviedb.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.test.chris.moviedb.MyApplication;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;


/**
 * Created by Chris on 17/08/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupActivityComponent(MyApplication.get(this).getComponent());
	}

	protected abstract void setupActivityComponent(ApplicationComponent appComponent);
}