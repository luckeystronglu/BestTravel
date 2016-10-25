package com.qfkf.context;

import android.app.Application;

import com.qfkf.util.ShareUtil;


public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化共享参数
        ShareUtil.init(this);
    }
}
