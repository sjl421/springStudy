package com.zxiaofan.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * 单元测试-Controller类
 * Created by xiaofan on 2017/4/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FruitControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void fruitList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/fruits")).andExpect(MockMvcResultMatchers.status().isOk()); // 使用get请求；期望返回状态码200
        mvc.perform(MockMvcRequestBuilders.get("/fruits")).andExpect(MockMvcResultMatchers.content().string("zxiaofan")); // 使用get请求；期望返回内容为zxiaofan
    }

}