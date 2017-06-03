package com.zxiaofan.util;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.sql.Connection;

/**
 * Created by xiaofan on 2017/5/6.
 */
public class JDBCUtilTest extends TestCase {
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}