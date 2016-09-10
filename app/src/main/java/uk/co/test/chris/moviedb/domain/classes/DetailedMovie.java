package uk.co.test.chris.moviedb.domain.classes;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import uk.co.test.chris.moviedb.data.entitys.FullMovieEntity;
import uk.co.test.chris.moviedb.data.entitys.GenreEntity;
import uk.co.test.chris.moviedb.data.entitys.ProductionCompanyEntity;
import uk.co.test.chris.moviedb.data.entitys.ProductionCountryEntity;
import uk.co.test.chris.moviedb.util.Util;
import uk.co.test.chris.moviedb.util.UtilDate;

/**
 * Created by Chris on 09/09/2016.
 */
public class DetailedMovie {

	private final String title;
	private final String backdropPath;
	private final String budget;
	private final String genres;
	private final String homepage;
	private final String originalLanguage;
	private final String overview;
	private final String posterPath;
	private final String tagline;
	private final String runtime;
	private final String revenue;
	private final String releaseDate;
	private final String productionCountries;
	private final String productionCompanies;

	public DetailedMovie(FullMovieEntity fullMovieEntity) {
		title = fullMovieEntity.getTitle();
		backdropPath = fullMovieEntity.getBackdropPath();
		budget = MessageFormat.format("{0}M", fullMovieEntity.getBudget() / 1000000);
		homepage = fullMovieEntity.getHomepage();
		originalLanguage = fullMovieEntity.getOriginalLanguage();
		overview = fullMovieEntity.getOverview();
		posterPath = fullMovieEntity.getPosterPath();
		tagline = fullMovieEntity.getTagline();
		revenue  = MessageFormat.format("{0}M", fullMovieEntity.getRevenue() / 1000000);
		releaseDate = UtilDate.convertServerDateToDisplayDate(fullMovieEntity.getReleaseDate());

		int minutes = fullMovieEntity.getRuntime();
		int hours = minutes / 60;
		minutes = minutes % 60 ;
		runtime = MessageFormat.format("{0}h{1}m", hours, minutes);

		List<String> genreNames = new ArrayList<>();
		for (GenreEntity genreEntity : fullMovieEntity.getGenres()) {
			genreNames.add(genreEntity.getName());
		}

		genres = Util.getCommaSeparatedString(genreNames);

		List<String> countryNames = new ArrayList<>();
		for (ProductionCountryEntity productionCountry : fullMovieEntity.getProductionCountries()) {
			countryNames.add(productionCountry.getName());
		}

		productionCountries = Util.getLineSeparatedString(countryNames);

		List<String> companyNames = new ArrayList<>();
		for (ProductionCompanyEntity productionCompany : fullMovieEntity.getProductionCompanies()) {
			companyNames.add(productionCompany.getName());
		}

		productionCompanies = Util.getLineSeparatedString(companyNames);
	}

	public String getTitle() {
		return title;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getBudget() {
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

	public String getRuntime() {
		return runtime;
	}

	public String getRevenue() {
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
