package org.spring.springframework.beans.factory.config;

/**
 * bean定义
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class BeanDefinition {
    private Class beanClass;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
