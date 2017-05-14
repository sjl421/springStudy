package com.zxiaofan.business;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaofan on 2017/5/13.
 */
public class EmployeeBusinessImplTest {
    private ApplicationContext ctx = null;
    private EmployeeBusinessImpl employeeBusiness;

    @Before
    public void init() {
        System.out.println("init ApplicationContext");
        ctx = new ClassPathXmlApplicationContext("beans-springDataJPA.xml");
        employeeBusiness = ctx.getBean(EmployeeBusinessImpl.class);
    }

    @Test
    public void testUpdateAgeByID() throws Exception {
        employeeBusiness.updateAgeByID(5, 23);
    }

}