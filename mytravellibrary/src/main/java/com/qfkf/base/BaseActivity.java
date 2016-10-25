package com.qfkf.base;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qf.luckey.utillibrary.R;
import com.qfkf.util.ScreenUtil;

/**
 * 所有Activity的父类
 * Created by Administrator on 2016/8/2.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment showfragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        /**
         * 沉浸式状态栏
         */
        if(isOpenStatus()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }

            //获得状态栏的高度
            int height = ScreenUtil.getStateBarHeight(this);
            if(height != -1){
                //设置Padding
                View view = findViewById(R.id.actionbar);
                if(view != null){
                    view.setPadding(0, height, 0, 0);
                }
            }
        }

        //初始化FragmentManager对象
        fragmentManager = getSupportFragmentManager();
        init();
        loadDatas();
    }

    /**
     * 以动画的方式启动activity
     * @param intent
     * @param animinid
     * @param animoutid
     */
    public void startActivityForAnimation(Intent intent, int animinid, int animoutid){
        startActivity(intent);
        overridePendingTransition(animinid, animoutid);
    }

    //返回当前activity所显示的布局ID
    public abstract int getContentViewId();
    //初始化方法
    protected void init() {
    }

    /**
     * 是否打开沉浸式状态栏
     * @return
     */
    public boolean isOpenStatus(){
        return true;
    }

    //加载数据的方法
    protected void loadDatas() {
    }

    /**
     * 查找页面布局ID所对应的控件对象，不用强制转换
     * @param resId
     * @param <T>
     * @return
     */
    protected  <T> T findViewByIds(int resId){
        return (T) findViewById(resId);
    }

    //管理fragment的显示与隐藏的方法
    protected void fragmentManager(int resId, Fragment fragment, String tag){
        //开始事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏正在显示的fragment对象
        if (showfragment != null){
            fragmentTransaction.hide(showfragment);
        }
        Fragment loadFragment = fragmentManager.findFragmentByTag(tag);
        if (loadFragment != null){
            fragmentTransaction.show(loadFragment);
        }else {
            loadFragment = fragment;
            fragmentTransaction.add(resId,fragment,tag);
        }
        showfragment = loadFragment;
        fragmentTransaction.commit();
    }



}
