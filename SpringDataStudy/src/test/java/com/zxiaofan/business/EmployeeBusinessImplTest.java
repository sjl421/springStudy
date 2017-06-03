package com.zxiaofan.business;

import com.zxiaofan.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void tesSave() throws Exception {
        List<Employee> employees = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            Employee employee = new Employee(i, "name" + i, 50 - i);
            employees.add(employee);
        }
        employeeBusiness.save(employees);
    }

}