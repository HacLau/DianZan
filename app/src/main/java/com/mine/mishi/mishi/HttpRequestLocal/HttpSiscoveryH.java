package com.mine.mishi.mishi.HttpRequestLocal;

/**
 * Created by liush on 2019/3/3.
 */

public class HttpSiscoveryH extends HttpRequestBase {
    private String userid;

    public HttpSiscoveryH() {
    }

    public HttpSiscoveryH(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
