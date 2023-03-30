package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * bean定义注册表
 *
 * @author zhengxin
 * @date 2023/02/05
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册bean定义
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
