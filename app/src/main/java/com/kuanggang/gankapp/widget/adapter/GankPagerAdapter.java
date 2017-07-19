package com.kuanggang.gankapp.widget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.local.LocalDataSource;
import com.kuanggang.gankapp.data.remote.RemoteDataSource;
import com.kuanggang.gankapp.function.gankdetail.GankFragment;
import com.kuanggang.gankapp.function.gankdetail.GankPresenter;

/**
 * @author KG on 2017/6/9.
 */

public class GankPagerAdapter extends FragmentPagerAdapter {

    public GankPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        GankFragment gankFragment = GankFragment.newInstance();
        // 绑定view和presenter
        DataRepository dataRepository = new DataRepository(new RemoteDataSource(), new LocalDataSource());
        new GankPresenter(gankFragment, dataRepository, position == 0);
        return gankFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
