package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class ConfigurationImagesEntity {

	@SerializedName("base_url")
	private String baseUrl;

	@SerializedName("secure_base_url")
	private String secureBaseUrl;

	@SerializedName("backdrop_sizes")
	private List<String> backdropSizes = new ArrayList<>();

	@SerializedName("poster_sizes")
	private List<String> posterSizes = new ArrayList<>();

	@SerializedName("profile_sizes")
	private List<String> profileSizes = new ArrayList<>();

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getSecureBaseUrl() {
		return secureBaseUrl;
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
