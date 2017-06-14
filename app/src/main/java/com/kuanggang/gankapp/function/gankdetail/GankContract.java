package com.kuanggang.gankapp.function.gankdetail;

import com.kuanggang.gankapp.base.BasePresenter;
import com.kuanggang.gankapp.base.BaseView;

/**
 * @author by KG on 2017/6/5.
 */

public interface GankContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        
        void showGankDataByCategory(String category, int page, int size);
    }
}
