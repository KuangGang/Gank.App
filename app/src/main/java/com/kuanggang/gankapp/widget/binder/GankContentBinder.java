package com.kuanggang.gankapp.widget.binder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuanggang.gankapp.Constants;
import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.function.browser.BrowserActivity;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.model.type.CategoryEnum;
import com.kuanggang.gankapp.utils.DensityUtil;
import com.kuanggang.gankapp.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author KG on 2017/6/14.
 */

public class GankContentBinder extends ItemViewBinder<GankItem, GankContentBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.fragment_gank_content_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GankItem item) {
        // 设置16:9图片
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) holder.iv.getLayoutParams();
        layoutParams.height = (DensityUtil.getScreenWidth(GankApp.application) - DensityUtil.dip2px(GankApp.application, 30)) / 16 * 9;
        holder.iv.setLayoutParams(layoutParams);
        holder.iv.setVisibility(View.GONE);

        List<String> images = item.images;
        if (images != null && images.size() > 0) {
            GlideUtils.newInstance().loadNetImage(images.get(0), holder.iv);
            holder.iv.setVisibility(View.VISIBLE);
        }

        holder.tvTitle.setText(item.desc);
        String author = !TextUtils.isEmpty(item.who) ? item.who : GankApp.application.getResources().getString(R.string.no_author);
        holder.tvAuthor.setText(GankApp.application.getString(R.string.author, author));

        holder.rlRoot.setOnClickListener(v -> {
            Context context = holder.rlRoot.getContext();
            Intent intent = new Intent(context, BrowserActivity.class);
            intent.putExtra(Constants.URL_KEY, item);
            context.startActivity(intent);
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.rl_root)
        RelativeLayout rlRoot;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
