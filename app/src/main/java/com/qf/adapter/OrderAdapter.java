package com.qf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.besttravel.R;
import com.qf.entity.TravelOrderEntity;
import com.qf.widget.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/10/20.
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {


    private Context context;
    private List<TravelOrderEntity.DataBean.ItemsBean> list;
//    private List<TravelOrderEntity.DataBean> onkeylist;

    public OrderAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
//        this.onkeylist = new ArrayList<>();
    }

    public void setDatas(List<TravelOrderEntity.DataBean.ItemsBean> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }


    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.item_order_rv, parent, false);
        return new OrderHolder(inflate);
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {

            holder.tv_ordertitle.setText(list.get(position).getTitle());
            holder.tv_ordersummary.setText(list.get(position).getDescription());
            Glide.with(context)
                    .load(list.get(position).getPhoto().getPhoto_url())
                    .crossFade(500)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.img_placeholder)
                    .transform(new GlideCircleTransform(context))
                    .thumbnail(0.1f)
                    .into(holder.iv_order);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder {
        TextView tv_ordertitle, tv_ordersummary;
        ImageView iv_order;

//        TextView tv_onekey_title,tv_onekey_summary;
        public OrderHolder(View itemView) {
            super(itemView);
            this.tv_ordertitle = (TextView) itemView.findViewById(R.id.order_tv_title);
            this.tv_ordersummary = (TextView) itemView.findViewById(R.id.order_tv_summary);
            this.iv_order = (ImageView) itemView.findViewById(R.id.order_iv);
//            this.tv_onekey_title = (TextView) itemView.findViewById(R.id.xingcheng_onestep_title);
//            this.tv_onekey_summary = (TextView) itemView.findViewById(R.id.xingcheng_onestep_summary);
        }
    }
}
