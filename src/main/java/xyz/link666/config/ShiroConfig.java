package xyz.link666.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author 林克大善人
 */
@Configuration
public class ShiroConfig {

    /**
     * @param securityManager 利用@Qualifier拿到，括号里是@Bean添加的别名
     * @return 返回ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //关联DefaultWebSecurityManager，设备安全管理器
        bean.setSecurityManager(securityManager);

        //配置登录跳转路径
        bean.setLoginUrl("/toLogin");
        //配置未授权跳转路径
        bean.setUnauthorizedUrl("/unAuthorization");
        /*  添加shiro内置过滤器
         *  anon：无需过滤可以直接访问
         *  authc：必须经过认证了才可以访问
         *  user：必须拥有记住我功能才可以访问
         *  perms：必须有对某个资源的访问权限才可以访问
         *  role：拥有某个角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //key是请求路径，value为过滤类型，对静态资源设置匿名访问
        filterMap.put("/index","anon");
        filterMap.put("/toLogin","anon");
        filterMap.put("/index.html","anon");
        filterMap.put("/user/login","anon");
        filterMap.put("/static/**", "anon");
        filterMap.put("/img/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/css/**","anon");
        //shiro Filter的执行顺序 自上而下，从左到右
        filterMap.put("/testRole","roles[管理员]");
        filterMap.put("/**","user");

        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }


    /**使用@Qualifier("getUserRealm")注解把spring托管的getUserRealm关联起来，默认填方法名
     * 2.DefaultWebSecurityManager
     * @return 默认的web权限管理
     */
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getUserRealm") MyRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(realm);
        //用户授权/认证信息Cache, 采用EhCache缓存
        //securityManager.setCacheManager(getEhCacheManager());

        //注入记住我管理器,将cookie管理对象设置到SecurityManager中
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }


    /**
     * 1.创建自定义Realm对象
     * @return UserRealm
     */
    @Bean
    public MyRealm getUserRealm(){
        return new MyRealm();
    }


    /**
     * 用于整合springboot
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


    /**1.该方法生成一个COOKIE
     * @return cookie
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        //最大寿命，即过期时间，单位为秒，这里是一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**2.cookie管理对象，生成rememberMe管理器，而且将这个rememberMe管理器设置到securityManager中
     * @return CookieRememberMeManager
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }


}
