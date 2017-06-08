package com.kuanggang.gankapp.network;

import com.kuanggang.gankapp.model.GankDay;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author KG on 2017/6/8.
 */

public interface Api {

    @GET("day/{year}/{month}/{day}")
    Observable<GankDay> getGanDay(@Path("year") int year, @Path("month") int month, @Path("day") int day);
}
