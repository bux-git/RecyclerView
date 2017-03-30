package com.dqr.www.recyclerview.bean;

import com.dqr.www.recyclerview.recyclerview.muladapter.TypeFactory;
import com.dqr.www.recyclerview.recyclerview.muladapter.Visitable;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 15:52
 */

public class PageBen implements Visitable{
    int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
