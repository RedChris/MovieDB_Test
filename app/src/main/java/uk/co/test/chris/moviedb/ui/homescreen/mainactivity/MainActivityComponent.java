package uk.co.test.chris.moviedb.ui.homescreen.mainactivity;

import dagger.Module;
import dagger.Subcomponent;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;
import uk.co.test.chris.moviedb.ui.base.BaseMvpViewModule;

/**
 * Created by Chris on 09/09/2016.
 */

@ActivityScope
@Subcomponent(
		modules = MainActivityComponent.MainActivityModule.class
)
public interface MainActivityComponent {
	MainActivity inject(MainActivity activity);

	@Module
	class MainActivityModule extends BaseMvpViewModule<MainActivityView> {
		MainActivityModule(MainActivityView view) {
			super(view);
		}
	}
}