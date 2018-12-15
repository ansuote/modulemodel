package com.lkl.ansuote.modulemodel.di.module;


import android.app.Application;

import com.lkl.ansuote.modulemodel.core.DataManager;
import com.lkl.ansuote.modulemodel.core.db.DbHelper;
import com.lkl.ansuote.modulemodel.core.db.GreenDaoHelper;
import com.lkl.ansuote.modulemodel.core.http.HttpServiceHelper;
import com.lkl.ansuote.modulemodel.core.http.RetrofitServiceHelper;
import com.lkl.ansuote.modulemodel.core.prefs.PreferenceHelper;
import com.lkl.ansuote.modulemodel.core.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 框架（网络／数据库／SP）的工厂
 * @author huangdongqiang
 * @date 2018/4/3
 */
@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpServiceHelper provideHttphelper(RetrofitServiceHelper retrofitServiceHelper) {
        return retrofitServiceHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferenceHelper(PreferenceHelperImpl preferenceHelper) {
        return preferenceHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpServiceHelper httpServiceHelper, PreferenceHelper preferenceHelper, DbHelper dbHelper) {
        return new DataManager(httpServiceHelper, preferenceHelper, dbHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(GreenDaoHelper greenDaoHelper) {
        return greenDaoHelper;
    }
}
