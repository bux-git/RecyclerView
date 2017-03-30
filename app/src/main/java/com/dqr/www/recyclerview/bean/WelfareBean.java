package com.dqr.www.recyclerview.bean;

import com.dqr.www.recyclerview.recyclerview.muladapter.TypeFactory;
import com.dqr.www.recyclerview.recyclerview.muladapter.Visitable;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-28 14:51
 */

public class WelfareBean implements Visitable{
    /**
     * _id : 58d9b4e0421aa969f75cedeb
     * createdAt : 2017-03-28T08:57:04.208Z
     * desc : 3-28
     * publishedAt : 2017-03-28T12:05:55.791Z
     * source : chrome
     * type : 福利
     * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-28-17494350_115579865647756_2448160714821468160_n.jpg
     * used : true
     * who : dmj
     */
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
}
