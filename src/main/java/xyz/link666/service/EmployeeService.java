package xyz.link666.service;

import xyz.link666.pojo.Employee;

import java.util.Collection;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/12 17:18
 */

public interface EmployeeService {
    Collection<Employee> getAllEmployees();
}