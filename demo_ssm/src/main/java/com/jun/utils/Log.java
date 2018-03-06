package com.jun.utils;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String[] value() default {};
    String desc() default "";
    String func() default "";
    String type() default "001";
}
