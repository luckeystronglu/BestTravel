package com.qf.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2016/10/21.
 */
public class TravelNoteEntity implements Serializable{


    /**
     * id : 102
     * name : 氢大V
     * gender : 1
     * level : 3
     * photo_url : http://inspiration.chanyouji.cn/User/102/8a3f18bf608593df7125a2b2748c8320.jpg
     */

    private UserBean user;
    /**
     * id : 62051
     * made_at : 2016-08-27T16:01:00.000Z
     * likes_count : 6
     * comments_count : 0
     * topic : 太平洋海里看野生鲨鱼进食，“惊心动魄”！【帕劳行之十一】
     * contents_count : 9
     * district_id : 25085
     * created_at : 2016-10-17T13:06:26.000Z
     * favorites_count : 1
     * parent_district_id : 1445564
     * parent_district_count : 11
     * level : 3
     * description : 哈哈！看到标题是不是被“唬”到了，但的确是真的。当大家听到潜导告诉说要去“鲨鱼城”浮潜看鲨鱼进食，一个个都非常激动又内心惶恐着：
     激动，因为伙伴们都是人生第一次与深海中野生鲨鱼近距离接触；惶恐着，更多皆因为在此之前大伙们都只在电视、电影里看到各种鲨鱼进食时的凶残情景，更別说下到海里没保护浮潜近距离感受；所以说“惊心动魄”一点不为过……
     【帕劳鲨鱼城】位于帕劳的西面环礁，距离科罗岛约45公里处，乘船约50分钟抵达。鲨鱼城在广阔开放的美丽水域之中，当潜船停泊后，伙伴们都一一下海浮潜在浮潜板旁，潜导让大伙別离开潜板，然后由他深潜下去用鸡骨头为我们招揽来深海鱼群和进食鲨鱼。
     当食物缓缓沉入水中时，从海底深处会冒出为数众多的鲨鱼与各种鱼群争相享用难得的大餐。具说此处的鲨鱼多半为黑鳍礁鲨（Black Tip Shark），又称黑鳍鲨，属于鲨鱼种类中较“温柔”的一种，而且当地海里食物来源丰富，一般来说这些鲨鱼都不会主动攻击人类，所以说到帕劳鲨鱼城与鲨鱼共泳真的是帕劳旅行难忘的经历之一……
     Tips：虽说帕劳鲨鱼城的鲨鱼群比较“温柔”，但必竟都是太平洋里自然野生鲨，不排除意外伤害；下海观看时必须听从潜导安排，集体浮潜在浮潜板旁，不可以单独下潜去近距离接触，如遇鲨鱼近距离靠近时，不要过度惊慌，否则没被鲨鱼咬到，到被自己惊慌下呼叫被海水呛到就不好了。
     * contents : [{"id":382604,"caption":"这是用GoPro拍下潜导深潜下去时的瞬间，被鱼群包围的感觉真好","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382604/8a11eec7ab17efe4eb9252d65de40c31.jpg","position":0,"width":1920,"height":1440},{"id":382605,"caption":"近距离看到的野生大鲨鱼，感觉就在自己身体下面，\u201c惊心动魄\u201d","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382605/30123a4c0cdce270a0c4e22d4e8e5514.jpg","position":1,"width":1920,"height":1440},{"id":382606,"caption":"这些个鱼群也争抢着进食","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382606/ae77788918d55b02cfa2c6cfb97b14f0.jpg","position":2,"width":1920,"height":1440},{"id":382607,"caption":"喏！我们就这样形成一个\u201c大团体\u201d，才让这群捕食者没最最靠近，其实有两次我看到两条大鲨鱼也游到我们脚旁，吓得我把脚都翘出海面了，也不知潜导让我们这样做是有依据吗？还是说集中好照顾吧\u2026\u2026","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382607/1db806123543be967b6df2a432109572.jpg","position":3,"width":1280,"height":960},{"id":382608,"caption":"鱼群争食，看到最外层的深海里的鲨鱼吧","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382608/f9c3986f817954050a9b323207186b6b.jpg","position":4,"width":1920,"height":1440},{"id":382609,"caption":"非常佩服潜导的胆量哦，脚下就有一条大鲨鱼","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382609/b71bce4d6cb2b170c5986529041eca4a.jpg","position":5,"width":1920,"height":1440},{"id":382610,"caption":"还好有这些个小鱼群在，否则单独只看到鲨鱼估计吓得够呛","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382610/9f37956c7b2a14d157b97eb53aea15fc.jpg","position":6,"width":1920,"height":1440},{"id":382611,"caption":"这可不是什么鲨鱼，它是附着在鲨鱼身上的\u201c吸盘鱼\u201d","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382611/a2f33997bb62fd8008e04fe6303cea4d.jpg","position":7,"width":1920,"height":1440},{"id":382612,"caption":"是不是太壮观了，简直就是\u201c与鲨共舞\u201d","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/382612/504542089e278fa13b461072e7b54468.jpg","position":8,"width":1920,"height":1440}]
     * districts : [{"id":1445564,"name":"帕劳","name_en":"Palau","name_pinyin":"pa lao|pl","score":null,"level":2,"path":".120003.1445564.","published":false,"is_in_china":false,"user_activities_count":48,"lat":7.51498,"lng":134.583,"is_valid_destination":false,"destination_id":290},{"id":25085,"name":"科罗尔","name_en":"Koror","name_pinyin":"ke luo er|kle","score":null,"level":4,"path":".120003.1445564.100254.25085.","published":false,"is_in_china":false,"user_activities_count":13,"lat":7.34224,"lng":134.479,"is_valid_destination":false,"destination_id":null}]
     * categories : [{"id":8197,"name":"鲨鱼城","category_type":"customize"}]
     * user : {"id":26955,"name":"2008town","gender":1,"level":3,"photo_url":"http://inspiration.chanyouji.cn/User/26955/fcaa4cb23f06ed7f0c352b3fc3e63767.jpg"}
     * poi : {"id":18698602,"h5_url":"http://m.ctrip.com/webapp/you/sight/25085/1692361.html?popup=close&autoawaken=close&allianceid=309340&sid=788076&ouid=","name":"帕劳国际珊瑚礁中心","name_en":"Palau International Coral Reef Center","name_pinyin":"pa lao guo ji shan hu jiao zhong xin","business_id":1692361,"poi_type":"SIGHT","district_id":25085,"lat":7.3387773542,"lng":134.4661330466,"address":"Palau International Coral Reef Center, P.O. Box 7086, Koror, Palau 96940","location_name":null,"blat":7.3374118575,"blng":134.4695163091,"youji_lat":null,"youji_lng":null,"youji_poi_id":null,"youji_poi_name":null,"is_in_china":false,"local_name":null,"local_address_name":null}
     * inspiration_activity_id : 0
     * inspiration_activity : null
     */

