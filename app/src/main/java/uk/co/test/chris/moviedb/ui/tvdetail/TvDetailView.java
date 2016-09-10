package uk.co.test.chris.moviedb.ui.tvdetail;

import uk.co.test.chris.moviedb.ui.base.MvpView;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public interface TvDetailView extends MvpView {
	void showLoadingState();

	void hideContent();

	void hideLoadingState();

	void showContent();

	void setName(String name);

	void setOverview(String overview);

	void setBackdrop(String url);

	void setStatus(String status);

	void setPoster(String url);

	void setNumberOfSeasons(String numberOfSeasons);

	void setNumberOfEpisodes(String numberOfEpisodes);

	void setFirstAirDate(String firstAirDate);

	void setRuntime(String episodeRunTime);

	void setGenre(String genres);

	void setOriginCountry(String originCountry);

	void setProductionCompany(String productionCompanies);

	void setCreatedBy(String createdBy);

	void setLanguages(String languages);

	void displayError(StringResHolder title, StringResHolder message);
}
