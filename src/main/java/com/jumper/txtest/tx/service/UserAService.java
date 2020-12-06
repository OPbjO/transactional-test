package com.jumper.txtest.tx.service;

import com.jumper.txtest.tx.entity.UserAEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author pengbj
 * @since 2020-12-06
 */
public interface UserAService extends IService<UserAEntity> {

    void methodA();

    void methodA2();

    void methodA3();

    void methodA4();

    void methodA5();

    void methodA6();

    void methodA7();

    void methodARequired();

    void methodATimeOut();
}
