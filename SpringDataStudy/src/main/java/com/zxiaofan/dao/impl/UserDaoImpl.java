package com.zxiaofan.dao.impl;


import com.zxiaofan.dao.IUserDao;
import com.zxiaofan.model.UserBo;
import com.zxiaofan.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDao的接口实现（JDBC方式访问）
 * <p>
 * Created by xiaofan on 2017/5/6.
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public List<UserBo> queryList() {
        String sql = "select age,userName,addTime from user limit 10;";
        List<UserBo> userBos = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {
//            while (resultSet.next()) {
//                int age = resultSet.getInt("age");
//                String userName = resultSet.getString("userName");
//                Date addTime = resultSet.getDate("addTime");
//                UserBo userBo = new UserBo(age, userName, addTime);
//                userBos.add(userBo);
//            }
            userBos = JDBCUtil.resultToEntity(resultSet, UserBo.class); // 使用工具类转换，避免逐一赋值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBos;
    }

    @Override
    public void save(UserBo userBo) {
        String sql = "insert into user(userName,age,addTime) values(?,?,?);";
        try (Connection connection = JDBCUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, userBo.getUserName());
            preparedStatement.setInt(2, userBo.getAge());
            preparedStatement.setDate(3, new java.sql.Date(userBo.getAddTime().getTime()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
