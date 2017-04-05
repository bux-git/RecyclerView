package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.View;

import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.PageBen;
import com.dqr.www.recyclerview.bean.WelfareBean;
import com.dqr.www.recyclerview.bean.WelfareBean2;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:13
 */

public class TypeFactoryList implements TypeFactory {
    private static final int TYPE_MEIZI_RESOURCE = R.layout.grid_meizi_item;
    private static final int TYPE_PAGE_RESOURCE = R.layout.page_item;
    private static final int TYPE_MEIZI2_RESOURCE = R.layout.grid_meizi_item2;

    @Override
    public int type(PageBen pageBen) {
        return TYPE_PAGE_RESOURCE;
    }

    @Override
    public int type(WelfareBean bean) {
        return TYPE_MEIZI_RESOURCE;
    }

    @Override
    public int type(WelfareBean2 bean2) {
        return TYPE_MEIZI2_RESOURCE;
    }

    @Override
    public int getSpanSize(PageBen pageBen) {
        return 2;
    }

    @Override
    public int getSpanSize(WelfareBean bean) {
        return 2;
    }

    @Override
    public int getSpanSize(WelfareBean2 bean2) {
        return 1;
    }

    @Override
    public MulViewHolder createViewHolder(int viewType, View itemView) {
        if (viewType == TYPE_MEIZI_RESOURCE) {
            return new WelOneHolder(itemView);
        } else if (viewType == TYPE_PAGE_RESOURCE) {
            return new PageViewHolder(itemView);
        } else if (viewType == TYPE_MEIZI2_RESOURCE) {
            return new WelTwoHolder(itemView);
        }
        return null;
    }


}
