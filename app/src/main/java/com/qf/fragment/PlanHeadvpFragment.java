package com.qf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.R;

/**
 * Created by luckey on 2016/10/2.
 */
public class PlanHeadvpFragment extends android.support.v4.app.Fragment{
    private ImageView iv;

    /**
     * 定义一个静态工厂方法接受数据
     * @param url
     * @return
     */
    public static PlanHeadvpFragment getInstance(String url){
        PlanHeadvpFragment fragHeadVp = new PlanHeadvpFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragHeadVp.setArguments(bundle);
        return fragHeadVp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.head_vp, null);
        iv = (ImageView) view.findViewById(R.id.iv_head);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        //下载图片
        Glide.with(getContext()).
                load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv);
    }
}
