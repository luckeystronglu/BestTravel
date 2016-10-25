package com.qf.besttravel;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.adapter.WorldNoteAdapter;
import com.qf.contacts.Contact;
import com.qf.entity.WorldNoteEntity;
import com.qf.widget.GlideCircleTransform;
import com.qfkf.base.BaseActivity;
import com.qfkf.util.DownUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by lenovo on 2016/10/21.
 */
public class WorldNoteActivity extends BaseActivity implements DownUtil.OnDownListener {
    private RecyclerView worldnote_rv;
    private WorldNoteAdapter adapter;
    //下拉刷新
    private SwipeRefreshLayout swipeRefreshLayout;


    private int page = 1;
//    private boolean isBottom = false;
//    private boolean isLoad = false;
    private String user_id;
    private int area_id;
    private String areaname;

    private ImageView worldnote_user_img,worldnote_back;
    private TextView worldnote_user_tv;
    private TextView worldnote_areaname;
    private List<WorldNoteEntity> list;

    @Override
    public int getContentViewId() {
        return R.layout.activity_worldnote;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        user_id = intent.getStringExtra("user_id");
        area_id = intent.getIntExtra("area_id", -1);
        areaname = intent.getStringExtra("areaname");
        String user_img = intent.getStringExtra("worldnote_user_img");
        String user_tv = intent.getStringExtra("worldnote_user_tv");
        worldnote_back = findViewByIds(R.id.worldnote_back);
        worldnote_user_img = findViewByIds(R.id.worldnote_user_img);
        worldnote_user_tv = findViewByIds(R.id.worldnote_user_tv);
        worldnote_areaname = findViewByIds(R.id.worldnote_areaname);
        worldnote_user_tv.setText(user_tv);
        worldnote_areaname.setText(areaname);
        Glide.with(WorldNoteActivity.this)
                .load(user_img)
                .crossFade(500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideCircleTransform(this))
                .placeholder(R.drawable.home_user_place_holder)
                .thumbnail(0.1f)
                .into(worldnote_user_img);

        worldnote_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        worldnote_rv = (RecyclerView) findViewById(R.id.travelnote_rv);
        worldnote_rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WorldNoteAdapter(this);
        worldnote_rv.setAdapter(adapter);
    }

    @Override
    protected void loadDatas() {
        String world_url = String.format(Contact.NOTE_WORLD_NOTE, user_id, area_id, page);
        Log.d("print", "loadDatas world_url: "+world_url);
        new DownUtil().setOnDownListener(this).downJSON(world_url);
    }

    @Override
    public Object paresJson(String json) {
        if (json != null) {

            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray ja = jsonObject.getJSONArray("data");
                TypeToken<List<WorldNoteEntity>> tt = new TypeToken<List<WorldNoteEntity>>() {
                };
                return new Gson().fromJson(ja.toString(), tt.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null) {
            list = (List<WorldNoteEntity>) object;
            adapter.setDatas(list);


            swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeFresh);
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.app_theme));
            swipeRefreshLayout.setColorSchemeColors(Color.BLUE);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    Log.d("print", "------>开始刷新，加载数据");

                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            //数据加载完成
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //关闭刷新
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                            });
                        }
                    }.start();
                }
            });

        }
    }
}
