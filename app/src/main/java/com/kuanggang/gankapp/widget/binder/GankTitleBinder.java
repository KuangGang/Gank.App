package com.kuanggang.gankapp.widget.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.model.GankTitle;
import com.kuanggang.gankapp.model.type.CategoryEnum;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author KG on 2017/6/14.
 */

public class GankTitleBinder extends ItemViewBinder<GankTitle, GankTitleBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.fragment_gank_title_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GankTitle item) {
        CategoryEnum to = CategoryEnum.to(item.type);
        holder.iv.setImageResource(to.drawableId);
        holder.tvCategory.setText(item.type);
//        holder.tvTime.set
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_time)
        TextView tvTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
