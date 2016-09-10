package uk.co.test.chris.moviedb.ui.moviedetail;

import uk.co.test.chris.moviedb.ui.base.MvpView;
import uk.co.test.chris.moviedb.util.StringResHolder;

/**
 * Created by Chris on 09/09/2016.
 */
public interface MovieDetailView extends MvpView {
	void showLoadingState();

	void hideLoadingState();

	void showContent();

	void hideContent();

	void setTitle(String title);

	void setBackdrop(String backdropUrl);

	void setTagline(String tagline);

	void setPoster(String posterPath);

	void setOverview(String overview);

	void setBudget(String budget);

	void setRunTime(String runtime);

	void setRevenue(String revenue);

	void setReleaseData(String releaseDate);

	void setGenre(String genres);

	void setProductionCountry(String productionCountries);

	void setProductionCompany(String productionCompanies);

	void displayError(StringResHolder title, StringResHolder message);
}
