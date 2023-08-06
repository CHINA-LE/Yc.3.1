package com.yc.spring.Test4_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 此注解表明此类为 业务层的类
public class ProductBizImpl implements ProductBiz{
    public ProductBizImpl(){
        System.out.println("ProductBizImpl被构造了！");
    }

    @Autowired // 由 spring 自动地从容器中取出productDao的一个实现类的对象 · 注入
    private ProductDao productDao; // 业务层依赖dao层，但最好依赖接口

    @Override
    public void takein() {
        productDao.find();
        int i = 1;
        if (i == 1){
            productDao.update();
        }else {
            productDao.add();
        }
    }
}
