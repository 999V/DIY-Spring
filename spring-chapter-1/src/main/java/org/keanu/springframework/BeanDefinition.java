package org.keanu.springframework;

/**
 * bean定义
 * @author zhengxin
 * @date 2023/02/04
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
