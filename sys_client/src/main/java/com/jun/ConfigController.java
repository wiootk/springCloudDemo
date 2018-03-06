package com.jun;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
//@RestController
//class ConfigController {
//    private final Logger logger = Logger.getLogger(getClass());
//    //    http://localhost:2222/from
//    //  post  http://localhost:2222/refresh  刷新数据
//    @Value("${from}")
//    private String from;
//    @RequestMapping("/from")
//    public String from() {
//        return this.from;
//    }
//}
