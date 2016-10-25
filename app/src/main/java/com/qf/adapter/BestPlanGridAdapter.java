package com.qf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.R;
import com.qf.entity.DestinationEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/10/7.
 */
public class BestPlanGridAdapter extends BaseAdapter{
    private Context context;
    private List<DestinationEntity.DataBean.DestinationsBean> gridlist;

    public BestPlanGridAdapter(Context context) {
        this.context = context;
        this.gridlist = new ArrayList<>();
    }


    //设置数据源
    public void setDatas(List<DestinationEntity.DataBean.DestinationsBean> gridlist){
        this.gridlist = gridlist;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return gridlist.size();
    }

    @Override
    public Object getItem(int position) {
        return gridlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder viewHolder;
        if(convertView != null){
            viewHolder = (ListViewHolder) convertView.getTag();
        } else {
            viewHolder = new ListViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridv_1des, null);
            viewHolder.grid_tv_chn = (TextView) convertView.findViewById(R.id.plan_grid_item_textchn);
            viewHolder.grid_tv_eng = (TextView) convertView.findViewById(R.id.plan_grid_item_texteng);
            viewHolder.grid_img = (ImageView) convertView.findViewById(R.id.plan_grid_item_img);
            convertView.setTag(viewHolder);
        }

        viewHolder.grid_tv_chn.setText(gridlist.get(position).getName());
        viewHolder.grid_tv_eng.setText(gridlist.get(position).getName_en());
        Glide.with(context)
                .load(gridlist.get(position).getPhoto_url())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.img_placeholder)
                .thumbnail(0.1f)
                .crossFade(500)
                .into(viewHolder.grid_img);
        return convertView;
    }


    class ListViewHolder{
        protected TextView grid_tv_chn,grid_tv_eng;
        protected ImageView grid_img;
    }
}
