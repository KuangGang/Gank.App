package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * @author KG on 2017/6/5.
 */

public class GankFragment extends Fragment implements GankContract.View {

    private GankContract.Presenter mPresenter;

    public static GankFragment newInstance() {
        Bundle args = new Bundle();
        GankFragment fragment = new GankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setPresenter(@NonNull GankContract.Presenter presenter) {
        mPresenter  = presenter;
    }
}
