package com.kuanggang.gankapp;

import android.app.Application;

/**
 * @author KG on 2017/6/5.
 */

public class GankApp extends Application{

    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
