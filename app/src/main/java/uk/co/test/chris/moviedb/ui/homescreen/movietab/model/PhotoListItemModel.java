package uk.co.test.chris.moviedb.ui.homescreen.movietab.model;

/**
 * Created by Chris on 09/09/2016.
 */
public class PhotoListItemModel {

	private final Integer id;
	private final String title;
	private final String image;

	public PhotoListItemModel(Integer id, String title, String image) {
		this.id = id;
		this.title = title;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}
}
