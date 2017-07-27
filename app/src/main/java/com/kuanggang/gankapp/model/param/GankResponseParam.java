package com.kuanggang.gankapp.model.param;

import com.kuanggang.gankapp.model.GankItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KG on 2017/6/21.
 */

public class GankResponseParam {
    /**
     * 初始数据
     */
    private List<GankItem> initItems = new ArrayList<>();

    /**
     * 处理后的数据
     */
    private List<Object> handleItems = new ArrayList<>();

    public void setInitItems(int page, List<GankItem> items) {
        if (page == 1)
            this.initItems = items;
        else
            this.initItems.addAll(items);
    }

    public List<GankItem> getInitItems() {
        return initItems;
    }

    public List<Object> getHandleItems() {
        return handleItems;
    }

    public void setHandleItems(List<Object> handleItems) {
        this.handleItems = handleItems;
    }
}
