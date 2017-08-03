package com.kuanggang.gankapp.data;

/**
 * @author KG on 2017/6/8.
 */

public class DataRepository implements RepositoryContract.RemoteRepository, RepositoryContract.LocalRepository {

    private RepositoryContract.RemoteRepository mRemoteDataSource;
    private RepositoryContract.LocalRepository mLocalDataSource;

    public DataRepository(RepositoryContract.RemoteRepository remoteDataSource, RepositoryContract.LocalRepository localDataSource) {
        this.mRemoteDataSource = remoteDataSource;
        this.mLocalDataSource = localDataSource;
    }

    /************************************网络数据**************************************/
    @Override
    public void getGankListByCategory(String category, int page, int size, RepositoryContract.GetDataCallback getDataCallback) {
        mRemoteDataSource.getGankListByCategory(category, page, size, getDataCallback);
    }

    @Override
    public void getNowVersion(RepositoryContract.GetDataCallback getDataCallback) {
        mRemoteDataSource.getNowVersion(getDataCallback);
    }

    @Override
    public void onDestory() {
        mRemoteDataSource.onDestory();
    }
}
