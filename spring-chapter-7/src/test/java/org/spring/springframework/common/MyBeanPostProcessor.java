package org.spring.springframework.common;


import org.spring.springframework.bean.UserService;
import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "=> 执行 MyBeanPostProcessor.postProcessBeforeInitialization()");
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("北京(在 MyBeanPostProcessor 中修改)");

            System.out.println("修改["+ beanName +"]的属性值");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + "=> 执行 MyBeanPostProcessor.postProcessAfterInitialization\n");
        return bean;
    }

}
