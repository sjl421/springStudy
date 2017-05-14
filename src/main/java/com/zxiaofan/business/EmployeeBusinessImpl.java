package com.zxiaofan.business;

import com.zxiaofan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


/**
 * Created by xiaofan on 2017/5/13.
 */
@Component
public class EmployeeBusinessImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void updateAgeByID(Integer id, Integer age) {
        employeeRepository.updateAgeByID(id, age);
    }
}
