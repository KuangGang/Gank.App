package com.kuanggang.gankapp.function.gankdetail;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.RepositoryContract;
import com.kuanggang.gankapp.model.GankCategory;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.multitype.GankTimeDivide;
import com.kuanggang.gankapp.model.multitype.GankTitle;
import com.kuanggang.gankapp.model.multitype.GankWealImage;
import com.kuanggang.gankapp.model.param.GankRequestParam;
import com.kuanggang.gankapp.model.param.GankResponseParam;
import com.kuanggang.gankapp.model.type.CategoryEnum;
import com.kuanggang.gankapp.model.type.PageSizeEnum;
import com.kuanggang.gankapp.utils.DateUtil;
import com.kuanggang.gankapp.utils.ToastUtil;

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
        mRequestParams = new GankRequestParam(1, PageSizeEnum.TWENTY.size, isCategory);// default
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
                        mResponseParams.setInitItems(mRequestParams.getPage(), entity.results);
                        mResponseParams.setHandleItems(handleResults(mResponseParams.getInitItems()));
                        mGankView.showGankData(mResponseParams);
                        if (mRequestParams.getPage() == 1)
                            mGankView.scrollToHead();
                    }

                    @Override
                    public void onDataNotAvailable(Throwable throwable) {
                        mGankView.onRefreshLoadOk();
                    }
                });
    }

    /**
     * 将服务器返回数据进行处理
     * 加入Title，Divide
     */
    private List<Object> handleResults(List<GankItem> initResults) {
        List<Object> results = new ArrayList<>();
        if (initResults == null || initResults.size() <= 0)
            return results;

        if (mRequestParams.getCategory().equals(CategoryEnum.WEAL.category)) {
            for (int i = 0; i < initResults.size(); i++) {
                results.add(new GankWealImage(initResults.get(i).url));
            }
            return results;
        }

        for (int i = 0; i < initResults.size(); i++) {
            String nowDate;
            String lastDate;
            GankItem item = initResults.get(i);
            if (i > 0) {
                GankItem lastItem = initResults.get(i - 1);
                nowDate = item.publishedAt.split("T")[0];
                lastDate = lastItem.publishedAt.split("T")[0];

                if (!nowDate.equals(lastDate))
                    addDivideAndTitle(results, nowDate, item, true);
                else if (!lastItem.type.equals(item.type))
                    addDivideAndTitle(results, null, item, true);
            } else {
                nowDate = DateUtil.convertDate2String(new Date());
                lastDate = item.publishedAt.split("T")[0];

                if (!nowDate.equals(lastDate))
                    addDivideAndTitle(results, lastDate, item, true);
                else
                    addDivideAndTitle(results, null, item, false);
            }
            results.add(item.type.equals(CategoryEnum.WEAL.category) ? new GankWealImage(item.url) : item);
        }
        return results;
    }

    private void addDivideAndTitle(List<Object> results, String date, GankItem item, boolean isAddDivide) {
        if (isAddDivide) {
            if (!TextUtils.isEmpty(date)) {
                date = DateUtil.convertString2String(date, "M月dd日");
                date = date.replaceAll("", " ");
                date = date.substring(1, date.length() - 1);
            }
            results.add(new GankTimeDivide(date));
        }
        results.add(new GankTitle(item.createdAt, item.publishedAt, item.type, item.url));
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
