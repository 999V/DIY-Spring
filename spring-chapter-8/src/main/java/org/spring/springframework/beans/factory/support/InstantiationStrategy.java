package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 * @author zhengxin
 * @date 2023/02/07
 */
public interface InstantiationStrategy {

    /**
     * 实例化
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名字
     * @param constructor    构造函数：包含类的信息，可以通过该参数获取符合如参信息的构造器
     * @param args           参数
     * @return {@link Object}
     * @throws BeansException bean异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
