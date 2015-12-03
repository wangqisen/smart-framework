package org.smart4j.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangqisen on 2015/12/1.
 */
public final class BeanHelper {

    private static final Map<Class<?>,Object> BEAN_MAP=new HashMap<Class<?>, Object>();
    private static final Logger LOGGER= LoggerFactory.getLogger(BeanHelper.class);

    static{
        Set<Class<?>> beanClassSet=ClassHelper.getBeanClassSet();
        for(Class<?> cls:beanClassSet){
            Object obj=ReflectionUtil.newInstance(cls);
            BEAN_MAP.put(cls,obj);
        }
    }

    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
            LOGGER.error("can not get bean by class:"+cls);
        }
        return (T)BEAN_MAP.get(cls);
    }
}
