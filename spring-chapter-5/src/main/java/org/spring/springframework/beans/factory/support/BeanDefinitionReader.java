package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.core.io.Resource;
import org.spring.springframework.core.io.ResourceLoader;

/**
 * bean定义读取器接口
 * <p> 注意 getRegistry()、getResourceLoader()，都是用于提供给后面三个方法的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法 </p>
 * @author zhengxin
 * @date 2023/02/09
 */
public interface BeanDefinitionReader {

    /**
     * 获取 BeanDefinition 注册表
     *
     * @return {@link BeanDefinitionRegistry}
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     *
     * @return {@link ResourceLoader}
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载bean定义
     *
     * @param resource 资源
     * @throws BeansException Beans异常
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载bean定义
     *
     * @param resources 资源
     * @throws BeansException Beans异常
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载bean定义
     *
     * @param location 位置
     * @throws BeansException Beans异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

}
