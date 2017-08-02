package com.kuanggang.gankapp.function.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.local.LocalDataSource;
import com.kuanggang.gankapp.data.remote.RemoteDataSource;
import com.kuanggang.gankapp.utils.ActivityUtils;
import com.kuanggang.gankapp.utils.TextUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/8/2.
 */

public class AboutActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        TextUtil.setFakeBoldText(tvTitle);

        initActionBar(toolbar);
        initListener();
        initFragment();
    }

    private void initListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void initFragment() {
        AboutFragment aboutFragment = (AboutFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout);
        if (aboutFragment == null) {
            aboutFragment = AboutFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    aboutFragment, R.id.framelayout);
        }

        new AboutPresenter(aboutFragment, new DataRepository(new RemoteDataSource(), new LocalDataSource()));
    }
}
