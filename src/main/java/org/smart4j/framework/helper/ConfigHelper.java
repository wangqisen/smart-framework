package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

import java.util.Properties;

/**
 * Created by wangqisen on 2015/11/28.
 */
public final class ConfigHelper {

    private static final String DEFAULT_APP_JSP_PATH="/WEB-INF/view/";
    private static final String DEFAULT_APP_ASSET_PATH="/asset/";

    private static final Properties CONFIG_PROPS= PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,DEFAULT_APP_JSP_PATH);
    }

    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,DEFAULT_APP_ASSET_PATH);
    }
}
