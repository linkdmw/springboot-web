package xyz.link666.employee.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.link666.pojo.Department;
import xyz.link666.pojo.Employee;
import xyz.link666.department.service.DepartmentService;
import xyz.link666.employee.service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/12 17:15
 */
@Api(tags = "员工模块")
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    /**显示全部员工
     * @param model model
     * @return 全部员工列表
     */
    @ApiOperation(value = "查询全部员工")
    @RequestMapping("/emp/getAllEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("emps",employeeService.getAllEmployees());
        return "list";
    }

    /**添加员工
     * @param employee employee
     * @return 重定向到员工列表
     */
    @ApiOperation(value = "添加员工")
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/emp/getAllEmployees";
    }

    /**
     * @param id 员工id
     * @param model model
     * @return 跳转到更新员工页面
     */
    @ApiOperation(value = "更新员工前处理")
    @GetMapping("toUpdateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("emp",employee);
        model.addAttribute("departments",departments);
        return "updateEmployee";
    }

    /**
     * @param employee 更新后employee
     * @return 更新并跳回首页
     */
    @ApiOperation(value = "更新员工")
    @PostMapping("updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return  "redirect:/emp/getAllEmployees";
    }

    /**
     * @param id 删除员工的ID
     * @return 重定向到员工页
     */
    @ApiOperation(value = "按ID删除员工")
    @GetMapping("deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmpById(id);
        return  "redirect:/emp/getAllEmployees";
    }
}
