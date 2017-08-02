package com.kuanggang.gankapp.function.about;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.kuanggang.gankapp.Constants;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.function.browser.BrowserActivity;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.param.GankRequestParam;
import com.kuanggang.gankapp.model.param.GankResponseParam;
import com.kuanggang.gankapp.model.type.PageSizeEnum;

/**
 * @author by KG on 2017/8/2.
 */

public class AboutPresenter implements AboutContract.Presenter {

    private AboutContract.View mGankView;
    private DataRepository mDataRepository;

    public AboutPresenter(@NonNull AboutContract.View gankView, DataRepository dataRepository) {
        mGankView = gankView;
        mDataRepository = dataRepository;

        mGankView.setPresenter(this);
    }

    @Override
    public void openGankIO(Context context) {
        GankItem gankItem = new GankItem();
        gankItem.type = "干货集中营";
        gankItem.url = "http://gank.io/";

        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra(Constants.URL_KEY, gankItem);
        context.startActivity(intent);
    }

    @Override
    public void onDestory() {
        mDataRepository.onDestory();
    }
}
