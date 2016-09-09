package uk.co.test.chris.moviedb.ui.homescreen.movietab;

import dagger.Module;
import dagger.Subcomponent;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;
import uk.co.test.chris.moviedb.ui.base.BaseMvpViewModule;

/**
 * Created by Chris on 09/09/2016.
 */

@ActivityScope
@Subcomponent(
		modules = MovieTabComponent.MovieTabModule.class
)
public interface MovieTabComponent {
	MovieTabFragment inject(MovieTabFragment fragment);

	@Module
	class MovieTabModule extends BaseMvpViewModule<MovieTabView> {
		MovieTabModule(MovieTabView view) {
			super(view);
		}
	}
}