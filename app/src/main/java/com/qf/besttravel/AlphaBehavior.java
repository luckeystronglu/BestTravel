package com.qf.besttravel;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ken on 2016/10/13.15:59
 */
public class AlphaBehavior extends FloatingActionButton.Behavior {


    public AlphaBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 接收滚动事件
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed
     * @param dyConsumed
     * @param dxUnconsumed
     * @param dyUnconsumed
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, final FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        //往下滑
        Log.d("print", "onNestedScroll: ----> dyConsumed: "+ dyConsumed);
        if (dyConsumed > 0) {
            child.setAlpha(1);
        }else {
            child.setAlpha(0);
        }
    }





    /**
     * 事件拦截
     * @param parent
     * @param child
     * @param ev
     * @return 返回true表示拦截事件
     */
    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, FloatingActionButton child, MotionEvent ev) {

        Log.d("print", "------>点击了FAB");
        return false;
    }


}
