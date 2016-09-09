package uk.co.test.chris.moviedb.domain.managers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.test.chris.moviedb.data.entitys.PersonEntity;
import uk.co.test.chris.moviedb.data.entitys.PersonListEntity;
import uk.co.test.chris.moviedb.data.net.MoviesDbService;
import uk.co.test.chris.moviedb.domain.classes.BasicPerson;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;

/**
 * Created by Chris on 09/09/2016.
 */
public class PersonManager {
	
	private MoviesDbService mMoviesDbService;
	private List<BasicPerson> mPeopleList = new ArrayList<>();

	public PersonManager(MoviesDbService moviesDbService) {

		mMoviesDbService = moviesDbService;
	}

	public void getPopularPeople(GenericRequestCallback<List<BasicPerson>> callback) {
		mMoviesDbService.getPopularPeople().enqueue(new Callback<PersonListEntity>() {
			@Override
			public void onResponse(Call<PersonListEntity> call, Response<PersonListEntity> response) {
				if (response.isSuccessful()) {

					List<PersonEntity> personEntities = response.body().getResults();

					mPeopleList.clear();
					for (PersonEntity personEntity : personEntities) {
						mPeopleList.add(new BasicPerson(personEntity));
					}

					callback.onComplete(mPeopleList);
				} else {
					callback.onFailure();
				}
			}

			@Override
			public void onFailure(Call<PersonListEntity> call, Throwable t) {
				callback.onFailure();
			}
		});
	}
}
