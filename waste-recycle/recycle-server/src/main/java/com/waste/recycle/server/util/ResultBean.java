package com.waste.recycle.server.util;

import java.io.Serializable;

import static com.waste.recycle.server.config.ErrorCode.SUCCESS;

public class ResultBean<T> implements Serializable {
    private T data;
    private int code;
    private String msg;
    private String hiddenMsg;

    private ResultBean(T data, int code) {
        this.data = data;
        this.code = code;
    }

    private ResultBean(T data, int code, String msg, String hiddenMsg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.hiddenMsg = hiddenMsg;
    }

    public static <T> ResultBean<T> success(T object) {
        return valueOf(object, SUCCESS.getCode(), SUCCESS.getMessage());
    }

    public static <T> ResultBean<T> failure(Integer code, String msg, String reason) {
        return new ResultBean<>(null, code, msg, reason);
    }

    private static ResultBean valueOf(Object data, int code, String msg) {
        return new ResultBean(data, code, msg);
    }

    public ResultBean(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
