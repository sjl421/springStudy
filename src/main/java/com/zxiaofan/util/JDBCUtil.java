package com.zxiaofan.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by xiaofan on 2017/5/6.
 */
public class JDBCUtil<T> {
    /**
     * 获取Connection
     *
     * @return JDBC Connection
     */
    public static Connection getConnection() throws Exception {
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("jdbc.url");
        String userName = properties.getProperty("jdbc.userName");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }

    /**
     * 释放DB相关资源(建议使用Try-with-resources)
     *
     * @param resultSet  resultSet
     * @param statement  statement
     * @param connection connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
         * 将resultSet结果转换成对象列表
         * @param resultSet jdbc结果集
         * @param clazz 对象的映射类
         * return 封装后的对象结果列表
         */
    public static List resultToEntity(ResultSet resultSet, Class clazz) throws Exception {
        if (null == resultSet || null == clazz) {
            return null;
        }
        //结果集的元素对象
        ResultSetMetaData rsmd = resultSet.getMetaData();
        //获取结果集的元素个数
        int colCount = rsmd.getColumnCount();
        //返回结果的列表集合
        List list = new ArrayList(colCount);
        //业务对象的属性数组
        Field[] fields = clazz.getDeclaredFields();
        while (resultSet.next()) {//对每一条记录进行操作
            Object obj = clazz.newInstance();//构造业务对象实体
            //将每一个字段取出进行赋值
            for (int i = 1; i <= colCount; i++) {
                Object value = resultSet.getObject(i);
                //寻找该列对应的对象属性
                for (int j = 0; j < fields.length; j++) {
                    Field f = fields[j];
                    //如果匹配进行赋值
                    if (f.getName().equalsIgnoreCase(rsmd.getColumnName(i))) {
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(obj, value);
                        f.setAccessible(flag);
                    }
                }
            }
            list.add(obj);
        }
        return list;
    }
}
