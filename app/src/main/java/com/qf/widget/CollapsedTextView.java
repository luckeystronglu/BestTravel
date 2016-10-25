package com.qf.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by luckey on 2016/7/18.
 */
public class CollapsedTextView extends TextView {
    private final String space = "http://schemas.android.com/apk/res/android";
    private boolean needCollapse;
    public boolean isCollapsed;
    private int maxLines;

    public CollapsedTextView(Context context) {
        this(context, null);
    }

    public CollapsedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollapsedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        maxLines = attrs.getAttributeIntValue(space, "maxLines", Integer.MAX_VALUE);
        init();
    }

    private void init() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (maxLines < getLineCount()) {//如果实际行数大于需要折叠的行数,就需要折叠
                    needCollapse = true;
                    setMaxLines(maxLines);
                    isCollapsed = true;
                } else {
                    needCollapse = false;
                }
//                Log.d("名字", getLineCount() + "行数" + needCollapse + "需要折叠:是否已折叠" + isCollapsed);
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public boolean isNeedCollapse() {
        return needCollapse;
    }

    public void collapse() {
        if (needCollapse && isCollapsed) {//如果需要折叠,并且已经折叠了,就张开
            setMaxLines(Integer.MAX_VALUE);
            isCollapsed = false;
        } else {//否则折叠
            setMaxLines(maxLines);
            isCollapsed = true;
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        init();
    }
}
