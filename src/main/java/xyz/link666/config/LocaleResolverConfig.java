package xyz.link666.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/7 23:00
 */

public class LocaleResolverConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //先拿个默认的
        Locale defaultLocale = Locale.getDefault();
        //解析请求中的语言参数
        String lang = request.getParameter("lang");

        if(!StringUtils.isEmpty(lang)){
            //地区_国家
            String[] split = lang.split("_");
            return new Locale(split[0],split[1]);
        }
        return defaultLocale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
