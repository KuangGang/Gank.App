package com.kuanggang.gankapp.function.gankdetail;

import android.support.annotation.NonNull;

import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.RepositoryContract;
import com.kuanggang.gankapp.model.GankCategory;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.GankTimeDivide;
import com.kuanggang.gankapp.model.GankTitle;
import com.kuanggang.gankapp.model.param.GankRequestParam;
import com.kuanggang.gankapp.model.param.GankResponseParam;
import com.kuanggang.gankapp.model.type.PageSizeEnum;
import com.kuanggang.gankapp.utils.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author by KG on 2017/6/5.
 */

public class GankPresenter implements GankContract.Presenter {

    private GankContract.View mGankView;
    private DataRepository mDataRepository;

    private GankRequestParam mRequestParams;
    private GankResponseParam mResponseParams;

    public GankPresenter(@NonNull GankContract.View gankView, DataRepository dataRepository, boolean isCategory) {
        mGankView = gankView;
        mDataRepository = dataRepository;
        mRequestParams = new GankRequestParam(1, PageSizeEnum.TEN.size, isCategory);// default
        mResponseParams = new GankResponseParam();

        mGankView.setPresenter(this);
    }

    @Override
    public void loadFirstPage() {
        if (mRequestParams.isCategory() || GankFragment.NOW_CATEGORY.equals(mRequestParams.getCategory()))
            return;
        mGankView.showRefreshAnim();
        mRequestParams.setCategory(GankFragment.NOW_CATEGORY);
        mRequestParams.setPage(1);
        showGankDataByCategory();
    }

    @Override
    public void loadNextPage() {
        if (mRequestParams.isCategory()) return;
        int page = mRequestParams.getPage();
        mRequestParams.setPage(++page);
        showGankDataByCategory();
    }

    @Override
    public void showGankDataByCategory() {
        mDataRepository.getGankListByCategory(mRequestParams.getCategory(), mRequestParams.getPage(), mRequestParams.getSize(),
                new RepositoryContract.GetDataCallback<GankCategory>() {
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
                        mResponseParams.addItems(mRequestParams.getPage(), handleResults(entity));
                        mGankView.showGankData(mResponseParams);
                    }

                    @Override
                    public void onDataNotAvailable(Throwable throwable) {
                        mGankView.onRefreshLoadOk();
                    }
                });
    }

    private List<Object> handleResults(GankCategory entity) {
        List<Object> results = new ArrayList<>();
        List<GankItem> initResults = entity.results;
        if (initResults == null || initResults.size() <= 0)
            return results;

        for (int i = 0; i < initResults.size(); i++) {
            GankItem item = initResults.get(i);
            GankItem lastItem = initResults.get(i - 1);
            String nowDate = i > 0 ? item.publishedAt.split("T")[0] : new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String lastDate = i > 0 ? lastItem.publishedAt.split("T")[0] : item.publishedAt.split("T")[0];
            if (!nowDate.equals(lastDate)) {
                results.add(new GankTimeDivide(nowDate));
                results.add(new GankTitle(item.createdAt, item.publishedAt, item.type, item.url));
            } else {
                if (i > 0 && !lastItem.type.equals(item.type))
                    results.add(new GankTitle(item.createdAt, item.publishedAt, item.type, item.url));
                else if (i <= 0)
                    results.add(new GankTitle(item.createdAt, item.publishedAt, item.type, item.url));
            }
            results.add(item);
        }
        return results;
    }

    @Override
    public GankRequestParam getRequestParams() {
        return mRequestParams;
    }

    @Override
    public GankResponseParam getResponseParams() {
        return mResponseParams;
    }

    @Override
    public void onDestory() {
        mDataRepository.onDestory();
    }
}
