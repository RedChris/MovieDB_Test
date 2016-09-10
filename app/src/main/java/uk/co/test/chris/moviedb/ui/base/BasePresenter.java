package uk.co.test.chris.moviedb.ui.base;


/**
 * Created by Chris on 11/08/2016.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

	protected T mView;

	public BasePresenter(T mvpView) {
		mView = mvpView;
	}

	public T getView() {
		return mView;
	}


	/**
	 * This method should be manually called by the view to indicate that the view is ready.
	 * Most usually triggered when internal view have been found and referenced.
	 */
	@Override
	public void onViewReady() {

	}

	/**
	 * This method should be manually called by the view to indicate that it will be destroyed,
	 * this callback is especially useful clearing up anything that may leak
	 */
	@Override
	public void onDestroy() {
		mView = null;
	}
}
