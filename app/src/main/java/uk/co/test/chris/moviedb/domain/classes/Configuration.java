package uk.co.test.chris.moviedb.domain.classes;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import uk.co.test.chris.moviedb.data.entitys.ConfigurationEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public class Configuration {

	@Expose
	private final String baseUrl;

	@Expose
	private final List<String> backdropSizes;

	@Expose
	private final List<String> posterSizes;

	@Expose
	private final List<String> profileSizes;

	public Configuration(ConfigurationEntity configurationEntity) {
		baseUrl = configurationEntity.getImages().getBaseUrl();
		backdropSizes = configurationEntity.getImages().getBackdropSizes();
		posterSizes = configurationEntity.getImages().getPosterSizes();
		profileSizes = configurationEntity.getImages().getProfileSizes();
	}


	public String getBaseUrl() {
		return baseUrl;
	}

	public List<String> getBackdropSizes() {
		return backdropSizes;
	}

	public List<String> getPosterSizes() {
		return posterSizes;
	}

	public List<String> getProfileSizes() {
		return profileSizes;
	}

}
