package com.kuanggang.gankapp.function.gankdetail;

import com.kuanggang.gankapp.base.BasePresenter;
import com.kuanggang.gankapp.base.BaseView;
import com.kuanggang.gankapp.model.GankCategory;

/**
 * @author by KG on 2017/6/5.
 */

interface GankContract {

    interface View extends BaseView<Presenter> {
        void onRefreshOk();
        void showGankData(GankCategory gankCategory);
    }

    interface Presenter extends BasePresenter {
        void showGankDataByCategory(String category, int page, int size);
        void onDestory();
    }
}
