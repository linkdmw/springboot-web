package xyz.link666.employee.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.link666.pojo.Employee;

import java.util.Collection;
import java.util.List;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/27 23:52
 */
@Mapper
@Repository
public interface EmployeeDao {
    /**
     * 查询全部
     * @return List<Employee>
     */
    List<Employee> selectAllEmployees();

    /**
     * 添加新员工
     * @param employee 新员工
     */
    void insertEmployee(Employee employee);

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return Employee
     */
    Employee selectEmployeeById(Integer id);

    /**
     * 更新员工信息
     * @param employee 更新后员工
     */
    void updateEmp(Employee employee);

    /**
     * 按id删除员工
     * @param id 员工id
     */
    void deleteEmp(Integer id);
}
