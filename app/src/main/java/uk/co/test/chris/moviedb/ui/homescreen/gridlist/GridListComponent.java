package uk.co.test.chris.moviedb.ui.homescreen.gridlist;

import dagger.Module;
import dagger.Subcomponent;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;
import uk.co.test.chris.moviedb.ui.base.BaseMvpViewModule;

/**
 * Created by Chris on 09/09/2016.
 */

@ActivityScope
@Subcomponent(
		modules = GridListComponent.GridListModule.class
)
public interface GridListComponent {
	GridListFragment inject(GridListFragment fragment);

	@Module
	class GridListModule extends BaseMvpViewModule<GridListView> {
		GridListModule(GridListView view) {
			super(view);
		}
	}
}