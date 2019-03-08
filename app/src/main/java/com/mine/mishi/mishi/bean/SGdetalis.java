package com.mine.mishi.mishi.bean;

/**
 * Created by liush on 2019/3/6.
 */

public class SGdetalis {

    /**
     * details : {"exchange_time":"13:00--16:00","is_in_eat":"Y","again_buy_date":2,"is_reserve":"N","cycle_time":30,"details_title":"烧烤菜单","is_refund":"Y","details_content":"[{\n\"name\":\"火锅\",\"price\":100\n},{\"name\":\"烧烤\",\"price\":200}]"}
     * home : {"shop_addres":"上海外滩88号","goods_name":"一号商铺名称","act_id":1,"note_number":1,"goods_id":1,"shop_name":"一号店铺名称","curve_price":83.54,"flowNumber":0,"shop_id":1,"goods_title":"一号商铺标题","market_price":100,"shop_phone":"13466668888","goods_img":"[\"\\\\2019\\\\1\\\\21\\\\001b.jpg\",\"\\\\2019\\\\1\\\\21\\\\002b.jpg\",\"\\\\2019\\\\1\\\\21\\\\003b.jpg\"]"}
     */

    private DetailsBean details;
    private HomeBean home;

    public DetailsBean getDetails() {
        return details;
    }

    public void setDetails(DetailsBean details) {
        this.details = details;
    }

    public HomeBean getHome() {
        return home;
    }

    public void setHome(HomeBean home) {
        this.home = home;
    }

    public static class DetailsBean {
        /**
         * exchange_time : 13:00--16:00
         * is_in_eat : Y
         * again_buy_date : 2
         * is_reserve : N
         * cycle_time : 30
         * details_title : 烧烤菜单
         * is_refund : Y
         * details_content : [{
         "name":"火锅","price":100
         },{"name":"烧烤","price":200}]
         */

        private String exchange_time;
        private String is_in_eat;
        private int again_buy_date;
        private String is_reserve;
        private int cycle_time;
        private String details_title;
        private String is_refund;
        private String details_content;

        public String getExchange_time() {
            return exchange_time;
        }

        public void setExchange_time(String exchange_time) {
            this.exchange_time = exchange_time;
        }

        public String getIs_in_eat() {
            return is_in_eat;
        }

        public void setIs_in_eat(String is_in_eat) {
            this.is_in_eat = is_in_eat;
        }

        public int getAgain_buy_date() {
            return again_buy_date;
        }

        public void setAgain_buy_date(int again_buy_date) {
            this.again_buy_date = again_buy_date;
        }

        public String getIs_reserve() {
            return is_reserve;
        }

        public void setIs_reserve(String is_reserve) {
            this.is_reserve = is_reserve;
        }

        public int getCycle_time() {
            return cycle_time;
        }

        public void setCycle_time(int cycle_time) {
            this.cycle_time = cycle_time;
        }

        public String getDetails_title() {
            return details_title;
        }

        public void setDetails_title(String details_title) {
            this.details_title = details_title;
        }

        public String getIs_refund() {
            return is_refund;
        }

        public void setIs_refund(String is_refund) {
            this.is_refund = is_refund;
        }

        public String getDetails_content() {
            return details_content;
        }

        public void setDetails_content(String details_content) {
            this.details_content = details_content;
        }
    }

    public static class HomeBean {
        /**
         * shop_addres : 上海外滩88号
         * goods_name : 一号商铺名称
         * act_id : 1
         * note_number : 1
         * goods_id : 1
         * shop_name : 一号店铺名称
         * curve_price : 83.54
         * flowNumber : 0
         * shop_id : 1
         * goods_title : 一号商铺标题
         * market_price : 100
         * shop_phone : 13466668888
         * goods_img : ["\\2019\\1\\21\\001b.jpg","\\2019\\1\\21\\002b.jpg","\\2019\\1\\21\\003b.jpg"]
         */

        private String shop_addres;
        private String goods_name;
        private int act_id;
        private int note_number;
        private int goods_id;
        private String shop_name;
        private double curve_price;
        private int flowNumber;
        private int shop_id;
        private String goods_title;
        private int market_price;
        private String shop_phone;
        private String goods_img;

        public String getShop_addres() {
            return shop_addres;
        }

        public void setShop_addres(String shop_addres) {
            this.shop_addres = shop_addres;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public int getAct_id() {
            return act_id;
        }

        public void setAct_id(int act_id) {
            this.act_id = act_id;
        }

        public int getNote_number() {
            return note_number;
        }

        public void setNote_number(int note_number) {
            this.note_number = note_number;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public double getCurve_price() {
            return curve_price;
        }

        public void setCurve_price(double curve_price) {
            this.curve_price = curve_price;
        }

        public int getFlowNumber() {
            return flowNumber;
        }

        public void setFlowNumber(int flowNumber) {
            this.flowNumber = flowNumber;
        }

        public int getShop_id() {
            return shop_id;
        }

        public void setShop_id(int shop_id) {
            this.shop_id = shop_id;
        }

        public String getGoods_title() {
            return goods_title;
        }

        public void setGoods_title(String goods_title) {
            this.goods_title = goods_title;
        }

        public int getMarket_price() {
            return market_price;
        }

        public void setMarket_price(int market_price) {
            this.market_price = market_price;
        }

        public String getShop_phone() {
            return shop_phone;
        }

        public void setShop_phone(String shop_phone) {
            this.shop_phone = shop_phone;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }
    }
}
