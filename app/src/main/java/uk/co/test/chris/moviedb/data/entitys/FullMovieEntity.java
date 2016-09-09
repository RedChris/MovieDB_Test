package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class FullMovieEntity {

	@SerializedName("adult")
	private Boolean adult;

	@SerializedName("backdrop_path")
	private String backdropPath;

	@SerializedName("belongs_to_collection")
	private Object belongsToCollection;

	@SerializedName("budget")
	private Integer budget;

	@SerializedName("genres")
	private List<GenreEntity> genres = new ArrayList<>();

	@SerializedName("homepage")
	private String homepage;

	@SerializedName("id")
	private Integer id;

	@SerializedName("imdb_id")
	private String imdbId;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("overview")
	private String overview;

	@SerializedName("popularity")
	private Double popularity;

	@SerializedName("poster_path")
	private String posterPath;

	@SerializedName("production_companies")
	private List<ProductionCompanyEntity> productionCompanies = new ArrayList<>();

	@SerializedName("production_countries")
	private List<ProductionCountryEntity> productionCountries = new ArrayList<>();

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("revenue")
	private Integer revenue;

	@SerializedName("runtime")
	private Integer runtime;

	@SerializedName("spoken_languages")
	private List<SpokenLanguageEntity> spokenLanguages = new ArrayList<>();

	@SerializedName("status")
	private String status;

	@SerializedName("tagline")
	private String tagline;

	@SerializedName("title")
	private String title;

	@SerializedName("video")
	private Boolean video;

	@SerializedName("vote_average")
	private Double voteAverage;

	@SerializedName("vote_count")
	private Integer voteCount;

	public Boolean getAdult() {
		return adult;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public Object getBelongsToCollection() {
		return belongsToCollection;
	}

	public Integer getBudget() {
		return budget;
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

	public String getImdbId() {
		return imdbId;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
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

	public List<ProductionCountryEntity> getProductionCountries() {
		return productionCountries;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Integer getRevenue() {
		return revenue;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public List<SpokenLanguageEntity> getSpokenLanguages() {
		return spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public String getTagline() {
		return tagline;
	}

	public String getTitle() {
		return title;
	}

	public Boolean getVideo() {
		return video;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Integer getVoteCount() {
		return voteCount;
	}
}
