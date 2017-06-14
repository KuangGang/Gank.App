package com.kuanggang.gankapp.data.remote;

import com.kuanggang.gankapp.data.RepositoryContract;
import com.kuanggang.gankapp.network.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author KG on 2017/6/7.
 */

public class RemoteDataSource implements RepositoryContract.RemoteRepository {

    /**
     * 根据分类获取gank数据
     */
    @Override
    public void getGankListByCategory(String category, int page, int size, RepositoryContract.GetDataCallback getDataCallback) {
        ApiService.getApi().getGankListByCategory(category, page, size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(gankCategory -> gankCategory != null && gankCategory.results != null)
                .subscribe(getDataCallback::onDataLoaded,
                        getDataCallback::onDataNotAvailable);
    }
}
