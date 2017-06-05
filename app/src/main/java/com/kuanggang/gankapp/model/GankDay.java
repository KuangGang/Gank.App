package com.kuanggang.gankapp.model;

import java.util.List;

/**
 * @author KG on 2017/6/5.
 */
public class GankDay {

    public boolean error;
    public List<String> category;
    public GankDayResults results;

    @Override
    public String toString() {
        return "GankDay{" +
                "error=" + error +
                ", category=" + category +
                ", results=" + results +
                '}';
    }
}
