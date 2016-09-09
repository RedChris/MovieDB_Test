package uk.co.test.chris.moviedb.ui.homescreen.movietab.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uk.co.test.chris.moviedb.R;
import uk.co.test.chris.moviedb.ui.homescreen.movietab.model.PhotoListItemModel;

/**
 * Created by Chris on 09/09/2016.
 */
public class MovieTabAdapter extends RecyclerView.Adapter<MovieTabAdapter.ViewHolder> {

	private Context mContext;
	private List<PhotoListItemModel> mItems = new ArrayList<>();
	private OnItemClickedListener mOnItemClickedListener;

	public MovieTabAdapter(Context context) {
		mContext = context;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_tab_list_grid, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		final PhotoListItemModel item = mItems.get(position);

		String imageUrl = item.getImage();
		if (imageUrl != null) {
			int targetWidth = 150;
			int targetHeight = 200;
			Picasso.with(mContext).load(imageUrl).resize(targetWidth, targetHeight).centerCrop().into(holder.mImageHolder);
		} else {
			holder.mImageHolder.setImageDrawable(null);
		}

		holder.mTitle.setText(item.getTitle());

		holder.itemView.setOnClickListener(view -> {
			if (mOnItemClickedListener != null) {
				mOnItemClickedListener.onItemClicked(item.getId());
			}
		});
	}

	@Override
	public int getItemCount() {
		return mItems.size();
	}

	public void updateItems(List<PhotoListItemModel> items) {
		mItems.clear();
		mItems.addAll(items);
		notifyDataSetChanged();
	}

	public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
		mOnItemClickedListener = onItemClickedListener;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public final ImageView mImageHolder;
		public final TextView mTitle;

		public ViewHolder(View view) {
			super(view);
			mImageHolder = (ImageView) view.findViewById(R.id.image);
			mTitle = (TextView) view.findViewById(R.id.title);
		}
	}

	public interface OnItemClickedListener {

		void onItemClicked(Integer itemId);
	}

}
