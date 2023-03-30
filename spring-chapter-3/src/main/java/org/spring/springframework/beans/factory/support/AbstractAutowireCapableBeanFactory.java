package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 抽象的自动装配bean工厂
 *
 * @author zhengxin
 * @date 2023/02/05
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            // 1.实例化bean
            bean = createBeanInstance(beanDefinition, name, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 2.添加单例bean
        registerSingleton(name, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        // 1.通过 BeanDefinition 获取bean的class
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 2.获取构造器
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructorToUse = null;
        // 3.遍历构造器，找到符合参数的构造器
        for (Constructor<?> constructor : constructors) {
            // 4.如果构造器的参数个数和传入的参数个数相同，则使用该构造器
            if (args != null && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        // 5.使用实例化策略实例化bean
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }
}