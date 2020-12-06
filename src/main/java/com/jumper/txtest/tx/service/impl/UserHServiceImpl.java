package com.jumper.txtest.tx.service.impl;

import com.jumper.txtest.tx.entity.UserGEntity;
import com.jumper.txtest.tx.entity.UserHEntity;
import com.jumper.txtest.tx.dao.UserHDao;
import com.jumper.txtest.tx.service.UserHService;
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
public class UserHServiceImpl extends ServiceImpl<UserHDao, UserHEntity> implements UserHService {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodHRequiresNew() {
        System.out.println("H执行了...........");
        this.save(new UserHEntity().setName("Hh").setAge(8));
    }
}
