package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * Created by xiaofan on 2017/5/7.
 */
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository { // extends Repository<Employee,Integer> {
    public Employee findByName(String name);

    /**
     * where name like ?% and age <?
     */
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name in(?,?...) or age<=?
    public  List<Employee> findByNameInAndAgeLessThanEqual(List<String> names,Integer age);
}
