package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.PageBen;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:46
 */

public class PageViewHolder extends MulViewHolder<PageBen>  {

    public PageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpView(PageBen data, int position, RecyclerView.Adapter adapter) {
        setText(R.id.tv_page, "Page " + data.getPage());
    }
}
