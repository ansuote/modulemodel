package com.lkl.ansuote.modulemodel.di.module;

import android.app.Activity;

import com.lkl.ansuote.modulemodel.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author huangdongqiang
 * @date 2018/4/3
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return mActivity;
    }

}
