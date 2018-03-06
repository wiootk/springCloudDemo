package com.jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//服务注册中心
@EnableEurekaServer
@SpringBootApplication
//相当于@Configuration、@EnableAutoConfiguration(自动配置)和  @ComponentScan
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
//        SpringApplication.run(Application.class, "--server.port=1112");
    }
}
//F11或S右键 Run Java Application 启动应用
//部署spring boot应用->工程目录:mvn package->进入target目录->java -jar simple.jar --server.port=8081  >log8081.log
