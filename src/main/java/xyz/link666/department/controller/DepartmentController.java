package xyz.link666.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.link666.pojo.Department;
import xyz.link666.department.service.DepartmentService;

import java.util.Collection;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/15 12:29
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("getAllDepartment")
    public String getAllDepartment(Model model){
        Collection<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("departments",departments);
        return "addList";
    }
}
