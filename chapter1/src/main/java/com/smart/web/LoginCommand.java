package com.smart.web;

/**
 * Created by yunhai on 2016/2/22.
 */

/**
 * 需在viewspace-servlet.xml中声明该控制器，扫描web路径，指定Spring MVC的视图解析器。
 */
public class LoginCommand {
    private String userName;
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
