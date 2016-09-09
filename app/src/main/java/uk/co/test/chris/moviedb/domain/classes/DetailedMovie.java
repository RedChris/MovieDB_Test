package uk.co.test.chris.moviedb.domain.classes;

import java.util.ArrayList;
import java.util.List;

import uk.co.test.chris.moviedb.data.entitys.FullMovieEntity;
import uk.co.test.chris.moviedb.data.entitys.GenreEntity;
import uk.co.test.chris.moviedb.data.entitys.ProductionCompanyEntity;
import uk.co.test.chris.moviedb.data.entitys.ProductionCountryEntity;
import uk.co.test.chris.moviedb.util.Util;

/**
 * Created by Chris on 09/09/2016.
 */
public class DetailedMovie {

	private final String title;
	private final String backdropPath;
	private final Integer budget;
	private final String genres;
	private final String homepage;
	private final String originalLanguage;
	private final String overview;
	private final String posterPath;
	private final String tagline;
	private final Integer runtime;
	private final Integer revenue;
	private final String releaseDate;
	private final String productionCountries;
	private final String productionCompanies;

	public DetailedMovie(FullMovieEntity fullMovieEntity) {
		title = fullMovieEntity.getTitle();
		backdropPath = fullMovieEntity.getBackdropPath();
		budget = fullMovieEntity.getBudget();
		homepage = fullMovieEntity.getHomepage();
		originalLanguage = fullMovieEntity.getOriginalLanguage();
		overview = fullMovieEntity.getOverview();
		posterPath = fullMovieEntity.getPosterPath();
		tagline = fullMovieEntity.getTagline();
		runtime = fullMovieEntity.getRuntime();
		revenue = fullMovieEntity.getRevenue();
		releaseDate = fullMovieEntity.getReleaseDate();

		List<String> genreNames = new ArrayList<>();
		for (GenreEntity genreEntity : fullMovieEntity.getGenres()) {
			genreNames.add(genreEntity.getName());
		}

		genres = Util.getCommaSeparatedString(genreNames);

		List<String> countryNames = new ArrayList<>();
		for (ProductionCountryEntity productionCountry : fullMovieEntity.getProductionCountries()) {
			countryNames.add(productionCountry.getName());
		}

		productionCountries = Util.getCommaSeparatedString(countryNames);

		List<String> companyNames = new ArrayList<>();
		for (ProductionCompanyEntity productionCompany : fullMovieEntity.getProductionCompanies()) {
			companyNames.add(productionCompany.getName());
		}

		productionCompanies = Util.getCommaSeparatedString(companyNames);
	}

	public String getTitle() {
		return title;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public Integer getBudget() {
		return budget;
	}

	public String getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOverview() {
		return overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public String getTagline() {
		return tagline;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public Integer getRevenue() {
		return revenue;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getProductionCountries() {
		return productionCountries;
	}

	public String getProductionCompanies() {
		return productionCompanies;
	}
}
