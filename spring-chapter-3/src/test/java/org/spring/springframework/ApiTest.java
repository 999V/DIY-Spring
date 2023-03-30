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
        beanFactory.registerBeanDefinition("userService1", new BeanDefinition(UserService.class));
        beanFactory.registerBeanDefinition("userService2", new BeanDefinition(UserService.class));

        //3.获取成功
        //UserService userService1 = (UserService) beanFactory.getBean("userService1", "测试用户", "测试地址");
        //userService1.queryUserInfo();

        //4.获取失败，因为目前AbstractAutowireCapableBeanFactory#createBeanInstance方法中，是根据构造函数的参数个数来匹配构造器的，会导致参数个数相同但是类型不同的构造器无法匹配
        //UserService userService2 = (UserService) beanFactory.getBean("userService2", "测试用户", 12);
        //userService2.queryUserInfo();

        UserService userService3 = (UserService) beanFactory.getBean("userService2");
        userService3.queryUserInfo();
    }
}
