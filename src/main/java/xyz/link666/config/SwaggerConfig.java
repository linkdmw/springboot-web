package xyz.link666.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by IDEA.
 *
 * @Author: huo
 * @Date: 2020/8/28 17:10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * 读取配置文件
     */
    @Value("${swaggerEnabled}")
    private boolean swaggerEnabled;

    /**进行配置swagger2的bean实例，类型为Docket；此处不进行配置则启用默认配置
     * @return Docket 配置后的
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnabled)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.ant("/log**"))
                .build()
                .groupName("master")
                ;
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("huo", "http://github.com/linkdmw", "cxwl.h@qq.com");
        return new ApiInfo("springboot-web",
                "简单的基于springboot开发的WEB项目",
                "1.0.0",
                "http://baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }


}
