package uk.co.test.chris.moviedb.domain.classes;

import uk.co.test.chris.moviedb.data.entitys.FullPersonEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public class DetailedPerson {

	private final String name;
	private final String biography;
	private final String birthday;
	private final Integer gender;
	private final String homepage;
	private final String placeOfBirth;
	private final String profilePath;

	public DetailedPerson(FullPersonEntity fullPersonEntity) {
		name = fullPersonEntity.getName();
		biography = fullPersonEntity.getBiography();
		birthday = fullPersonEntity.getBirthday();
		gender = fullPersonEntity.getGender();
		homepage = fullPersonEntity.getHomepage();
		placeOfBirth = fullPersonEntity.getPlaceOfBirth();
		profilePath = fullPersonEntity.getProfilePath();
	}

	public String getName() {
		return name;
	}

	public String getBiography() {
		return biography;
	}

	public String getBirthday() {
		return birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public String getProfilePath() {
		return profilePath;
	}
}
