package com.kuanggang.gankapp.data;

import com.kuanggang.gankapp.base.BaseLocalRepository;
import com.kuanggang.gankapp.base.BaseRemoteRepository;

/**
 * @author KG on 2017/6/7.
 */

public interface RepositoryContract {

    interface RemoteRepository extends BaseRemoteRepository{

        void onSuccess(DataSource entity);

        void onFail(String msg);
    }

    interface LocalRepository extends BaseLocalRepository{

    }
}
