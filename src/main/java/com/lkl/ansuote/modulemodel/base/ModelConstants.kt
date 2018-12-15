package com.lkl.ansuote.modulemodel.base

import java.io.File

/**
 *
 *
 * @author huangdongqiang
 * @date 15/12/2018
 */
class ModelConstants {
    companion object {

        val PATH_DATA = ModuleModel.sApplication.cacheDir.absolutePath + File.separator + "data"

        val PATH_CACHE = "$PATH_DATA/NetCache"
    }
}