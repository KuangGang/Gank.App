package com.kuanggang.gankapp.function.browser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.kuanggang.gankapp.Constants;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.local.LocalDataSource;
import com.kuanggang.gankapp.data.remote.RemoteDataSource;
import com.kuanggang.gankapp.utils.ActivityUtils;
import com.kuanggang.gankapp.widget.customview.WebViewLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/7/5.
 */

public class BrowserActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.webViewLayout)
    WebViewLayout webViewLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);

        initActionBar();
        initListener();
        loadUrl();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("");
    }

    private void initListener() {
        ivBack.setOnClickListener(this);
    }

    private void loadUrl() {
        String url = getIntent().getStringExtra(Constants.URL_KEY);
        webViewLayout.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        webViewLayout.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        webViewLayout.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        webViewLayout.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webViewLayout.goBack()) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
