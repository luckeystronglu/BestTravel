package com.qf.besttravel;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.adapter.OrderAdapter;
import com.qf.contacts.Contact;
import com.qf.entity.TravelOrderEntity;
import com.qfkf.base.BaseActivity;
import com.qfkf.util.DownUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016/10/20.
 */
public class MakeOrderActivity extends BaseActivity implements DownUtil.OnDownListener {
//    @Bind(R.id.travel_map_days_title)
//    TextView travelMapDaysTitle;
//    @Bind(R.id.scenery_web_back)
//    ImageView sceneryWebBack;
//    @Bind(R.id.travel_order_rv)
//    RecyclerView travelOrderRv;



    private List<TravelOrderEntity.DataBean> datas= new ArrayList<>();;
    private RecyclerView recyclerView;

    private OrderAdapter adapter;

//    private TextView tv_onekey_title,tv_onekey_summary;


    @Override
    public int getContentViewId() {
        return R.layout.activity_travel_order;
    }


    @Override
    protected void init() {
//        tv_onekey_title = findViewByIds(R.id.xingcheng_onestep_title);
//        tv_onekey_summary = findViewByIds(R.id.xingcheng_onestep_summary);
//        tv_onekey_title.setText(datas.get(0).getTitle());
//        tv_onekey_summary.setText(datas.get(0).getSummary());

        recyclerView = (RecyclerView) findViewById(R.id.travel_order_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void loadDatas() {
        new DownUtil().setOnDownListener(this).downJSON(Contact.TRAVEL_ORDER);
    }

    @Override
    public Object paresJson(String json) {
        if (json != null){
            try {
                JSONArray jsonArray = new JSONObject(json).optJSONObject("data").optJSONArray("items");
                TypeToken<List<TravelOrderEntity.DataBean.ItemsBean>> tt = new TypeToken<List<TravelOrderEntity.DataBean.ItemsBean>>(){};
                return new Gson().fromJson(jsonArray.toString(),tt.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null){
            List<TravelOrderEntity.DataBean.ItemsBean> da = (List<TravelOrderEntity.DataBean.ItemsBean>) object;
            adapter.setDatas(da);
            Log.d("print", "downSucc: "+da);
            Log.d("print", "downSucc: "+da.size());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
