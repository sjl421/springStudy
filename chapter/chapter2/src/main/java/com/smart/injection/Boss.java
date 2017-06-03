package com.smart.injection;

import java.util.*;

/**
 * Created by yunhai on 2016/2/29.
 */
public class Boss {
    private List list = new ArrayList<String>();
    private Map mapWeek = new HashMap();
    private Properties type = new Properties();
    private Car car;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMapWeek() {
        return mapWeek;
    }

    public void setMapWeek(Map map) {
        this.mapWeek = map;
    }

    public Properties getType() {
        return type;
    }

    public void setType(Properties type) {
        this.type = type;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
