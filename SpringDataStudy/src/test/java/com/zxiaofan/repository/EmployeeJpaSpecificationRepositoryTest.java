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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by xiaofan on 2017/5/14.
 */
public class EmployeeJpaSpecificationRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationRepository employeeJpaSpecificationRepository;

    @Before
    public void init() {
        System.out.println("init ApplicationContext");
        ctx = new ClassPathXmlApplicationContext("beans-springDataJPA.xml");
        employeeJpaSpecificationRepository = ctx.getBean(EmployeeJpaSpecificationRepository.class);
    }

    /**
     * 分页；排序；age>35
     * <p>
     */
    @Test
    public void testFind() {
        /**
         * root：查询类型（employee）;query：查询条件；cb：构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // root(employee(age))
                Path path = root.get("age");
                Predicate predicate = cb.gt(path, 35); // gt表示大于
                return predicate;
            }
        };

        // 结合分页排序
        // 排序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        // PageRequest(int page, int size)：page以0开始
        Pageable pageable = new PageRequest(1, 2, sort);

        Page<Employee> employees = employeeJpaSpecificationRepository.findAll(specification, pageable);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}