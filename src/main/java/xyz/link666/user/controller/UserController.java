package xyz.link666.user.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.link666.pojo.User;
import xyz.link666.user.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/8 21:35
 */
@Api(tags = "用户模块控制器类")
@Controller
public class UserController {

    @Autowired
    UserService uSerService;

    @RequestMapping("/user/login")
    public String login(User user,
                        Model model,
                        HttpSession session) {
        User loginUser = uSerService.userLogin(user);
        if (loginUser != null) {
            session.setAttribute("loginUser",loginUser);
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
