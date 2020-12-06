package com.jumper.txtest.tx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jumper.txtest.tx.dao.UserBDao;
import com.jumper.txtest.tx.entity.UserBEntity;
import com.jumper.txtest.tx.service.UserBService;
import com.jumper.txtest.tx.service.UserFService;
import com.jumper.txtest.tx.service.UserGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pengbj
 * @since 2020-12-06
 */
@Service
public class UserBServiceImpl extends ServiceImpl<UserBDao, UserBEntity> implements UserBService {

    @Autowired
    private UserFService userFService;

    @Autowired
    private UserGService userGService;

    @Override
    public void methodB() {
        this.save(new UserBEntity().setName("Bb").setAge(2));
        int i = 1 / 0;
    }

    @Override
    @Transactional
    public void methodB2() {
        this.save(new UserBEntity().setName("Bb").setAge(2));
        //int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void methodB3() {
        this.save(new UserBEntity().setName("Bb").setAge(2));
        //int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void methodB4() {
        this.save(new UserBEntity().setName("Bb").setAge(2));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodB5() {
        this.save(new UserBEntity().setName("Bb").setAge(2));
        int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void methodB6() {
        this.save(new UserBEntity().setName("Bb").setAge(2));
        int i = 1 / 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodBRequired() {
        System.out.println("B执行了...........");
        this.save(new UserBEntity().setName("Bb").setAge(2));
        userFService.methodFRequiresNew();
        userGService.methodGRequired();
    }
}
