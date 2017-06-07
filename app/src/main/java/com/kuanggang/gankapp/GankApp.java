package com.kuanggang.gankapp;

import android.app.Application;
import android.graphics.Typeface;

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
    }
}
