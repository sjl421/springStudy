package com.zxiaofan.common;

import java.util.Objects;

/**
 * Created by xiaofan on 2017/4/9.
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result(1, "success", object);
        return result;
    }

    public static Result success() {
        Result result = new Result(1, "success");
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result(code, msg);
        return result;
    }
}
