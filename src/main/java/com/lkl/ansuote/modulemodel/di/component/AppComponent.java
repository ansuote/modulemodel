package com.lkl.ansuote.modulemodel.di.component;


import android.app.Application;

import com.lkl.ansuote.modulemodel.core.DataManager;
import com.lkl.ansuote.modulemodel.core.db.GreenDaoHelper;
import com.lkl.ansuote.modulemodel.core.http.RetrofitServiceHelper;
import com.lkl.ansuote.modulemodel.core.prefs.PreferenceHelper;
import com.lkl.ansuote.modulemodel.di.module.AppModule;
import com.lkl.ansuote.modulemodel.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 数框架（网络／数据库／SP）的工厂的 Component
 * @author huangdongqiang
 * @date 2018/4/3
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 提供App的Context
     *
     * @return context
     */
    Application getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();


    /**
     * 提供http的帮助类
     *
     * @return RetrofitHelper
     */
    RetrofitServiceHelper getRetrofitHelper();

    /**
     * 获取 sp
     * @return
     */
    PreferenceHelper getPreferenceHelper();

    /**
     * 提供数据库帮助类
     *
     * @return GreenDaoHelper
     */
    GreenDaoHelper getGreenDaoHelper();

}
