package com.jumper.txtest.tx.service;

import com.jumper.txtest.tx.entity.UserBEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pengbj
 * @since 2020-12-06
 */
public interface UserBService extends IService<UserBEntity> {

    void methodB();

    void methodB2();

    void methodB3();

    void methodB4();

    void methodB5();

    void methodB6();

    void methodBRequired();
}
