package com.qf.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2016/10/22.
 */
public class WorldNoteEntity implements Serializable{


    /**
     * id : 44402
     * made_at : 2016-05-02T01:10:24.000Z
     * likes_count : 5
     * comments_count : 1
     * topic : 寒酸的首里城
     * contents_count : 8
     * district_id : 57429
     * created_at : 2016-05-03T01:54:45.000Z
     * favorites_count : 1
     * parent_district_id : 100041
     * parent_district_count : 13
     * description : 首里城是琉球文化的代表建筑，当然也经历过战争，被毁过，然后重建了，即便如此，也还是朴素到寒酸啊～想想当个附属国国王也不过如此，拿着卖白菜的钱（王宫也不怎样），操着卖白粉的心（还要想着进贡和保家卫国）！
     单轨列车到首里城站下，一路上跟着指示牌进入首里城景点，大约走路也得十几二十分钟的样子。凭借单轨列车一日票，门票可以拿团体票的票价，660日圆。整个首里城景点给游客们一件有趣的任务，你可以在信息问询处拿到首里城景点地图，然后在每个景点盖章，地图上有专门盖章的地方，我感觉上海世博会盖章的劲头又来了！
     正殿是可以入内参观的，但不许拍照，还要脱鞋，进去参观不过更加了解琉球国王的生活多么简朴，看到琉球文化并没有超越中华文化的架势，我也就安心了！
     首里城东南角有一条石叠道，就是一两百年的一条石头台阶路，旁边还住着居民呢，游览完首里城就过去走了走，十分幽静！
     * current_user_liked : false
     * current_user_commented : false
     * current_user_favorited : false
     * contents : [{"id":276884,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276884/96b56079999f2f02297a07a076aa77b5.jpg","width":1920,"height":1283,"position":0},{"id":276885,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276885/7e48aef95f39f90583891f18c77a46ed.jpg","width":1920,"height":1283,"position":1},{"id":276886,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276886/7486f80402037bc616548bc5d3093933.jpg","width":1920,"height":1283,"position":2},{"id":276887,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276887/d0683ee9cae7a951ab416961a6daf374.jpg","width":1920,"height":1283,"position":3},{"id":276888,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276888/5c2db0e0b9a2669359984c1ed6d877c2.jpg","width":1920,"height":1283,"position":4},{"id":276889,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276889/ebb269642322ccb95f448e3dee430c0b.jpg","width":1920,"height":1283,"position":5},{"id":276890,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276890/eb0a7d36e9870262e93e5cdabb0cdb95.jpg","width":1920,"height":1283,"position":6},{"id":276891,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/276891/cd28cd7b6a0007684782b906f632dc01.jpg","width":1920,"height":1283,"position":7}]
     * districts : [{"id":100041,"name":"日本","name_en":"Japan","name_pinyin":"ri ben|rb","score":null,"level":2,"path":".120001.100041.","published":false,"is_in_china":false,"user_activities_count":309,"lat":36.2048,"lng":138.253,"is_valid_destination":true,"destination_id":31},{"id":57429,"name":"那霸","name_en":"Naha","name_pinyin":"na ba|nb","score":null,"level":4,"path":".120001.100041.292.57429.","published":false,"is_in_china":false,"user_activities_count":43,"lat":26.2285,"lng":127.689,"is_valid_destination":false,"destination_id":null}]
     * categories : [{"id":5523,"name":"五一假期","category_type":"activity"}]
     * poi : {"id":78975,"h5_url":"http://m.ctrip.com/webapp/you/sight/57429/13435.html?popup=close&autoawaken=close&allianceid=309340&sid=788076&ouid=","name":"首里城","name_en":"Shuri Castle","name_pinyin":"shou li cheng","business_id":13435,"poi_type":"SIGHT","district_id":57429,"lat":26.217167,"lng":127.719449,"address":"冲绳县那覇市首里金城町1-2","location_name":null,"blat":26.2138561531,"blng":127.7237710626,"youji_lat":26.217167,"youji_lng":127.719449,"youji_poi_id":37326,"youji_poi_name":"首里城","is_in_china":false,"local_name":"首里城","local_address_name":"沖縄県那覇市首里金城町１丁目２"}
     * user : {"id":2499,"name":"saintazure","gender":0,"level":4,"photo_url":"http://inspiration.chanyouji.cn/User/2499/d19037e8f2f64346abe70547466726a4.jpg"}
     * inspiration_activity_id : 7166
     * inspiration_activity : {"id":7166,"topic":"首里城：中日合璧的琉球国皇宫"}
     */

