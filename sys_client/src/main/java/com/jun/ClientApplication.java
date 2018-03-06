package com.jun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//服务注册客户端
@EnableEurekaClient
//@EnableDiscoveryClient
//激活Eureka中的DiscoveryClient实现
public class ClientApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ClientApplication.class, args);
        new SpringApplicationBuilder(ClientApplication.class).web(true).run(args);
    }
}
