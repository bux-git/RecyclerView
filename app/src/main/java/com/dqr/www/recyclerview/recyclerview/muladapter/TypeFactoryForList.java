package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.View;

import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.PageBen;
import com.dqr.www.recyclerview.bean.WelfareBean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 15:31
 */

public class TypeFactoryForList implements  TypeFactory {

    private final int TYPE_RESOURCE_GRID= R.layout.grid_meizi_item;
    private final int TYPE_RESOURCE_PAGE=R.layout.page_item;


    @Override
    public int type(WelfareBean bean) {
        return TYPE_RESOURCE_GRID;
    }

    @Override
    public int type(PageBen page) {
        return TYPE_RESOURCE_PAGE;
    }

    @Override
    public MulViewHolder createViewHolder(int type, View itemView) {
        if(type==TYPE_RESOURCE_GRID){
            return new GirlViewHolder(itemView);
        }else if(type==TYPE_RESOURCE_PAGE){
            return new PageViewHolder(itemView);
        }
        return null;
    }
}
