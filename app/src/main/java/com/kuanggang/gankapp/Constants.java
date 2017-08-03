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
     * fir上的app_id
     */
    String FIR_IM_APP_ID = "59829e94ca87a81d48000646";

    /**
     * fir上的api_token
     */
    String FIR_IM_API_TOKEN = "c59f703353b9d97065f955a85122d104";

    /**
     * 服务器地址（干货集中营的）
     */
    String BASE_URL = "http://gank.io/api/";

    /**
     * 获取最新版本号
     */
    String APP_VERSION_URL = "http://api.fir.im/apps/latest/" + FIR_IM_APP_ID + "?api_token=" + FIR_IM_API_TOKEN + "&type=android";

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
