package com.beini.test.javase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by beini on 2017/8/17.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Testface {
/**
 *   1  定义  interface
 *   2 通过反射设置变量
 */
    int value();
}
