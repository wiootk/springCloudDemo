package com.jun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class KOAController {
    @Autowired
    KOAClient client;
//    http://localhost:3344/findBooks
    @RequestMapping(value = "/findBooks", method = RequestMethod.GET)
    public List<Object> books() {
        return client.findBooks("10");
    }
}