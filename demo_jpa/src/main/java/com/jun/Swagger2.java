package com.jun;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:{port}/swagger-ui.html 或在注册服务的列表点击超链接
@Configuration
@EnableSwagger2 // 启用Swagger2
public class Swagger2 implements EnvironmentAware {

    private String basePackage;
    private RelaxedPropertyResolver propertyResolver;

    //  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("swagger-ui.html")
//            .addResourceLocations("classpath:/META-INF/resources/");
//    registry.addResourceHandler("/webjars/**")
//            .addResourceLocations("classpath:/META-INF/resources/webjars/");
//}
    @Bean
    public Docket createRestApi() {// 创建API基本信息
        return new Docket(DocumentationType.SWAGGER_2)
                //.pathMapping("/get/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jun"))
                // 扫描该包下的所有需要在Swagger中展示的API(包括实现的包)，@ApiIgnore注解标注的除外
                .paths(PathSelectors.any())
//              .paths(Predicates.or(
//                        //这里添加你需要展示的接口
//                        PathSelectors.ant("/qqq/**"),
//                        PathSelectors.ant("/eee/**")
//                        )
//                )
                .build();
    }

    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("Swagger2构建RESTful APIs")// API 标题
                .description("jpa提供的API")// API描述
                .contact("jun@")// 联系人
                .version("1.0")// 版本号
                .build();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, (String) null);
        this.basePackage = this.propertyResolver.getProperty("swagger.basepackage");
    }
}