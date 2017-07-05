package com.kuanggang.gankapp.function.browser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseFragment;

/**
 * @author KG on 2017/7/5.
 */

public class BrowserFragment extends BaseFragment implements BrowserContract.View {

    private BrowserContract.Presenter mPresenter;

    public static BrowserFragment newInstance() {
        return new BrowserFragment();
    }

    @Override
    public void setPresenter(BrowserContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_browser, container, false);

        return root;
    }
}
