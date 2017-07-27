package com.kuanggang.gankapp.model.multitype;

/**
 * @author KG on 2017/7/27.
 */

public class GankWealImage {
    public String imageUrl;

    public GankWealImage(String url) {
        this.imageUrl = url;
    }

    @Override
    public String toString() {
        return "GankWealImage{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
