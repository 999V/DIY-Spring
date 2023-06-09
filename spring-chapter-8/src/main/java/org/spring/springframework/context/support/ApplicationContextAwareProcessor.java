package org.spring.springframework.context.support;

import org.spring.springframework.beans.factory.config.BeanPostProcessor;
import org.spring.springframework.context.ApplicationContext;
import org.spring.springframework.context.ApplicationContextAware;

/**
 * 应用上下文处理器
 * <P> 由于 ApplicationContext 的获取并不能直接在创建 Bean 的时候拿到，
 * 所以需要在 refresh 操作时，把 ApplicationContext 写入到一个包装的 BeanPostProcessor 中去，
 * 再由 AbstractAutowiredCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization 方法调用
 *
 * @author zhengxin
 * @date 2023/04/04
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
