package com.mine.mishi.mishi.HttpRequestLocal;

/**
 * Created by liush on 2019/3/3.
 */

public class HttpNoteSIMPort extends HttpRequestBase {
    private String phone;


    public HttpNoteSIMPort(String phone) {
        this.phone = phone;
    }

    public HttpNoteSIMPort() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
