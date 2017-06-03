package com.zxiaofan.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by xiaofan on 2017/3/23.
 */
@Component
@ConfigurationProperties(prefix = "car") // 注入前缀为car的配置
public class CarProperties {
    private String color;
    private Integer size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
