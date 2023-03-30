package org.spring.springframework;

import org.junit.Test;
import org.spring.springframework.bean.UserService;
import org.spring.springframework.beans.factory.config.BeanDefinition;
import org.spring.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author zhengxin
 * @date 2023/02/04
 */
public class ApiTest {
    @Test
    public void testBeanFactory() {
        //1.创建Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册UserService Bean
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class));

        //3.第一次获取 Bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();

        //4.第二次获取 Bean from Singleton
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUserInfo();
    }
}
