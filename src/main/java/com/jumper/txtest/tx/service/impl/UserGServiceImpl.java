package com.jumper.txtest.tx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jumper.txtest.tx.dao.UserGDao;
import com.jumper.txtest.tx.entity.UserGEntity;
import com.jumper.txtest.tx.service.UserGService;
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
public class UserGServiceImpl extends ServiceImpl<UserGDao, UserGEntity> implements UserGService {

    @Override
    public void methodG() {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodGRequired() {
        System.out.println("G执行了...........");
        this.save(new UserGEntity().setName("Gg").setAge(7));
        int i = 1 / 0;
    }
}
