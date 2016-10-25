package com.qfkf.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.luckey.utillibrary.R;
import com.qfkf.util.ScreenUtil;

/**
 * Created by Administrator on 2016/8/2.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(),container,false);
        return view;
    }

    /**
     * 该方法会紧随onCreateView被调用后调用
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //查找actionbar控件设置paddingtop
        BaseActivity activity = (BaseActivity) getActivity();
        //判断activity是否开启沉浸式通知栏
        if(activity.isOpenStatus()){
            View actionbarview = view.findViewById(R.id.actionbar);
            if(actionbarview != null){
                int heigth = ScreenUtil.getStateBarHeight(getActivity());
                actionbarview.setPadding(0, heigth, 0, 0);
            }
        }


        init(view);
        loadDatas();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBundle(getArguments());
    }

    //获得bundle数据
    protected void getBundle(Bundle bundle){

    }

    /**
     * 设置fragment需要展示的布局ID
     * @return
     */
    protected abstract int getContentView();
    //初始化
    protected void init(View view) {

    }
    //加载数据
    protected void loadDatas() {
    }


}
