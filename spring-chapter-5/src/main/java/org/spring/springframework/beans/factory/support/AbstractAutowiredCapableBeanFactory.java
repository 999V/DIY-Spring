package org.spring.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.PropertyValue;
import org.spring.springframework.beans.PropertyValues;
import org.spring.springframework.beans.factory.config.BeanDefinition;
import org.spring.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 抽象的自动装配bean工厂
 *
 * @author zhengxin
 * @date 2023/02/05
 */

public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            // 1.实例化bean
            bean = createBeanInstance(beanDefinition, name, args);
            // 2.填充bean属性
            applyPropertyValues(name, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 3.添加单例bean
        registerSingleton(name, bean);
        return bean;
    }


    /**
     * 创建bean实例
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名字
     * @param args           参数
     * @return {@link Object}
     */
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


    /**
     * 填充bean属性
     *
     * @param beanName       bean名字
     * @param bean           bean
     * @param beanDefinition bean定义
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            // 1.获取bean的属性值
            PropertyValues propertyValues = beanDefinition.getPropertyValues();

            // 2.遍历属性值
            for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
                String propertyName = propertyValue.getName();
                Object originalValue = propertyValue.getValue();

                // 3.如果属性值是BeanReference类型，则递归调用getBean方法，获取bean
                if (originalValue instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) originalValue;
                    // 递归调用getBean方法，获取bean, 例如A依赖B，B依赖C，那么这里就会递归调用getBean方法，依次获取C -> B -> A
                    originalValue = getBean(beanReference.getBeanName());
                }

                // 4.使用工具类，设置属性值
                BeanUtil.setFieldValue(bean, propertyName, originalValue);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values:" + beanName, e);
        }
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }
}