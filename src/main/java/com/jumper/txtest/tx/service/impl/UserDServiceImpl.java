package com.jumper.txtest.tx.service.impl;

import com.jumper.txtest.tx.entity.UserCEntity;
import com.jumper.txtest.tx.entity.UserDEntity;
import com.jumper.txtest.tx.dao.UserDDao;
import com.jumper.txtest.tx.service.UserDService;
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
public class UserDServiceImpl extends ServiceImpl<UserDDao, UserDEntity> implements UserDService {

    @Override
    public void methodD() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodDRequired() {
        System.out.println("D执行了...........");
        this.save(new UserDEntity().setName("Dd").setAge(4));
    }
}
