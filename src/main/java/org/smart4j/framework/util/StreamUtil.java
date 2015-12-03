package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wangqisen on 2015/12/3.
 */
public final class StreamUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(StreamUtil.class);

    public static String getString(InputStream is){
        StringBuilder sb=new StringBuilder();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
            }
        }catch (Exception e){
            LOGGER.error("get string failure",e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
