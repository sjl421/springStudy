package com.zxiaofan.dao.impl;

import com.zxiaofan.model.Fruit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 单元测试-Service类
 * Created by xiaofan on 2017/4/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest // 启动整个Spring工程
public class FruitDaoImplTest {
    @Autowired
    private FruitDaoImpl fruitDao;

    @Test
    public void findOne() {
        Fruit fruit = fruitDao.findOne(2);
        Assert.assertEquals(new Integer("14"), fruit.getSize());
    }

}