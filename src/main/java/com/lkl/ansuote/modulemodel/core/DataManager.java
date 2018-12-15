package com.lkl.ansuote.modulemodel.core;


import com.lkl.ansuote.modulemodel.core.db.DbHelper;
import com.lkl.ansuote.modulemodel.core.http.HttpServiceHelper;
import com.lkl.ansuote.modulemodel.core.prefs.PreferenceHelper;

/**
 * @author huangdongqiang
 * @date 2018/4/3
 */
public class DataManager implements HttpServiceHelper, PreferenceHelper, DbHelper {
    private HttpServiceHelper mHttpServiceHelper;
    private PreferenceHelper mPreferenceHelper;
    private DbHelper mDbHelper;


    public DataManager(HttpServiceHelper httpServiceHelper, PreferenceHelper preferenceHelper, DbHelper dbHelper) {
        mHttpServiceHelper = httpServiceHelper;
        mPreferenceHelper = preferenceHelper;
        mDbHelper = dbHelper;
    }

}
