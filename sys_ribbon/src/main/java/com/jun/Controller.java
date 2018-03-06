package com.jun;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "addFallback")
    //指定调用失败断路器调用的函数
    public String add() {
        return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return restTemplate.getForEntity("http://compute-service/hi?name=testRibbon", String.class).getBody();
    }

    public String addFallback() {
        return "error";
    }
}
