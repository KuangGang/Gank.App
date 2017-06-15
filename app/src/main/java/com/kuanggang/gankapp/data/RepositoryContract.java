package com.kuanggang.gankapp.data;

import com.kuanggang.gankapp.base.BaseLocalRepository;
import com.kuanggang.gankapp.base.BaseRemoteRepository;

/**
 * @author KG on 2017/6/7.
 */

public interface RepositoryContract {

    interface GetDataCallback<T> {

        void onDataLoaded(T entity);

        void onDataNotAvailable(Throwable throwable);
    }

    interface RemoteRepository extends BaseRemoteRepository {
        void getGankListByCategory(String category, int page, int size, GetDataCallback getDataCallback);

        void onDestory();
    }

    interface LocalRepository extends BaseLocalRepository {

    }
}
