package com.dqr.www.recyclerview.bean;

import com.dqr.www.recyclerview.recyclerview.muladapter.TypeFactory;
import com.dqr.www.recyclerview.recyclerview.muladapter.Visitable;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:11
 */

public class WelfareBean2 implements Visitable {
    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private int page;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

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
    @Override
    public int getSpanSize(TypeFactory typeFactory) {
        return typeFactory.getSpanSize(this);
    }

}
