package uk.co.test.chris.moviedb.ui.base;

import dagger.Module;
import dagger.Provides;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;


/**
 * Created by Chris on 17/08/2016.
 */

@Module
public abstract class BaseMvpViewModule<T extends MvpView> {

	protected final T mView;

	public BaseMvpViewModule(T view) {
		this.mView = view;
	}

	@Provides
	@ActivityScope
	public T provideView() {
		return mView;
	}
}
