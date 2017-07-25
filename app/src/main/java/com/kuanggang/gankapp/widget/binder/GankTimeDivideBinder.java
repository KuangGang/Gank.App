package com.kuanggang.gankapp.widget.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.model.GankTimeDivide;
import com.kuanggang.gankapp.model.GankTitle;
import com.kuanggang.gankapp.model.type.CategoryEnum;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author KG on 2017/6/14.
 */

public class GankTimeDivideBinder extends ItemViewBinder<GankTimeDivide, GankTimeDivideBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.fragment_gank_divide_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GankTimeDivide item) {
        if (TextUtils.isEmpty(item.publishedAt)) {
            holder.tvTime.setVisibility(View.GONE);
            return;
        }
        holder.tvTime.setVisibility(View.VISIBLE);
        holder.tvTime.setText(item.publishedAt);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView tvTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
