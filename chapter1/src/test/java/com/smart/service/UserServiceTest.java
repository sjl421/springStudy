package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import static org.testng.Assert.*;

/**
 * Created by yunhai on 2016/2/19.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"}) //启动spring容器
// 继承基于testNG的Spring测试框架
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "111111");
        assertTrue(b1); // 需手动导包static org.testng.Assert.*;
//        assertTrue(b2);
    }

    @Test
    public void findUserByUserName() {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin"); //assertEquals(actual,expected)
    }

    @Test
    public void loginSuccess() {
        String userName = "admin";
        User user = userService.findUserByUserName(userName);
        user.setUserId(1);
        user.setUserName(userName);
        user.setLastIp("172.17.1.110");
        userService.loginSuccess(user);
    }
}
