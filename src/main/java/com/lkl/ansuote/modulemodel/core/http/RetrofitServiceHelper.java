package com.lkl.ansuote.modulemodel.core.http;


import com.lkl.ansuote.modulemodel.core.http.api.Apis;

import javax.inject.Inject;

/**
 * @author huangdongqiang
 * @date 2018/4/3
 */
public class RetrofitServiceHelper implements HttpServiceHelper {
    private Apis mApis;

    @Inject
    RetrofitServiceHelper(Apis apis) {
        mApis = apis;
    }


}
