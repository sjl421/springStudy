package com.zxiaofan.dao;

import com.zxiaofan.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xiaofan on 2017/4/4.
 */
// JpaRepository<Fruit,Integer>（类名，ID类型）
public interface IFruitDao extends JpaRepository<Fruit, Integer> {
    // 通过size查询数据（方法名格式）
    public List<Fruit> findBySize(Integer size);
}
