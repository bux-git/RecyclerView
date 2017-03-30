package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.View;

import com.dqr.www.recyclerview.bean.PageBen;
import com.dqr.www.recyclerview.bean.WelfareBean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 15:29
 */

public interface TypeFactory {

    int type(WelfareBean bean);
    int type(PageBen page);

    MulViewHolder createViewHolder(int type,View itemView);
}
