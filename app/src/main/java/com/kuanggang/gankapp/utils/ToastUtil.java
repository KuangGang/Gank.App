package com.kuanggang.gankapp.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @author KG on 2017/6/5.
 */
public class ToastUtil {

    private static Toast mToast;

    public static void show(Context context, @StringRes int id) {
        if (context == null) return;
        show(context, context.getResources().getString(id));
    }

    public static void show(Context context, String msg) {
        if (context == null) return;
        if (TextUtils.isEmpty(msg)) return;

        int duration;
        if (msg.length() > 10) {
            duration = Toast.LENGTH_LONG;
        } else {
            duration = Toast.LENGTH_SHORT;
        }

        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
            mToast.setDuration(duration);
        }

        mToast.show();
    }
}