    private int id;
    private String made_at;
    private int likes_count;
    private int comments_count;
    private String topic;
    private int contents_count;
    private int district_id;
    private String created_at;
    private int favorites_count;
    private int parent_district_id;
    private int parent_district_count;
    private String description;
    private boolean current_user_liked;
    private boolean current_user_commented;
    private boolean current_user_favorited;
    /**
     * id : 78975
     * h5_url : http://m.ctrip.com/webapp/you/sight/57429/13435.html?popup=close&autoawaken=close&allianceid=309340&sid=788076&ouid=
     * name : 首里城
     * name_en : Shuri Castle
     * name_pinyin : shou li cheng
     * business_id : 13435
     * poi_type : SIGHT
     * district_id : 57429
     * lat : 26.217167
     * lng : 127.719449
     * address : 冲绳县那覇市首里金城町1-2
     * location_name : null
     * blat : 26.2138561531
     * blng : 127.7237710626
     * youji_lat : 26.217167
     * youji_lng : 127.719449
     * youji_poi_id : 37326
     * youji_poi_name : 首里城
     * is_in_china : false
     * local_name : 首里城
     * local_address_name : 沖縄県那覇市首里金城町１丁目２
     */

    private PoiBean poi;
    /**
     * id : 2499
     * name : saintazure
     * gender : 0
     * level : 4
     * photo_url : http://inspiration.chanyouji.cn/User/2499/d19037e8f2f64346abe70547466726a4.jpg
     */

    private UserBean user;
    private int inspiration_activity_id;
    /**
     * id : 7166
     * topic : 首里城：中日合璧的琉球国皇宫
     */

    private InspirationActivityBean inspiration_activity;
    /**
     * id : 276884
     * caption : null
     * photo_url : http://inspiration.chanyouji.cn/UserActivityContent/276884/96b56079999f2f02297a07a076aa77b5.jpg
     * width : 1920
     * height : 1283
     * position : 0
     */

    private List<ContentsBean> contents;
    /**
     * id : 100041
     * name : 日本
     * name_en : Japan
     * name_pinyin : ri ben|rb
     * score : null
     * level : 2
     * path : .120001.100041.
     * published : false
     * is_in_china : false
     * user_activities_count : 309
     * lat : 36.2048
     * lng : 138.253
     * is_valid_destination : true
     * destination_id : 31
     */

    private List<DistrictsBean> districts;
    /**
     * id : 5523
     * name : 五一假期
     * category_type : activity
     */

    private List<CategoriesBean> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMade_at() {
        return made_at;
    }

