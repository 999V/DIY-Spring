package org.spring.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 BeanName
 * <P> Interface to be implemented by beans that want to be aware of their bean name in a bean factory.
 * @author zhengxin
 * @date 2023/04/04
 */
public interface BeanNameAware extends Aware {

    /**
     * 设置bean名称
     *
     * @param name bean名称
     */
    void setBeanName(String name);

}
