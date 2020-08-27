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
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        model.addAttribute("msg","用户名或密码错误，登录失败");
        return "index";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        //使当前session无效，该方法等于调用session对象中的destroy方法
        session.invalidate();
        return "redirect:/index.html";
    }
}
