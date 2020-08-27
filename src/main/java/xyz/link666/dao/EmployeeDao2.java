package xyz.link666.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.link666.pojo.Department;
import xyz.link666.pojo.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/4 19:07
 */
//@Repository
public class EmployeeDao2 {

    @Autowired
    DepartmentDao departmentDao;

    private static Map<Integer, Employee> eployeeMap = new HashMap<Integer, Employee>();
    private static int initId = 105;

    static {
        eployeeMap.put(101, new Employee("AA", 101, "cxwl.A@qq.com", 0, new Date(), new Department(1001, "办公部")));
        eployeeMap.put(102, new Employee("BB", 102, "cxwl.B@qq.com", 1, new Date(), new Department(1002, "劳务部")));
        eployeeMap.put(103, new Employee("CC", 103, "cxwl.C@qq.com", 0, new Date(), new Department(1003, "技术部")));
        eployeeMap.put(104, new Employee("DD", 104, "cxwl.D@qq.com", 1, new Date(), new Department(1004, "人事部")));
    }


    /**
     * @param employee 新增员工
     */
    public void insertEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        eployeeMap.put(employee.getId(), employee);
    }


    /**
     * @return 查询全部
     */
    public Collection<Employee> selectAllEmployees() {
        return eployeeMap.values();
    }

    /**
     * @param id
     * 按id删除员工
     */
    public void deleteEmployee(Integer id){
        eployeeMap.remove(id);
    }

    /**
     * @param id
     * @return 按id查询员工
     */
    public Employee findEmployeeById(Integer id){
        return eployeeMap.get(id);
    }


    /**
     * @param id
     * @return 按id
     */
    public Employee selectEmployeeById(Integer id) {
        return eployeeMap.get(id);
    }

    public void updateEmp(Employee employee) {
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        eployeeMap.put(employee.getId(),employee);
    }

    public void deleteEmp(Integer id) {
        eployeeMap.remove(id);
    }
}