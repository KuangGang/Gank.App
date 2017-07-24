package com.kuanggang.gankapp.model.type;

import com.kuanggang.gankapp.R;

/**
 * @author KG on 2017/7/5.
 */

public enum CategoryEnum {
    ALL("all", R.mipmap.icon_all),
    ANDROID("Android", R.mipmap.icon_android),
    IOS("iOS", R.mipmap.icon_ios),
    WEB("前端", R.mipmap.icon_web),
    VIDEO("休息视频", R.mipmap.icon_video),
    WEAL("福利", R.mipmap.icon_weal),
    EXPAND("拓展资源", R.mipmap.icon_expand),
    RECOMMEND("瞎推荐", R.mipmap.icon_recommend),
    APP("App", R.mipmap.icon_app);
    public String category;
    public int drawableId;

    CategoryEnum(String category, int drawableId) {
        this.category = category;
        this.drawableId = drawableId;
    }

    public static CategoryEnum to(String category){
        for(CategoryEnum element:values()){
            if(element.category.equals(category))
                return element;
        }
        return null;
    }
}
