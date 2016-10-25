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

/**
 * Created by lenovo on 2016/10/8.
 */
public class SelfTravelView extends LinearLayout {

    private ImageView self_img;
    private TextView self_title, self_subtitle;

    public SelfTravelView(Context context) {
        this(context, null);
    }

    public SelfTravelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelfTravelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.desinfo_03_item_model, this, true);
        self_img = (ImageView) findViewById(R.id.self_travel_img);
        self_title = (TextView) findViewById(R.id.self_travel_tvtop);
        self_subtitle = (TextView) findViewById(R.id.self_travel_tvsecond);
    }

    public void setdatas(String pic_url,String title,String subtitle) {
        Glide.with(getContext())
                .load(pic_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.img_placeholder)
                .thumbnail(0.1f)
                .crossFade(500)
                .into(self_img);
        self_title.setText(title);
        self_subtitle.setText(subtitle);
    }



}
