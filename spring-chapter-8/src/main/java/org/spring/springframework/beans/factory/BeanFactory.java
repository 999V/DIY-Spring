package org.spring.springframework.beans.factory;

import org.spring.springframework.beans.BeansException;

/**
 * bean工厂
 *
 * @author zhengxin
 * @date 2023/02/05
 */
public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param name 名字
     * @return {@link Object}
     * @throws BeansException bean异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取bean
     *
     * @param name 名字
     * @param args 参数
     * @return {@link Object}
     * @throws BeansException 豆子例外
     */
    Object getBean(String name, Object... args) throws BeansException;


    /**
     * 获取bean
     *
     * @param name         名字
     * @param requiredType 所需类型
     * @return {@link T}
     * @throws BeansException Beans异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
