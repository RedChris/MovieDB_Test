package uk.co.test.chris.moviedb.ui.homescreen.gridlist;


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
import uk.co.test.chris.moviedb.ui.homescreen.OnItemClickedListener;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.adapter.GridListItemAdapter;
import uk.co.test.chris.moviedb.ui.homescreen.gridlist.model.PhotoListItemModel;

/**
 * Created by Chris on 09/09/2016.
 */
public class GridListFragment extends BaseFragment implements GridListView {

	@Inject GridListPresenter mMovieTabPresenter;

	@BindView(R.id.list) RecyclerView mList;

	private GridListItemAdapter mAdapter;
	private OnItemClickedListener mOnItemClickedListener;

	@Override
	protected void setupActivityComponent(ApplicationComponent appComponent) {
		appComponent.plus(new GridListComponent.GridListModule(this)).inject(this);

	}

	public static GridListFragment newInstance() {
		return new GridListFragment();
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
		mAdapter = new GridListItemAdapter(getActivity());
		int NUMBER_OF_COLUMNS = 2;
		mList.setLayoutManager(new GridLayoutManager(getActivity(), NUMBER_OF_COLUMNS));
		mList.setAdapter(mAdapter);

		mAdapter.setOnItemClickedListener(itemId -> {
			if (mOnItemClickedListener != null) {
				mOnItemClickedListener.onItemClicked(itemId);
			}
		});

	}

	@Override
	public void onDetach() {
		super.onDetach();
		mMovieTabPresenter.onDestroy();
		mOnItemClickedListener = null;
	}

	public void updateItems(List<PhotoListItemModel> movieList) {
		mAdapter.updateItems(movieList);
	}

	public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
		mOnItemClickedListener = onItemClickedListener;
	}
}
