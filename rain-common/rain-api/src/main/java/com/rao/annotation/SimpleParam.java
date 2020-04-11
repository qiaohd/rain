package com.rao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 简单参数绑定注解
 *
 * @author raojing
 * @date 2020-04-11 11:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface SimpleParam {
    String value() default "";
}
