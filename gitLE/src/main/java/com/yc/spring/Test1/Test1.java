package com.yc.spring.Test1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test1 {
    public static void main(String[] args) {
        // 1.早期的程序
//        Student student = new Student();
//        student.setId(1);
//        student.setName("张三");
//        System.out.println(student.toString());
        // 小结：这叫控制不反转，程序来创建对象 -> Test1 依赖于 Student.

        // 关于项目中很少有人使用的功能可能存在问题却发现不及时；启动容器因为会提前装配，可以提早发现这类问题

        // 2.引入spring的IOC机制
        // IOC: 控制反转，由spring来创建 对象 Student
        //              ClassPathXmlApplicationContext：类路径下的 xml文件
//       方法一
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 上面那句：启动容器，读取class路径下的bean.xml文件，并获得bean配置的class，实例化对象并存到容器里
        Student ss = (Student) context.getBean("s");
        System.out.println(ss.toString());
        System.out.println(ss.hashCode());

//       方法二
        ApplicationContext context1 = new FileSystemXmlApplicationContext("classpath:beans.xml"); // 不要加空格！
//        ApplicationContext context1 = new FileSystemXmlApplicationContext("file:///E:/yc-zhang/Thread/0724预习/beans.xml"); // 不要加空格！
        Student s1 = (Student) context1.getBean("s");
        s1.setName("张三");
        System.out.println(s1.toString());

        Student s2 = (Student) context1.getBean("s");
        System.out.println(s2.toString());

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode()); // 哈希相同，改一动二，单例模式

//       方法二
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory context2 = new XmlBeanFactory(res);
        Student s3 = (Student) context2.getBean("s");
        System.out.println(s3.toString());

        // TODO: 让Student的属性有值 --> DI / Dependency injection 依赖注入

    }
}
