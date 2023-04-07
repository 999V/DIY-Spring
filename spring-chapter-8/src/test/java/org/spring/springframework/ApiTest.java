package org.spring.springframework;

import org.junit.Test;
import org.spring.springframework.bean.UserService;
import org.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.spring.springframework.common.MyBeanFactoryPostProcessor;
import org.spring.springframework.common.MyBeanPostProcessor;
import org.spring.springframework.context.support.ClassPathXmlApplicationContext;


public class ApiTest {

    @Test
    public void test_xml() throws InterruptedException {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        Thread.sleep(1000);

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }


    @Test
    public void test() {

    }
}
