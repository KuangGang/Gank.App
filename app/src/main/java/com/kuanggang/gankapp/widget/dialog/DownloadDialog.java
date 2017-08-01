package com.kuanggang.gankapp.widget.dialog;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.kuanggang.gankapp.utils.ToastUtil;

/**
 * @author KG on 17/8/1.
 */
public class DownloadDialog {

    private Context mContext;
    private MaterialDialog materialDialog;

    public DownloadDialog(Context context) {
        this.mContext = context;
    }

    public MaterialDialog getMaterialDialog() {
        return materialDialog;
    }

    public void show() {
        if (materialDialog == null) {
            materialDialog = new MaterialDialog.Builder(mContext)
                    .content("正在下载...")
                    .progress(false, 100, false)
                    .cancelListener(dialog -> ToastUtil.show(mContext, "已进入后台下载"))
                    .build();
        }
        if (!materialDialog.isShowing()) {
            materialDialog.show();
        }
    }

    public void setProgress(int progress) {
        materialDialog.setProgress(progress);
    }

    public boolean isShowing() {
        if (materialDialog != null) {
            return materialDialog.isShowing();
        }
        return false;
    }

    public void dismiss() {
        if (materialDialog != null && materialDialog.isShowing()) {
            materialDialog.dismiss();
            materialDialog = null;
        }
    }

}
