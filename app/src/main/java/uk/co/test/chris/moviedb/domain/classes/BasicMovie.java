package uk.co.test.chris.moviedb.domain.classes;

import com.google.gson.annotations.Expose;

import uk.co.test.chris.moviedb.data.entitys.MovieEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public class BasicMovie {
	public static final String KEY_BASIC_MOVIE_ID = "keyBasicMovieId";


	@Expose
	private final Integer id;

	@Expose
	private final String originalTitle;

	@Expose
	private final String title;

	@Expose
	private final String posterPath;

	public BasicMovie(MovieEntity movieEntity) {
		id = movieEntity.getId();
		originalTitle = movieEntity.getOriginalTitle();
		title = movieEntity.getTitle();
		posterPath = movieEntity.getPosterPath();
	}

	public Integer getId() {
		return id;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getTitle() {
		return title;
	}

	public String getPosterPath() {
		return posterPath;
	}
}