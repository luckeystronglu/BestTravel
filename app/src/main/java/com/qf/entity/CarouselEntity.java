package com.qf.entity;

import java.util.List;

/**
 * Created by lenovo on 2016/10/9.
 */
public class CarouselEntity{

    /**
     * photo : {"width":1280,"height":600,"photo_url":"http://inspiration.chanyouji.cn/Advert/128/3767179302031cf063bc7d85454bf3cd.jpg"}
     * id : 128
     * ios_url :
     * android_url :
     * target_id : 90
     * advert_type : album
     * topic : 在热气球里遇见世界
     * market : all
     * open_in_browser : false
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * width : 1280
         * height : 600
         * photo_url : http://inspiration.chanyouji.cn/Advert/128/3767179302031cf063bc7d85454bf3cd.jpg
         */

        private PhotoBean photo;
        private int id;
        private String topic;

        public PhotoBean getPhoto() {
            return photo;
        }

        public void setPhoto(PhotoBean photo) {
            this.photo = photo;
        }

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
