package com.lkl.ansuote.modulemodel.di.component;

import android.app.Activity;

import com.lkl.ansuote.modulemodel.di.module.ActivityModule;
import com.lkl.ansuote.modulemodel.di.scope.ActivityScope;

import dagger.Component;

/**
 * 所有 Activity 的 component
 *
 * @author huangdongqiang
 * @date 2018/4/3
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取当前 Activity
     * @return
     */
    Activity getActivity();
}
