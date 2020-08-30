package xyz.link666.department.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.link666.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA.
 */

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = new HashMap<Integer, Department>();
    private static int ID;

    static {
        departmentMap.put(1001,new Department(1001,"办公部"));
        departmentMap.put(1002,new Department(1002,"劳务部"));
        departmentMap.put(1003,new Department(1003,"技术部"));
        departmentMap.put(1004,new Department(1004,"人事部"));
    }

    /**
     * @return 模拟取出全部部门数据
     */
    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }


    /**
     * @param id 部门id
     * @return 根据id查询部门实体
     */
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }

    public Collection<Department> selectAllDepartment(){
        return departmentMap.values();
    }

    public void addDepartment(Department department){
        departmentMap.put(ID++,department);
    }
}
