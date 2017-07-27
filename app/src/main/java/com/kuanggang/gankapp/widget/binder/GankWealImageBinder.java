package com.kuanggang.gankapp.widget.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.model.multitype.GankTimeDivide;
import com.kuanggang.gankapp.model.multitype.GankWealImage;
import com.kuanggang.gankapp.utils.GlideUtils;
import com.kuanggang.gankapp.widget.customview.AutoScaleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author KG on 2017/7/27.
 */

public class GankWealImageBinder extends ItemViewBinder<GankWealImage, GankWealImageBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.fragment_gank_wealimage_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GankWealImage item) {
        GlideUtils.newInstance().loadNetImage(item.imageUrl, holder.iv);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        AutoScaleImageView iv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
