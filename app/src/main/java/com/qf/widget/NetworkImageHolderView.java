package com.qf.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.R;
import com.qf.entity.BannerItem;


/**
 * Created by Sai on 15/8/4.
 * 网络图片加载例子
 */
/*public class NetworkImageHolderView implements Holder<String> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, final int position, String data) {
        imageView.setImageResource(R.mipmap.icon_guide_headimg);
        Glide.with(context).load(data).into(imageView);
//        ImageLoader.getInstance().displayImage(data,imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击事件
                Toast.makeText(view.getContext(), "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
            }
        });
    }*/


public class NetworkImageHolderView implements Holder<BannerItem> {
    private View view;
    @Override
    public View createView(Context context) {
        //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
        view = LayoutInflater.from(context).inflate(R.layout.banner_item, null, false);

        return view;
    }

    @Override
    public void UpdateUI(Context context, final int position, BannerItem data) {
        ImageView imageView = (ImageView) view.findViewById(R.id.sdv_background);
        TextView tv = (TextView) view.findViewById(R.id.tv_title);
        tv.setText(data.getTitle());
        Glide.with(context)
                .load(data.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.img_placeholder)
                .thumbnail(0.1f)
                .crossFade(500)
                .into(imageView);
        Glide.with(context).load(data.getImage()).into(imageView);


    }
}