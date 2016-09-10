package uk.co.test.chris.moviedb.ui.tvdetail;

import dagger.Module;
import dagger.Subcomponent;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;
import uk.co.test.chris.moviedb.ui.base.BaseMvpViewModule;

/**
 * Created by Chris on 09/09/2016.
 */

@ActivityScope
@Subcomponent(
		modules = TvDetailComponent.TvDetailActivityModule.class
)
public interface TvDetailComponent {
	TvDetailActivity inject(TvDetailActivity activity);

	@Module
	class TvDetailActivityModule extends BaseMvpViewModule<TvDetailView> {
		TvDetailActivityModule(TvDetailView view) {
			super(view);
		}
	}
}