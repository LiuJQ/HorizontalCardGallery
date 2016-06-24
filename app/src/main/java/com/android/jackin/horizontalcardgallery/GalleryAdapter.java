package com.android.jackin.horizontalcardgallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuJQ on 2016/6/24.
 */
public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mItemList;
    private final LayoutInflater mLayoutInflater;

    public GalleryAdapter(Context context, List<String> mItemList) {
        this.mItemList = mItemList;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<String> data) {
        if (mItemList == null) {
            mItemList = new ArrayList<>();
        }
        if (data != null) {
            mItemList.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GalleryItemViewHolder(mLayoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final GalleryItemViewHolder viewHolder = (GalleryItemViewHolder) holder;
        viewHolder.mCoverImage.setImageResource(position % 2 == 0 ? R.mipmap.cheese_1 : R.mipmap.cheese_2);
        viewHolder.mTitle.setText(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList != null ? mItemList.size() : 0;
    }

    class GalleryItemViewHolder extends RecyclerView.ViewHolder {

        ImageView mCoverImage;
        TextView mTitle;

        public GalleryItemViewHolder(View itemView) {
            super(itemView);

            mCoverImage = (ImageView) itemView.findViewById(R.id.list_item_cover);
            mTitle = (TextView) itemView.findViewById(R.id.list_item_title);
        }
    }

}
