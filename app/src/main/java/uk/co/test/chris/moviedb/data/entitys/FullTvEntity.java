package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class FullTvEntity {
	
	@SerializedName("backdrop_path")
	private String backdropPath;
	
	@SerializedName("created_by")
	private List<CreatedByEntity> createdBy = new ArrayList<>();
	
	@SerializedName("episode_run_time")
	private List<Integer> episodeRunTime = new ArrayList<>();
	
	@SerializedName("first_air_date")
	private String firstAirDate;
	
	@SerializedName("genres")
	private List<GenreEntity> genres = new ArrayList<>();
	
	@SerializedName("homepage")
	private String homepage;
	
	@SerializedName("id")
	private Integer id;
	
	@SerializedName("in_production")
	private Boolean inProduction;
	
	@SerializedName("languages")
	private List<String> languages = new ArrayList<>();
	
	@SerializedName("last_air_date")
	private String lastAirDate;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("networks")
	private List<NetworkEntity> networks = new ArrayList<>();
	
	@SerializedName("number_of_episodes")
	private Integer numberOfEpisodes;
	
	@SerializedName("number_of_seasons")
	private Integer numberOfSeasons;
	
	@SerializedName("origin_country")
	private List<String> originCountry = new ArrayList<String>();
	
	@SerializedName("original_language")
	private String originalLanguage;
	
	@SerializedName("original_name")
	private String originalName;
	
	@SerializedName("overview")
	private String overview;
	
	@SerializedName("popularity")
	private Double popularity;
	
	@SerializedName("poster_path")
	private String posterPath;
	
	@SerializedName("production_companies")
	private List<ProductionCompanyEntity> productionCompanies = new ArrayList<>();
	
	@SerializedName("seasons")
	private List<SeasonEntity> seasons = new ArrayList<>();
	
	@SerializedName("status")
	private String status;
	
	@SerializedName("type")
	private String type;
	
	@SerializedName("vote_average")
	private Double voteAverage;
	
	@SerializedName("vote_count")
	private Integer voteCount;

	public String getBackdropPath() {
		return backdropPath;
	}

	public List<CreatedByEntity> getCreatedBy() {
		return createdBy;
	}

	public List<Integer> getEpisodeRunTime() {
		return episodeRunTime;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public List<GenreEntity> getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public Integer getId() {
		return id;
	}

	public Boolean getInProduction() {
		return inProduction;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public String getLastAirDate() {
		return lastAirDate;
	}

	public String getName() {
		return name;
	}

	public List<NetworkEntity> getNetworks() {
		return networks;
	}

	public Integer getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public Integer getNumberOfSeasons() {
		return numberOfSeasons;
	}

	public List<String> getOriginCountry() {
		return originCountry;
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

	public Double getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public List<ProductionCompanyEntity> getProductionCompanies() {
		return productionCompanies;
	}

	public List<SeasonEntity> getSeasons() {
		return seasons;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Integer getVoteCount() {
		return voteCount;
	}
}
