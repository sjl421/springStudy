package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() throws Exception {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("t", 21);
        if (null != employees) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThanEqual() throws Exception {
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThanEqual(Arrays.asList("t1", "t2"), 21);
        if (null != employees) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void testGetEmployeeByMaxID() throws Exception {
        Employee employee = employeeRepository.getEmployeeByMaxID();
        if (null != employee) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryByNameAge() throws Exception {
        List<Employee> employees = employeeRepository.queryByNameAge("t2", 21);
        if (null != employees) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void testQueryByNameAge2() throws Exception {
        List<Employee> employees = employeeRepository.queryByNameAge2("t2", 21);
        if (null != employees) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void testQueryLike() throws Exception {
//        List<Employee> employees = employeeRepository.queryLike("t1");
        List<Employee> employees = employeeRepository.queryLike2("t1");
        if (null != employees) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void testGetCount() throws Exception {
        Integer count = employeeRepository.getCount();
        System.out.println(count);
    }

}