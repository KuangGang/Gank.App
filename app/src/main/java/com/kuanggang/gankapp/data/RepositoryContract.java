package com.kuanggang.gankapp.data;

import com.kuanggang.gankapp.base.BaseLocalRepository;
import com.kuanggang.gankapp.base.BaseRemoteRepository;

/**
 * @author KG on 2017/6/7.
 */

public interface RepositoryContract {

    interface GetDataCallback<T> {

        void onDataLoaded(T entity);

        void onDataNotAvailable(String msg);
    }

    interface RemoteRepository extends BaseRemoteRepository{
        void getGankDay(GetDataCallback getDataCallback);
    }

    interface LocalRepository extends BaseLocalRepository{

    }
}
