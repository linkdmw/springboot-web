package xyz.link666.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.link666.pojo.Department;
import xyz.link666.pojo.Employee;
import xyz.link666.service.DepartmentService;
import xyz.link666.service.EmployeeService;

import java.util.Collection;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/12 17:15
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/emp/getAllEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("emps",employeeService.getAllEmployees());
        return "list";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/emp/getAllEmployees";
    }

    @GetMapping("toUpdateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        Collection<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("emp",employee);
        model.addAttribute("departments",departments);
        return "updateEmployee";
    }
}
