package com.kuanggang.gankapp.widget.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kuanggang.gankapp.data.DataRepository;
import com.kuanggang.gankapp.data.local.LocalDataSource;
import com.kuanggang.gankapp.data.remote.RemoteDataSource;
import com.kuanggang.gankapp.function.gankdetail.GankFragment;
import com.kuanggang.gankapp.function.gankdetail.GankPresenter;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author KG on 2017/6/9.
 */

public class GankPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"全部", "Android", "iOS", "前端", "休息视频",
            "福利", "拓展资源", "瞎推荐", "App"};

    public GankPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        GankFragment gankFragment = GankFragment.newInstance();
        // 绑定view和presenter
        DataRepository dataRepository = new DataRepository(new RemoteDataSource(), new LocalDataSource());
        String category = titles[position].equals("全部") ? "all" : titles[position];
        new GankPresenter(gankFragment, dataRepository, category);
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

    public String[] getTitles() {
        return titles;
    }
}
