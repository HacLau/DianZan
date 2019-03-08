package com.mine.mishi.mishi.entity;

/**
 * Created by liush on 2019/2/22.
 */

public class CitySearchResultEntty {
    private String imgUrl;
    private String text;

    public CitySearchResultEntty(String imgUrl, String text) {
        this.imgUrl = imgUrl;
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
