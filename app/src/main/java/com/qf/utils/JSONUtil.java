package com.qf.utils;

import com.qf.entity.CarouselEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface JSONUtil {


    @GET("api/v1/adverts.json?market=qq&first_launch=false")
    Call<CarouselEntity> getCarousel();


    //根据json解析首页vp中的实体数据集合
//    public static List<CaroulEntity> getHeaderByJson(String json){
//        try {
//            JSONArray jsonArray = new JSONObject(json).optJSONArray("data");
//
//            TypeToken<List<CaroulEntity>> tt = new TypeToken<List<CaroulEntity>>(){};
//            return new Gson().fromJson(jsonArray.toString(),tt.getType());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }



}
