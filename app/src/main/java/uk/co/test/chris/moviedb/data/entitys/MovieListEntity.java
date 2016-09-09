package uk.co.test.chris.moviedb.data.entitys;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieListEntity {

	@SerializedName("page")
	public Integer page;

	@SerializedName("results")
	public List<MovieEntity> results = new ArrayList<>();

	@SerializedName("total_pages")
	public Integer totalPages;

	@SerializedName("total_results")
	public Integer totalResults;

}
