package xyz.link666.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.link666.service.EmployeeService;

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

    @RequestMapping("/emp/getAllEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("emps",employeeService.getAllEmployees());
        return "list";
    }
}