    private ActivityBean activity;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public ActivityBean getActivity() {
        return activity;
    }

    public void setActivity(ActivityBean activity) {
        this.activity = activity;
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

    public static class ActivityBean implements Serializable{
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
        private int level;
        private String description;
        /**
         * id : 26955
         * name : 2008town
         * gender : 1
         * level : 3
         * photo_url : http://inspiration.chanyouji.cn/User/26955/fcaa4cb23f06ed7f0c352b3fc3e63767.jpg
         */

        private UserBean user;
        /**
         * id : 18698602
         * h5_url : http://m.ctrip.com/webapp/you/sight/25085/1692361.html?popup=close&autoawaken=close&allianceid=309340&sid=788076&ouid=
         * name : 帕劳国际珊瑚礁中心
         * name_en : Palau International Coral Reef Center
         * name_pinyin : pa lao guo ji shan hu jiao zhong xin
         * business_id : 1692361
         * poi_type : SIGHT
         * district_id : 25085
         * lat : 7.3387773542
         * lng : 134.4661330466
         * address : Palau International Coral Reef Center, P.O. Box 7086, Koror, Palau 96940
         * location_name : null
         * blat : 7.3374118575
         * blng : 134.4695163091
         * youji_lat : null
         * youji_lng : null
         * youji_poi_id : null
         * youji_poi_name : null
         * is_in_china : false
         * local_name : null
         * local_address_name : null
         */

        private PoiBean poi;
        private int inspiration_activity_id;
        private Object inspiration_activity;
        /**
         * id : 382604
         * caption : 这是用GoPro拍下潜导深潜下去时的瞬间，被鱼群包围的感觉真好
         * photo_url : http://inspiration.chanyouji.cn/UserActivityContent/382604/8a11eec7ab17efe4eb9252d65de40c31.jpg
         * position : 0
         * width : 1920
         * height : 1440
         */

        private List<ContentsBean> contents;
        /**
         * id : 1445564
         * name : 帕劳
         * name_en : Palau
         * name_pinyin : pa lao|pl
         * score : null
         * level : 2
         * path : .120003.1445564.
         * published : false
         * is_in_china : false
         * user_activities_count : 48
         * lat : 7.51498
         * lng : 134.583
         * is_valid_destination : false
         * destination_id : 290
         */

        private List<DistrictsBean> districts;
        /**
         * id : 8197
         * name : 鲨鱼城
         * category_type : customize
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

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public PoiBean getPoi() {
            return poi;
        }

        public void setPoi(PoiBean poi) {
            this.poi = poi;
        }

        public int getInspiration_activity_id() {
            return inspiration_activity_id;
        }

        public void setInspiration_activity_id(int inspiration_activity_id) {
            this.inspiration_activity_id = inspiration_activity_id;
        }

        public Object getInspiration_activity() {
            return inspiration_activity;
        }

        public void setInspiration_activity(Object inspiration_activity) {
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
            private Object youji_lat;
            private Object youji_lng;
            private Object youji_poi_id;
            private Object youji_poi_name;
            private boolean is_in_china;
            private Object local_name;
            private Object local_address_name;

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

            public Object getYouji_lat() {
                return youji_lat;
            }

            public void setYouji_lat(Object youji_lat) {
                this.youji_lat = youji_lat;
            }

            public Object getYouji_lng() {
                return youji_lng;
            }

            public void setYouji_lng(Object youji_lng) {
                this.youji_lng = youji_lng;
            }

            public Object getYouji_poi_id() {
                return youji_poi_id;
            }

            public void setYouji_poi_id(Object youji_poi_id) {
                this.youji_poi_id = youji_poi_id;
            }

            public Object getYouji_poi_name() {
                return youji_poi_name;
            }

            public void setYouji_poi_name(Object youji_poi_name) {
                this.youji_poi_name = youji_poi_name;
            }

            public boolean isIs_in_china() {
                return is_in_china;
            }

            public void setIs_in_china(boolean is_in_china) {
                this.is_in_china = is_in_china;
            }

            public Object getLocal_name() {
                return local_name;
            }

            public void setLocal_name(Object local_name) {
                this.local_name = local_name;
            }

            public Object getLocal_address_name() {
                return local_address_name;
            }

            public void setLocal_address_name(Object local_address_name) {
                this.local_address_name = local_address_name;
            }
        }

        public static class ContentsBean implements Serializable{
            private int id;
            private String caption;
            private String photo_url;
            private int position;
            private int width;
            private int height;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
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
}
