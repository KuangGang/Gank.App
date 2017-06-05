package com.kuanggang.gankapp.model;

/**
 * @author KG on 2017/6/5.
 */
public class GankItemTitle extends GankItem {

    public GankItemTitle() {
    }

    public GankItemTitle(GankItem item) {
        type = item.type;
        desc = item.desc;
        who = item.who;
        url = item.url;
        images = item.images;
        createdAt = item.createdAt;
        publishedAt = item.publishedAt;
    }

}
