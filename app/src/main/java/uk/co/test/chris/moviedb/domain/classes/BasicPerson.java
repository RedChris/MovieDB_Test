package uk.co.test.chris.moviedb.domain.classes;

import com.google.gson.annotations.Expose;

import uk.co.test.chris.moviedb.data.entitys.PersonEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public class BasicPerson {

	@Expose
	private Integer id;

	@Expose
	private String name;

	@Expose
	private String profilePath;

	public BasicPerson(PersonEntity personEntity) {
		id = personEntity.getId();
		name = personEntity.getName();
		profilePath = personEntity.getProfilePath();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProfilePath() {
		return profilePath;
	}
}
