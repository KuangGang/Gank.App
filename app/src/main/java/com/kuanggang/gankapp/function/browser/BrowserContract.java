package com.kuanggang.gankapp.function.browser;

import com.kuanggang.gankapp.base.BasePresenter;
import com.kuanggang.gankapp.base.BaseView;

/**
 * @author KG on 2017/7/5.
 */

public class BrowserContract {
    interface View extends BaseView<BrowserContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
