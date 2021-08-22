package com.waste.recycle.server.config;

import java.util.Arrays;
import java.util.MissingFormatArgumentException;

public interface IErrorCode {
    /**
     * 错误码
     *
     * @return
     */
    Integer getCode();

    /**
     * 错误信息
     *
     * @return
     */
    String getMessage();

    /**
     * 带参数的format的错误信息
     *
     * @param args
     * @return
     */
    default String getMessage(Object... args) {
        String msg = this.getMessage();
        String rt;
        try {
            rt = String.format(msg, args);
        } catch (MissingFormatArgumentException e) {
            rt = msg + Arrays.asList(args) + "," + e.getMessage();
        }
        return rt;
    }
}
