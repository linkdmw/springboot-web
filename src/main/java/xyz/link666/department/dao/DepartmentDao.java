package xyz.link666.department.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.link666.pojo.Department;

import java.util.Collection;
import java.util.List;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/9/3 0:35
 */
@Mapper
@Repository
public interface DepartmentDao {

    List<Department> selectAllDepartment();
}
