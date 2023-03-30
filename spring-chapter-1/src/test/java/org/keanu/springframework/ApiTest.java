package org.keanu.springframework;

import org.junit.Test;
import org.keanu.springframework.bean.UserService;

/**
 * @author zhengxin
 * @date 2023/02/04
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        //1.创建Bean工厂
        BeanFactory beanFactory = new BeanFactory();

        //2.注册UserService Bean
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));

        //3.获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
