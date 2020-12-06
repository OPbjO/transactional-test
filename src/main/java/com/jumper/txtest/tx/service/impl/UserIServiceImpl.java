package com.jumper.txtest.tx.service.impl;

import com.jumper.txtest.tx.entity.UserHEntity;
import com.jumper.txtest.tx.entity.UserIEntity;
import com.jumper.txtest.tx.dao.UserIDao;
import com.jumper.txtest.tx.service.UserIService;
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
public class UserIServiceImpl extends ServiceImpl<UserIDao, UserIEntity> implements UserIService {

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void methodIRequired() {
        System.out.println("I执行了...........");
        this.save(new UserIEntity().setName("Ii").setAge(9));
    }
}
