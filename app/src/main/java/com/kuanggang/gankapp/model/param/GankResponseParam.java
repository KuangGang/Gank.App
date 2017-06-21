package com.kuanggang.gankapp.model.param;

import com.kuanggang.gankapp.model.GankItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KG on 2017/6/21.
 */

public class GankResponseParam {
    /**
     * 分类数据
     */
    private List<GankItem> items = new ArrayList<>();

    public void addItems(int page, List<GankItem> items) {
        if (page == 1)
            this.items = items;
        else
            this.items.addAll(items);
    }

    public List<GankItem> getItems() {
        return items;
    }
}
