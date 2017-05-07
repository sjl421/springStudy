package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaofan on 2017/5/7.
 */
public class EmployeeRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository;

    @Before
    public void init() {
        System.out.println("init ApplicationContext");
        ctx = new ClassPathXmlApplicationContext("beans-springDataJPA.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
    }

    @Test
    public void testFindByName() throws Exception {
        // org.springframework.data.jpa.repository.support.SimpleJpaRepository@4074023c
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("zxiaofna.com");
        if (null == employee) {
            System.out.println("null");
        } else {
            System.out.println(employee.toString());
        }
    }

}