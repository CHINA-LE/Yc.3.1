package com.yc.spring.Test5_import;

import com.yc.spring.Test2.Apple;
import com.yc.spring.Test3_factoryBean.Pear;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 这个技术所解决的问题是@Import一个一个写类的繁杂，不太具有观赏性，而且这样也并于对要注入到容器的bean进行增减
 * 将要注入到容器的bean在这里统一规定，最后一起注入
 */
public class FruitImportSelector implements ImportSelector {
    public FruitImportSelector() {
        System.out.println("FruitImportSelector被构造了！！！");
    }

    @Override // 回调
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // TODO: 扫描一些jar包 配置文件 -> 指定第三方的类的路径

        return new String[]{Pear.class.getName(), Apple.class.getName()};
    }
}
