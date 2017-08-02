package com.kuanggang.gankapp.base;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * @author KG on 2017/7/5.
 */

public class BaseFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }

    public void setOnClickListener(View... views){
        if (views == null || views.length <= 0) return;
        for (View view : views){
            view.setOnClickListener(this);
        }
    }
}
