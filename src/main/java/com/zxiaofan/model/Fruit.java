package com.zxiaofan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by xiaofan on 2017/3/27.
 */
@Entity
public class Fruit {
    @Id
    @GeneratedValue
    private Integer id;
    private String color;
    @Min(value = 20, message = "水果未成熟禁止采摘")
    private Integer size;

    public Fruit() { // 必须有一个无参构造函数
    }

    public Fruit(String color, Integer size) {
        this.color = color;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
