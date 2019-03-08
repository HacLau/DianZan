package com.mine.mishi.mishi.bean;

/**
 * Created by liush on 2019/3/1.
 */

public class SiscoveryH {

    /**
     * shop_addres : 上海外滩88号
     * shop_dimension : 18:94
     * goods_name : 一号商铺名称
     * shop_longitude : 73:22
     * goods_title : 一号商铺标题
     * act_id : 1
     * is_valid : 1
     * market_price : 100
     * isFlow : Y
     * goods_img : asdsa.jpg
     * curve_price : 86.77
     */

    private String shop_addres;
    private String shop_dimension;
    private String goods_name;
    private String shop_longitude;
    private String goods_title;
    private int act_id;
    private int is_valid;
    private int market_price;
    private String isFlow;
    private String goods_img;
    private double curve_price;

    public String getShop_addres() {
        return shop_addres;
    }

    public void setShop_addres(String shop_addres) {
        this.shop_addres = shop_addres;
    }

    public String getShop_dimension() {
        return shop_dimension;
    }

    public void setShop_dimension(String shop_dimension) {
        this.shop_dimension = shop_dimension;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getShop_longitude() {
        return shop_longitude;
    }

    public void setShop_longitude(String shop_longitude) {
        this.shop_longitude = shop_longitude;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public int getAct_id() {
        return act_id;
    }

    public void setAct_id(int act_id) {
        this.act_id = act_id;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }

    public int getMarket_price() {
        return market_price;
    }

    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }

    public String getIsFlow() {
        return isFlow;
    }

    public void setIsFlow(String isFlow) {
        this.isFlow = isFlow;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public double getCurve_price() {
        return curve_price;
    }

    public void setCurve_price(double curve_price) {
        this.curve_price = curve_price;
    }
}
