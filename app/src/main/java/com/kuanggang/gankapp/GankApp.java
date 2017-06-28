package com.kuanggang.gankapp;

import android.app.Application;
import android.graphics.Typeface;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * @author KG on 2017/6/5.
 */

public class GankApp extends Application {

    public static Application application;
    public static Typeface titleTf;
    public static Typeface contentTf;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        titleTf = Typeface.createFromAsset(getAssets(), "PMingLiU.ttf");
        contentTf = Typeface.createFromAsset(getAssets(), "PingFang_SC_Regular.ttf");

        Logger.init("GankApp").logLevel(BuildConfig.isDebug ? LogLevel.FULL : LogLevel.NONE);
    }
}
