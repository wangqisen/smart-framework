package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.MethodProxy;
import org.smart4j.framework.annotation.Proxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqisen on 2015/12/13.
 */
public class ProxyChain {

    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targetMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;

    private List<Proxy> proxyList= new ArrayList<Proxy>();
    private int proxyIndex=0;

    public ProxyChain(Class<?> targetClass,Object targetObject,Method targetMethod,MethodProxy methodProxy,Object[] methodParams,List<Proxy> proxyList){
        this.targetClass=targetClass;
        this.targetObject=targetObject;
        this.targetMethod=targetMethod;
        this.methodProxy=methodProxy;
        this.methodParams=methodParams;
        this.proxyList=proxyList;
    }

    public Object[] getMethodParams(){
        return methodParams;
    }

    public Class<?> getTargetClass(){
        return targetClass;
    }

    public Method getTargetMethod(){
        return targetMethod;
    }

    public Object doProxyChain() throws Throwable{
        Object methodReult;
        if(proxyIndex<proxyList.size()){
            methodReult=proxyList.get(proxyIndex++).doProxy(this);
        }else{
            methodReult=methodProxy.invokeSuper(targetObject,methodParams);
        }
        return methodReult;
    }

}
