package com.kuanggang.gankapp.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;

/**
 * @author KG on 2017/1/23.
 */
public class GlideUtils {

    private RequestOptions mOptions;

    //在装载该内部类时才会去创建单例对象
    private static class Singleton {
        private static GlideUtils ourInstance = new GlideUtils();
    }

    public static GlideUtils newInstance() {
        return Singleton.ourInstance;
    }

    public GlideUtils() {
        mOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.icon_white_back)
                .error(R.drawable.icon_white_back)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    // 加载网络图片
    public void loadNetImage(String url, ImageView iv) {
        Glide.with(GankApp.application)
                .load(url)
                .apply(mOptions)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into(iv);
    }

    // 加载自适应高度的ImageView
    public void loadAutoHeightNetImage(String url, ImageView iv) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.icon_white_back)
                .error(R.drawable.icon_white_back)
                .priority(Priority.HIGH)
                .override(DensityUtil.getScreenWidth(GankApp.application), Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(GankApp.application)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into(iv);
    }


    // 加载drawable图片
    public void loadResImage() {
    }

    // 加载本地图片
    public void loadLocalPathImage() {
    }

}
