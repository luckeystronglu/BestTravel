package com.qf.besttravel;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.qf.adapter.TravelPagerAdapter;
import com.qf.fragment.BestPlanFragment;
import com.qf.fragment.MineFragment;
import com.qf.fragment.TravelNoteFragment;
import com.qf.fragment.TravelOrderFragment;
import com.qfkf.base.BaseActivity;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener {
    private ViewPager vp;
    private TabLayout tabLayout;
    private RadioButton radioButton;
    private int [] img_cover = {R.mipmap.icon_tab_home,R.mipmap.icon_tab_trip,R.mipmap.icon_tab_plan,R.mipmap.icon_tab_my};
    private String [] tabs={"攻略","游记","行程单","我的"};



    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        vp = (ViewPager) findViewById(R.id.travel_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        initViewpager(vp);
        vp.setOffscreenPageLimit(3);
        //此处的方法是为了页面和标题联动
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.getTabAt(0).setText("");
        tabLayout.getTabAt(0).setIcon(img_cover[0]);
        tabLayout.getTabAt(0).select();

        radioButton = findViewByIds(R.id.search_trip);
        radioButton.setOnClickListener(this);

    }

    /**
     * 初始化一个viewpagerd的方法
     *
     * @param viewPager
     */
    private void initViewpager(ViewPager viewPager) {
        TravelPagerAdapter adapter = new TravelPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BestPlanFragment(), tabs[0]);
        adapter.addFragment(new TravelNoteFragment(), tabs[1]);
        adapter.addFragment(new TravelOrderFragment(), tabs[2]);
        adapter.addFragment(new MineFragment(), tabs[3]);
        viewPager.setAdapter(adapter);

    }



    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.setText("");
        tab.setIcon(img_cover[tab.getPosition()]);
        vp.setCurrentItem(tab.getPosition());
    }


    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.setIcon(null);
        tab.setText(tabs[tab.getPosition()]);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    private long presstime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * web.canGoBack()判断webview是否有可以返回的页面
         */
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - presstime < 2000) {
                this.finish();
            } else {
                Toast.makeText(MainActivity.this, "再按一次退出氢气球", Toast.LENGTH_SHORT).show();
                presstime = System.currentTimeMillis();
            }

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,SearchActivity.class));
    }

    /***
     * 沉浸式状态栏
     *
     * @return
     */
//    @Override
//    public boolean isOpenStatus() {
//        return false;
//    }
}
