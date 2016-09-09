package uk.co.test.chris.moviedb.domain.classes;

import com.google.gson.annotations.Expose;

import uk.co.test.chris.moviedb.data.entitys.TvEntity;

/**
 * Created by Chris on 09/09/2016.
 */
public class BasicTvShow {
	@Expose
	private final Integer id;

	@Expose
	private final String originalName;

	@Expose
	private final String mName;

	@Expose
	private final String posterPath;

	public BasicTvShow(TvEntity tvEntity) {
		id = tvEntity.getId();
		originalName = tvEntity.getOriginalName();
		mName = tvEntity.getName();
		posterPath = tvEntity.getPosterPath();
	}

	public Integer getId() {
		return id;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getName() {
		return mName;
	}

	public String getPosterPath() {
		return posterPath;
	}
}
