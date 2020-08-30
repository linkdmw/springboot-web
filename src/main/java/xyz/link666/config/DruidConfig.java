package xyz.link666.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by IDEA.
 *
 * @Author: 霍梦威
 * @Date: 2020/6/9 22:05
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        //为了拿yml里配置的DataSource私有属性
        return new DruidDataSource();
    }


    //后台监控
    //注册一个servlet bean
    //因为SpringBoot 内置了Servlet容器，所以没有web. xmL ，替代方法: ServletRegistrationBean

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //key是固定的
        initParameters.put("loginUsername","link");
        initParameters.put("loginPassword","123456");

        //设置初始化参数Map<String,String>
        bean.setInitParameters(initParameters);
        return bean;
    }
}
