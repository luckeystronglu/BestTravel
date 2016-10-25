package com.qf.entity;

import java.util.List;

/**
 * Created by zhoudan on 2016/10/7.
 */
public class SceneryEntity {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;

        private List<DaysBean> days;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DaysBean> getDays() {
            return days;
        }

        public void setDays(List<DaysBean> days) {
            this.days = days;
        }

        public static class DaysBean {
            private int position;
            private String description;

            private List<PointsBean> points;

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<PointsBean> getPoints() {
                return points;
            }

            public void setPoints(List<PointsBean> points) {
                this.points = points;
            }

            public static class PointsBean {
                private int id;
                private int position;
                /**
                 * id : 91537
                 * h5_url : http://m.ctrip.com/webapp/you/sight/21/109999.html?popup=close&autoawaken=close&allianceid=309340&sid=788076&ouid=
                 * name : 曾厝垵
                 * name_en :
                 * name_pinyin : zeng cuo an
                 * business_id : 109999
                 * poi_type : SIGHT
                 * district_id : 21
                 * lat : 24.4305267334
                 * lng : 118.1247940063
                 * address : 厦门市思明区曾厝垵
                 * location_name : null
                 * blat : 24.4362773895
                 * blng : 118.1313350123
                 * youji_lat : 24.430574
                 * youji_lng : 118.12482
                 * youji_poi_id : 10623
                 * youji_poi_name : 曾厝垵
                 * is_in_china : true
                 * local_name : null
                 * local_address_name : null
                 */

                private PoiBean poi;
                /**
                 * id : 1050
                 * visit_tip : 2-3小时
                 * address : 厦门市思明区曾厝垵
                 * topic : 曾厝垵逛特色文艺小店
                 * introduce : 曾厝垵以前是厦门的一个临海小渔村，因地理位置得天独厚，加之旅游业迅猛发展，曾经的小渔村改为民居，增添的是极富海滨特色的家庭旅馆，布置精美的商铺，在曾厝垵发生变化的同时，很多特有的历史遗迹依然保留了下来。

                 有着鼓浪屿的文艺小资，却少了鼓浪屿的拥挤嘈杂，是近年来厦门又一文艺小清新们的聚集地，这里有很多有情调的咖啡厅、餐厅和特色商品小店等；还融汇了道教、佛教、基督教、伊斯兰教，更有厦门独有的，香火旺盛的妈祖崇拜。
                 * time_cost : 120
                 * wishes_count : 11409
                 * icon_type : 2
                 * price : 0
                 * user_activities_count : 11
                 * destination : {"id":90,"lat":24.4864997864,"lng":118.0889968872,"district_id":21,"parent_id":5,"name":"厦门","name_en":"Xiamen","name_pinyin":"sha men|sm","score":180,"level":3,"path":".1.5.90.","published":true,"is_in_china":true,"inspiration_activities_count":59,"activity_collections_count":9,"wishes_count":274701,"wiki_destination_id":null,"photo_url":"http://inspiration.chanyouji.cn/Destination/90/fc79de4a2684d4ffdb1a3e69c843e27e.jpg","title":"海上花园享受小资慢生活","description":"厦门位于福建省东南端，\u201c小资\u201d、\u201c慢生活\u201d俨然成了厦门的标签，住特色民宿、走海滨木栈、骑行环岛路、鼓浪屿探店集章、写一张给未来的明信片、邂逅一只猫、去一次小资咖啡馆酒吧、游万国建筑博览等等都是去厦门必做的事情。\r\n\r\n乘坐飞机或火车前往厦门都十分方便，3~4天的行程是厦门旅行的标配。春秋两季是厦门旅游的最佳季节。","tip":"最新厦门游玩指南，含鼓浪屿、周边古镇、古村土楼、特色体验、美食购物等攻略","time_cost":"","wiki_page_id":null,"has_airport":true,"visit_tip":"建议游玩3-4天","is_top_destination":true,"is_in_grouping":false,"alias_name":"景点玩乐","travel_tip":"","photo":{"id":433725,"width":800,"height":480,"url":"http://inspiration.chanyouji.cn/Destination/90/fc79de4a2684d4ffdb1a3e69c843e27e.jpg","file_size":243398,"photo_url":"http://inspiration.chanyouji.cn/Destination/90/fc79de4a2684d4ffdb1a3e69c843e27e.jpg"},"wiki_page":null}
                 * pois : [{"id":91537,"h5_url":"http://m.ctrip.com/webapp/you/sight/21/109999.html?popup=close&autoawaken=close&allianceid=309340&sid=788076&ouid=","name":"曾厝垵","name_en":"","name_pinyin":"zeng cuo an","business_id":109999,"poi_type":"SIGHT","district_id":21,"lat":24.4305267334,"lng":118.1247940063,"address":"厦门市思明区曾厝垵","location_name":null,"blat":24.4362773895,"blng":118.1313350123,"youji_lat":24.430574,"youji_lng":118.12482,"youji_poi_id":10623,"youji_poi_name":"曾厝垵","is_in_china":true,"local_name":null,"local_address_name":null}]
                 * activity_collections : [{"id":181,"topic":"文艺小清新"}]
                 * photo : {"width":1408,"height":844,"photo_url":"http://inspiration.chanyouji.cn/InspirationActivity/1050/8ff2ef56c4eb4764f5b5b806d047e30d.jpg?imageMogr2/crop/!1408x844a74a99/thumbnail/800"}
                 */

