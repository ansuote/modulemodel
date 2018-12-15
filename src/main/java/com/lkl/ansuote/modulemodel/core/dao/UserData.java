package com.lkl.ansuote.modulemodel.core.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户信息表
 * @author huangdongqiang
 * @date 12/06/2018
 */
@Entity
public class UserData {
    @Id(autoincrement = true)
    private Long id;

    @Generated(hash = 1900143060)
    public UserData(Long id) {
        this.id = id;
    }

    @Generated(hash = 1838565001)
    public UserData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
