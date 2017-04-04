package com.zxiaofan.dao.impl;

import com.zxiaofan.dao.IFruitDao;
import com.zxiaofan.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiaofan on 2017/4/4.
 */
@Service
public class FruitDaoImpl {
    @Autowired
    private IFruitDao fruitDao;

    /**
     * Transactional 多条数据要么都成功要么都失败
     */
    @Transactional
    public void insertList() {
        Fruit fruit1 = new Fruit("green", 20);
        Fruit fruit2 = new Fruit("purple", 21);
        fruitDao.save(fruit1);
        fruitDao.save(fruit2);
    }
}
