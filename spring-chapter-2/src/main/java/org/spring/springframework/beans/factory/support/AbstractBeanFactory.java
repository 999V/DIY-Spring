package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.BeanFactory;
import org.spring.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object singleton = getSingleton(name);
        // 如果已经存在单例对象，直接返回
        if (singleton != null) {
            return singleton;
        }
        // 如果不存在单例对象，创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;
}
