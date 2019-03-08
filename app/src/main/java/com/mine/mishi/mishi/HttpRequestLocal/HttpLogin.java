package com.mine.mishi.mishi.HttpRequestLocal;

/**
 * Created by liush on 2019/3/3.
 */

public class HttpLogin extends HttpRequestBase{
    private String phone;
    private String code;

    public HttpLogin() {
    }

    public HttpLogin(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
