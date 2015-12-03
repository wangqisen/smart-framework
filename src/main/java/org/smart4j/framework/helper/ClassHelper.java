package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangqisen on 2015/11/30.
 */
public final class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static{
        String basePackage=ConfigHelper.getAppBasePackage();
        CLASS_SET= ClassUtil.getClassSet(basePackage);
    }

    /*
    获取包下所有类
    * */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }


    /*
    获取所有的Service类
    * */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();

        for(Class<?> cls:CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }

        return classSet;
    }

    /*
    获取所有的Controller类
    * */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();

        for(Class<?> cls:CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }

        return classSet;
    }

    /*
    * 获取所有的Bean类
    * */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet=new HashSet<Class<?>>();
        beanClassSet.addAll(getControllerClassSet());
        beanClassSet.addAll(getServiceClassSet());
        return beanClassSet;
    }


}
