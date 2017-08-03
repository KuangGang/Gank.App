package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseFragment;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.local.LocalDataSource;
import com.kuanggang.gankapp.data.remote.RemoteDataSource;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.multitype.GankTimeDivide;
import com.kuanggang.gankapp.model.multitype.GankTitle;
import com.kuanggang.gankapp.model.multitype.GankWealImage;
import com.kuanggang.gankapp.model.param.GankResponseParam;
import com.kuanggang.gankapp.widget.adapter.GankCategoryAdapter;
import com.kuanggang.gankapp.widget.binder.GankContentBinder;
import com.kuanggang.gankapp.widget.binder.GankTimeDivideBinder;
import com.kuanggang.gankapp.widget.binder.GankTitleBinder;
import com.kuanggang.gankapp.widget.binder.GankWealImageBinder;
import com.kuanggang.gankapp.widget.customview.RefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author KG on 2017/6/5.
 */

public class GankFragment extends BaseFragment implements GankContract.View {

    /**
     * 当前选择的分类，默认为all
     */
    public static String NOW_CATEGORY = "all";

    @BindView(R.id.refreshlayout)
    RefreshLayout refreshlayout;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.rv_category)
    RecyclerView rvCategory;
    @BindView(R.id.rl_category)
    RelativeLayout rlCategory;

    private Unbinder unbinder;
    private MultiTypeAdapter mContentAdapter;
    private GankCategoryAdapter mCategoryAdapter;
    private GankContract.Presenter mPresenter;

    public static GankFragment newInstance() {
        return new GankFragment();
    }

    @Override
    public void setPresenter(@NonNull GankContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCategoryAdapter = new GankCategoryAdapter((GankActivity) getActivity());
        mContentAdapter = new MultiTypeAdapter();
        mContentAdapter.register(GankTitle.class, new GankTitleBinder());
        mContentAdapter.register(GankItem.class, new GankContentBinder());
        mContentAdapter.register(GankTimeDivide.class, new GankTimeDivideBinder());
        mContentAdapter.register(GankWealImage.class, new GankWealImageBinder());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gank, container, false);
        unbinder = ButterKnife.bind(this, root);

        init();
        initListener();
        return root;
    }

    private void init() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCategory.setLayoutManager(gridLayoutManager);
        rvCategory.setAdapter(mCategoryAdapter);

        rvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvContent.setAdapter(mContentAdapter);

        if (mPresenter == null) return;
        // 控制显示内容
        refreshlayout.setVisibility(mPresenter.getRequestParams().isCategory() ? View.GONE : View.VISIBLE);
        rlCategory.setVisibility(mPresenter.getRequestParams().isCategory() ? View.VISIBLE : View.GONE);

        mPresenter.loadFirstPage();
        if (mPresenter.getRequestParams().isCategory())
            mPresenter.checkNewVersion(getActivity());
    }

    private void initListener() {
        refreshlayout.setOnRefreshListener(() -> {
            mPresenter.getRequestParams().setCategory("");
            mPresenter.loadFirstPage();
        });
        refreshlayout.setOnLoadListener(() -> mPresenter.loadNextPage());
    }

    @Override
    public void showGankData(GankResponseParam mResponseParams) {
        mContentAdapter.setItems(mResponseParams.getHandleItems());
        mContentAdapter.notifyDataSetChanged();
        onRefreshLoadOk();
    }

    @Override
    public void onRefreshLoadOk() {
        if (refreshlayout == null) return;
        refreshlayout.setRefreshing(false);
        refreshlayout.setLoading(false);
    }

    @Override
    public void showRefreshAnim() {
        if (refreshlayout == null) return;
        refreshlayout.setRefreshing(true);
    }

    @Override
    public void scrollToHead() {
        if (rvContent == null) return;
        rvContent.scrollToPosition(0);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && mPresenter != null) {
            mPresenter.loadFirstPage();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder == null) return;
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter == null) return;
        mPresenter.onDestory();
    }
}
