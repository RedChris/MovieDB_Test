package uk.co.test.chris.moviedb.ui.persondetail;

import android.support.v4.util.Pair;

import javax.inject.Inject;

import uk.co.test.chris.moviedb.domain.classes.DetailedMovie;
import uk.co.test.chris.moviedb.domain.classes.DetailedPerson;
import uk.co.test.chris.moviedb.domain.managers.ConfigurationManager;
import uk.co.test.chris.moviedb.domain.managers.PersonManager;
import uk.co.test.chris.moviedb.ui.base.BasePresenter;
import uk.co.test.chris.moviedb.util.GenericRequestCallback;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public class PersonDetailPresenter extends BasePresenter<PersonDetailView> {

	private final ConfigurationManager mConfigurationManager;
	private final PersonManager mPersonManager;

	@Inject
	public PersonDetailPresenter(PersonDetailView mvpView, ConfigurationManager configurationManager, PersonManager personManager) {
		super(mvpView);
		mConfigurationManager = configurationManager;
		mPersonManager = personManager;
	}

	public void userWantsToViewPerson(Integer personId) {
		getView().showLoadingState();
		getView().hideContent();
		mPersonManager.getPerson(personId, new GenericRequestCallback<DetailedPerson>() {
			@Override
			public void onComplete(DetailedPerson person) {
				getView().hideLoadingState();
				getView().showContent();
				setupUiWithPerson(person);
			}

			@Override
			public void onFailure(Pair<StringResHolder, StringResHolder> errorPair) {
				getView().hideLoadingState();
				getView().displayError(errorPair.first, errorPair.second);
			}
		});
	}

	private void setupUiWithPerson(DetailedPerson person) {
		getView().setName(person.getName());
		getView().setBiography(person.getBiography());
		getView().setProfileUrl(mConfigurationManager.buildStandardImageUrlForProfile(person.getProfilePath()));
		getView().setBirthday(person.getBirthday());
		getView().setGender(person.getGender());
	}
}
