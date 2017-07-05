package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseFragment;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.param.GankResponseParam;
import com.kuanggang.gankapp.widget.binder.GankTextViewBinder;
import com.kuanggang.gankapp.widget.customview.RefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author KG on 2017/6/5.
 */

public class GankFragment extends BaseFragment implements GankContract.View {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    RefreshLayout refreshlayout;

    private Unbinder unbinder;
    private MultiTypeAdapter mAdapter;
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

        mAdapter = new MultiTypeAdapter();
        mAdapter.register(GankItem.class, new GankTextViewBinder());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gank, container, false);
        unbinder = ButterKnife.bind(this, root);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(mAdapter);
        mPresenter.loadFirstPage();
        initListener();
        return root;
    }

    private void initListener() {
        refreshlayout.setOnRefreshListener(() -> mPresenter.loadFirstPage());
        refreshlayout.setOnLoadListener(() -> mPresenter.loadNextPage());
    }

    @Override
    public void showGankData(GankResponseParam mResponseParams) {
        mAdapter.setItems(mResponseParams.getItems());
        mAdapter.notifyDataSetChanged();
        onRefreshLoadOk();
    }

    @Override
    public void onRefreshLoadOk() {
        if (refreshlayout == null) return;
        refreshlayout.setRefreshing(false);
        refreshlayout.setLoading(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
    }
}
