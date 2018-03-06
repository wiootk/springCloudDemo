package com.jun.utils;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(AccessInterceptor.class);

    // 在调用方法之前执行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String moduleDesc = "";
        List<String> modules = new ArrayList<>();
        String methodDesc = "";
        List<String> roles = new ArrayList<>();
        List<String> powers = new ArrayList<>();
        List<String> absPowers = new ArrayList<>();
        // 将handler强转为HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取所在的类
        Class clazz = handlerMethod.getBeanType();
        if (clazz.isAnnotationPresent(AccessModule.class)) {
            //类上的权限
            AccessModule pAccess = (AccessModule) clazz.getAnnotation(AccessModule.class);
            log.error("类权限的描述：{},模块：{}", pAccess.desc(), pAccess.module());
            moduleDesc = pAccess.desc();
            modules = Arrays.asList(pAccess.module());
        }
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的Access注解
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }
        log.error("方法权限的描述：{},角色：{},权限:{},绝对权限:{}", access.desc()
                , access.roles(), access.powers(), access.absPowers());
        methodDesc = access.desc();
        roles = Arrays.asList(access.roles());
        powers = Arrays.asList(access.powers());
        absPowers = Arrays.asList(access.absPowers());
        Set<String> powerSet = new HashSet<>();
        if (powers.size() > 0) {
            if (modules.size() > 0) {
                for (String module : modules) {
                    for (String power : powers) {
                        powerSet.add(module + "." + power);
                    }
                }
            } else {
                for (String power : powers) {
                    powerSet.add(power);
                }
            }
        }
        if (absPowers.size() > 0) {
            for (String power : absPowers) {
                powerSet.add(power);
            }
        }
        String desc = methodDesc;
        if (!StringUtils.isEmpty(moduleDesc)) {
            desc = moduleDesc + "(" + desc + ")";
        }
        log.error("权限描述：{},角色：{},权限:{}",desc,JSON.toJSONString(roles), JSON.toJSONString(powerSet));
        // 拦截之后应该返回公共结果, 这里没做处理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.debug(">>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.debug(">>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }






}

