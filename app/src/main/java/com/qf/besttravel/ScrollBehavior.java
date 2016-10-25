package com.qf.besttravel;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Ken on 2016/10/13.14:56
 */
public class ScrollBehavior extends CoordinatorLayout.Behavior {

    public ScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 该方法返回true才能接收到滚动事件
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 滚动事件监听
     * @param coordinatorLayout
     * @param child 从动的控件对象
     * @param recyclerview 主动的控件对象，这里应该是RecyclerView
     * @param dxConsumed
     * @param dyConsumed 有效的滚动偏移量，当该值为正，表示RecyclerView正在向下滑动，该值为负时反之，如果为0，说明RecyclerView已经滑动到了顶部或者底部
     * @param dxUnconsumed
     * @param dyUnconsumed 无效的滚动偏移量，当该值为正，表示RecyclerView滑动到了底部，仍然在继续滑动，如果为负值反之，其余情况都为0
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View recyclerview, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.d("print", "dyConsumed:" + dyConsumed + "    dyUnconsumed:" + dyUnconsumed);
        if(dyConsumed > 0){
            //RecyclerView在向上滚动
            float y = child.getY();
            y = y - dyConsumed;
            if(Math.abs(y) > child.getHeight()){
                y = -child.getHeight();
            }
            child.setY(y);
        } else if(dyConsumed == 0 && dyUnconsumed < 0){
            float y = child.getY();
            y = y - dyUnconsumed;
            if(y > 0){
                y = 0;
            }
            child.setY(y);
        }
    }


    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        Log.d("print", "----->" + velocityY + "  " + consumed);
        return true;
    }
}
