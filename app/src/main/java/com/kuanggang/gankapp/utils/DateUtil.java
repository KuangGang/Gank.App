package com.kuanggang.gankapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author KG on 2017/6/5.
 */
public class DateUtil {

    public static final String GANK_DATE_FORMAT = "yyyy-MM-dd";

    // 把日期转为字符串
    public static String convertDate2String(Date date) {
        DateFormat df = new SimpleDateFormat(GANK_DATE_FORMAT);
        return df.format(date);
    }

    // 把字符串转为日期
    public static Date convertString2Date(String dateStr) {
        DateFormat df = new SimpleDateFormat(GANK_DATE_FORMAT);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    // 把字符串转为日期
    public static String convertString2String(String dateStr) {
        DateFormat df = new SimpleDateFormat(GANK_DATE_FORMAT);
        try {
            return df.format(df.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStr;
    }
}
