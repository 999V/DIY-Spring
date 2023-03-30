package org.spring.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * cglib子类实例化策略
 *
 * @author zhengxin
 * @date 2023/02/07
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 无参构造
        if (constructor == null) {
            return enhancer.create();
        } else {
            // 有参构造
            return enhancer.create(constructor.getParameterTypes(), args);
        }
    }

}
