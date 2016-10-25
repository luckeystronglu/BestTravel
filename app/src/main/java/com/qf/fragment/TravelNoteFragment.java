package com.qf.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.adapter.TravelNoteAdapter2;
import com.qf.besttravel.R;
import com.qf.contacts.Contact;
import com.qf.entity.TravelNoteEntity;
import com.qfkf.base.BaseFragment;
import com.qfkf.util.DownUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by lenovo on 2016/9/30.
 */
public class TravelNoteFragment extends BaseFragment implements DownUtil.OnDownListener {
    private RecyclerView note_recycler;
    private TravelNoteAdapter2 adapter;


    //下拉刷新
    private SwipeRefreshLayout swipeRefreshLayout;

    private int page = 1;
    private boolean isBottom = false;
    private boolean isLoad = false;

    @Override
    protected int getContentView() {
        return R.layout.fragment_travelnote;
    }

    @Override
    protected void init(View view) {
        note_recycler = (RecyclerView) view.findViewById(R.id.travelnote_rv);
        note_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new TravelNoteAdapter2(getActivity());
        note_recycler.setAdapter(adapter);

//        note_recycler.setOnScrollListener(this);
    }

    @Override
    protected void loadDatas() {
        String note_url = String.format(Contact.TRAVEL_NOTE, page);
        new DownUtil().setOnDownListener(this).downJSON(note_url);
    }

    @Override
    public Object paresJson(String json) {
        if (json != null) {

            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray ja = jsonObject.getJSONArray("data");
                TypeToken<List<TravelNoteEntity>> tt = new TypeToken<List<TravelNoteEntity>>() {
                };
                return new Gson().fromJson(ja.toString(), tt.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            return new Gson().fromJson(json,TravelNoteEntity.class);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null) {
            List<TravelNoteEntity> list = (List<TravelNoteEntity>) object;
            adapter.setDatas(list);

            swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeFresh);
            swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.app_theme));
            swipeRefreshLayout.setColorSchemeColors(Color.BLUE);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    Log.d("print", "------>开始刷新，加载数据");

                    new Thread(){
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            //数据加载完成
                            getActivity().runOnUiThread(new Runnable() {
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

//    @Override
//    public void onScrollStateChanged(AbsListView view, int scrollState) {
//        switch (scrollState) {
//            case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
//                if (isBottom && !isLoad) {
//                    isLoad = true;
//                    page++;
//                    loadDatas();
//                }
//                break;
//        }
//    }
//
//    @Override
//    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//        if (firstVisibleItem + visibleItemCount == totalItemCount) {
//            isBottom = true;
//        } else {
//            isBottom = false;
//        }
//    }
}
