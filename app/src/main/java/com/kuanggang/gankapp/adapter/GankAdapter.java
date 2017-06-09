package com.kuanggang.gankapp.adapter;

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

public class GankAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"全部", "Android", "iOS", "前端", "休息视频",
            "福利", "拓展资源", "瞎推荐", "App"};

    public GankAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        GankFragment gankFragment = GankFragment.newInstance(titles[position]);
        // 绑定view和presenter
        DataRepository dataRepository = new DataRepository(new RemoteDataSource(), new LocalDataSource());
        new GankPresenter(gankFragment, dataRepository);
        return gankFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public String[] getTitles(){
        return titles;
    }
}
