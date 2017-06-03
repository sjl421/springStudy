package com.zxiaofan.dao;

import com.zxiaofan.model.UserBo;

import java.util.List;

/**
 * Created by xiaofan on 2017/5/6.
 */
public interface IUserDao {
    /**
     * 查询所有数据
     *
     * @return List
     */
    public List<UserBo> queryList();

    /**
     * 添加单条数据
     * @param userBo userBo
     */
    public void save(UserBo userBo);
}
