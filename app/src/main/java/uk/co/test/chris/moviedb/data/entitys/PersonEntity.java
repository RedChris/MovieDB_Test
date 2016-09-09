package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class PersonEntity {
	@SerializedName("adult")
	private Boolean adult;

	@SerializedName("id")
	private Integer id;

	@SerializedName("known_for")
	private List<KnownForEntity> knownFor = new ArrayList<>();

	@SerializedName("name")
	private String name;

	@SerializedName("popularity")
	private Double popularity;

	@SerializedName("profile_path")
	private String profilePath;

	public Boolean getAdult() {
		return adult;
	}

	public Integer getId() {
		return id;
	}

	public List<KnownForEntity> getKnownFor() {
		return knownFor;
	}

	public String getName() {
		return name;
	}

	public Double getPopularity() {
		return popularity;
	}

	public String getProfilePath() {
		return profilePath;
	}
}
