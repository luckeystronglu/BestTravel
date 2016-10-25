package com.qfkf.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/8/5.
 */
public class PullandFreshView extends LinearLayout implements View.OnTouchListener {

    //头部控件的视图
    private View headView;

    //列表对象
    private ListView listView;

    //头部控件的高度
    private int headViewHeight;

    private static final int NONE = 0;//普通状态
    private static final int PULL = 1;//正在下拉状态
    private static final int PULL_REFRESH = 2;//松手刷新状态
    private static final int REFRESHING = 3;//正在刷新状态
    private int state = NONE;//当前的控件状态

    /**
     *  下拉刷新的接口对象
     */
    private OnPullToRefreshListener onPullToRefreshListener;

    public void setOnPullToRefreshListener(OnPullToRefreshListener onPullToRefreshListener) {
        this.onPullToRefreshListener = onPullToRefreshListener;
    }


    public PullandFreshView(Context context) {
        this(context,null);
    }

    public PullandFreshView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PullandFreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化下拉刷新控件
    private void init() {
        this.setOrientation(VERTICAL);
    }
    /**
     * 设置头部控件
     * @param headView
     */
    public void setHeadView(View headView){
        this.headView = headView;
        initView();
    }

    public void setHeadView(int headViewLayout){
        View view = LayoutInflater.from(getContext()).inflate(headViewLayout, null);
        setHeadView(view);
    }

    /**
     * 设置头部以后，初始化控件
     */
    private void initView() {
        //将头部控件添加进LinearLayout中
        //隐藏头部内容
        headView.measure(0, 0);//测量宽高
        headViewHeight = headView.getMeasuredHeight();
        headView.setPadding(headView.getLeft(), -headViewHeight, headView.getRight(), headView.getBottom());
        this.addView(headView);

        //将ListView添加进LinearLayout中
        listView = new ListView(getContext());
        listView.setOnTouchListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.addView(listView, layoutParams);
    }

    /**
     * 暴露ListView的常用方法
     * @param baseAdapter
     */
    public void setAdapter(ListAdapter baseAdapter){
        if(listView != null){
            listView.setAdapter(baseAdapter);
        }
    }

    public void addHeaderView(View headView){
        if(listView != null){
            listView.addHeaderView(headView);
        }
    }

    public void addFooterView(View footView){
        if(listView != null){
            listView.addFooterView(footView);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener l){
        if(listView != null){
            listView.setOnScrollListener(l);
        }
    }

    public ListView getListView(){
        return listView;
    }

    /**
     * setOnTouchListener
     * 给当前控件设置一个手势监听器，onTouch方法
     * onTouch方法会先与当前控件的onTouchEvnent方法被调用
     * 如果onTouch方法返回true，则onTouchEvnent方法不会调用
     * 如果onTouch方法返回false，则onTouchEvnent方法会被调用
     * @param v
     * @param event
     * @return
     */
    private int by = -1;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                if(isPullTop()){
                    //事件不再传给ListView

                    //计算手指滑动的偏移量
                    int y = (int) event.getRawY();//基于屏幕的y值
                    if(by == -1){
                        by = y;
                    }
                    int movey = y - by;
                    by = y;

                    //如果往上滑动，并且头部没有被拉出来时，事件应该交给ListView处理
                    if(movey < 0 && headView.getPaddingTop() <= -headViewHeight && state == NONE){
                        return false;
                    }

                    //表示可以可以下拉了
                    headView.setPadding(headView.getPaddingLeft(), headView.getPaddingTop() + movey/2, headView.getPaddingRight(), headView.getPaddingBottom());

                    if(state != REFRESHING) {
                        if (headView.getPaddingTop() >= 0) {
                            state = PULL_REFRESH;//置为松手刷新的状态
                        } else if (headView.getPaddingTop() > -headViewHeight) {
                            state = PULL;
                        }

                        //-----------------------回调正在下拉的方法---------------------
                        if (onPullToRefreshListener != null) {
                            onPullToRefreshListener.pull(headView, (headView.getPaddingTop() + headViewHeight) / 2);
                        }
                    }

                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                reset();//调用重置方法
                break;
        }
        return false;
    }

    /**
     * 重置方法
     */
    private int backHeight;
    private Handler handler = new Handler();
    private void reset() {
        by = -1;//将by重置

        if(state == PULL || state == REFRESHING){//如果是下拉状态或者是正在刷新状态，那么重置到头部完全隐藏的高度
            backHeight = -headViewHeight;
            if(state == PULL) {
                state = NONE;//把状态置为普通状态
            }
        } else if(state == PULL_REFRESH){//如果是正在下拉状态，则重置到头部刚刚显示的高度
            backHeight = 0;
            state = REFRESHING;//把状态置为正在刷新状态
            //--------------------回调正在刷新的方法-------------------------
            if(onPullToRefreshListener != null){
                onPullToRefreshListener.refreshing(headView);
            }
        }

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(headView.getPaddingTop() > backHeight){
                            headView.setPadding(getPaddingLeft(), headView.getPaddingTop() - 5, getPaddingRight(), getPaddingBottom());
                        } else {
                            headView.setPadding(getPaddingLeft(), backHeight, getPaddingRight(), getPaddingBottom());
                            timer.cancel();
                        }
                    }
                });
            }
        }, 0, 5);
    }

    /**
     * 判断是否ListView拉到顶部
     * @return true 表示拉到顶部 false 表示 未拉到顶部
     */
    private boolean isPullTop(){

        if(listView.getChildCount() > 0){
            View view = listView.getChildAt(0);//获得ListView中的第一个控件
            int index = listView.getFirstVisiblePosition();
            int top = listView.getChildAt(0).getTop();
            if(top == 0 && index == 0){
                //表示ListView已经拉到顶部了
                return true;
            } else {
                return false;
            }
        } else {
            //如果ListView没有内容，则可以下拉
            return true;
        }
    }

    /**
     * 加载完成后调用
     */
    public void refreshCompelet(){
        reset();
        state = NONE;//重置状态
        //-------------------回调刷新完成的方法-------------------------
        if(onPullToRefreshListener != null){
            onPullToRefreshListener.refreshCompelet(headView);
        }
    }

    /**
     * 下拉刷新的接口回调
     */
    public interface OnPullToRefreshListener{
        //正在下拉
        void pull(View headView, int movey);

        //正在刷新
        void refreshing(View headView);

        //刷新完成
        void refreshCompelet(View headView);
    }


}
