package indi.jackie.boot;

import java.lang.annotation.*;

/**
 * 指定data source group
 * Date: 2015-09-25
 *
 * @author jackie chen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Dao {
    String value() default "";
}


