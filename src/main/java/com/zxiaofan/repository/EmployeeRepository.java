package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Created by xiaofan on 2017/5/7.
 */
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository { // extends Repository<Employee,Integer> {
    public Employee findByName(String name);
}
