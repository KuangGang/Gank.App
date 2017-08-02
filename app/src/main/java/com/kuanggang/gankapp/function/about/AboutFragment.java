package com.kuanggang.gankapp.function.about;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuanggang.gankapp.R;
import com.kuanggang.gankapp.base.BaseFragment;
import com.kuanggang.gankapp.utils.AppUtil;
import com.kuanggang.gankapp.utils.TextUtil;
import com.kuanggang.gankapp.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author KG on 2017/6/5.
 */

public class AboutFragment extends BaseFragment implements AboutContract.View {

    @BindView(R.id.ll_original)
    LinearLayout llOriginal;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_jianshu)
    TextView tvJianshu;
    @BindView(R.id.tv_weibo)
    TextView tvWeibo;
    @BindView(R.id.ll_version)
    LinearLayout llVersion;
    @BindView(R.id.tv_version)
    TextView tvVersion;

    private Unbinder unbinder;
    private AboutContract.Presenter mPresenter;

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public void setPresenter(@NonNull AboutContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        unbinder = ButterKnife.bind(this, root);

        init();
        initListener();
        return root;
    }

    private void init() {
        tvVersion.setText(getResources().getString(R.string.version, AppUtil.getVersionName()));
    }

    private void initListener() {
        setOnClickListener(llOriginal, tvEmail, tvJianshu, tvWeibo, llVersion);
    }

    @Override
    public void onClick(View v) {
        if (mPresenter == null) return;
        switch (v.getId()){
            case R.id.ll_original:
                mPresenter.openGankIO(getActivity());
                break;
            case R.id.tv_email:
                copyToClipBoard("kuanggang_android@163.com", "邮箱已复制");
                break;
            case R.id.tv_jianshu:
                copyToClipBoard("小筐子", "简书已复制");
                break;
            case R.id.tv_weibo:
                copyToClipBoard("小筐子hhh", "微博已复制");
                break;
            case R.id.ll_version:
                break;
        }
    }

    private void copyToClipBoard(String copyText, String toastText) {
        TextUtil.copyToClipBoard(copyText);
        ToastUtil.show(getActivity(), toastText);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder == null) return;
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter == null) return;
        mPresenter.onDestory();
    }
}
