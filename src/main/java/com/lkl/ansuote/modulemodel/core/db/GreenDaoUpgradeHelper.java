package com.lkl.ansuote.modulemodel.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.github.yuweiguocn.library.greendao.MigrationHelper;
import com.lkl.ansuote.modulemodel.core.dao.DaoMaster;
import com.lkl.ansuote.modulemodel.core.dao.UserDataDao;

import org.greenrobot.greendao.database.Database;

/**
 * 升级帮助类
 * @author huangdongqiang
 * @date 14/06/2018
 */
public class GreenDaoUpgradeHelper extends DaoMaster.OpenHelper{
    public GreenDaoUpgradeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, UserDataDao.class); //参数为所有的Dao类：
    }
}
