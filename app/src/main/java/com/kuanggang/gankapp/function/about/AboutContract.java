package com.kuanggang.gankapp.function.about;

import android.content.Context;

import com.kuanggang.gankapp.base.BasePresenter;
import com.kuanggang.gankapp.base.BaseView;
import com.kuanggang.gankapp.model.param.GankRequestParam;
import com.kuanggang.gankapp.model.param.GankResponseParam;

/**
 * @author by KG on 2017/8/2.
 */

interface AboutContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void openGankIO(Context context);

        void onDestory();

    }
}
