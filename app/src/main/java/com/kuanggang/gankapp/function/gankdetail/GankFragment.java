package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

/**
 * @author KG on 2017/6/5.
 */

public class GankFragment extends Fragment implements GankContract.View {

    private static final String BUNDLE_KEY = "key";

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter.showGankDay();
        Logger.d(getArguments().getString(BUNDLE_KEY));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
