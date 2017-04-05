package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.WelfareBean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:48
 */

public class WelOneHolder extends MulViewHolder<WelfareBean> {

    public WelOneHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(WelfareBean data, int position, RecyclerView.Adapter adapter) {
        ImageButton imageButton=getView(R.id.iv_btn);
        Glide.with(itemView.getContext()).load(data.getUrl()).into(imageButton);
        final MulAdapter mulAdapter= (MulAdapter) adapter;
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mulAdapter.getDragSwipeListener().onStartDrag(WelOneHolder.this);
                return false;
            }
        });

    }
}
