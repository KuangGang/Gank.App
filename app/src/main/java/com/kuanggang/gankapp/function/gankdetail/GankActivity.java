package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.widget.adapter.GankPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GankActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.iv_category)
    ImageView ivCategory;
    @BindView(R.id.iv_content)
    ImageView ivContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);

        initActionBar();
        initTabLayoutViewPager();
        initListener();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("");
    }

    private void initTabLayoutViewPager() {
        GankPagerAdapter gankPagerAdapter = new GankPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(gankPagerAdapter);
    }

    private void initListener() {
        ivCategory.setOnClickListener(this);
        ivContent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_category:
                viewpager.setCurrentItem(0);
                break;
            case R.id.iv_content:
                viewpager.setCurrentItem(1);
                break;
        }
        super.onClick(v);
    }
}
