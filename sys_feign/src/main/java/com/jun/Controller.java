package com.jun;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Client client;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return client.add(10, 20);
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return client.hi("testFeign");
    }

}