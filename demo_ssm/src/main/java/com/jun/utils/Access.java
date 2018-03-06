package com.jun.utils;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {
    String[] value() default {};
    String[] roles() default {};
    String[] powers() default {};
    String[] absPowers() default {};
    String desc() default "";
}

