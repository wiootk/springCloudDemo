package com.jun.utils;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@Component
@Aspect
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(AccessInterceptor.class);

    @Pointcut(value = "@annotation(com.jun.utils.Log)")
    public void log() {
    }

    @Before("log()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.error("URL : {}\r\nHTTP_METHOD :{}\r\nIP : {}\r\nCLASS_METHOD :{}\r\nARGS :{}\r\n", request.getRequestURL().toString(),
                request.getMethod(), request.getRemoteAddr(), (joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()),
                JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.error("方法的返回值 : {}", ret);
    }

    //后置异常通知
    @AfterThrowing("log()")
    public void throwss(JoinPoint jp) {
        logger.error("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("log()")
    public void after(JoinPoint jp) {
        logger.error("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("@annotation(log)")
    public Object arround(ProceedingJoinPoint pjp, Log log) {
        logger.error("注解里的值:\r\n 描述：{}\r\n功能：{} \r\n类型：{}", log.desc(), log.func(), log.type());
        try {
            Object o = pjp.proceed();
            logger.error("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
