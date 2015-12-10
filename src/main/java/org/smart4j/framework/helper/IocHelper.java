package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by wangqisen on 2015/12/1.
 */
public final class IocHelper {

    static {
        Map<Class<?>,Object> BEAN_MAP= BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(BEAN_MAP)){
            for(Map.Entry<Class<?>,Object> entry:BEAN_MAP.entrySet()){
                Class<?> beanCls=entry.getKey();
                Object beanInstance=entry.getValue();
                Field[] beanFields=beanCls.getDeclaredFields();
                for(Field beanField:beanFields){
                    if(beanField.isAnnotationPresent(Inject.class)){
                        Class<?> beanFieldType=beanField.getType();
                        Object beanFieldInstance=BEAN_MAP.get(beanFieldType);
                        if(beanFieldInstance!=null){
                            ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                        }
                    }
                }
            }
        }
    }
}
