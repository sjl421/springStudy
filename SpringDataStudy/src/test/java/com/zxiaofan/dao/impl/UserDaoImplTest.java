package com.zxiaofan.dao.impl;

import com.zxiaofan.dao.IUserDao;
import com.zxiaofan.model.UserBo;
import junit.framework.TestCase;

import java.util.Date;
import java.util.List;

/**
 * Created by xiaofan on 2017/5/6.
 */
public class UserDaoImplTest extends TestCase {
    public void testQueryList() throws Exception {
        IUserDao IUserDao = new UserDaoImpl();
        List<UserBo> userBos = IUserDao.queryList();
        for (UserBo userBo : userBos) {
            System.out.println(userBo.toString());
        }
    }

    public void testSave() throws Exception {
        IUserDao IUserDao = new UserDaoImpl();
        UserBo userBo = new UserBo(20, "zxf", new Date());
        IUserDao.save(userBo);
    }

}