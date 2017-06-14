package com.kuanggang.gankapp.model.requestparam;

/**
 * @author KG on 2017/6/14.
 */

public class GankRequestParam {
    private int page;
    private int size;
    private String category;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
