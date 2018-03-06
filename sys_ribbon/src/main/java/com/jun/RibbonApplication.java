package com.jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrixDashboard
//断路器仪表盘  http://localhost:3333/hystrix
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient//添加发现服务能力
@EnableCircuitBreaker//启用断路器
public class RibbonApplication {
    @Bean
    @LoadBalanced//开启均衡负载
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }
}


////http://localhost:3333/hystrix.stream
////locahost:3333/hystrix   输入：locahost:3333/hystrix.stream 、2000 、title
////另一个窗口 http://localhost:3333/add
////重新刷新hystrix.stream网页
