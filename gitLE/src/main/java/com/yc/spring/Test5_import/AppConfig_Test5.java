package com.yc.spring.Test5_import;

import com.yc.spring.Test2.Apple;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 表示这个相当于 bean
@Import({Banana.class, Apple.class}) // 也可以直接写成 Banana.class这样的
public class AppConfig_Test5 {
    // @ComponentScan 是以字符串的形式传路径
    // @Import 则是以类（反射？）的形式传了过去

    // @ComponentScan 约定的beanId 就是对应类名的首字母小写形式（banana）
    // @Import 则是 该类项目中的全路径名（com.yc.spring.Test5_import.Banana.class）。虽然可以直接传类（Banana.class），但前提是与Config同一包下

    // @Import 可以通过实现了ImportSelector的类，来整合要注入的bean。例 @Import({FruitImportSelector.class})
}
