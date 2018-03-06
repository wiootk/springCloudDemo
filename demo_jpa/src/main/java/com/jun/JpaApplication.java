package com.jun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//服务注册客户端
@EnableEurekaClient
//@EnableWebMvc
//@EnableDiscoveryClient
//激活Eureka中的DiscoveryClient实现
public class JpaApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ClientApplication.class, args);
        new SpringApplicationBuilder(JpaApplication.class).web(true).run(args);
    }
}
