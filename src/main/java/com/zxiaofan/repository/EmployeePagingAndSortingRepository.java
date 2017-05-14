package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xiaofan on 2017/5/14.
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {
}
