package com.zxiaofan.dao.impl;

import com.zxiaofan.dao.IUserDao;
import com.zxiaofan.model.UserBo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SpringJDBC 操作数据库
 * <p>
 * Created by xiaofan on 2017/5/6.
 */
public class UserDaoSpringJDBCImpl implements IUserDao {
    /**
     * Spring 注入与Set方法相关
     */
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserBo> queryList() {
        List<UserBo> userBos = new ArrayList<>();
        String sql = "select age,userName,addTime from user limit 10;";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int age = rs.getInt("age");
                String name = rs.getString("userName");
                Date date = rs.getDate("addTime");
                UserBo userBo = new UserBo(age, name, date);
                userBos.add(userBo);
            }
        });
        return userBos;
    }

    @Override
    public void save(UserBo userBo) {
        String sql = "insert into user(userName,age,addTime) values(?,?,?);";
        jdbcTemplate.update(sql, new Object[]{userBo.getUserName(), userBo.getAge(), userBo.getAddTime()});
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
