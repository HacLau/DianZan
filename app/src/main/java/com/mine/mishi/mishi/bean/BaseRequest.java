package com.mine.mishi.mishi.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liush on 2019/2/28.
 */

public class BaseRequest<T> {


    /**
     * code : 300
     * data : null
     * isOk : true
     * errorCode : null
     */

    private int code;
    private String message;
    private T data;
    private boolean isOk;
    private Object errorCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isIsOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", isOk=" + isOk +
                ", errorCode=" + errorCode +
                '}';
    }
}
