package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.model.GankCategory;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.param.GankRequestParam;
import com.kuanggang.gankapp.model.param.GankResponseParam;
import com.kuanggang.gankapp.widget.binder.GankTextViewBinder;
import com.kuanggang.gankapp.widget.customview.RefreshLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author KG on 2017/6/5.
 */

public class GankFragment extends Fragment implements GankContract.View {

    private static final String BUNDLE_KEY = "key";

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    RefreshLayout refreshlayout;

    private Unbinder unbinder;
    private MultiTypeAdapter mAdapter;
    private GankRequestParam mRequestParams;
    private GankResponseParam mResponseParams;
    private GankContract.Presenter mPresenter;

    public static GankFragment newInstance(String key) {
        GankFragment fragment = new GankFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, key);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(@NonNull GankContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mResponseParams = new GankResponseParam();
        mRequestParams = new GankRequestParam();
        mRequestParams.setPage(1);
        mRequestParams.setSize(15);

        mAdapter = new MultiTypeAdapter();
        mAdapter.register(GankItem.class, new GankTextViewBinder());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gank, container, false);
        unbinder = ButterKnife.bind(this, root);
        mRequestParams.setCategory(getArguments().getString(BUNDLE_KEY));
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(mAdapter);

        loadData();
        initListener();
        return root;
    }

    private void loadData() {
        mPresenter.showGankDataByCategory(mRequestParams.getCategory(), mRequestParams.getPage(), mRequestParams.getSize());
    }

    private void initListener() {
        refreshlayout.setOnRefreshListener(() -> {
            mRequestParams.setPage(1);
            loadData();
        });
        refreshlayout.setOnLoadListener(() -> {
            int page = mRequestParams.getPage();
            mRequestParams.setPage(++page);
            loadData();
        });
    }

    @Override
    public void showGankData(GankCategory gankCategory) {
        mResponseParams.addItems(mRequestParams.getPage(), gankCategory.results);
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
