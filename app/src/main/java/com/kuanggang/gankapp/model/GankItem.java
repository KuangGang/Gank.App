package com.kuanggang.gankapp.model;

/**
 * @author KG on 2017/6/14.
 */

public class GankItem {
    public String desc;
    public String ganhuo_id;
    public String publishedAt;
    public String type;
    public String url;
    public String who;

    @Override
    public String toString() {
        return "GankItem{" +
                "desc='" + desc + '\'' +
                ", ganhuo_id='" + ganhuo_id + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", who='" + who + '\'' +
                '}';
    }
}
