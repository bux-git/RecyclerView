package com.dqr.www.recyclerview.listener;

import android.support.v7.widget.RecyclerView;

public interface OnRecyclerItemClickListener {
    void onItemClick(RecyclerView.ViewHolder viewHolder, int position);

    void onItemLongClick(RecyclerView.ViewHolder viewHolder, int position);

    void onItemTouch(RecyclerView.ViewHolder viewHolder, int position);
}