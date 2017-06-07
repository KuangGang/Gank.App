package com.kuanggang.gankapp.function.gankdetail;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GankActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorlayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;

    private GankContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);

        initActionBar();
        bindViewAndPresenter();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("");
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void bindViewAndPresenter() {
        GankFragment gankFragment = (GankFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameLayout);
        if (gankFragment == null){
            gankFragment = GankFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), gankFragment, R.id.contentFrameLayout);
        }

        mPresenter = new GankPresenter(gankFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerlayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
