package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.View;

import com.dqr.www.recyclerview.bean.PageBen;
import com.dqr.www.recyclerview.bean.WelfareBean;
import com.dqr.www.recyclerview.bean.WelfareBean2;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:09
 */

public interface TypeFactory {
    int type(PageBen pageBen);
    int type(WelfareBean bean);
    int type(WelfareBean2 bean2);

    int getSpanSize(PageBen pageBen);
    int getSpanSize(WelfareBean bean);
    int getSpanSize(WelfareBean2 bean2);

    MulViewHolder createViewHolder(int viewType,View itemView);
}
