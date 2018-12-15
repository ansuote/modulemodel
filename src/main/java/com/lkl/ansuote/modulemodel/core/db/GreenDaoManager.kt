package com.lkl.ansuote.modulemodel.core.db

import android.content.Context
import com.lkl.ansuote.modulemodel.core.dao.DaoMaster
import com.lkl.ansuote.modulemodel.core.dao.DaoSession

/**
 *
 * 初始化数据库
 * @author huangdongqiang
 * @date 15/12/2018
 */
object GreenDaoManager {
    lateinit var mDaoSession: DaoSession

    /**
     * 初始化 greendao
     */
    fun init(context: Context, dbName: String) {
        //未加入升级配置
        //DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplication(), Constants.DB_NAME);
        //已加入升级配置
        val devOpenHelper = GreenDaoUpgradeHelper(context, dbName, null)
        //未使用加密
        val database = devOpenHelper.writableDatabase
        //已使用加密 sqlcipher 加密打包后，apk 大小会变大，每个会 CPU 类型会增加近 2m 的大小 ，暂时屏蔽
        //Database database = devOpenHelper.getEncryptedWritableDb(XEncryptUtils.SHA256_KEY);
        val daoMaster = DaoMaster(database)
        mDaoSession = daoMaster.newSession()
    }
}