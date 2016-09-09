package uk.co.test.chris.moviedb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;


/**
 * Created by Chris on 09/09/2016.
 */
public class NavigationAction {

	private Class<? extends Activity> mDestinationActivity;
	private Bundle mBundle = new Bundle();

	private NavigationAction(@NonNull Class<? extends Activity> destinationActivity) {
		mDestinationActivity = destinationActivity;
	}

	public static NavigationAction NavigateTo(@NonNull Class<? extends Activity> destinationActivity) {
		return new NavigationAction(destinationActivity);
	}

	public NavigationAction withInt(String key, int value){
		mBundle.putInt(key, value);
		return this;
	}

	public NavigationAction withBoolean(String key, boolean value){
		mBundle.putBoolean(key, value);
		return this;
	}

	public NavigationAction withString(String key, String value){
		mBundle.putString(key, value);
		return this;
	}

	public void start(@NonNull Context context) {
		Intent intent = new Intent(context, mDestinationActivity);
		if (!mBundle.isEmpty()) {
			intent.putExtras(mBundle);
		}
		context.startActivity(intent);
	}
}
