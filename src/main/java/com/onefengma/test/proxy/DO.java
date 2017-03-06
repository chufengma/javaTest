package com.onefengma.test.proxy;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dev on 2017/3/6.
 */
@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface DO {
    String test();
    boolean name() default false;
}
