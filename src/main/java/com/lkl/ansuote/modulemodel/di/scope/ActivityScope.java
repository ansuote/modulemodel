package com.lkl.ansuote.modulemodel.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author huangdongqiang
 * @date 2018/4/3
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
