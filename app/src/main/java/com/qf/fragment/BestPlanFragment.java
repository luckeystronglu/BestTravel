package com.qf.fragment;

import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.adapter.BestPlanLvAdapter;
import com.qf.besttravel.R;
import com.qf.contacts.Contact;
import com.qf.entity.BannerItem;
import com.qf.entity.CarouselEntity;
import com.qf.entity.DestinationEntity;
import com.qf.utils.JSONUtil;
import com.qf.widget.NetworkImageHolderView;
import com.qf.widget.planlv.PlanListview;
import com.qfkf.base.BaseFragment;
import com.qfkf.util.DownUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2016/9/30.
 */
public class BestPlanFragment extends BaseFragment implements DownUtil.OnDownListener {

    private PlanListview bestplanLv;
    private BestPlanLvAdapter adapter;


    //顶部轮播图
    private ConvenientBanner convenientBanner;
    private List<String> imglist = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private List<BannerItem> bannerItems = new ArrayList<>();

    private String[] is;
    private String[] ts;



    @Override
    protected int getContentView() {
        return R.layout.fragment_bestplan;
    }

    @Override
    protected void init(View view) {

        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner_showGoods);
        bestplanLv = (PlanListview) view.findViewById(R.id.bestplan_lv_);
        adapter = new BestPlanLvAdapter(getContext());
        bestplanLv.setAdapter(adapter);

    }

//    //下载图片的封装方法
//    private void downimg(String url, ImageView img) {
//        Glide.with(getContext())
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.img_placeholder)
//                .thumbnail(0.1f)
//                .crossFade(500)
//                .into(img);
//    }



    //加载listview数据
    @Override
    protected void loadDatas() {
        //头部的轮播图
        initCarousel();

        //下载listview数据
        new DownUtil().setOnDownListener(this).downJSON(Contact.PLAN_DESTINATIONS);
    }


    //头部的轮播图
    private void initCarousel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Contact.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONUtil util = retrofit.create(JSONUtil.class);
        Call<CarouselEntity> call = util.getCarousel();
        call.enqueue(new Callback<CarouselEntity>() {
            @Override
            public void onResponse(Call<CarouselEntity> call, Response<CarouselEntity> response) {
                List<CarouselEntity.DataBean> data = response.body().getData();

                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getPhoto() != null){
//                        Log.d("pring", "onResponse: "+data.get(i).getPhoto().getPhoto_url());
                        imglist.add(data.get(i).getPhoto().getPhoto_url());
                    }

                }
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getPhoto() != null){
//                        Log.d("pring", "onResponse: "+data.get(i).getPhoto());
                        titles.add(data.get(i).getTopic());
                    }

                }

                is = new String[imglist.size()];
                for (int i = 0; i < imglist.size(); i++) {
                    is[i] = imglist.get(i);
                }

                ts = new String[titles.size()];
                for (int i = 0; i < titles.size(); i++) {
                    ts[i] = titles.get(i);
                }

                for (int i = 0; i < imglist.size(); i ++) {
                    bannerItems.add(new BannerItem(is[i], ts[i]));
                }

                convenientBanner
                        .setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                            @Override
                            public NetworkImageHolderView createHolder() {
                                return new NetworkImageHolderView();
                            }
                        }, bannerItems)
                        .setPageIndicator(new int[]{R.mipmap.abc_btn_radio_to_on_mtrl_000,
                                R.mipmap.abc_btn_radio_to_on_mtrl_015})
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                        .startTurning(2000);
            }

            @Override
            public void onFailure(Call<CarouselEntity> call, Throwable t) {

            }
        });

    }

    //下载listview数据
    @Override
    public Object paresJson(String json) {
        if (json != null) {
            try {
                JSONArray jarray = new JSONObject(json).optJSONArray("data");
                TypeToken<List<DestinationEntity.DataBean>> tt = new TypeToken<List<DestinationEntity.DataBean>>(){};
                return new Gson().fromJson(jarray.toString(),tt.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null){
            List<DestinationEntity.DataBean> dataBeanList = (List<DestinationEntity.DataBean>) object;
            adapter.setDatas(dataBeanList);

        }
    }




}
