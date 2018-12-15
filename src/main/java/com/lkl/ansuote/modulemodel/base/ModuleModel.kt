package com.lkl.ansuote.modulemodel.base

import android.app.Application
import com.lkl.ansuote.modulemodel.core.db.GreenDaoManager
import com.lkl.ansuote.modulemodel.di.component.AppComponent
import com.lkl.ansuote.modulemodel.di.component.DaggerAppComponent
import com.lkl.ansuote.modulemodel.di.module.AppModule

/**
 *
 *
 * @author huangdongqiang
 * @date 15/12/2018
 */
object ModuleModel {
    @Volatile
    private var sAppComponent: AppComponent? = null

    lateinit var sApplication: Application

    /**
     * 框架类初始化方法
     */
    fun init(application: Application, dbName: String) {
        sApplication = application
        //初始化数据库
        GreenDaoManager.init(application, dbName)
    }


    fun getAppComponent(): AppComponent {
        if (null == sAppComponent) {
            synchronized(ModuleModel::class.java) {
                if (null == sAppComponent) {
                    sAppComponent = DaggerAppComponent.builder()
                            .appModule(AppModule(sApplication))
                            .build()
                }
            }
        }
        return sAppComponent!!
    }

}