package com.kuanggang.gankapp.function.browser;

import android.support.annotation.NonNull;

import com.kuanggang.gankapp.data.DataRepository;

/**
 * @author KG on 2017/7/5.
 */

public class BrowserPresenter implements BrowserContract.Presenter {

    private BrowserContract.View mBrowserView;
    private DataRepository mDataRepository;

    public BrowserPresenter(@NonNull BrowserContract.View browserView, DataRepository dataRepository) {
        mBrowserView = browserView;
        mDataRepository = dataRepository;

        mBrowserView.setPresenter(this);
    }
}
