package com.lkl.ansuote.modulemodel.core.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.lkl.ansuote.modulemodel.base.ModuleModel;

import javax.inject.Inject;

/**
 * SharedPreferences 实现类
 *
 * @author huangdongqiang
 * @date 2018/4/3
 */
public class PreferenceHelperImpl implements PreferenceHelper {
    public static final String PRE_NAME = "pre_name";
    private SharedPreferences mPreference;

    @Inject
    PreferenceHelperImpl(){
        mPreference = ModuleModel.sApplication.getSharedPreferences(PRE_NAME, Context.MODE_PRIVATE);
    }

}
