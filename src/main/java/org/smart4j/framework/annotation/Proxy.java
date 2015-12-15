package org.smart4j.framework.annotation;

import org.smart4j.framework.proxy.ProxyChain;

/**
 * Created by wangqisen on 2015/12/13.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
