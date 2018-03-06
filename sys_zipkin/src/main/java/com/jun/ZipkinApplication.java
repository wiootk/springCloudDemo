package com.jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.NoOpSpanAdjuster;
import org.springframework.cloud.sleuth.SpanAdjuster;
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }
    @Bean
    @ConditionalOnMissingBean
    public SpanAdjuster defaultSpanAdjuster() {
        return new NoOpSpanAdjuster();
    }
}
//http://localhost:8899/ ==>Dependencies依赖关系==>find traces 服务调用数据