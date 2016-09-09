package uk.co.test.chris.moviedb;

import android.app.Application;
import android.content.Context;

import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.injection.ApplicationModule;
import uk.co.test.chris.moviedb.injection.DaggerApplicationComponent;

/**
 * Created by Chris on 08/09/2016.
 */
public class MyApplication extends Application {
	ApplicationComponent mApplicationComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		initComponent();
	}

	public static MyApplication get(Context context) {
		return (MyApplication) context.getApplicationContext();
	}

	private void initComponent() {
		mApplicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.build();
	}

	public ApplicationComponent getComponent() {
		return mApplicationComponent;
	}

	// Needed to replace the component with a test specific one
	public void setComponent(ApplicationComponent applicationComponent) {
		mApplicationComponent = applicationComponent;
	}
}
