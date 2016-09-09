package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class TvListEntity {

	@SerializedName("page")
	private Integer page;

	@SerializedName("results")
	private List<TvEntity> results = new ArrayList<>();

	@SerializedName("total_pages")
	private Integer totalPages;

	@SerializedName("total_results")
	private Integer totalResults;

	public Integer getPage() {
		return page;
	}

	public List<TvEntity> getResults() {
		return results;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Integer getTotalResults() {
		return totalResults;
	}
}
