package com.qf.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.LookPlanWebActivity;
import com.qf.besttravel.R;
import com.qf.entity.SceneryEntity;

import java.util.List;

/**
 * Created by lenovo on 2016/10/15.
 */
public class Scenery2Adapter extends RecyclerView.Adapter<Scenery2Adapter.SceneryHolder>{
    private Context context;
    private List<SceneryEntity.DataBean.DaysBean.PointsBean> pointlist;

    public Scenery2Adapter(Context context, List<SceneryEntity.DataBean.DaysBean.PointsBean> pointlist) {
        this.context = context;
        this.pointlist = pointlist;
    }

    public void setDatas(List<SceneryEntity.DataBean.DaysBean.PointsBean> pointlist){
        this.pointlist = pointlist;
        this.notifyDataSetChanged();
    }

    @Override
    public SceneryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemgv_travel_day, parent, false);
        return new SceneryHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final SceneryHolder holder, final int position) {
        if(pointlist.get(position).getInspiration_activity().getIcon_type() == 2){
            holder.leftmark_img.setImageResource(R.drawable.icon_plan_scenery);

        }else{
            holder.leftmark_img.setImageResource(R.drawable.icon_plan_food);
        }

        holder.tv_scenery_title.setText(pointlist.get(position).getInspiration_activity().getTopic());
        holder.tv_scenery_city.setText(pointlist.get(position).getInspiration_activity().getDestination().getName());
        holder.tv_plan_time.setText("建议玩"+pointlist.get(position).getInspiration_activity().getVisit_tip());
        holder.tv_scenery_summary.setText(pointlist.get(position).getInspiration_activity().getIntroduce());

        holder.tv_planAndNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LookPlanWebActivity.class);
                intent.putExtra("web_url",pointlist.get(position).getPoi().getH5_url());
                context.startActivity(intent);
            }
        });

        Glide.with(context)
                .load(pointlist.get(position).getInspiration_activity().getPhoto().getPhoto_url())
                .crossFade(500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.home_user_place_holder)
//                .transform(new GlideCircleTransform(context))
                .thumbnail(0.1f)
                .into(holder.scenery_bigimg);

//        holder.travel_days_ll.setVisibility(View.GONE);
        holder.travel_days_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.travel_days_ll.getVisibility() == View.GONE){
                    holder.travel_days_ll.setVisibility(View.VISIBLE);
                }else {
                    holder.travel_days_ll.setVisibility(View.GONE);
                }
            }
        });

        /**
         * 首先把所有布局设置为默认隐藏
         */
//        final SceneryHolder viewHolder1 = holder;
//        viewHolder1.travel_days_ll.setVisibility(View.GONE);
//        holder.travel_days_relative.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(viewHolder1.travel_days_ll.getVisibility()==View.GONE){
//                    viewHolder1.travel_days_ll.setVisibility(View.VISIBLE);
//                }else {
//                    viewHolder1.travel_days_ll.setVisibility(View.GONE);
//                }
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return pointlist.size();
    }


    public class SceneryHolder extends RecyclerView.ViewHolder{

        ImageView leftmark_img,scenery_bigimg;
        TextView tv_scenery_title,tv_scenery_city,tv_last_distance,tv_plan_time,tv_scenery_summary,tv_planAndNote;
        LinearLayout travel_days_ll;
        RelativeLayout travel_days_relative;

        public SceneryHolder(View itemView) {
            super(itemView);
            this.leftmark_img = (ImageView) itemView.findViewById(R.id.travel_day_leftmark_img);
            this.scenery_bigimg = (ImageView) itemView.findViewById(R.id.travel_days_scenery_bigimg);
            this.tv_scenery_title = (TextView) itemView.findViewById(R.id.tv_scenery_title);
            this.tv_scenery_city = (TextView) itemView.findViewById(R.id.tv_scenery_city);
            this.tv_last_distance = (TextView) itemView.findViewById(R.id.tv_scenery_last_distance);
            this.tv_plan_time = (TextView) itemView.findViewById(R.id.tv_scenery_plan_time);
            this.tv_scenery_summary = (TextView) itemView.findViewById(R.id.travel_days_scenery_summary);
            this.tv_planAndNote = (TextView) itemView.findViewById(R.id.travel_days_plan_note);
            this.travel_days_ll = (LinearLayout) itemView.findViewById(R.id.travel_days_ll);
            this.travel_days_relative = (RelativeLayout) itemView.findViewById(R.id.travel_days_relative);
//            this.travel_days_ll.setVisibility(View.GONE);
        }
    }
}
