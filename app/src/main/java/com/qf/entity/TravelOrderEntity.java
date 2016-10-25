package com.qf.entity;

import java.util.List;

/**
 * Created by lenovo on 2016/10/20.
 */
public class TravelOrderEntity {

    /**
     * id : 37
     * title : 如何一键生成行程
     * summary : 氢气球发明了旅行黑科技，只点一个键，立刻生成为你定制的行程地图。
     * items : [{"id":570,"title":"收藏榜单后，自动生成行程","description":"在目的地主页浏览「旅行榜单」，把喜欢的玩法全部收藏起来，你只管点收藏\u2014\u2014黑科技自动将你的收藏生成行程单，并且自带行程地图。","url":"","target_id":null,"target_type":"ActivityCategory","entry_text":null,"photo":{"width":720,"height":800,"photo_url":"http://inspiration.chanyouji.cn/AlbumItem/570/31dacf9574ebfa3dc5ab5ed483ab4cae.jpg"},"target":null,"user_activity":null},{"id":568,"title":"复制经典路线，叠加生成行程","description":"如果你懒得一条条收藏玩法，也可以直接复制目的地主页的「经典路线」，把这条路线加入你的行程单。\r\n\r\n重要的是，你可以复制多条经典路线，叠加在一起，比如台北2日+高雄2日+垦丁3日=台湾7日旅行，DIY你最中意的旅程。","url":"","target_id":null,"target_type":"ActivityCategory","entry_text":null,"photo":{"width":720,"height":800,"photo_url":"http://inspiration.chanyouji.cn/AlbumItem/568/2a7a47534fdd0d3f485d2a1a77f22a78.jpg"},"target":null,"user_activity":null},{"id":569,"title":"小贴士：优化你的行程单","description":"从行程单进入地图模式，可以看着地图对行程排序，拖过来拖过去，既方便又好玩。\r\n\r\n在地图单天模式下，还可以查看附近景点和餐馆。点击地图底部的\u201c日期卡片\u201d即可进入单天编辑模式。","url":"","target_id":null,"target_type":"ActivityCategory","entry_text":null,"photo":{"width":720,"height":800,"photo_url":"http://inspiration.chanyouji.cn/AlbumItem/569/a590a5005ff334d9853f81bc3650e633.jpg"},"target":null,"user_activity":null},{"id":571,"title":"小贴士：贴心的城市排序功能","description":"有时候，行程单会因为黑魔法的入侵而略显凌乱。你在地图模式下试试\u201c城市排序\u201d功能，批量移动整个城市的旅行计划，比如将大阪排到京都前面，不用一个个拖动，令人感动到流下泪水。","url":"","target_id":null,"target_type":"ActivityCategory","entry_text":null,"photo":{"width":720,"height":800,"photo_url":"http://inspiration.chanyouji.cn/AlbumItem/571/18c87fb8dc91be71dab49ab00b3fbbd8.jpg"},"target":null,"user_activity":null}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private String summary;
        /**
         * id : 570
         * title : 收藏榜单后，自动生成行程
         * description : 在目的地主页浏览「旅行榜单」，把喜欢的玩法全部收藏起来，你只管点收藏——黑科技自动将你的收藏生成行程单，并且自带行程地图。
         * url :
         * target_id : null
         * target_type : ActivityCategory
         * entry_text : null
         * photo : {"width":720,"height":800,"photo_url":"http://inspiration.chanyouji.cn/AlbumItem/570/31dacf9574ebfa3dc5ab5ed483ab4cae.jpg"}
         * target : null
         * user_activity : null
         */

        private List<ItemsBean> items;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            private String title;
            private String description;
            /**
             * width : 720
             * height : 800
             * photo_url : http://inspiration.chanyouji.cn/AlbumItem/570/31dacf9574ebfa3dc5ab5ed483ab4cae.jpg
             */

            private PhotoBean photo;

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

            public PhotoBean getPhoto() {
                return photo;
            }

            public void setPhoto(PhotoBean photo) {
                this.photo = photo;
            }

            public static class PhotoBean {
                private String photo_url;

                public String getPhoto_url() {
                    return photo_url;
                }

                public void setPhoto_url(String photo_url) {
                    this.photo_url = photo_url;
                }
            }
        }
    }
}
