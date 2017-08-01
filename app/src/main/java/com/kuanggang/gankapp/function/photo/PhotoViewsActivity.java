package com.kuanggang.gankapp.function.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuanggang.gankapp.Constants;
import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseActivity;
import com.kuanggang.gankapp.utils.AppUtil;
import com.kuanggang.gankapp.utils.ImageUtils;
import com.kuanggang.gankapp.widget.adapter.PhotoViewPagerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KG on 2017/8/1
 */
public class PhotoViewsActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tv_cur_position)
    TextView tvCurPosition;
    @BindView(R.id.tv_separator)
    TextView tvSeparator;
    @BindView(R.id.tv_sum_count)
    TextView tvSumCount;
    @BindView(R.id.rl_indicator)
    RelativeLayout rlIndicator;
    @BindView(R.id.iv_save)
    ImageView ivSave;

    private List<String> mGirls;
    private int curPosition = 0;
    private ImageUtils imageHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_photoviews);
        ButterKnife.bind(this);

        initData();
        initView();
        initListener();
    }

    private void initData() {
        mGirls = (List<String>) getIntent().getSerializableExtra(Constants.IMAGE_URL_LIST_KEY);
        if (AppUtil.isEmpty(mGirls)) {
            throw new RuntimeException("The girls of gank is empty!");
        }
        curPosition = mGirls.indexOf(getIntent().getStringExtra(Constants.IMAGE));
    }

    private void initView() {
        tvCurPosition.setText(String.valueOf(curPosition + 1));
        tvSumCount.setText(String.valueOf(mGirls.size()));
        viewPager.setAdapter(new PhotoViewPagerAdapter(this, mGirls));
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                curPosition = position;
                tvCurPosition.setText(String.valueOf(position + 1));
                viewPager.setTag(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        viewPager.setCurrentItem(curPosition);

        AppUtil.singleClick(ivSave, o -> {
            imageHelper = new ImageUtils(PhotoViewsActivity.this);
            imageHelper.saveImage(mGirls.get(curPosition));
        });
    }

    @Override
    protected void onDestroy() {
        if (imageHelper != null) {
            imageHelper.unInit();
        }
        super.onDestroy();
    }

}