    public void setMade_at(String made_at) {
        this.made_at = made_at;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getContents_count() {
        return contents_count;
    }

    public void setContents_count(int contents_count) {
        this.contents_count = contents_count;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public int getParent_district_id() {
        return parent_district_id;
    }

    public void setParent_district_id(int parent_district_id) {
        this.parent_district_id = parent_district_id;
    }

    public int getParent_district_count() {
        return parent_district_count;
    }

    public void setParent_district_count(int parent_district_count) {
        this.parent_district_count = parent_district_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCurrent_user_liked() {
        return current_user_liked;
    }

    public void setCurrent_user_liked(boolean current_user_liked) {
        this.current_user_liked = current_user_liked;
    }

    public boolean isCurrent_user_commented() {
        return current_user_commented;
    }

    public void setCurrent_user_commented(boolean current_user_commented) {
        this.current_user_commented = current_user_commented;
    }

    public boolean isCurrent_user_favorited() {
        return current_user_favorited;
    }

    public void setCurrent_user_favorited(boolean current_user_favorited) {
        this.current_user_favorited = current_user_favorited;
    }

    public PoiBean getPoi() {
        return poi;
    }

    public void setPoi(PoiBean poi) {
        this.poi = poi;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getInspiration_activity_id() {
        return inspiration_activity_id;
    }

    public void setInspiration_activity_id(int inspiration_activity_id) {
        this.inspiration_activity_id = inspiration_activity_id;
    }

    public InspirationActivityBean getInspiration_activity() {
        return inspiration_activity;
    }

    public void setInspiration_activity(InspirationActivityBean inspiration_activity) {
        this.inspiration_activity = inspiration_activity;
    }

    public List<ContentsBean> getContents() {
        return contents;
    }

    public void setContents(List<ContentsBean> contents) {
        this.contents = contents;
    }

    public List<DistrictsBean> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictsBean> districts) {
        this.districts = districts;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class PoiBean implements Serializable{
        private int id;
        private String h5_url;
        private String name;
        private String name_en;
        private String name_pinyin;
        private int business_id;
        private String poi_type;
        private int district_id;
        private double lat;
        private double lng;
        private String address;
        private Object location_name;
        private double blat;
        private double blng;
        private double youji_lat;
        private double youji_lng;
        private int youji_poi_id;
        private String youji_poi_name;
        private boolean is_in_china;
        private String local_name;
        private String local_address_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getH5_url() {
            return h5_url;
        }

        public void setH5_url(String h5_url) {
            this.h5_url = h5_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_pinyin() {
            return name_pinyin;
        }

        public void setName_pinyin(String name_pinyin) {
            this.name_pinyin = name_pinyin;
        }

        public int getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(int business_id) {
            this.business_id = business_id;
        }

        public String getPoi_type() {
            return poi_type;
        }

        public void setPoi_type(String poi_type) {
            this.poi_type = poi_type;
        }

        public int getDistrict_id() {
            return district_id;
        }

        public void setDistrict_id(int district_id) {
            this.district_id = district_id;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getLocation_name() {
            return location_name;
        }

        public void setLocation_name(Object location_name) {
            this.location_name = location_name;
        }

        public double getBlat() {
            return blat;
        }

        public void setBlat(double blat) {
            this.blat = blat;
        }

        public double getBlng() {
            return blng;
        }

        public void setBlng(double blng) {
            this.blng = blng;
        }

        public double getYouji_lat() {
            return youji_lat;
        }

        public void setYouji_lat(double youji_lat) {
            this.youji_lat = youji_lat;
        }

        public double getYouji_lng() {
            return youji_lng;
        }

        public void setYouji_lng(double youji_lng) {
            this.youji_lng = youji_lng;
        }

        public int getYouji_poi_id() {
            return youji_poi_id;
        }

        public void setYouji_poi_id(int youji_poi_id) {
            this.youji_poi_id = youji_poi_id;
        }

        public String getYouji_poi_name() {
            return youji_poi_name;
        }

        public void setYouji_poi_name(String youji_poi_name) {
            this.youji_poi_name = youji_poi_name;
        }

        public boolean isIs_in_china() {
            return is_in_china;
        }

        public void setIs_in_china(boolean is_in_china) {
            this.is_in_china = is_in_china;
        }

        public String getLocal_name() {
            return local_name;
        }

        public void setLocal_name(String local_name) {
            this.local_name = local_name;
        }

        public String getLocal_address_name() {
            return local_address_name;
        }

        public void setLocal_address_name(String local_address_name) {
            this.local_address_name = local_address_name;
        }
    }

    public static class UserBean implements Serializable{
        private int id;
        private String name;
        private int gender;
        private int level;
        private String photo_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }
    }

    public static class InspirationActivityBean implements Serializable{
        private int id;
        private String topic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }
    }

    public static class ContentsBean implements Serializable{
        private int id;
        private Object caption;
        private String photo_url;
        private int width;
        private int height;
        private int position;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getCaption() {
            return caption;
        }

        public void setCaption(Object caption) {
            this.caption = caption;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public static class DistrictsBean implements Serializable{
        private int id;
        private String name;
        private String name_en;
        private String name_pinyin;
        private Object score;
        private int level;
        private String path;
        private boolean published;
        private boolean is_in_china;
        private int user_activities_count;
        private double lat;
        private double lng;
        private boolean is_valid_destination;
        private int destination_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_pinyin() {
            return name_pinyin;
        }

        public void setName_pinyin(String name_pinyin) {
            this.name_pinyin = name_pinyin;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public boolean isPublished() {
            return published;
        }

        public void setPublished(boolean published) {
            this.published = published;
        }

        public boolean isIs_in_china() {
            return is_in_china;
        }

        public void setIs_in_china(boolean is_in_china) {
            this.is_in_china = is_in_china;
        }

        public int getUser_activities_count() {
            return user_activities_count;
        }

        public void setUser_activities_count(int user_activities_count) {
            this.user_activities_count = user_activities_count;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public boolean isIs_valid_destination() {
            return is_valid_destination;
        }

        public void setIs_valid_destination(boolean is_valid_destination) {
            this.is_valid_destination = is_valid_destination;
        }

        public int getDestination_id() {
            return destination_id;
        }

        public void setDestination_id(int destination_id) {
            this.destination_id = destination_id;
        }
    }

    public static class CategoriesBean implements Serializable{
        private int id;
        private String name;
        private String category_type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory_type() {
            return category_type;
        }

        public void setCategory_type(String category_type) {
            this.category_type = category_type;
        }
    }
}
