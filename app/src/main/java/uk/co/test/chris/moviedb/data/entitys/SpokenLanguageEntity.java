package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chris on 09/09/2016.
 */
public class SpokenLanguageEntity {

	@SerializedName("name")
	private String name;

	public String getName() {
		return name;
	}
}
