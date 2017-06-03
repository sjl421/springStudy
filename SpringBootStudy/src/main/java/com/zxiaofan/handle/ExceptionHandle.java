package com.zxiaofan.handle;

import com.zxiaofan.common.FruitException;
import com.zxiaofan.common.Result;
import com.zxiaofan.common.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获类.
 * Created by xiaofan on 2017/4/9.
 */
@ControllerAdvice // 捕获Controller抛出的异常
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class) // 待捕获的异常类型
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof FruitException) {
            FruitException fruitException = (FruitException) e;
            return ResultUtil.error(fruitException.getCode(), fruitException.getMessage());
        } else {
            logger.error("Unknown exception:{}", e); // 记录异常日志
            return ResultUtil.error(-1, "Unknown exception:" + e.getMessage());
        }
    }
}
