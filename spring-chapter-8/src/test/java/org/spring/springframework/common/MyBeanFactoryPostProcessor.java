package org.spring.springframework.common;


import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.PropertyValue;
import org.spring.springframework.beans.PropertyValues;
import org.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.spring.springframework.beans.factory.config.BeanDefinition;
import org.spring.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 从 BeanFactory 中获取 BeanDefinition
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");

        // 修改 BeanDefinition 属性值
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动(在 BeanFactoryPostProcessor 中修改)"));
    }

}
