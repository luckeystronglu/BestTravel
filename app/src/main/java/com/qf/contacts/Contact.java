package com.qf.contacts;

/**
 * Created by lenovo on 2016/9/30.
 */
public interface Contact {
    //头部图片
    String BASE_URL = "http://q.chanyouji.com/";
//    String PLAN_HEADIMG="api/v1/adverts.json?market=qq&first_launch=false";
    //攻略 目的地列表
    String PLAN_DESTINATIONS="http://q.chanyouji.com/api/v2/destinations.json";

    //攻略 目的地详情
    String PAGE_STRATEGY="http://q.chanyouji.com/api/v3/destinations/%d.json";

    //攻略 每一个X日游详情
    String PAGE_STRATEGY_DETAILS="http://q.chanyouji.com/api/v2/plans/%d.json";

    //游记接口
    String TRAVEL_NOTE = "http://q.chanyouji.com/api/v1/timelines.json?page=%d";

    //
    String NOTE_WORLD_NOTE = "http://q.chanyouji.com/api/v1/users/%s/user_activities.json?parent_district_id=%d&page=%d";
//    String NOTE_USER_ALLNOTE2 = "http://q.chanyouji.com/api/v1/users/2098/user_activities.json?parent_district_id=100048&page=1";


    //行程单
    String TRAVEL_ORDER = "http://q.chanyouji.com/api/v1/albums/37.json";
}
