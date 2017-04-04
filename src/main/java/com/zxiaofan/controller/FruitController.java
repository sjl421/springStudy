package com.zxiaofan.controller;

import com.zxiaofan.dao.IFruitDao;
import com.zxiaofan.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaofan on 2017/4/4.
 */
@RestController
public class FruitController {
    @Autowired
    private IFruitDao fruitDao;

    /**
     * Get请求查询所有fruit列表
     *
     * @return fruits
     */
    @GetMapping(value = "/fruits")
    public List<Fruit> fruitList() {
        return fruitDao.findAll();
    }

    /**
     * Post请求添加一条Fruit数据
     *
     * @param color
     * @param size
     * @return
     */
    @PostMapping(value = "/fruits")
    public Fruit fruitAdd(@RequestParam("color") String color, @RequestParam("size") Integer size) {
        Fruit fruit = new Fruit(color, size);
        return fruitDao.save(fruit);
    }

    /**
     * 通过ID查询数据（数据库无数据将返回null）
     */
    @GetMapping(value = "/fruits/{id}")
    public Fruit fruitFindOne(@PathVariable("id") Integer id) {
        return fruitDao.findOne(id);
    }

    /**
     * 通过ID更新数据
     */
    @PutMapping(value = "/fruits/{id}")
    public Fruit fruitUpdate(@PathVariable("id") Integer id, @RequestParam("color") String color, @RequestParam("size") Integer size) {
        Fruit fruit = new Fruit(color, size);
        fruit.setId(id);
        return fruitDao.save(fruit);
    }

    /**
     * 通过ID删除数据
     */
    @DeleteMapping(value = "/fruits/{id}")
    public void fruitDelete(@PathVariable("id") Integer id) {
        fruitDao.delete(id);
    }

    /**
     * 通过size查询数据(url:port/fruits/size/22)
     */
    @GetMapping(value = "/fruits/size/{size}")
    public List<Fruit> fruitListBySize(@PathVariable("size") Integer size) {
        return fruitDao.findBySize(size);
    }
}
