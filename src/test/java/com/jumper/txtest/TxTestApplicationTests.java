package com.jumper.txtest;

import com.jumper.txtest.tx.service.UserAService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxTestApplicationTests {

    @Autowired
    private UserAService userAService;

    @Test
    void contextLoads() {
    }

    /**
     * methodA有@Transactional注解，methodB无@Transactional注解，只要A或者B方法抛出异常，均会回滚
     */
    @Test
    void Test1() {
        userAService.methodA();
    }


    /**
     * methodA无@Transactional注解，methodB有@Transactional注解，此时只有methodB有事务。
     * 若methodA抛出异常，methodA和methodB都可以插入成功；若methodB抛出异常，methodB插入失败，但是methodA可以插入成功；
     */
    @Test
    void Test2() {
        userAService.methodA2();
    }


    /**
     * methodA和methodB均有注解，如果B的方法methodB的事务传播特性是PROPAGATION_REQUIRED(默认值)
     * 1、如果A的methodA抛出异常，则A和B的事务都会被回滚。如果A捕获了自己抛出的异常，则A/B插入均会成功。
     * 2、如果B的methodB抛出异常，则A和B的事务都会回滚，如果A捕获了异常，则会发生Transaction rolled back because it has been marked as rollback-only的异常，A/B的插入均不会生效。
     */
    @Test
    void Test3() {
        userAService.methodA3();
    }

    /**
     *  如果B的方法methodB的事务传播特性是PROPAGATION_REQUIRES_NEW，表示当前方法需要运行在一个新的事务中；
     *  1、如果A存在事务，A.methodA抛出异常，A事务被回滚，但B事务不受影响；
     *  2、如果A存在事务，如果B.methodB抛出异常，A.methodA和B.methodB的事务都会被回滚。如果A捕获的话，A.methodA的事务不受影响但B.methodB的事务回滚。
     */
    @Test
    void Test6() {
        userAService.methodA6();
    }

    /**
     * 如果B的方法methodB的事务传播特性是PROPAGATION_SUPPORTS,那么如果A的方法包含事务，则B运行在此事务环境中，如果A的方法不包含事务，则B运行在非事务环境；
     * 1、如果A没有事务(即methodA无@Transactional)，则A和B的出现运行时异常都不会回滚。
     * 2、如果A有事务，和PROPAGATION_REQUIRED没有区别
     */
    @Test
    void Test4() {
        userAService.methodA4();
    }

    /**
     * 如果B的方法methodB的事务传播特性是PROPAGATION_MANDATORY，表示当前方法必须在一个事务中运行，如果没有事务，将抛出异常；
     * 1、如果A的methodA方法没有事务，则B的methodB执行的时候会报如下异常：No existing transaction found for transaction marked with propagation 'mandatory'，A能插入成功，B失败
     * 2、如果A的methodA方法有事务，和PROPAGATION_REQUIRED没有区别。
     */
    @Test
    void Test5() {
        userAService.methodA5();
    }


    /**
     * 如果B的方法methodB的事务传播特性是PROPAGATION_NOT_SUPPORTED，表示该方法不应该在一个事务中运行，如果有一个事务正在运行，他将在运行期被挂起，直到这个事务提交或者回滚才恢复执行；
     * 1、如果A不存在事务，无论A,B哪一个抛出异常，抛出异常前的数据库操作均能成功，相当于A,B均没有事务。
     * 2、如果A.methodA存在事务，如果A抛出异常，A回滚，B不回滚。如果B.methodB()抛出异常，A回滚，B不回滚。如果A.methodA捕获的话，则A不回滚，B.methodB异常抛出前的数据操作不受影响。
     */
    @Test
    void Test7() {
        userAService.methodA7();
    }


    @Test
    void Test8() {
        userAService.methodARequired();
    }


    @Test
    void Test9() {
        userAService.methodATimeOut();
    }



}
