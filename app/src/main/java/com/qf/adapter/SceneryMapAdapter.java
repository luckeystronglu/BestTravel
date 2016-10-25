package com.qf.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qf.besttravel.R;
import com.qf.entity.SceneryEntity;

import java.util.List;

/**
 * Created by lenovo on 2016/10/15.
 */
public class SceneryMapAdapter extends RecyclerView.Adapter<SceneryMapAdapter.SceneryHolder>{
    private Context context;
    private List<SceneryEntity.DataBean.DaysBean> daylist;
    private List<SceneryEntity.DataBean.DaysBean.PointsBean> pointlist;
    private Scenery2Adapter sce2Adapter;

    public SceneryMapAdapter(Context context, List<SceneryEntity.DataBean.DaysBean> daylist) {
        this.context = context;
        this.daylist = daylist;
    }

    public void setDatas(List<SceneryEntity.DataBean.DaysBean> daylist){
        this.daylist = daylist;
        this.notifyDataSetChanged();
    }

    @Override
    public SceneryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemlv_travel_days, parent, false);
        return new SceneryHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SceneryHolder holder, int position) {
        holder.tv_title.setText(daylist.get(position).getPoints().get(0).getInspiration_activity().getDestination().getName());
        holder.tv_summary.setText(daylist.get(position).getDescription());
        pointlist=daylist.get(position).getPoints();

        holder.smallrv.setLayoutManager(new LinearLayoutManager(context));
        sce2Adapter = new Scenery2Adapter(context,pointlist);
        holder.smallrv.setAdapter(sce2Adapter);
//        sce2Adapter.notifyDataSetChanged();
        sce2Adapter.setDatas(pointlist);

    }

    @Override
    public int getItemCount() {
        return daylist.size();
    }


    public class SceneryHolder extends RecyclerView.ViewHolder{

        TextView tv_title,tv_summary;
        RecyclerView smallrv;
        public SceneryHolder(View itemView) {
            super(itemView);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_day_destination);
            this.tv_summary = (TextView) itemView.findViewById(R.id.map_travel_tv_note);
            smallrv = (RecyclerView) itemView.findViewById(R.id.rv_days_scenery);
//            smallrv.setLayoutManager(new LinearLayoutManager(context));
        }
    }
}
