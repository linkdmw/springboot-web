package xyz.link666.dao;

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
     * @return 查询全部
     */
    List<Employee> selectAllEmployees();

    void insertEmployee(Employee employee);

    Employee selectEmployeeById(Integer id);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);
}
