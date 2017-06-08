package com.kuanggang.gankapp;

import android.app.Application;
import android.graphics.Typeface;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * @author KG on 2017/6/5.
 */

public class GankApp extends Application{

    public static Application application;
    public static Typeface mingTf;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mingTf = Typeface.createFromAsset(getAssets(), "PMingLiU.ttf");

        Logger.init("GankApp").logLevel(BuildConfig.isDebug ? LogLevel.FULL : LogLevel.NONE);
    }
}
