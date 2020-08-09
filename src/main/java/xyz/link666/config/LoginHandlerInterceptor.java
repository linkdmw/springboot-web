package xyz.link666.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/9 18:27
 */

public class LoginHandlerInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return true;
        }else {
            request.setAttribute("msg","权限不足！您还没有登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
    }
}
