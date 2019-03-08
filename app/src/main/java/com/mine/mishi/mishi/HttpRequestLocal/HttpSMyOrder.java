package com.mine.mishi.mishi.HttpRequestLocal;

/**
 * Created by liush on 2019/3/3.
 */

public class HttpSMyOrder extends HttpRequestBase {
    private String userid;
    private int type;

    public HttpSMyOrder() {
    }

    public HttpSMyOrder(String userid, int type) {
        this.userid = userid;
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
