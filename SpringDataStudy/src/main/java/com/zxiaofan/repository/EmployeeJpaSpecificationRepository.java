package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by xiaofan on 2017/5/14.
 */
// 一定要声明实体类类型和主键类型
public interface EmployeeJpaSpecificationRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
