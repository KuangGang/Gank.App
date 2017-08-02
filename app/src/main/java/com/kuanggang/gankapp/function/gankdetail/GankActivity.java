package com.kuanggang.gankapp.function.gankdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.function.about.AboutActivity;
import com.kuanggang.gankapp.utils.ToastUtil;
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

        initActionBar(toolbar);
        setMenuSelected(true);
        initTabLayoutViewPager();
        initListener();
    }

    private void initTabLayoutViewPager() {
        GankPagerAdapter gankPagerAdapter = new GankPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(gankPagerAdapter);
    }

    private void initListener() {
        ivCategory.setOnClickListener(this);
        ivContent.setOnClickListener(this);
        viewpager.addOnPageChangeListener(new GankPagerChangeListener());
        toolbar.setOnMenuItemClickListener(new OnGankMenuItemClickListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_category:
                viewpager.setCurrentItem(0);
                setMenuSelected(true);
                break;
            case R.id.iv_content:
                viewpager.setCurrentItem(1);
                setMenuSelected(false);
                break;
        }
        super.onClick(v);
    }

    private void setMenuSelected(boolean isCategory) {
        if (ivCategory == null || ivContent == null) return;
        ivCategory.setSelected(isCategory);
        ivContent.setSelected(!isCategory);
    }

    public void showContent() {
        if (viewpager == null) return;
        viewpager.setCurrentItem(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    private class GankPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setMenuSelected(position == 0);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class OnGankMenuItemClickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_about:
                    Intent intent = new Intent(GankActivity.this, AboutActivity.class);
                    startActivity(intent);
                    break;
                case R.id.action_more:
                    ToastUtil.show(GankActivity.this, getString(R.string.expect_toast));
                    break;
            }
            return true;
        }
    }

    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (viewpager != null && viewpager.getCurrentItem() == 1) {
                viewpager.setCurrentItem(0);
                setMenuSelected(true);
                return true;
            }
            if (System.currentTimeMillis() - firstTime > 2000) {
                ToastUtil.show(GankActivity.this, getString(R.string.clickmore_exit));
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
