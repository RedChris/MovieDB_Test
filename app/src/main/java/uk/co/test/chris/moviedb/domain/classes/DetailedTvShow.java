package uk.co.test.chris.moviedb.domain.classes;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import uk.co.test.chris.moviedb.data.entitys.CreatedByEntity;
import uk.co.test.chris.moviedb.data.entitys.FullTvEntity;
import uk.co.test.chris.moviedb.data.entitys.GenreEntity;
import uk.co.test.chris.moviedb.data.entitys.ProductionCompanyEntity;
import uk.co.test.chris.moviedb.util.Util;
import uk.co.test.chris.moviedb.util.UtilDate;

/**
 * Created by Chris on 09/09/2016.
 */
public class DetailedTvShow {

	private final String backdropPath;
	private final String createdBy;
	private final String episodeRunTime;
	private final String firstAirDate;
	private final String genres;
	private final String homepage;
	private final String languages;
	private final String name;
	private final String numberOfEpisodes;
	private final String numberOfSeasons;
	private final String originCountry;
	private final String overview;
	private final String posterPath;
	private final String productionCompanies;
	private final String status;

	public DetailedTvShow(FullTvEntity fullTvEntity) {
		backdropPath = fullTvEntity.getBackdropPath();
		homepage = fullTvEntity.getHomepage();
		name = fullTvEntity.getName();
		numberOfEpisodes = fullTvEntity.getNumberOfEpisodes().toString();
		numberOfSeasons = fullTvEntity.getNumberOfSeasons().toString();
		overview = fullTvEntity.getOverview();
		posterPath = fullTvEntity.getPosterPath();
		status = fullTvEntity.getStatus();

		//First air date
		firstAirDate = UtilDate.convertServerDateToDisplayDate(fullTvEntity.getFirstAirDate());

		//Episode run time
		if (!fullTvEntity.getEpisodeRunTime().isEmpty()) {
			episodeRunTime = MessageFormat.format("{0}m", fullTvEntity.getEpisodeRunTime().get(0));
		} else {
			episodeRunTime = null;
		}

		// Created By string
		List<String> creatorNames = new ArrayList<>();
		for (CreatedByEntity createdBy : fullTvEntity.getCreatedBy()) {
			creatorNames.add(createdBy.getName());
		}

		createdBy = Util.getLineSeparatedString(creatorNames);

		// Language string
		languages = Util.getLineSeparatedString(fullTvEntity.getLanguages());

		// Origin Country string
		originCountry = Util.getLineSeparatedString(fullTvEntity.getOriginCountry());

		// Genre string
		List<String> genreNames = new ArrayList<>();
		for (GenreEntity genreEntity : fullTvEntity.getGenres()) {
			genreNames.add(genreEntity.getName());
		}

		genres = Util.getLineSeparatedString(genreNames);

		//Production Company String
		List<String> companyNames = new ArrayList<>();
		for (ProductionCompanyEntity productionCompany : fullTvEntity.getProductionCompanies()) {
			companyNames.add(productionCompany.getName());
		}

		productionCompanies = Util.getLineSeparatedString(companyNames);
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getEpisodeRunTime() {
		return episodeRunTime;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public String getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getLanguages() {
		return languages;
	}

	public String getName() {
		return name;
	}

	public String getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public String getNumberOfSeasons() {
		return numberOfSeasons;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public String getOverview() {
		return overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public String getProductionCompanies() {
		return productionCompanies;
	}

	public String getStatus() {
		return status;
	}
}
