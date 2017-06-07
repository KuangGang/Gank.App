package com.kuanggang.gankapp.data.remote;

import com.kuanggang.gankapp.data.DataSource;
import com.kuanggang.gankapp.data.RepositoryContract;

/**
 * @author KG on 2017/6/7.
 */

public class RemoteDataSource implements RepositoryContract.RemoteRepository {

    @Override
    public void onSuccess(DataSource entity) {

    }

    @Override
    public void onFail(String msg) {

    }
}
