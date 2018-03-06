package com.jun;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ClientHystrix implements Client {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
    @Override
    public String hi(@RequestParam(value = "name") String name) {
        return "-9999";
    }
}
