package com.kuanggang.gankapp.function.browser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.local.LocalDataSource;
import com.kuanggang.gankapp.data.remote.RemoteDataSource;
import com.kuanggang.gankapp.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/7/5.
 */

public class BrowserActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);

        initActionBar();
        addFragment();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("");
    }

    private void addFragment() {
        BrowserFragment browserFragment = (BrowserFragment) getSupportFragmentManager().findFragmentById(R.id.framelayout);
        if (browserFragment != null) return;

        browserFragment = BrowserFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                browserFragment, R.id.framelayout);

        DataRepository dataRepository = new DataRepository(new RemoteDataSource(), new LocalDataSource());
        new BrowserPresenter(browserFragment, dataRepository);
    }
}
