package com.zxiaofan.common;

import com.zxiaofan.enums.ResultEnum;

/**
 * 自定义异常.
 * Created by xiaofan on 2017/4/9.
 */
public class FruitException extends RuntimeException {
    private Integer code;

    public FruitException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public FruitException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
