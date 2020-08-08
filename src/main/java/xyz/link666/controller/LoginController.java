package xyz.link666.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/8 21:35
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(String username,
                        String password,
                        Model model,
                        HttpSession session) {
        if (username != null && "666".equals(password)) {
            System.out.println();
            return "redirect:/main.html";
        }
        model.addAttribute("msg","用户名或密码错误，登录失败");
        return "index";
    }
}
