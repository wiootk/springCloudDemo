package com.jun.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
//全局异常处理
public class ErrorController {
    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);
    class ErrorMag{
        private String code;
        private String message;
        private String exception;
        private String  time;
        public String DateConver(Long time){
            if(time!=null&&time==0){
                time=System.currentTimeMillis();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(time);
            return simpleDateFormat.format(date);
        }
        public String DateConver(){
           return DateConver(System.currentTimeMillis());
        }
        public ErrorMag( String code,String message,Exception e){
            this.code=code;
            this.message=message;
            this.exception=e.getMessage();
            this.time= DateConver();
        }
        public void setTime(long time) {
            this.time = DateConver(time);
        }
        public void setTime() {
            this.time = DateConver();
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getException() {
            return exception;
        }

        public void setException(String exception) {
            this.exception = exception;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    //捕获除0异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ErrorMag exception1(ArithmeticException e){
        System.out.println("处理除0异常");
//        //继续抛出异常，才能被logback的error级别日志捕获
//        throw e;
        return new ErrorMag("001","处理除0异常", e);
    }
    //捕获空指针异常
    @ExceptionHandler(NullPointerException.class)
    public String exception2(NullPointerException e){
        System.out.println("处理空指针异常");
        //手动将异常写入logback的error级别日志
        log.error("空指针异常",e);
        return "/null.html";
    }


}
