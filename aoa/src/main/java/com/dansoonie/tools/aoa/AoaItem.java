package com.dansoonie.tools.aoa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dansoonie on 4/13/16.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AoaItem {
    String parent() default "";
    String title() default "";
    String description() default "";
}
