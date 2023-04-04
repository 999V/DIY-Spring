package org.spring.springframework.beans.factory.config;

import org.spring.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 可配置bean工厂
 *
 * @author zhengxin
 * @date 2023/04/02
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加 bean 后置处理器
     *
     * @param beanPostProcessor bean 后置处理器
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例Bean
     */
    void destroySingletons();
}
