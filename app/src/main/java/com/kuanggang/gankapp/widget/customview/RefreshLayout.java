package com.kuanggang.gankapp.widget.customview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * @author KG on 17/6/16.
 */
public class RefreshLayout extends SwipeRefreshLayout {

    // 滑动到最下面时的上拉操作
    private int mTouchSlop;

    // 该项目以RecyclerView为主
    private RecyclerView mRecyclerView;

    // 上拉监听器, 到了最底部的上拉加载操作
    private OnLoadListener mOnLoadListener;

    // 按下时的y坐标
    private int mYDown;

    // 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
    private int mLastY;

    // 是否在加载中 ( 上拉加载更多 )
    private boolean isLoading = false;

    // 是否可以上拉加载更多
    private boolean canLoad = true;

    public RefreshLayout(Context context) {
        this(context, null);
        init(context);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // 初始化ListView对象
        if (mRecyclerView == null) {
            getRecyclerView();
        }
    }

    // 获取RecyclerView对象
    private void getRecyclerView() {
        int childes = getChildCount();
        if (childes <= 0) return;
        View childView = getChildAt(0);
        if (!(childView instanceof RecyclerView)) return;

        mRecyclerView = (RecyclerView) childView;
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (!canLoad()) return;
                mOnLoadListener.onLoad();//当滑动到底部的时候触动这个方法
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            }
        });
    }

    // 上拉加载的
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                // 按下
                mYDown = (int) event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                // 移动
                mLastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    // 是否可以加载更多, 条件是到了最底部, 不在加载中, 且为上拉操作
    private boolean canLoad() {
        return canLoad && isBottom() && !isLoading && isPullUp();
    }

    // 判断是否到了最底部
    private boolean isBottom() {
        if (mRecyclerView != null && mRecyclerView.getAdapter() != null) {
            LinearLayoutManager manager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
            return manager.findLastCompletelyVisibleItemPosition() == manager.getItemCount() - 1;
        }
        return false;
    }

    // 是否是上拉操作
    private boolean isPullUp() {
        return (mYDown - mLastY) >= mTouchSlop;
    }

    // 如果到了最底部, 而且是上拉操作, 那么执行onLoad方法
    private void loadData() {
        if (mOnLoadListener != null) {
            // 设置状态
            setLoading(true);
            mOnLoadListener.onLoad();
        }
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
        if (!isLoading) {
            mYDown = 0;
            mLastY = 0;
        }
    }

    // 是否可以上拉加载更多
    public void setCanLoad(boolean canLoad) {
        this.canLoad = canLoad;
    }

    // 加载更多的监听器
    public interface OnLoadListener {
        void onLoad();
    }

    public void setOnLoadListener(OnLoadListener loadListener) {
        mOnLoadListener = loadListener;
    }
}
