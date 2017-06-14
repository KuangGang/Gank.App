package com.kuanggang.gankapp.function.gankdetail;

import android.support.annotation.NonNull;

import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.RepositoryContract;
import com.kuanggang.gankapp.model.GankCategory;
import com.orhanobut.logger.Logger;

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
                Logger.d(entity.toString());
            }

            @Override
            public void onDataNotAvailable(Throwable throwable) {
            }
        });
    }
}
