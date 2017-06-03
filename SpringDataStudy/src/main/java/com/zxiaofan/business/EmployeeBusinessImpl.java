package com.zxiaofan.business;

import com.zxiaofan.model.Employee;
import com.zxiaofan.repository.EmployeeCrudRepository;
import com.zxiaofan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by xiaofan on 2017/5/13.
 */
@Component
public class EmployeeBusinessImpl {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void updateAgeByID(Integer id, Integer age) {
        employeeRepository.updateAgeByID(id, age);
    }

    @Transactional
    public void save(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }
}
