package com.qfkf.util;

import android.content.Context;

/**
 * Created by lenovo on 2016/9/26.
 */
public class ScreenUtil {
    //获得通知栏的高度
    public static int getStateBarHeight(Context context){
        int resid = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resid > 0) {
            return context.getResources().getDimensionPixelSize(resid);
        }
        return -1;
    }
}
