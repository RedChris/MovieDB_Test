package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class FullPersonEntity {

	@SerializedName("adult")
	private Boolean adult;
	
	@SerializedName("also_known_as")
	private List<String> alsoKnownAs = new ArrayList<>();
	
	@SerializedName("biography")
	private String biography;
	
	@SerializedName("birthday")
	private String birthday;
	
	@SerializedName("deathday")
	private String deathday;
	
	@SerializedName("gender")
	private Integer gender;
	
	@SerializedName("homepage")
	private String homepage;

	@SerializedName("id")
	private Integer id;
	
	@SerializedName("imdb_id")
	private String imdbId;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("place_of_birth")
	private String placeOfBirth;
	
	@SerializedName("popularity")
	private Double popularity;
	
	@SerializedName("profile_path")
	private String profilePath;

	public Boolean getAdult() {
		return adult;
	}

	public List<String> getAlsoKnownAs() {
		return alsoKnownAs;
	}

	public String getBiography() {
		return biography;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getDeathday() {
		return deathday;
	}

	public Integer getGender() {
		return gender;
	}

	public String getHomepage() {
		return homepage;
	}

	public Integer getId() {
		return id;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getName() {
		return name;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public Double getPopularity() {
		return popularity;
	}

	public String getProfilePath() {
		return profilePath;
	}
}
