package com.zxiaofan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofan on 2017/3/22.
 */
@RestController
public class HelloController {
    /**
     * 访问127.0.0.1:8081/hi
     * @return hi
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hi(){
        return "Hi SpringBoot , zxiaofan.com";
    }
}
