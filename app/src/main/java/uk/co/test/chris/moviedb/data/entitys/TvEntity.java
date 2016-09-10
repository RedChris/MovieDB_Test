package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class TvEntity {

	@SerializedName("backdrop_path")
	private String backdropPath;
	
	@SerializedName("first_air_date")
	private String firstAirDate;
	
	@SerializedName("genre_ids")
	private List<Integer> genreIds = new ArrayList<>();
	
	@SerializedName("id")
	private Integer id;
	
	@SerializedName("original_language")
	private String originalLanguage;
	
	@SerializedName("original_name")
	private String originalName;
	
	@SerializedName("overview")
	private String overview;
	
	@SerializedName("origin_country")
	private List<String> originCountry = new ArrayList<>();
	
	@SerializedName("poster_path")
	private String posterPath;
	
	@SerializedName("popularity")
	private Double popularity;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("vote_average")
	private Double voteAverage;
	
	@SerializedName("vote_count")
	private Integer voteCount;

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public Integer getId() {
		return id;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getOverview() {
		return overview;
	}

	public List<String> getOriginCountry() {
		return originCountry;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Double getPopularity() {
		return popularity;
	}

	public String getName() {
		return name;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Integer getVoteCount() {
		return voteCount;
	}
}
