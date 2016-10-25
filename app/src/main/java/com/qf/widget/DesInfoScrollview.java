package com.qf.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by lenovo on 2016/10/11.
 */
public class DesInfoScrollview extends ScrollView {

    private ScrollViewListener scrollViewListener = null;

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public DesInfoScrollview(Context context) {
        this(context,null);
    }

    public DesInfoScrollview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DesInfoScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }
    }

    public interface ScrollViewListener {

        void onScrollChanged(DesInfoScrollview scrollView, int x, int y,
                             int oldx, int oldy);

    }
}
