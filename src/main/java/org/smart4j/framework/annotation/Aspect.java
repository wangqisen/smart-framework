package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by wangqisen on 2015/12/13.
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
