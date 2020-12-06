package com.jumper.txtest.tx.service.impl;

import com.jumper.txtest.tx.entity.UserAEntity;
import com.jumper.txtest.tx.dao.UserADao;
import com.jumper.txtest.tx.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserAServiceImpl extends ServiceImpl<UserADao, UserAEntity> implements UserAService {

    @Autowired
    private UserBService userBService;

    @Autowired
    private UserCService userCService;

    @Autowired
    private UserDService userDService;

    @Autowired
    private UserEService userEService;

    @Autowired
    private UserFService userFService;

    @Autowired
    private UserGService userGService;

    @Override
    @Transactional
    public void methodA() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
        userBService.methodB();
        //int i = 1/0;
    }

    @Override
    public void methodA2() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
        userBService.methodB2();
        int i = 1 / 0;
    }

    @Override
    @Transactional
    public void methodA3() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
        userBService.methodB2();
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void methodA4() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
      /*  try {
            userBService.methodB3();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        userBService.methodB3();
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void methodA5() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
        userBService.methodB4();
    }

    @Override
    @Transactional
    public void methodA6() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
        try {
            userBService.methodB5();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //int i = 1 / 0;
    }

    @Override
    @Transactional
    public void methodA7() {
        this.save(new UserAEntity().setName("Aa").setAge(1));
        try {
            userBService.methodB6();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodARequired() {
        System.out.println("A执行了...........");
        this.save(new UserAEntity().setName("Aa").setAge(1));
        userBService.methodBRequired();
        userCService.methodCRequiresNew();
        userDService.methodDRequired();
        userEService.methodERequiresNew();
    }

    @Override
    @Transactional(timeout = 2)
    public void methodATimeOut() {
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.save(new UserAEntity().setName("Aa").setAge(1));

    }
}
