package org.spring.springframework.beans.factory;

import org.spring.springframework.beans.BeansException;

import java.util.Map;

/**
 * 可列举的bean工厂
 *
 * @author zhengxin
 * @date 2023/03/30
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * Return the names of all beans defined in this registry.
     *
     * @return {@link String[]}
     */
    String[] getBeanDefinitionNames();

}
