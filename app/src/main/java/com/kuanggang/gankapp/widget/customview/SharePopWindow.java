package com.kuanggang.gankapp.widget.customview;

import android.widget.PopupWindow;

/**
 * @author KG
 *         Created by KG on 2018/1/29.
 */

public class SharePopWindow extends PopupWindow {

//    @BindView(R.id.ll_weixin)
//    LinearLayout llWeixin;
//    @BindView(R.id.ll_weixin_friend)
//    LinearLayout llWeixinFriend;
//    @BindView(R.id.tv_cancel)
//    TextView tvCancel;
//    @BindView(R.id.view_back)
//    View viewBack;
//
//    Unbinder unbinder;
//    private Activity mActivity;
//
//
//    public SharePopWindow(Activity context) {
//        super(context);
//        this.mActivity = context;
//        initView();
//    }
//
//    public void showPopWindow(View view, Platform.ShareParams params) {
//        initListener(v -> {
//            switch (v.getId()) {
//                case R.id.ll_weixin:
//                    share(params, Wechat.NAME);
//                    dismiss();
//                    break;
//                case R.id.ll_weixin_friend:
//                    share(params, WechatMoments.NAME);
//                    dismiss();
//                    break;
//            }
//        });
//        showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
//    }
//
//    private void share(Platform.ShareParams params, String name) {
//        Platform platform = ShareSDK.getPlatform(name);
//        platform.setPlatformActionListener(new PlatformActionListener() {
//            @Override
//            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//                ToastUtil.show(mActivity, "分享成功");
//            }
//
//            @Override
//            public void onError(Platform platform, int i, Throwable throwable) {
//                ToastUtil.show(mActivity, "分享失败");
//            }
//
//            @Override
//            public void onCancel(Platform platform, int i) {
//                ToastUtil.show(mActivity, "取消分享");
//            }
//        });
//        platform.share(params);
//    }
//
//    private void initListener(View.OnClickListener itemsOnClick) {
//        //设置按钮监听
//        llWeixin.setOnClickListener(itemsOnClick);
//        llWeixinFriend.setOnClickListener(itemsOnClick);
//        tvCancel.setOnClickListener(v -> dismiss());
//        viewBack.setOnClickListener(v -> dismiss());
//    }
//
//    private void initView() {
//        if (mActivity == null) {
//            return;
//        }
//
//        LayoutInflater mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View mView = mInflater.inflate(R.layout.popup_window_share, null);
//        unbinder = ButterKnife.bind(this, mView);
//        setContentView(mView);
//
//        setWidth(WindowManager.LayoutParams.FILL_PARENT);
//        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
//        setFocusable(true);
//        setTouchable(true);
//        setOutsideTouchable(true);
//        setAnimationStyle(R.style.AnimBottom);
//
//        //实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0x00000000);
//        //设置SelectPicPopupWindow弹出窗体的背景
//        this.setBackgroundDrawable(dw);
//        backgroundAlpha(mActivity, 0.5f);//0.0-1.0
//        this.setOnDismissListener(() -> {
//            // TODO Auto-generated method stub
//            backgroundAlpha(mActivity, 1f);
//        });
//    }
//
//    /**
//     * 设置添加屏幕的背景透明度
//     *
//     * @param bgAlpha
//     */
//    private void backgroundAlpha(Activity context, float bgAlpha) {
//        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
//        lp.alpha = bgAlpha;
//        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        context.getWindow().setAttributes(lp);
//    }
//
//    @Override
//    public void dismiss() {
//        super.dismiss();
//        backgroundAlpha(mActivity, 1f);
//    }
}
