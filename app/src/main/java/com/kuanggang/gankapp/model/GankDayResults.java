package com.kuanggang.gankapp.model;

import java.util.List;

/**
 * @author KG on 2017/6/5.
 */
public class GankDayResults {

    public List<GankItemGirl> 福利;
    public List<GankItem> Android;
    public List<GankItem> iOS;
    public List<GankItem> App;
    public List<GankItem> 瞎推荐;
    public List<GankItem> 休息视频;

    @Override
    public String toString() {
        return "GankDayResults{" +
                "福利=" + 福利 +
                ", Android=" + Android +
                ", iOS=" + iOS +
                ", App=" + App +
                ", 瞎推荐=" + 瞎推荐 +
                ", 休息视频=" + 休息视频 +
                '}';
    }
}
