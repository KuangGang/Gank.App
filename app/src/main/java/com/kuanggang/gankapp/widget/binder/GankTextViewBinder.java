package com.kuanggang.gankapp.widget.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuanggang.gankapp.GankApp;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.model.GankItem;
import com.kuanggang.gankapp.widget.customview.TitleFontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

/**
 * @author KG on 2017/6/14.
 */

public class GankTextViewBinder extends ItemViewBinder<GankItem, GankTextViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.fragment_gank_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull GankItem item) {
        holder.tv.setText(item.desc);
        holder.tvAuthor.setText(!TextUtils.isEmpty(item.who) ? item.who : GankApp.application.getResources().getString(R.string.no_author));
        holder.llRoot.setBackgroundColor(GankApp.application.getResources().getColor(getPosition(holder) % 2 == 0 ? R.color.md_grey_800 : R.color.md_grey_900));
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_root)
        LinearLayout llRoot;
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.tv_author)
        TextView tvAuthor;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
