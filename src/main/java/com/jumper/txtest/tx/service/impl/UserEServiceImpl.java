package com.jumper.txtest.tx.service.impl;

import com.jumper.txtest.tx.entity.UserCEntity;
import com.jumper.txtest.tx.entity.UserEEntity;
import com.jumper.txtest.tx.dao.UserEDao;
import com.jumper.txtest.tx.service.UserEService;
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
public class UserEServiceImpl extends ServiceImpl<UserEDao, UserEEntity> implements UserEService {

    @Override
    public void methodE() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodERequiresNew() {
        System.out.println("E执行了...........");
        this.save(new UserEEntity().setName("Ee").setAge(5));

    }
}
