package com.dqr.www.recyclerview.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 8:51
 */

public interface OnStartDragSwipeListener {
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
    void onStartSwipe(RecyclerView.ViewHolder viewHolder);
}
