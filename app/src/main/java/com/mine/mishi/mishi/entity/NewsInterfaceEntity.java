package com.mine.mishi.mishi.entity;

/**
 * Created by liush on 2019/2/26.
 */

public class NewsInterfaceEntity {
    private String headUrl;
    private String userName;
    private String desc;
    private String imageUrl;
    private String data;

    public NewsInterfaceEntity(String headUrl, String userName, String desc, String imageUrl, String data) {
        this.headUrl = headUrl;
        this.userName = userName;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.data = data;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
