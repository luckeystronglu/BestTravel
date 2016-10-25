package com.qf.besttravel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
public class FabBehavior extends FloatingActionButton.Behavior {

    private boolean isAnimation;

    public FabBehavior(Context context, AttributeSet attrs) {
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
        if(!isAnimation) {
            if (dyConsumed > 0) {
                //往下滑
                child.animate()
                        .scaleXBy(1)
                        .scaleX(0)
                        .scaleYBy(1)
                        .scaleY(0)
                        .alphaBy(1)
                        .alpha(0.2f)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                child.setVisibility(View.GONE);
                                isAnimation = false;
                            }

                            @Override
                            public void onAnimationStart(Animator animation) {
                                super.onAnimationStart(animation);
                                isAnimation = true;
                            }
                        })
                        .start();
            } else if(dyConsumed < 0) {
                //往上滑
                child.animate()
                        .scaleXBy(0)
                        .scaleX(1)
                        .scaleYBy(0)
                        .scaleY(1)
                        .alphaBy(0.2f)
                        .alpha(1)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                isAnimation = false;
                            }

                            @Override
                            public void onAnimationStart(Animator animation) {
                                super.onAnimationStart(animation);
                                child.setVisibility(View.VISIBLE);
                                isAnimation = true;
                            }
                        })
                        .start();
            }
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

    /**
     * 处理拦截下来的事件
     * @param parent
     * @param child
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, FloatingActionButton child, MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("print", "--->按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("print", "--->移动");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("print", "--->抬起");
                break;
        }
        return true;
    }
}
