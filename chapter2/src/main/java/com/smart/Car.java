package com.smart;

/**
 * Created by yunhai on 2016/2/23.
 */

import org.springframework.beans.factory.*;

public class Car implements DisposableBean{
    private String brand; //商标
    private String color;
    private int maxSpeed;
    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用Car默认构造函数");
    }

    @Override
    public String toString() {
        return "brand:" + brand + ",color:" + color + ",maxSpeed:" + maxSpeed;
    }

    public void introduce() {
        System.out.println("introduce:" + this.toString());
    }

    public void myInit() {
        System.out.println("调用myInit()，设置maxSpeed为260");
        this.maxSpeed=260;
    }
    // DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()。");
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
