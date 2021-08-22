package com.waste.recycle.server.config;

public enum ErrorCode implements IErrorCode {
    SUCCESS(200, "SUCCESS"),
    INVALID_PARAMS(400, "参数有误"),
    INVALID_PERMISSION(401, "身份验证失败"),
    UNKNOWN_CODE(500, "unknown error")
    ;
    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
