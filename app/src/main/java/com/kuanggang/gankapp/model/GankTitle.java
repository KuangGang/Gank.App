package com.kuanggang.gankapp.model;

/**
 * @author KG on 2017/7/24.
 */

public class GankTitle {
    public String createdAt;
    public String publishedAt;
    public String type;
    public String url;

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
