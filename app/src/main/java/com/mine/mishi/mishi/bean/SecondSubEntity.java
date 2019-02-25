package com.mine.mishi.mishi.bean;

/**
 * Created by liush on 2019/2/22.
 */

public class SecondSubEntity {
    private String imgUrl;
    private String title;
    private String address;
    private String distance;
    private String sellPrice;
    private String originalPrice;

    public SecondSubEntity(String imgUrl, String address, String distance, String sellPrice, String originalPrice) {
        this.imgUrl = imgUrl;
        this.address = address;
        this.distance = distance;
        this.sellPrice = sellPrice;
        this.originalPrice = originalPrice;
    }

    public SecondSubEntity(String imgUrl, String title, String address, String distance, String sellPrice, String originalPrice) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.address = address;
        this.distance = distance;
        this.sellPrice = sellPrice;
        this.originalPrice = originalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SecondSubEntity() {
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }
}
