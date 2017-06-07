package com.kuanggang.gankapp.function.gankdetail;

import android.support.annotation.NonNull;

/**
 * @author by KG on 2017/6/5.
 */

public class GankPresenter implements GankContract.Presenter {

    private GankContract.View mGankView;

    public GankPresenter(@NonNull GankContract.View gankView) {
        mGankView = gankView;
        gankView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
