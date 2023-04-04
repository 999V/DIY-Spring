package org.spring.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 BeanFactory
 * <P> Interface to be implemented by beans that wish to be aware of their owning {@link BeanFactory}.
 *
 * @author zhengxin
 * @date 2023/04/04
 */
public interface BeanFactoryAware extends Aware {

    /**
     * 设置bean工厂
     *
     * @param beanFactory bean工厂
     * @throws Exception 异常
     */
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
