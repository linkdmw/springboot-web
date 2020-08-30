package xyz.link666.employee.service;

import xyz.link666.pojo.Employee;

import java.util.Collection;
import java.util.List;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/12 17:18
 */

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);
}
