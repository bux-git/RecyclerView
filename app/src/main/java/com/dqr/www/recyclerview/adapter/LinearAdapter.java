package com.dqr.www.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;

import com.dqr.www.recyclerview.bean.WelfareBean;
import com.dqr.www.recyclerview.recyclerview.BaseAdapter;
import com.dqr.www.recyclerview.recyclerview.ViewHolder;

import java.util.Collection;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 14:43
 */

public class LinearAdapter extends BaseAdapter<WelfareBean> {

    public LinearAdapter(RecyclerView recyclerView, Collection<WelfareBean> data, int itemLayoutId) {
        super(recyclerView, data, itemLayoutId);
    }

    @Override
    public void bindData(ViewHolder holder, WelfareBean item, int position, boolean isScrolling) {

    }
}
