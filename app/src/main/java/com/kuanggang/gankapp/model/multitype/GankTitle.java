package com.kuanggang.gankapp.model.multitype;

/**
 * @author KG on 2017/7/24.
 */

public class GankTitle {
    public String createdAt;
    public String publishedAt;
    public String type;
    public String url;

    public GankTitle(String createdAt, String publishedAt, String type, String url) {
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.type = type;
        this.url = url;
    }

    @Override
    public String toString() {
        return "GankTitle{" +
                "createdAt='" + createdAt + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
