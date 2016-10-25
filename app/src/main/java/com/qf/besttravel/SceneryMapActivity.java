package com.qf.besttravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qf.adapter.SceneryMapAdapter;
import com.qf.entity.SceneryEntity;
import com.qfkf.base.BaseActivity;
import com.qfkf.util.DownUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016/10/15.
 */
public class SceneryMapActivity extends BaseActivity implements DownUtil.OnDownListener {
//    @Bind(R.id.plan_mapdays_lv)
//    RecyclerView planMapdaysLv;
//    @Bind(R.id.travel_map_days_title)
//    TextView travelMapDaysTitle;
//    @Bind(R.id.travel_map_days_back)
//    ImageView travelMapDaysBack;
    @Bind(R.id.plan_maptravel_share)
    ImageView planMaptravelShare;
    @Bind(R.id.relative_mapdays_head)
    RelativeLayout relativeMapdaysHead;

    private String mapurl;
    private SceneryMapAdapter adapter;

    private RecyclerView planMapdaysLv;
    private TextView travelMapDaysTitle;
    private ImageView travelMapDaysBack;


    @Override
    public int getContentViewId() {
        return R.layout.activity_travelmap_scenery;
    }

    @Override
    protected void init() {
        travelMapDaysBack = findViewByIds(R.id.travel_map_days_back);
        planMapdaysLv = findViewByIds(R.id.plan_mapdays_lv);
        travelMapDaysTitle = findViewByIds(R.id.travel_map_days_title);

        travelMapDaysBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        mapurl = intent.getStringExtra("mapurl");
        Log.d("print", "init: mapurl"+mapurl);
    }

    @Override
    protected void loadDatas() {
        new DownUtil().setOnDownListener(this).downJSON(mapurl);
    }

    @Override
    public Object paresJson(String json) {
        if(json!=null){
            return new Gson().fromJson(json.toString(), SceneryEntity.class);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null) {
            SceneryEntity sceneryEntity = (SceneryEntity) object;
            travelMapDaysTitle.setText(sceneryEntity.getData().getTitle());

            List<SceneryEntity.DataBean.DaysBean> daysBeanList = sceneryEntity.getData().getDays();

            planMapdaysLv.setLayoutManager(new LinearLayoutManager(this));
            adapter = new SceneryMapAdapter(this,daysBeanList);
            planMapdaysLv.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
            adapter.setDatas(daysBeanList);

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
