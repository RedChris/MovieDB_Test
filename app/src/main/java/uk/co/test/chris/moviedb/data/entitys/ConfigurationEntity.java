package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chris on 09/09/2016.
 */
public class ConfigurationEntity {

	@SerializedName("images")
	private ConfigurationImagesEntity images;

	public ConfigurationImagesEntity getImages() {
		return images;
	}
}