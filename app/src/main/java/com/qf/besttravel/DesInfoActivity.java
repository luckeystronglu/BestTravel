package com.qf.besttravel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.qf.contacts.Contact;
import com.qf.entity.DesInfoEntity;
import com.qf.widget.DesInfoScrollview;
import com.qf.widget.plandetails.DestinationView;
import com.qf.widget.plandetails.SelfTravelView;
import com.qfkf.base.BaseActivity;
import com.qfkf.util.DownUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2016/10/7.
 */
public class DesInfoActivity extends BaseActivity implements DownUtil.OnDownListener, RadioGroup.OnCheckedChangeListener{
    @Bind(R.id.des_info_bigimg)
    ImageView desInfoBigimg;
    @Bind(R.id.des_info_withimg_text)
    TextView desInfoWithimgText;
    @Bind(R.id.des_info_withimg_englishtext)
    TextView desInfoWithimgEnglishtext;
    @Bind(R.id.des_info_proname)
    TextView desInfoProname;
    @Bind(R.id.plan_info_back_logo)
    ImageView planInfoBackLogo;
//    @Bind(R.id.relative_des_headinfo)
//    RelativeLayout relativeDesHeadinfo;
    @Bind(R.id.tv_destination)
    TextView tvDestination;
    @Bind(R.id.horizontal_des_city)
    LinearLayout horizontalDesCity;
    @Bind(R.id.des_map)
    TextView desMap;
    @Bind(R.id.classic_route)
    TextView classicRoute;
    //    @Bind(R.id.bmapView)
//    MapView bmapView;
    @Bind(R.id.btn_onmap)
    Button btnOnmap;
    @Bind(R.id.map_rg)
    RadioGroup mapRg;
    @Bind(R.id.travel_list)
    TextView travelList;


    @Bind(R.id.des_related_travel_notes)
    TextView desRelatedTravelNotes;
    @Bind(R.id.des_related_big_img)
    ImageView desRelatedBigImg;
    @Bind(R.id.des_note_img_count)
    TextView desNoteImgCount;
    @Bind(R.id.travel_note_tv_by)
    TextView travelNoteTvBy;
    @Bind(R.id.travel_note_tv_name)
    TextView travelNoteTvName;
    @Bind(R.id.travel_note_tv_title)
    TextView travelNoteTvTitle;
    @Bind(R.id.des_note_tv_detail)
    TextView desNoteTvDetail;
    @Bind(R.id.button_text)
    TextView buttonText;
    @Bind(R.id.ll_destination)
    LinearLayout llDestination;
    @Bind(R.id.desinfo_map)
    LinearLayout desinfoMap;
    @Bind(R.id.desinfo_self_travel)
    LinearLayout desinfoSelfTravel;
    @Bind(R.id.desinfo_note_relate)
    LinearLayout desinfoNoteRelate;

    @Bind(R.id.line_self_travel)
    LinearLayout lineSelfTravel;
    @Bind(R.id.plan_desinfo_scro)
    DesInfoScrollview planDesinfoScro;


    private RelativeLayout relativeDesHeadinfo;


    private int id;
    private double lat, lng; //纬度、经度

