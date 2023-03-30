package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.BeanFactory;
import org.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象bean工厂
 *
 * @author zhengxin
 * @date 2023/02/13
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }


    private <T> T doGetBean(String beanName, Object[] args) {
        // 1.先从单例缓存中获取
        Object singleton = getSingleton(beanName);
        // 2.如果单例缓存中存在，则直接返回
        if (singleton != null) {
            return (T) singleton;
        }
        // 3.如果单例缓存中不存在，则从bean定义中获取
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        // 4.根据 BeanDefinition 创建bean
        return (T) createBean(beanName, beanDefinition, args);
    }


    //-----------------------定义抽象方法，具体逻辑由子类实现-----------------------

    /**
     * 获取bean定义
     *
     * @param name 名字
     * @return {@link BeanDefinition}
     * @throws BeansException bean异常
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 创建bean
     *
     * @param name           名字
     * @param beanDefinition bean定义
     * @param args           参数
     * @return {@link Object}
     * @throws BeansException bean异常
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
