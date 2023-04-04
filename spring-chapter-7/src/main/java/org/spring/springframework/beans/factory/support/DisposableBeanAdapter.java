package org.spring.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.spring.springframework.beans.factory.DisposableBean;
import org.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * 用于实现 DisposableBean 接口的适配器
 *
 * @author zhengxin
 * @date 2023/03/31
 */
@Data
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;


    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 如果bean实现了 DisposableBean 接口，就调用destroy方法
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 如果配置了 destroy-method，就调用指定的方法
        if (StrUtil.isNotBlank(destroyMethodName)) {
            if (bean instanceof DisposableBean && StrUtil.equals(destroyMethodName, "destroy")) {
                // 避免二次销毁
                return;
            }
            // 通过反射调用指定的方法
            bean.getClass().getMethod(destroyMethodName).invoke(bean);
        }
    }
}
