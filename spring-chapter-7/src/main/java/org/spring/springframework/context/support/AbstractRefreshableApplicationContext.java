package org.spring.springframework.context.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.spring.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 抽象可刷新应用程序上下文
 *
 * @author zhengxin
 * @date 2023/02/11
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    /**
     * 刷新bean工厂
     * <p> 获取了 DefaultListableBeanFactory 的实例化以及对资源配置的加载操作 loadBeanDefinitions(beanFactory)，
     * 在加载完成后即可完成对 spring.xml 配置文件中 Bean 对象的定义和注册，同时也包括实现了
     * 接口 BeanFactoryPostProcessor、BeanPostProcessor 的配置 Bean 信息
     * @throws BeansException Beans异常
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载bean定义
     * <p>资源加载还只是定义了一个抽象类方法,需要继续由其他抽象类继承实现</p>
     *
     * @param beanFactory bean工厂
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
