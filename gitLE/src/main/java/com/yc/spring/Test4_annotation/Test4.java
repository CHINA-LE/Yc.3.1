package com.yc.spring.Test4_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test4.class);

        ProductBiz pb = (ProductBiz) ac.getBean("productBizImpl"); // beanId的约定（默认）是：类名首字母小写
        pb.takein();

        // 也可以自己取名
        ProductDao dao = (ProductDao) ac.getBean("dao"); // 只是测试，正常项目不要直接调用dao！！！
        dao.update();
    }
}
