package com.zxiaofan.controller;

import com.zxiaofan.properties.CarProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofan on 2017/3/22.
 */
@RestController
public class HelloController {
    @Value("${fruit.apple}")
    private String fruitApple;
    @Value("${fruits}")
    private String fruits;
    @Autowired
    private CarProperties carProperties;

    /**
     * 访问127.0.0.1:8081/hi
     *
     * @return hi
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        String result = "Hi SpringBoot , zxiaofan.com";
        return result + "_" + fruitApple + "_" + fruits + "_car_" + carProperties.getColor();
    }
}
