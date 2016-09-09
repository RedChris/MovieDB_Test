package uk.co.test.chris.moviedb.ui.homescreen.movietab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.injection.ApplicationComponent;
import uk.co.test.chris.moviedb.ui.base.BaseFragment;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.adapter.MovieTabAdapter;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.model.PhotoListItemModel;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieTabFragment extends BaseFragment implements MovieTabView {

	@Inject MovieTabPresenter mMovieTabPresenter;

	@BindView(R.id.list) RecyclerView mList;

	private MovieTabAdapter mAdapter;

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new MovieTabComponent.MovieTabModule(this)).inject(this);

	}

	public static MovieTabFragment newInstance() {
		return new MovieTabFragment();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tab_list, container, false);
		ButterKnife.bind(this, view);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initUi();
		mMovieTabPresenter.onViewReady();
	}

	private void initUi() {
		mAdapter = new MovieTabAdapter(getActivity());
		int NUMBER_OF_COLUMNS = 2;
		mList.setLayoutManager(new GridLayoutManager(getActivity(), NUMBER_OF_COLUMNS));
		mList.setAdapter(mAdapter);

		mAdapter.setOnItemClickedListener(itemId -> {
			//
		});


	}

	@Override
	public void onDetach() {
		super.onDetach();
		mMovieTabPresenter.onDestroy();
		//mListener = null;
	}

	public void updateMovies(List<PhotoListItemModel> movieList) {
		mAdapter.updateItems(movieList);
	}
}
