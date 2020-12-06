package com.jumper.txtest.tx.service.impl;

import com.jumper.txtest.tx.entity.UserCEntity;
import com.jumper.txtest.tx.entity.UserFEntity;
import com.jumper.txtest.tx.dao.UserFDao;
import com.jumper.txtest.tx.service.UserFService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserFServiceImpl extends ServiceImpl<UserFDao, UserFEntity> implements UserFService {

    @Override
    public void methodF() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodFRequiresNew() {
        System.out.println("F执行了...........");
        this.save(new UserFEntity().setName("Ff").setAge(6));
    }
}
