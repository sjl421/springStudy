package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by xiaofan on 2017/5/14.
 */
public class EmployeeJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository;

    @Before
    public void init() {
        System.out.println("init ApplicationContext");
        ctx = new ClassPathXmlApplicationContext("beans-springDataJPA.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
    }

    @Test
    public void testFind() {
        Employee employee = employeeJpaRepository.findOne(9);
        System.out.println(employee);
        System.out.println(employeeJpaRepository.exists(10));
        System.out.println(employeeJpaRepository.exists(100));
    }
}