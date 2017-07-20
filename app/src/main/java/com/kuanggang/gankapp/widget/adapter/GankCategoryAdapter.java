package com.kuanggang.gankapp.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuanggang.gankapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/7/20.
 */

public class GankCategoryAdapter extends RecyclerView.Adapter<GankCategoryAdapter.CategoryViewHolder> {

    private String[] categorys = new String[]{"全部", "Android", "iOS", "前端", "休息视频",
            "福利", "拓展资源", "瞎推荐", "App"};

    private int[] drawableIds = new int[]{R.mipmap.icon_all, R.mipmap.icon_android, R.mipmap.icon_ios,
            R.mipmap.icon_web, R.mipmap.icon_video, R.mipmap.icon_weal, R.mipmap.icon_expand,
            R.mipmap.icon_recommend, R.mipmap.icon_app};

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = View.inflate(parent.getContext(), R.layout.fragment_category_item, null);
        return new CategoryViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tv.setText(categorys[position]);
        holder.iv.setImageResource(drawableIds[position]);
    }

    @Override
    public int getItemCount() {
        return categorys.length;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv)
        TextView tv;

        CategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
