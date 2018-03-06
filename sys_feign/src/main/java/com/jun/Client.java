package com.jun;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value ="compute-service", fallback = ClientHystrix.class)
//绑定该接口对应compute-service服务
//@FeignClient(name = "stores", configuration = FooConfiguration.class)
//@FeignClient("compute-service")//绑定该接口对应服务
//指定服务名，同时需要制定服务配置类
public interface Client {
    @RequestMapping(method = RequestMethod.GET, value = "/add")
//    @HystrixCommand(fallbackMethod="findByIdFallback")// 单个方法的fallback
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @RequestMapping(method = RequestMethod.GET, value = "/hi")
    String hi(@RequestParam(value = "name") String name);

}