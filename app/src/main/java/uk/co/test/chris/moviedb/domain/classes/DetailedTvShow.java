package uk.co.test.chris.moviedb.domain.classes;

import java.util.ArrayList;
import java.util.List;

import uk.co.test.chris.moviedb.data.entitys.CreatedByEntity;
import uk.co.test.chris.moviedb.data.entitys.FullTvEntity;
import uk.co.test.chris.moviedb.data.entitys.GenreEntity;
import uk.co.test.chris.moviedb.data.entitys.ProductionCompanyEntity;
import uk.co.test.chris.moviedb.util.Util;

/**
 * Created by Chris on 09/09/2016.
 */
public class DetailedTvShow {

	private final String backdropPath;
	private final String createdBy;
	private final Integer episodeRunTime;
	private final String firstAirDate;
	private final String genres;
	private final String homepage;
	private final String languages;
	private final String name;
	private final Integer numberOfEpisodes;
	private final Integer numberOfSeasons;
	private final String originCountry;
	private final String overview;
	private final String posterPath;
	private final String productionCompanies;
	private final String status;

	public DetailedTvShow(FullTvEntity fullTvEntity) {
		backdropPath = fullTvEntity.getBackdropPath();
		firstAirDate = fullTvEntity.getFirstAirDate();
		homepage = fullTvEntity.getHomepage();
		name = fullTvEntity.getName();
		numberOfEpisodes = fullTvEntity.getNumberOfEpisodes();
		numberOfSeasons = fullTvEntity.getNumberOfSeasons();
		overview = fullTvEntity.getOverview();
		posterPath = fullTvEntity.getPosterPath();
		status = fullTvEntity.getStatus();

		//Episode run time
		if (!fullTvEntity.getEpisodeRunTime().isEmpty()) {
			episodeRunTime = fullTvEntity.getEpisodeRunTime().get(0);
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
		languages = Util.getCommaSeparatedString(fullTvEntity.getLanguages());

		// Origin Country string
		originCountry = Util.getCommaSeparatedString(fullTvEntity.getOriginCountry());

		// Genre string
		List<String> genreNames = new ArrayList<>();
		for (GenreEntity genreEntity : fullTvEntity.getGenres()) {
			genreNames.add(genreEntity.getName());
		}

		genres = Util.getCommaSeparatedString(genreNames);

		//Production Company String
		List<String> companyNames = new ArrayList<>();
		for (ProductionCompanyEntity productionCompany : fullTvEntity.getProductionCompanies()) {
			companyNames.add(productionCompany.getName());
		}

		productionCompanies = Util.getCommaSeparatedString(companyNames);
	}
}
