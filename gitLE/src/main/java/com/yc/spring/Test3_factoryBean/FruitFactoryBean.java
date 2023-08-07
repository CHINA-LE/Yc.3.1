package com.yc.spring.Test3_factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 水果工厂  还是被 spring托管
 * FactoryBean一般用于Bean非常多的时候，所解决的问题是代码在Config的堆积，增加代码的观赏性
 */
public class FruitFactoryBean implements FactoryBean<Pear> {
    public FruitFactoryBean(){
        System.out.println("FruitFactoryBean被构造了");
    }

    @Override
    public Pear getObject() throws Exception {
        // 与普通的相比，这里可以加入更多的逻辑，不影响代码的观赏性
        return new Pear();
    }

    /**
     * 反射！？？
     * @return 返回的是Pear的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Pear.class;
    }

    /**
     * 单例多例，默认单例，false为多例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
