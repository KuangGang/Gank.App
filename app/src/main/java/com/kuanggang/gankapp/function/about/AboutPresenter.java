package com.kuanggang.gankapp.function.about;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.kuanggang.gankapp.Constants;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.RepositoryContract;
import com.kuanggang.gankapp.function.browser.BrowserActivity;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.utils.update.UpdateHelper;
import com.kuanggang.gankapp.utils.update.VersionEntity;

/**
 * @author by KG on 2017/8/2.
 */

public class AboutPresenter implements AboutContract.Presenter {

    private AboutContract.View mGankView;
    private DataRepository mDataRepository;

    private UpdateHelper updateHelper;

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
    public void checkNewVersion(Activity activity) {
        mDataRepository.getNowVersion(new RepositoryContract.GetDataCallback<VersionEntity>() {
            @Override
            public void onDataLoaded(VersionEntity entity) {
                updateHelper = new UpdateHelper(activity);
                updateHelper.dealWithVersion(entity);
            }

            @Override
            public void onDataNotAvailable(Throwable throwable) {
                mGankView.showToast("已是最新版本");
            }
        });
    }

    @Override
    public void onDestory() {
        mDataRepository.onDestory();
        if (updateHelper != null){
            updateHelper.unInit();
        }
    }
}
