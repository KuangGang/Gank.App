package com.kuanggang.gankapp.widget.dialog;

import android.content.Context;
import android.text.TextUtils;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * @author KG on 17/8/1.
 */
public class LoadingDialog {

    private Context mContext;
    private MaterialDialog dialog;

    public LoadingDialog(Context context) {
        this.mContext = context;
    }

    public MaterialDialog getDialog() {
        return dialog;
    }

    public void show(String tip) {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(mContext)
                    .content(TextUtils.isEmpty(tip) ? "正在加载..." : tip)
                    .progress(true, 0)
                    .progressIndeterminateStyle(false)
                    .build();
            dialog.setCanceledOnTouchOutside(true);
        }
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void show() {
        show(null);
    }

    public void showCancelDialog(String tip) {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(mContext)
                    .content(TextUtils.isEmpty(tip) ? "正在加载..." : tip)
                    .progress(true, 0)
                    .progressIndeterminateStyle(false)
                    .build();
            dialog.setCanceledOnTouchOutside(false);
        }
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void showCancelDialog() {
        showCancelDialog(null);
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public boolean isShowing() {
        if (dialog == null) return false;
        return dialog.isShowing();
    }

}
