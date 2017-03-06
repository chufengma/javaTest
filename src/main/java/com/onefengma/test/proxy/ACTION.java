package com.onefengma.test.proxy;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dev on 2017/3/6.
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface ACTION {
    String value() default "";
}
