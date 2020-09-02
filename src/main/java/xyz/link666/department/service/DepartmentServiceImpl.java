package xyz.link666.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.link666.department.dao.DepartmentDao;
import xyz.link666.pojo.Department;

import java.util.Collection;
import java.util.List;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/15 12:28
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.selectAllDepartment();
    }
}
