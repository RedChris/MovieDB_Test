package uk.co.test.chris.moviedb.ui.homescreen.gridlist.classes;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Chris on 09/09/2016.
 */
public class GridListItemDecorator extends RecyclerView.ItemDecoration {


	private int spanCount;
	private int spacing;
	private boolean includeEdge;

	public GridListItemDecorator(int spanCount, int spacing) {
		this.spanCount = spanCount;
		this.spacing = spacing;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		int position = parent.getChildAdapterPosition(view); // item position
		int column = position % spanCount; // item column

		outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
		outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
		if (position >= spanCount) {
			outRect.top = spacing; // item top
		}
	}
}