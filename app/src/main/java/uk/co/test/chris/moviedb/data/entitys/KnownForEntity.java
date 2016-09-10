package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chris on 09/09/2016.
 */
public class KnownForEntity {

	@SerializedName("backdrop_path")
	private String backdropPath;
	
	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;

	public String getBackdropPath() {
		return backdropPath;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
}
