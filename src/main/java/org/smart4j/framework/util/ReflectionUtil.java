package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wangqisen on 2015/12/1.
 */
public final class ReflectionUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls){
        Object ins=null;
        try{
            ins=cls.newInstance();
        }catch (Exception e){
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return ins;
    }

    public static Object newInstance(String className){
        Object ins=null;
        try{
            ins=Class.forName(className);
        }catch (Exception e){
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return ins;
    }

    public static Object invokeMethod(Object obj,Method method,Object...args){
        method.setAccessible(true);
        Object result=null;
        try{
            result=method.invoke(obj,args);
        }catch (Exception e){
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Object invokeMethod(Object obj,Method method){
        method.setAccessible(true);
        Object result=null;
        try{
            result=method.invoke(obj);
        }catch (Exception e){
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object obj,Field field,Object value){
        try{
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            LOGGER.error("set Field failure",e);
            throw new RuntimeException(e);
        }
    }

}
