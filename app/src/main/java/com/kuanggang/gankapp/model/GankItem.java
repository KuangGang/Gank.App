package com.kuanggang.gankapp.model;

import java.util.List;

/**
 * @author KG on 2017/6/14.
 */

public class GankItem {
    public String _id;
    public String desc;
    public String createdAt;
    public String publishedAt;
    public String source;
    public String type;
    public String url;
    public String who;
    public List<String> images;

    @Override
    public String toString() {
        return "GankItem{" +
                "_id='" + _id + '\'' +
                ", desc='" + desc + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", who='" + who + '\'' +
                ", images=" + images +
                '}';
    }
}
