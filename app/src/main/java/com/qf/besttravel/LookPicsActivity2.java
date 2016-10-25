package com.qf.besttravel;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.entity.WorldNoteEntity;
import com.qfkf.base.BaseActivity;

import java.util.List;

/**
 * Created by lenovo on 2016/10/23.
 */
public class LookPicsActivity2 extends BaseActivity{

    TextView tv_num_now, tv_num_total;
    private ViewPager picvp;
    private PicsVpAdapter vpAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_lookpics;
    }

    @Override
    protected void init() {
        picvp = findViewByIds(R.id.pic_viewpager);
        tv_num_now = findViewByIds(R.id.pic_num_now);
        tv_num_total = findViewByIds(R.id.pic_num_total);
        Intent intent = getIntent();
        WorldNoteEntity worldNoteEntity = (WorldNoteEntity) intent.getSerializableExtra("entity2");
        List<WorldNoteEntity.ContentsBean> contents = worldNoteEntity.getContents();
        int po = intent.getIntExtra("picnum2",-1);
        tv_num_now.setText((po + 1) + "");
        tv_num_total.setText(contents.size() + "");
        vpAdapter = new PicsVpAdapter(this,contents);
        picvp.setAdapter(vpAdapter);
        picvp.setCurrentItem(po);
        picvp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_num_now.setText((position + 1) + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public static class PicsVpAdapter extends PagerAdapter{
        private Context context;
        private List<WorldNoteEntity.ContentsBean> piclist;

        public PicsVpAdapter(Context context,List<WorldNoteEntity.ContentsBean> piclist) {
            this.context = context;
            this.piclist = piclist;
        }

        @Override
        public int getCount() {
            return piclist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(context);
            photoView.enable();//可缩放
            photoView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context)
                    .load(piclist.get(position).getPhoto_url())
                    .crossFade(500)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.home_user_place_holder)
                    .thumbnail(0.1f)
                    .into(photoView);
            container.addView(photoView);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}

