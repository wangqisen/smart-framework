package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * Created by wangqisen on 2015/12/3.
 */
public class Handler {

    private Class<?> controllerClass;
    private Method actionMethod;

    public Handler(Class<?> controllerClass,Method method){
        this.controllerClass=controllerClass;
        this.actionMethod=method;
    }

    public Class<?> getControllerClass(){
        return controllerClass;
    }

    public Method getActionMethod(){
        return actionMethod;
    }
}
