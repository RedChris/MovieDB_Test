package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chris on 09/09/2016.
 */
public class SeasonEntity {
	
	@SerializedName("air_date")
	private String airDate;
	
	@SerializedName("episode_count")
	private Integer episodeCount;
	
	@SerializedName("id")
	private Integer id;
	
	@SerializedName("poster_path")
	private String posterPath;
	
	@SerializedName("season_number")
	private Integer seasonNumber;

	public String getAirDate() {
		return airDate;
	}

	public Integer getEpisodeCount() {
		return episodeCount;
	}

	public Integer getId() {
		return id;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Integer getSeasonNumber() {
		return seasonNumber;
	}
}
