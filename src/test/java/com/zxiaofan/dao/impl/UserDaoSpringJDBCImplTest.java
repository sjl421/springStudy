package com.zxiaofan.dao.impl;

import com.zxiaofan.dao.IUserDao;
import com.zxiaofan.model.UserBo;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * 执行顺序:@BeforeClass ，@Before，@Test，@After，@AfterClass
 * 在JUnit4中，如果测试类继承了TestCase类，那么所有的Annotation都不会起作用。
 * Created by xiaofan on 2017/5/6.
 */
public class UserDaoSpringJDBCImplTest {
    private ApplicationContext ctx = null;
    private IUserDao userDao = null;

    @Before
    public void init() {
        System.out.println("init ApplicationContext");
        ctx = new ClassPathXmlApplicationContext("beans-jdbc.xml");
        userDao = (IUserDao) ctx.getBean("userDao");
    }

    @Test
    public void testQueryList() throws Exception {
        List<UserBo> userBos = userDao.queryList();
        for (UserBo userBo : userBos) {
            System.out.println(userBo.toString());

        }
    }

    @Test
    public void testSave() throws Exception {
        UserBo userBo = new UserBo(20, "zxf-Spring", new Date());
        userDao.save(userBo);
    }

}