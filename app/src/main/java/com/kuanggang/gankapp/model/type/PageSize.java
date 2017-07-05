package com.kuanggang.gankapp.model.type;

/**
 * @author KG on 2017/7/5.
 */

public enum PageSize {
    FIVE(5),
    TEN(10),
    FIFTEEN(15),
    TWENTY(20);
    public int size;

    PageSize(int size) {
        this.size = size;
    }
}
