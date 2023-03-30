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

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
