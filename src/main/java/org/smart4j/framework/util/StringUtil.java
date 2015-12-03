package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by wangqisen on 2015/11/25.
 */
public final class StringUtil {
    public static boolean isNotEmpty(String str){
        if(str!=null){
            str=str.trim();
        }
        return StringUtils.isNotEmpty(str);
    }

    public static String[] splitString(String str,String separator){
        return StringUtils.splitByWholeSeparator(str,separator);
    }
}
