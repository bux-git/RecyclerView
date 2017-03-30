package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.View;

import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.PageBen;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 16:01
 */

public class PageViewHolder extends MulViewHolder<PageBen> {

    public PageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpVew(PageBen model, int position, MultiTypeAdapter multiTypeAdapter) {
        setText(R.id.tv_page, model.getPage() + "");
    }
}
