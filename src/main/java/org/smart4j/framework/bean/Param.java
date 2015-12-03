package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;

import java.util.Map;

/**
 * Created by wangqisen on 2015/12/3.
 */
public class Param {

    private Map<String,Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap=paramMap;
    }

    public String getString(String name){
        return CastUtil.castString(paramMap.get(name));
    }
}
