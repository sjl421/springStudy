package com.zxiaofan.repository;

import com.zxiaofan.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

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
    public List<Employee> findByNameInAndAgeLessThanEqual(List<String> names, Integer age);

    /**
     * 查询ID最大的那条数据
     *
     * @return Employee
     */
    @Query("select e1 from Employee e1 where id=(select max(id) from Employee e2)")
    public Employee getEmployeeByMaxID();

    /**
     * 占位符方式
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select e1 from Employee e1 where e1.name=?1 and e1.age=?2")
    public List<Employee> queryByNameAge(String name, Integer age);

    /**
     * 命名参数方式
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select e1 from Employee e1 where e1.name=:name and e1.age=:age")
    public List<Employee> queryByNameAge2(@Param("name") String name, @Param("age") Integer age);

    /**
     * 占位符like
     *
     * @param name
     * @return
     */
    @Query("select e1 from Employee e1 where e1.name like %?1%")
    public List<Employee> queryLike(String name);

    @Query("select e1 from Employee e1 where e1.name like %:name%")
    public List<Employee> queryLike2(@Param("name") String name);

    /**
     * 原生sql（nativeQuery = true, value ="sql"）
     *
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT COUNT(1) FROM  Employee")
    public Integer getCount();
}
