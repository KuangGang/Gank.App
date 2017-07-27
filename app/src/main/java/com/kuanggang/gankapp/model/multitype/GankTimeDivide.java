package com.kuanggang.gankapp.model.multitype;

/**
 * @author KG on 2017/7/24.
 */

public class GankTimeDivide {
    public String publishedAt;

    public GankTimeDivide(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "GankTimeDivide{" +
                "publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
