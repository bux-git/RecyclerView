package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.View;

import com.dqr.www.recyclerview.recyclerview.ViewHolder;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 15:25
 */

public abstract class MulViewHolder<T> extends ViewHolder {

    public MulViewHolder(View itemView) {
        super(itemView);
    }

    public MulViewHolder(View itemView, int count) {
        super(itemView, count);
    }

    public abstract void setUpVew(T model,int position,MultiTypeAdapter multiTypeAdapter);
}
