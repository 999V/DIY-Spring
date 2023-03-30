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
}