                private InspirationActivityBean inspiration_activity;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPosition() {
                    return position;
                }

                public void setPosition(int position) {
                    this.position = position;
                }

                public PoiBean getPoi() {
                    return poi;
                }

                public void setPoi(PoiBean poi) {
                    this.poi = poi;
                }

                public InspirationActivityBean getInspiration_activity() {
                    return inspiration_activity;
                }

                public void setInspiration_activity(InspirationActivityBean inspiration_activity) {
                    this.inspiration_activity = inspiration_activity;
                }

                public static class PoiBean {
                    private int id;
                    private String name;
                    private String name_pinyin;
                    private String poi_type;
                    private String address;

                    public String getH5_url() {
                        return h5_url;
                    }

                    public void setH5_url(String h5_url) {
                        this.h5_url = h5_url;
                    }

                    private String h5_url;

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

                    public String getName_pinyin() {
                        return name_pinyin;
                    }

                    public void setName_pinyin(String name_pinyin) {
                        this.name_pinyin = name_pinyin;
                    }

                    public String getPoi_type() {
                        return poi_type;
                    }

                    public void setPoi_type(String poi_type) {
                        this.poi_type = poi_type;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }
                }

                public static class InspirationActivityBean {
                    private int id;
                    private String visit_tip;
                    private String address;
                    private String topic;
                    private String introduce;
                    private int icon_type;
                    private int user_activities_count;

                    public PhotoBean getPhoto() {
                        return photo;
                    }

                    public void setPhoto(PhotoBean photo) {
                        this.photo = photo;
                    }

                    private PhotoBean photo;
                    /**
                     * id : 90
                     * lat : 24.4864997864
                     * lng : 118.0889968872
                     * district_id : 21
                     * parent_id : 5
                     * name : 厦门
                     * name_en : Xiamen
                     * name_pinyin : sha men|sm
                     * score : 180
                     * level : 3
                     * path : .1.5.90.
                     * published : true
                     * is_in_china : true
                     * inspiration_activities_count : 59
                     * activity_collections_count : 9
                     * wishes_count : 274701
                     * wiki_destination_id : null
                     * photo_url : http://inspiration.chanyouji.cn/Destination/90/fc79de4a2684d4ffdb1a3e69c843e27e.jpg
                     * title : 海上花园享受小资慢生活
                     * description : 厦门位于福建省东南端，“小资”、“慢生活”俨然成了厦门的标签，住特色民宿、走海滨木栈、骑行环岛路、鼓浪屿探店集章、写一张给未来的明信片、邂逅一只猫、去一次小资咖啡馆酒吧、游万国建筑博览等等都是去厦门必做的事情。

                     乘坐飞机或火车前往厦门都十分方便，3~4天的行程是厦门旅行的标配。春秋两季是厦门旅游的最佳季节。
                     * tip : 最新厦门游玩指南，含鼓浪屿、周边古镇、古村土楼、特色体验、美食购物等攻略
                     * time_cost :
                     * wiki_page_id : null
                     * has_airport : true
                     * visit_tip : 建议游玩3-4天
                     * is_top_destination : true
                     * is_in_grouping : false
                     * alias_name : 景点玩乐
                     * travel_tip :
                     * photo : {"id":433725,"width":800,"height":480,"url":"http://inspiration.chanyouji.cn/Destination/90/fc79de4a2684d4ffdb1a3e69c843e27e.jpg","file_size":243398,"photo_url":"http://inspiration.chanyouji.cn/Destination/90/fc79de4a2684d4ffdb1a3e69c843e27e.jpg"}
                     * wiki_page : null
                     */
                    public static class PhotoBean {
                        public String getPhoto_url() {
                            return photo_url;
                        }

                        public void setPhoto_url(String photo_url) {
                            this.photo_url = photo_url;
                        }

                        private String photo_url;
                    }
                    private DestinationBean destination;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getVisit_tip() {
                        return visit_tip;
                    }

                    public void setVisit_tip(String visit_tip) {
                        this.visit_tip = visit_tip;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public String getTopic() {
                        return topic;
                    }

                    public void setTopic(String topic) {
                        this.topic = topic;
                    }

                    public String getIntroduce() {
                        return introduce;
                    }

                    public void setIntroduce(String introduce) {
                        this.introduce = introduce;
                    }

                    public int getIcon_type() {
                        return icon_type;
                    }

                    public void setIcon_type(int icon_type) {
                        this.icon_type = icon_type;
                    }

                    public int getUser_activities_count() {
                        return user_activities_count;
                    }

                    public void setUser_activities_count(int user_activities_count) {
                        this.user_activities_count = user_activities_count;
                    }

                    public DestinationBean getDestination() {
                        return destination;
                    }

                    public void setDestination(DestinationBean destination) {
                        this.destination = destination;
                    }

                    public static class DestinationBean {
                        private String name;
                        private String title;
                        private String description;
                        private String tip;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public String getTip() {
                            return tip;
                        }

                        public void setTip(String tip) {
                            this.tip = tip;
                        }
                    }
                }
            }
        }
    }
}
