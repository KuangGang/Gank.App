package com.kuanggang.gankapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    /**
     * 日期相差天数(字符串的)
     */
    public static int getStrDateDiff(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }
}
