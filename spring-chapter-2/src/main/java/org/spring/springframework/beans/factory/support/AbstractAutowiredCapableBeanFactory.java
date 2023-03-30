package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象的自动装配bean工厂
 *
 * @author zhengxin
 * @date 2023/02/05
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 注册单例
        registerSingleton(name, bean);
        return bean;
    }
}
