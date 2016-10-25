package com.qf.entity;

/**
 * Created by lenovo on 2016/10/13.
 */
public class BannerItem {
    private String image;
    private String title;

    public BannerItem() {
    }

    public BannerItem(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
