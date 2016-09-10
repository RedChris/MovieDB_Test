package uk.co.test.chris.moviedb.ui.persondetail;

import dagger.Module;
import dagger.Subcomponent;
import uk.co.test.chris.moviedb.injection.scopes.ActivityScope;
import uk.co.test.chris.moviedb.ui.base.BaseMvpViewModule;

/**
 * Created by Chris on 09/09/2016.
 */

@ActivityScope
@Subcomponent(
		modules = PersonDetailComponenet.PersonDetailActivityModule.class
)
public interface PersonDetailComponenet {
	PersonDetailActivity inject(PersonDetailActivity activity);

	@Module
	class PersonDetailActivityModule extends BaseMvpViewModule<PersonDetailView> {
		PersonDetailActivityModule(PersonDetailView view) {
			super(view);
		}
	}
}