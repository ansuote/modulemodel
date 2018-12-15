package com.lkl.ansuote.modulemodel.core.http.api;

import com.lkl.ansuote.modulemodel.BuildConfig;

/**
 * @author huangdongqiang
 * @date 2018/4/3
 */
public interface Apis {
    /**
     * 基础地址
     */
    String HOST = BuildConfig.HOST_BASE;

    /**
     * 无网络时，设置超时为4周
     */
    int MAX_STALE = 60 * 60 * 24 * 28;

    /**
     * 连接超时
     */
    long CONNECT_TIME_OUT = 15;

    /**
     * 读取超时
     */
    long READ_TIME_OUT = 20;

    /**
     * 写入超时
     */
    long WRITE_TIME_OUT = 20;
}

