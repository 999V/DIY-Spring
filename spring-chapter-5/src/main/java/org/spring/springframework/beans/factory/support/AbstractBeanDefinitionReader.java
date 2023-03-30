package org.spring.springframework.beans.factory.support;

import org.spring.springframework.core.io.DefaultResourceLoader;
import org.spring.springframework.core.io.ResourceLoader;

/**
 * 抽象 BeanDefinition 读取器
 * <p> 为了方便后面的实现，将 getRegistry()、getResourceLoader() 这两个方法的实现放到抽象类中，以免污染具体的接口实现方法 </p>
 *
 * @author zhengxin
 * @date 2023/02/09
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 注册表
     * <p> 用于把解析后的 XML 文件中的 Bean 信息，注册到 Spring 容器去 </p>
     */
    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
