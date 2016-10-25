package com.qf.widget.plandetails;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.R;

import butterknife.OnClick;

/**
 * Created by lenovo on 2016/10/8.
 */
public class DestinationView extends LinearLayout {
//    @Bind(R.id.plan_grid_item_img)
//    ImageView planGridItemImg;
//    @Bind(R.id.plan_grid_item_textchn)
//    TextView planGridItemTextchn;
//    @Bind(R.id.plan_grid_item_texteng)
//    TextView planGridItemTexteng;
    private ImageView des_img;
    private TextView des_tv_chn, des_tv_eng;

    public DestinationView(Context context) {
        this(context, null);
    }

    public DestinationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DestinationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_gridv_1des, this, true);
        des_img = (ImageView) findViewById(R.id.plan_grid_item_img);
        des_tv_chn = (TextView) findViewById(R.id.plan_grid_item_textchn);
        des_tv_eng = (TextView) findViewById(R.id.plan_grid_item_texteng);
    }

    public void setdatas(String pic_url,String tv_chn,String tv_eng) {
        Glide.with(getContext())
                .load(pic_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.img_placeholder)
                .thumbnail(0.1f)
                .crossFade(500)
                .into(des_img);
        des_tv_chn.setText(tv_chn);
        des_tv_eng.setText(tv_eng);
    }


    @OnClick(R.id.plan_des_item)
    public void onClick() {

    }
}
