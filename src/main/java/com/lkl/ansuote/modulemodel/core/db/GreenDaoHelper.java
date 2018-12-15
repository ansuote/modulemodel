package com.lkl.ansuote.modulemodel.core.db;

import com.lkl.ansuote.modulemodel.core.dao.DaoSession;

import javax.inject.Inject;

/**
 * 数据库具体实现
 * @author huangdongqiang
 * @date 12/06/2018
 */
public class GreenDaoHelper implements DbHelper{

    private DaoSession mDaoSession;

    @Inject
    GreenDaoHelper() {
        mDaoSession = GreenDaoManager.mDaoSession;
    }


}
