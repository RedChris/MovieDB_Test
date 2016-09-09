package uk.co.test.chris.moviedb.injection;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.test.chris.moviedb.data.net.injection.MoviesDbServiceModule;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.GridListComponent;
import uk.co.test.chris.moviedb.ui.homescreen.mainactivity.MainActivityComponent;

/**
 * Created by Chris on 08/09/2016.
 */

@Singleton
@Component(
		modules = {
				ApplicationModule.class,
				MoviesDbServiceModule.class
		}
)
public interface ApplicationComponent {

	MainActivityComponent plus(MainActivityComponent.MainActivityModule module);

	GridListComponent plus(GridListComponent.GridListModule gridListModule);
}
