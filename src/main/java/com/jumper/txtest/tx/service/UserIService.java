package com.jumper.txtest.tx.service;

import com.jumper.txtest.tx.entity.UserIEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pengbj
 * @since 2020-12-06
 */
public interface UserIService extends IService<UserIEntity> {

    void methodIRequired();
}
