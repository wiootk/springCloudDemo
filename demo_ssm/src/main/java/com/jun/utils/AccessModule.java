package com.jun.utils;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessModule {
    String[] value() default {};
    String[] module() default {};
    String desc() default "";
}