    private String baiducity;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new BDLocationListener() {
        @Override
        public void onReceiveLocation(BDLocation location) {

            //接收定位返回结果
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");


                //获得经纬度
//                lat = location.getLatitude();
//                lng = location.getLongitude();
                baiducity = location.getCity();//获取当前城市


//                Log.d("print", "onReceiveLocation: baiducity  "+ baiducity);
//                Log.d("print", "定位坐标Latitude： "+ lat +" Longitude:"+ lng);
//                Toast.makeText(DesInfoActivity.this, "您现在位于"+baiducity+",当前位置为北纬：" + lat + "，东经:" + lng, Toast.LENGTH_SHORT).show();


                //构建Marker图标
                BitmapDescriptor bitmap = BitmapDescriptorFactory
                        .fromResource(R.drawable.location);
                //构建MarkerOption，用于在地图上添加Marker
                MarkerOptions option = new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .icon(bitmap)
                        .draggable(true);//可拖拽

                // 生长动画
                option.animateType(MarkerOptions.MarkerAnimateType.grow);


                //在地图上添加Marker，并显示
                map.addOverlay(option);

                //设置地图显示的位置
                MapStatus mMapStatus = new MapStatus.Builder()
                        .target(new LatLng(lat, lng))//地图显示位置的中心点
                        .build();


                MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
                map.setMapStatus(mMapStatusUpdate);

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }

            }
            Log.d("print", sb.toString());
//            Toast.makeText(DingWeiActivity.this, "----->" + sb, Toast.LENGTH_SHORT).show();
        }
    };


    //地图相关
    private MapView mMapView;
    private BaiduMap map;

    //经典线路相关
    private List<DesInfoEntity.DataBean.SectionsBean.ModelsBean> models2;
    int[] colors = {Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.CYAN};
    private int mapid;
    private String mapurl;
    private List<DesInfoEntity.DataBean.SectionsBean> sectionlist;

    //    private ViewTreeObserver vto;

    @Override
    public int getContentViewId() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        return R.layout.activity_desinfo;
    }

    @Override
    protected void init() {



        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        lat = intent.getDoubleExtra("lat", 22.61);//获取纬度，默认深圳市纬度
        lng = intent.getDoubleExtra("lng", 114.06);//获取经度，默认深圳市经度
        if (id != -1) {
            String url = String.format(Contact.PAGE_STRATEGY, id);
            new DownUtil().setOnDownListener(this).downJSON(url);
        }

        mMapView = (MapView) findViewById(R.id.bmapView);
        map = mMapView.getMap();

        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数

        initLocation();

        mLocationClient.start();//开始定位

//        setalpha();

    }

  /*  private void setalpha() {
        Log.d("print", "setalpha: "+height);
        relativeDesHeadinfo = findViewByIds(R.id.relative_des_headinfo);
        relativeDesHeadinfo.setBackgroundColor(Color.parseColor("#50D2DE"));
        planDesinfoScro.setScrollViewListener(this);
//        vto = desInfoBigimg.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                desInfoBigimg.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                height = desInfoBigimg.getHeight();
////                desInfoBigimg.getWidth();
//                planDesinfoScro.setScrollViewListener(DesInfoActivity.this);
//            }
//
//        });
    }

    @Override
    public void onScrollChanged(DesInfoScrollview scrollView, int x, int y, int oldx, int oldy) {
        if (y <= height/2){
            relativeDesHeadinfo.setBackgroundColor(Color.argb(0x00,0x50,0xD2,0xDE));
        }
        else if (y <= height && height/2 <y){
            float scale =(float) y /height;
            float alpha =  (255 * scale);
            relativeDesHeadinfo.setBackgroundColor(Color.argb((int) alpha,0x50,0xD2,0xDE));
        }
        else if (y > height){
            relativeDesHeadinfo.setBackgroundColor(Color.argb(0xEE,0x50,0xD2,0xDE));
        }

    }*/



  /*  @Override
    public void onScrollChanged(DesInfoScrollview scrollView, int x, int y, int oldx, int oldy) {
        if (y <= height){
            float scale =(float) y /height;
            float alpha =  (255 * scale);
            relativeDesHeadinfo.setBackgroundColor(Color.argb((int) alpha,0x50,0xD2,0xDE));
        }
    }*/

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0; //仅定位一次
//        int span= 5000; //每隔5秒定位一次
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    //下载图片的封装方法
    private void glidedownimg(String url, ImageView img) {
        Glide.with(DesInfoActivity.this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.img_placeholder)
                .thumbnail(0.1f)
                .crossFade(500)
                .into(img);
    }


    @Override
    public Object paresJson(String json) {
        if (json != null) {
            return new Gson().fromJson(json.toString(), DesInfoEntity.class);
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null) {
            final DesInfoEntity desInfoEntity = (DesInfoEntity) object;
            String url_bigimg = desInfoEntity.getData().getDestination().getPhoto_url();
            glidedownimg(url_bigimg, desInfoBigimg);//下载目的地背景大图
            desInfoProname.setText(desInfoEntity.getData().getDestination().getName());
            desInfoWithimgText.setText(desInfoEntity.getData().getDestination().getName());
            desInfoWithimgEnglishtext.setText(desInfoEntity.getData().getDestination().getName_en());
            sectionlist = desInfoEntity.getData().getSections();
            for (DesInfoEntity.DataBean.SectionsBean sectionsBean : sectionlist) {
                switch (sectionsBean.getType()) {
                    case "Destination"://目的地
                        llDestination.setVisibility(View.VISIBLE);
                        tvDestination.setText(sectionsBean.getTitle());
                        desMap.setText(sectionsBean.getButton_text());
                        List<DesInfoEntity.DataBean.SectionsBean.ModelsBean> models = sectionsBean.getModels();
                        for (DesInfoEntity.DataBean.SectionsBean.ModelsBean model : models) {
                            DestinationView desview = new DestinationView(getApplicationContext());
                            desview.setdatas(model.getPhoto_url(), model.getName(), model.getName_en());
                            desview.setPadding(10, 10, 10, 10);
                            horizontalDesCity.addView(desview);
                        }
                        break;
                    case "Plan"://经典线路
                        desinfoMap.setVisibility(View.VISIBLE);
                        classicRoute.setText(sectionsBean.getTitle());
                        btnOnmap.setText(sectionsBean.getModels().get(0).getTitle());

                        models2 = sectionsBean.getModels();

                        for (int i = 0; i < models2.size(); i++) {
                            LinearLayout.LayoutParams params = new LinearLayout
                                    .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            params.leftMargin = 20;
                            params.rightMargin = 10;
                            RadioButton rb = new RadioButton(DesInfoActivity.this);
                            rb.getLayoutParams();
                            rb.setText(models2.get(i).getDays_count() + "日行程");
                            rb.setTextColor(colors[i]);
                            rb.setTextSize(18);
                            rb.setId(i);
                            rb.setButtonDrawable(android.R.color.transparent);

//                            rb.setButtonDrawable(R.drawable.plan_sce_button_shape);
                            rb.setBackgroundColor(Color.parseColor("#50D2DE"));
//                            rb.setLayoutParams(params);
                            rb.setPadding(30, 10, 30, 10);
                            mapRg.setLayoutParams(params);
                            mapRg.addView(rb);

                            mapid = sectionsBean.getModels().get(i).getId();
//                            Log.d("print", "downSucc: mapid"+sectionsBean.getModels().get(i).getId());
//                            mapurl = String.format(Contact.PAGE_STRATEGY_DETAILS, mapid);

                            mapRg.setOnCheckedChangeListener(this);
                            mapRg.getChildAt(0).performClick();
                        }
                        break;

                    //旅行榜单：
                    case "SearchActivityCollectionDestinationEntity":
                        desinfoSelfTravel.setVisibility(View.VISIBLE);
                        List<DesInfoEntity.DataBean.SectionsBean.ModelsBean> model3 = sectionsBean.getModels();
                        for (DesInfoEntity.DataBean.SectionsBean.ModelsBean m3 : model3) {
                            SelfTravelView selftview = new SelfTravelView(getApplicationContext());
                            selftview.setdatas(m3.getPhoto_url(), m3.getTitle(), m3.getSummary());
                            lineSelfTravel.addView(selftview);
                        }
                        break;

                    case "UserActivity"://相关氢游记
                        desinfoNoteRelate.setVisibility(View.VISIBLE);
                        desRelatedTravelNotes.setText(sectionsBean.getTitle());
                        buttonText.setText(sectionsBean.getButton_text());

                        List<DesInfoEntity.DataBean.SectionsBean.ModelsBean> model4 = sectionsBean.getModels();
                        for (DesInfoEntity.DataBean.SectionsBean.ModelsBean mo : model4) {
                            travelNoteTvTitle.setText(mo.getTitle());
                            travelNoteTvName.setText(mo.getUser().getName());
                            travelNoteTvTitle.setText(mo.getTopic());
                            desNoteTvDetail.setText(mo.getDescription());

                            desNoteImgCount.setText(mo.getContents_count());

                            //下载图片
                            glidedownimg(mo.getContents().get(0).getPhoto_url(), desRelatedBigImg);

                        }
                        break;

                }
            }

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case 0:
                btnOnmap.setText(models2.get(0).getTitle());
                btnOnmap.setTextColor(colors[0]);
                mapid = models2.get(0).getId();
                mapurl = String.format(Contact.PAGE_STRATEGY_DETAILS, mapid);
                break;
            case 1:
                btnOnmap.setText(models2.get(1).getTitle());
                btnOnmap.setTextColor(colors[1]);
                mapid = models2.get(1).getId();
                mapurl = String.format(Contact.PAGE_STRATEGY_DETAILS, mapid);
                break;
            case 2:
                btnOnmap.setText(models2.get(2).getTitle());
                btnOnmap.setTextColor(colors[2]);
                mapid = models2.get(2).getId();
                mapurl = String.format(Contact.PAGE_STRATEGY_DETAILS, mapid);
                break;
            case 3:
                btnOnmap.setText(models2.get(3).getTitle());
                btnOnmap.setTextColor(colors[3]);
                mapid = models2.get(3).getId();
                mapurl = String.format(Contact.PAGE_STRATEGY_DETAILS, mapid);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.des_map, R.id.btn_onmap, R.id.map_rg, R.id.plan_info_back_logo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.des_map:
                break;
            case R.id.btn_onmap:
                Log.d("print","onClick+执行了");
                Intent intent=new Intent(DesInfoActivity.this, SceneryMapActivity.class);
                intent.putExtra("mapurl",mapurl);
                startActivity(intent);
                break;
            case R.id.map_rg:
                break;
            case R.id.plan_info_back_logo:
                finish();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }




//    @Override
//    public boolean isOpenStatus() {
//        return false;
//    }
}
