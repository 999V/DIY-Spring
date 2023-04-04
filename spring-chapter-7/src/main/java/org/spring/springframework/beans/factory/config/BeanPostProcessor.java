package org.spring.springframework.beans.factory.config;

/**
 * Bean后置处理器
 * <p> 提供了修改新实例化 Bean 对象的扩展点
 *
 * @author zhengxin
 * @date 2023/02/10
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前
     *
     * @param Bean     bean
     * @param beanName bean名字
     * @return {@link Object}
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 在 Bean 对象执行初始化方法之后
     *
     * @param Bean     bean
     * @param beanName bean名字
     * @return {@link Object}
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
