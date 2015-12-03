package org.smart4j.framework.util;


/**
 * Created by wangqisen on 2015/11/25.
 */
public final class CastUtil {

    public static String castString(Object obj){
        return castString(obj,"");
    }

    public static String castString(Object obj,String defaultString){
        if(obj==null)
            return null;
        String value=defaultString;

        if(obj instanceof String){
            value=String.valueOf(obj);
        }

        return value;
    }

    public static int castInt(Object obj){
        return castInt(obj,0);
    }

    public static int castInt(Object obj,int defaultValue){
        int intValue=defaultValue;

        if(obj!=null){
            String strValue=castString(obj);
            if(StringUtil.isNotEmpty(strValue)){
                try{
                    intValue=Integer.parseInt(strValue);
                }catch(NumberFormatException e){
                    intValue=defaultValue;
                }
            }
        }

        return intValue;
    }
}
