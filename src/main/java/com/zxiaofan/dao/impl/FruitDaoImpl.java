package com.zxiaofan.dao.impl;

import com.zxiaofan.common.FruitException;
import com.zxiaofan.dao.IFruitDao;
import com.zxiaofan.enums.ResultEnum;
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

    public void getSize(Integer id) throws Exception {
        Fruit fruit = fruitDao.findOne(id);
        if (null != fruit) {
            Integer size = fruit.getSize();
            if (size < 20) {// 水果未成熟，禁止采摘
                throw new FruitException(ResultEnum.UNRIPE_FRUIT_ERROR);
            } else if (size > 60) { // 水果变异，不建议食用
                throw new FruitException(ResultEnum.VARIANT_FRUIT_ERROR);
            } else if (size == 20) { // 模拟未知异常
                throw new NullPointerException();
            } else { // 水果正常

            }
        }
    }
}
