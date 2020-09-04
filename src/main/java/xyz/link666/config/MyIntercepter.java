package xyz.link666.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz.link666.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/9/4 12:29
 */

public class MyIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Subject currentSubject = SecurityUtils.getSubject();
        if(currentSubject.isRemembered()){
            User oldUser = (User) currentSubject.getPrincipal();
            request.getSession().setAttribute("loginUser",oldUser);
        }
        return true;
    }
}
