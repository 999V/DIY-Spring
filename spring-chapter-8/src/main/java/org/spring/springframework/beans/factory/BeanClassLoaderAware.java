package org.spring.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 ClassLoader
 * <p> Callback that allows a bean to be aware of the bean{@link ClassLoader class loader}; that is, the class loader used by the present bean factory to load bean classes.
 *
 * @author zhengxin
 * @date 2023/04/04
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * 设置类加载器
     *
     * @param classLoader 类装入器
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
