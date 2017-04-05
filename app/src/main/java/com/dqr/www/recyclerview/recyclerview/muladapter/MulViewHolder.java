package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dqr.www.recyclerview.recyclerview.ViewHolder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:23
 */

public abstract class MulViewHolder<T> extends ViewHolder {

    public MulViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setUpView(T data, int position, RecyclerView.Adapter adapter);
}
