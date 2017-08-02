package com.kuanggang.gankapp.widget.binder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kuanggang.gankapp.Constants;
import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.function.photo.PhotoViewsActivity;
import com.kuanggang.gankapp.model.multitype.GankWealImage;
import com.kuanggang.gankapp.utils.GlideUtils;
import com.kuanggang.gankapp.widget.adapter.PhotoViewPagerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        Glide.with(GankApp.application);
        GlideUtils.newInstance().loadAutoHeightNetImage(item.imageUrl, holder.iv);

        holder.iv.setOnClickListener(v -> {
            List<Object> entities = (List<Object>) getAdapter().getItems();
            List<GankWealImage> items = new ArrayList<>();
            for (Object object : entities){
                if (object instanceof GankWealImage) {
                    items.add((GankWealImage) object);
                }
            }

            if (items.size() <= 0) return;
            List<String> imgs = new ArrayList<>();
            for (GankWealImage entity : items) {
                imgs.add(entity.imageUrl);
            }

            Context context = holder.iv.getContext();
            Intent intent = new Intent(context, PhotoViewsActivity.class);
            intent.putExtra(Constants.IMAGE_URL_LIST_KEY, (Serializable) imgs);
            intent.putExtra(Constants.IMAGE, item.imageUrl);
            context.startActivity(intent);
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
