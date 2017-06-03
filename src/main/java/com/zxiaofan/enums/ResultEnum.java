package com.zxiaofan.enums;

/**
 * Created by xiaofan on 2017/4/9.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "UNKNOWN_ERROR"),
    SUCCESS(0, "SUCCESS"),
    UNRIPE_FRUIT_ERROR(-2, "水果未成熟"),
    VARIANT_FRUIT_ERROR(-3, "水果变异");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
