package com.kuanggang.gankapp;

/**
 * Created by KG on 2017/5/26.
 * 常量
 */
public interface Constants {
    /**
     * 读取超时时间
     */
    int READ_TIME_OUT = 10;
    /**
     * 连接超时时间
     */
    int CONNECT_TIME_OUT = 30;
    /**
     * 服务器地址（干货集中营的）
     */
    String BASE_URL = "http://gank.io/api/";
    /**
     * 传递网址数据的key
     */
    String URL_KEY = "url";
    /**
     * 获取图片URL列表的key
     */
    String IMAGE_URL_LIST_KEY = "image_url_list";
    /**
     * 获取当前图片URL
     */
    String IMAGE = "image";
}
