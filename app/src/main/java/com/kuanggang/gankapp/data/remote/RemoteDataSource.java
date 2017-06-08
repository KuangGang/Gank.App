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
     * 获取干货数据
     */
    @Override
    public void getGankDay(final RepositoryContract.GetDataCallback getDataCallback) {
        ApiService.getApi().getGanDay(2017, 6, 8)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(gankDay -> gankDay != null && gankDay.results != null)
                .subscribe(gankDay -> getDataCallback.onDataLoaded(gankDay),
                        throwable -> getDataCallback.onDataNotAvailable(throwable.toString()));
    }
}
