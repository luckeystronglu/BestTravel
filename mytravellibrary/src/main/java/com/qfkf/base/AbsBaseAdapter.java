package com.qfkf.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qf.luckey.utillibrary.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 适配器的封装
 * Created by Ken on 2016/7/25.
 */
public abstract class AbsBaseAdapter<T> extends BaseAdapter{

    protected Context context;
    protected List<T> datas = new ArrayList<>();
    private int resId;//布局id

    public AbsBaseAdapter(Context context, int resId){
        this.context = context;
        this.resId = resId;
    }

    /**
     * 设置数据源
     */
    public void setDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    /**
     * 追加数据
     * @param datas
     */
    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    /**
     * 删除数据源
     * @param position
     */
    public void deleteDatas(int position){
        this.datas.remove(position);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if(convertView != null){
            viewHodler = (ViewHodler) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(resId, parent, false);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);
        }

        //为控件设置值
        bindDatas(viewHodler, datas.get(position));

        return convertView;
    }

    /**
     * 绑定数据
     */
    public abstract void bindDatas(ViewHodler viewHodler, T data);

    public class ViewHodler{
        private View layoutView;
        private Map<Integer, View> map = new HashMap<>();
        public ViewHodler(View layoutView){
            this.layoutView = layoutView;
        }

        public View getView(int id){
            View view ;
            if(map.containsKey(id)){
                view = map.get(id);
            } else {
                view = layoutView.findViewById(id);
                map.put(id, view);
            }
            return view;
        }

        /**
         * 设置TextView
         * @param id
         */
        public ViewHodler setTextView(int id, String value){
            TextView tv = (TextView) this.getView(id);
            tv.setText(value);
            return this;
        }

        /**
         * 设置ImageView
         * @param id
         * @param url
         * @return
         */
        public ViewHodler setImageView(int id, String url){
            ImageView iv = (ImageView) this.getView(id);
            Glide.with(context)
                    .load(url)
                    .placeholder(R.drawable.list_default_image)
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade(500)
                    .into(iv);
            return this;
        }
    }
}
