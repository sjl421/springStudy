package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yunhai on 2016/2/16.
 * 持久层
 */
@Repository //通过Spring注解定义一个DAO
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate; //自动注入JdbcTemplate的bean

    /**
     * 根据用户名、密码获取匹配用户数，等于1表示正确，0则用户名或密码错误。
     *
     * @param userName
     * @param passWord
     * @return
     */
    public int getMatchCount(String userName, String passWord) {
        String sqlStr = " select count(*) from t_user "
                + " where user_name=? and password=? "; //为避免语句错误，在每行的句首句尾都加空格
        return jdbcTemplate.queryForInt(sqlStr, new Object[]{userName, passWord});
    }

    /**
     * 根据用户名获取User对象。
     *
     * @param userName
     * @return
     */
    public User findUserByUserName(final String userName) {
        String sqlStr = " select user_id,user_name "
                + " from t_user where user_name=? ";
        final User user = new User();
        //RowCallbackHandler匿名类方式实现的回调函数
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
            }
        });
        return user;
    }

    /**
     * 更新用户最后登录时间及登陆IP。
     *
     * @param user
     */
    public void updateLoginInfo(User user) {
        String sqlStr = " update t_user set last_visit=?,last_ip=? "
                + " where user_id=? ";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(), user.getLastIp(), user.getUserId()});
    }
}
