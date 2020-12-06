package com.jumper.txtest.tx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jumper.txtest.tx.dao.UserCDao;
import com.jumper.txtest.tx.entity.UserCEntity;
import com.jumper.txtest.tx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author pengbj
 * @since 2020-12-06
 */
@Service
public class UserCServiceImpl extends ServiceImpl<UserCDao, UserCEntity> implements UserCService {

    @Autowired
    private UserHService userHService;

    @Autowired
    private UserIService userIService;

    @Override
    public void methodC() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodCRequiresNew() {
        System.out.println("C执行了...........");
        this.save(new UserCEntity().setName("Cc").setAge(3));
        userHService.methodHRequiresNew();
        userIService.methodIRequired();
    }
}
