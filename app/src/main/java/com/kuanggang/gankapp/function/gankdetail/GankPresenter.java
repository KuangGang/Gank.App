package com.kuanggang.gankapp.function.gankdetail;

import android.support.annotation.NonNull;

import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.RepositoryContract;
import com.kuanggang.gankapp.model.GankCategory;
import com.kuanggang.gankapp.utils.ToastUtil;

/**
 * @author by KG on 2017/6/5.
 */

public class GankPresenter implements GankContract.Presenter {

    private GankContract.View mGankView;
    private DataRepository mDataRepository;

    public GankPresenter(@NonNull GankContract.View gankView, DataRepository dataRepository) {
        mGankView = gankView;
        mDataRepository = dataRepository;

        gankView.setPresenter(this);
    }

    @Override
    public void showGankDataByCategory(String category, int page, int size) {
        mDataRepository.getGankListByCategory(category, page, size, new RepositoryContract.GetDataCallback<GankCategory>() {
            @Override
            public void onDataLoaded(GankCategory entity) {
                if (entity.error) {
                    ToastUtil.show(GankApp.application, R.string.net_error);
                    return;
                }
                if (entity.results == null || entity.results.size() <= 0) {
                    ToastUtil.show(GankApp.application, R.string.no_data);
                    return;
                }
                mGankView.showGankData(entity);
            }

            @Override
            public void onDataNotAvailable(Throwable throwable) {
                mGankView.onRefreshLoadOk();
            }
        });
    }

    @Override
    public void onDestory() {
        mDataRepository.onDestory();
    }
}
