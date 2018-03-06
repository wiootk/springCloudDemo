package com.jun;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "koa2")
public interface KOAClient {
    @RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
    public List<Object> findBooks(@RequestParam("id") String id);
}