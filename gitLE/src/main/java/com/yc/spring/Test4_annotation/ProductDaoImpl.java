package com.yc.spring.Test4_annotation;

import org.springframework.stereotype.Repository;

@Repository("dao") // 表明这个类被 spring托管，这是一个dao层的类  -> spring会将异常（一般是 SQLException） 转化为 RuntimeException 可以减少对 业务层 的侵入性
/**
 * 关于对业务层的侵入性指的是，dao层的错误要到业务层去处理，比如 throw new SQLException();
 */
public class ProductDaoImpl implements ProductDao{
    public ProductDaoImpl(){
        System.out.println("ProductDaoImpl被构造了！");
    }

    @Override
    public void find() {
        System.out.println("ProductDaoImpl的find");
    }

    @Override
    public void add() {
        System.out.println("ProductDaoImpl的add");
    }

    @Override
    public void update() {
        System.out.println("ProductDaoImpl的update");
    }
}
