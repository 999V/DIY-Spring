package org.spring.springframework.beans.factory.config;

import org.spring.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * bean工厂后置处理器
 *
 * @author zhengxin
 * @date 2023/02/10
 */
public interface BeanFactoryPostProcessor {

    /**
     * 这个接口是满足于在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory bean工厂
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
