package com.qfkf.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qf.luckey.utillibrary.R;

/**
 * Created by Administrator on 2016/8/4.
 */
public class NavView extends FrameLayout {

    private LinearLayout ll_unchecked,ll_checked;
    private ImageView iv_checked;

    private int checkedImage,uncheckedImage;

    public NavView(Context context) {
        this(context,null);
    }

    public NavView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        parseAttrs(attrs);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_navview,this,true);
        ll_unchecked = (LinearLayout) findViewById(R.id.ll_unchecked);
        ll_checked = (LinearLayout) findViewById(R.id.ll_checked);
    }

    private void parseAttrs(AttributeSet attrs) {
        TypedArray typearray = getResources().obtainAttributes(attrs,R.styleable.NavView);
        checkedImage = typearray.getResourceId(R.styleable.NavView_checked,0);
        uncheckedImage = typearray.getResourceId(R.styleable.NavView_unchecked,0);
        typearray.recycle();

    }

    //设置viewpager的页数
    public void setCount(int count) {
        ll_unchecked.removeAllViews();
        ll_checked.removeAllViews();
        if (count <= 0) {
            return;
        }
        //添加未被选中的图片
        for (int i = 0; i < count; i++) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(uncheckedImage);
            iv.setPadding(10, 0, 10, 0);
            ll_unchecked.addView(iv);
        }

        //添加被选中的图片
        iv_checked = new ImageView(getContext());
        iv_checked.setImageResource(checkedImage);
        iv_checked.setPadding(10, 0, 10, 0);
        ll_checked.addView(iv_checked);
    }

    //设置需要联动的viewpager对象
        public void setViewPager(ViewPager viewpager){
            if (viewpager != null){
                viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        LinearLayout.LayoutParams layoutparams = (LinearLayout.LayoutParams) iv_checked.getLayoutParams();
                        layoutparams.leftMargin = (int) (iv_checked.getMeasuredWidth()*(position+positionOffset));
//                        Log.d("print",iv_checked.getWidth()+"");
                        iv_checked.setLayoutParams(layoutparams);
                    }

                    @Override
                    public void onPageSelected(int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }







    }
}
