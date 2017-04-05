package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.WelfareBean2;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:48
 */

public class WelTwoHolder extends MulViewHolder<WelfareBean2> {

    public WelTwoHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(WelfareBean2 data, int position, RecyclerView.Adapter adapter) {
        setImageResource(R.id.iv_btn,data.getUrl());
    }
}
