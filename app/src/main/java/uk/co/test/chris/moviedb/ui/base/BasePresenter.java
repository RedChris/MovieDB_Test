package uk.co.test.chris.moviedb.ui.base;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Chris on 11/08/2016.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

	protected T mView;
	protected CompositeSubscription mSubscription;

	public BasePresenter(T mvpView) {
		mView = mvpView;
		mSubscription = new CompositeSubscription();
	}

	public T getView() {
		return mView;
	}

	protected CompositeSubscription getSubscription() {
		return mSubscription;
	}

	/**
	 * Calling un-subscribe on a compositeSubscription will render it un-usable, as it will automatically
	 * ub-subscribe aanything added to it afterwards. This method will call un-subscribe the compositeSubscription
	 * and re-create the object.
	 */
	protected void recreateSubscription() {
		mSubscription.unsubscribe();
		mSubscription = new CompositeSubscription();
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
	 * this callback is especially useful if you are taking advantage of the compositeSubscription.
	 */
	@Override
	public void onDestroy() {
		mSubscription.unsubscribe();
		mView = null;
	}
}
