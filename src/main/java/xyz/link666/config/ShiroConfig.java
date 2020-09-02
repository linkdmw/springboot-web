package xyz.link666.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
        /*  添加shiro内置过滤器
         *  anon：无需过滤可以直接访问
         *  authc：必须经过认证了才可以访问
         *  user：必须拥有记住我功能才可以访问
         *  perms：必须有对某个资源的访问权限才可以访问
         *  role：拥有某个角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        //key是请求路径，value为过滤类型
        filterMap.put("/index","anon");
        filterMap.put("/","anon");
        filterMap.put("/toLogin","anon");
        filterMap.put("/index.html","anon");
        filterMap.put("/user/login","anon");
        filterMap.put("/img/**","anon");
        filterMap.put("/js/**","anon");
        filterMap.put("/css/**","anon");
        //shiro Filter的执行顺序 自上而下，从左到右
        filterMap.put("/testRole","roles[管理员]");
        filterMap.put("/**","authc");

        bean.setFilterChainDefinitionMap(filterMap);
        //配置登录跳转路径
        bean.setLoginUrl("/toLogin");
        //配置未授权跳转路径
        bean.setUnauthorizedUrl("/unAuthorization");
        return bean;
    }


    /**
     * 2.DefaultWebSecurityManager
     * @return 默认的web权限管理
     */
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getUserRealm") MyRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm,使用@Qualifier("getUserRealm")注解把spring托管的getUserRealm关联起来，默认填方法名
        securityManager.setRealm(realm);
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
}
