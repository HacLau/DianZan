package com.mine.mishi.mishi.HttpRequestLocal;

/**
 * Created by liush on 2019/3/6.
 */

public class HttpSGdetalis extends HttpRequestBase {
    private String userid;
    private String actId;

    public HttpSGdetalis() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }
}
