package com.zxiaofan.repository;

import com.zxiaofan.business.EmployeeBusinessImpl;
import junit.framework.TestCase;
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
public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Before
    public void init() {
        System.out.println("init ApplicationContext");
        ctx = new ClassPathXmlApplicationContext("beans-springDataJPA.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
    }

    @Test
    public void testPage() {
        // 排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        // PageRequest(int page, int size)：page以0开始
        // Pageable pageable = new PageRequest(1, 4);
        Pageable pageable = new PageRequest(1, 4, sort);

        Page page = employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前页数：" + page.getNumber()); // 以0开始
        System.out.println("当前页面集合：" + page.getContent());
        System.out.println("当前页面记录数：" + page.getNumberOfElements());
    }
}