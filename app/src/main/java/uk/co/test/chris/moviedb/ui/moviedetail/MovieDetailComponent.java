package uk.co.test.chris.moviedb.ui.moviedetail;

import dagger.Module;
import dagger.Subcomponent;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;
import uk.co.test.chris.moviedb.ui.base.BaseMvpViewModule;

/**
 * Created by Chris on 09/09/2016.
 */

@ActivityScope
@Subcomponent(
		modules = MovieDetailComponent.MovieDetailActivityModule.class
)
public interface MovieDetailComponent {
	MovieDetailActivity inject(MovieDetailActivity activity);

	@Module
	class MovieDetailActivityModule extends BaseMvpViewModule<MovieDetailView> {
		MovieDetailActivityModule(MovieDetailView view) {
			super(view);
		}
	}
}