package uk.co.test.chris.moviedb.injection;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.test.chris.moviedb.data.net.injection.MoviesDbServiceModule;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.GridListComponent;
import uk.co.test.chris.moviedb.ui.homescreen.mainactivity.MainActivityComponent;
import uk.co.test.chris.moviedb.ui.moviedetail.MovieDetailComponent;
import uk.co.test.chris.moviedb.ui.persondetail.PersonDetailComponenet;
import uk.co.test.chris.moviedb.ui.tvdetail.TvDetailComponent;

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

	MovieDetailComponent plus(MovieDetailComponent.MovieDetailActivityModule movieDetailActivityModule);

	TvDetailComponent plus(TvDetailComponent.TvDetailActivityModule tvDetailActivityModule);

	PersonDetailComponenet plus(PersonDetailComponenet.PersonDetailActivityModule personDetailActivityModule);
}
