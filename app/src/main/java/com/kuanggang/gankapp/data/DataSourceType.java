package com.kuanggang.gankapp.data;

/**
 * @author KG on 2017/6/7.
 */

public enum DataSourceType {
    GANK_DATA(1, "获取GANK数据");

    public int code;
    public String type;

    DataSourceType(int code, String type) {
        this.code = code;
        this.type = type;
    }
}
