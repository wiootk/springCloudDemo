package com.jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2018/1/7.
 */
@SpringBootApplication
//@ComponentScan("com.jun")  //扫描下面的包@service @controller 等
//@MapperScan("com.jun.mapper")  //扫面下面的mapper类
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}


