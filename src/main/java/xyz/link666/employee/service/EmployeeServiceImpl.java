package xyz.link666.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.link666.employee.dao.EmployeeDao;
import xyz.link666.employee.service.EmployeeService;
import xyz.link666.pojo.Employee;

import java.util.List;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/12 17:19
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.selectAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.selectEmployeeById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }

    @Override
    public void deleteEmpById(Integer id) {
        employeeDao.deleteEmpById(id);
    }
}
