package org.spring.springframework.beans.factory.config;

/**
 * 单例bean注册表
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例
     *
     * @param beanName bean名字
     * @return {@link Object}
     */
    Object getSingleton(String beanName);
}
