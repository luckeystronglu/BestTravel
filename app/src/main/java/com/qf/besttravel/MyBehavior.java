package com.qf.besttravel;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ken on 2016/10/13.11:22
 */
public class MyBehavior extends CoordinatorLayout.Behavior{

    private int viewid;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getResources().obtainAttributes(attrs, R.styleable.behavior);
        viewid = typedArray.getResourceId(R.styleable.behavior_viewid, -1);
        typedArray.recycle();
    }

    /**
     * 确定依赖关系
     * @param parent
     * @param child 表示设置了该Behavior的对象，即需要依赖的控件对象
     * @param dependency 表示被依赖的对象
     * @return 如果返回true dependency就被确定为被依赖的对象
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == viewid;
    }

    /**
     * 监听被依赖对象，当被依赖的对象发生改变时，就会自动回调这个方法
     * @param parent
     * @param child 设置了Behavior的控件对象 这里是指id为view2的控件
     * @param dependency 被依赖的控件对象 这里是指id为view1的控件
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getY() + dependency.getHeight());
        return true;
    }
}
