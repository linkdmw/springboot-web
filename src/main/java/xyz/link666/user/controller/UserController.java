package xyz.link666.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ApiOperation(value = "跳转到登录页面")
    @GetMapping("toLogin")
    public String toLogin(){
        return "index";
    }

    @ApiOperation(value = "跳转到未授权页面")
    @GetMapping("unAuthorization")
    public String unAuthorization(){
        return "unAuthorization";
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("user/login")
    public String login(@ApiParam(name = "user",value = "传入需验证用户",required = true) User user,
                        Model model,
                        HttpSession session) {
        //获取当前用户
        Subject currentSubject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            currentSubject.login(token);
            User loginUser = (User) currentSubject.getPrincipal();
            session.setAttribute("loginUser",loginUser);
            return "redirect:/main.html";
        } catch (UnknownAccountException e) {   //用户名不存在
            model.addAttribute("login_msg","用户不存在！");
            return "index";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("login_msg","密码错误");
            return "index";
        }

    }

    @ApiOperation(value = "注销登录")
    @GetMapping("user/logout")
    public String logout(HttpSession session){
        //使当前session无效，该方法等于调用session对象中的destroy方法
        session.invalidate();
        return "redirect:/index.html";
    }

    @GetMapping("testRole")
    public String testRole() {
        return "addList";
    }
}
