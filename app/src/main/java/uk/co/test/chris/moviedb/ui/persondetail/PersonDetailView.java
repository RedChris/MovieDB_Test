package uk.co.test.chris.moviedb.ui.persondetail;

import uk.co.test.chris.moviedb.ui.base.MvpView;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public interface PersonDetailView extends MvpView {
	void showLoadingState();

	void hideContent();

	void hideLoadingState();

	void showContent();

	void setName(String name);

	void setBiography(String biography);

	void setProfileUrl(String profilePath);

	void setBirthday(String birthday);

	void setGender(String gender);

	void displayError(StringResHolder title, StringResHolder message);
}
