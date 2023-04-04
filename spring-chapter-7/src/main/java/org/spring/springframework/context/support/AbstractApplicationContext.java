package org.spring.springframework.context.support;

import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.spring.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.spring.springframework.beans.factory.config.BeanPostProcessor;
import org.spring.springframework.context.ConfigurableApplicationContext;
import org.spring.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象应用程序上下文
 *
 * @author zhengxin
 * @date 2023/02/10
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory 并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5. 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();

    }

    /**
     * <p> Runtime.getRuntime().addShutdownHook()方法是Java提供的一种机制，
     * 可以在JVM关闭之前执行一段代码，用于释放资源或执行清理操作。
     *
     * <p> 当JVM收到操作系统发出的关闭信号或调用System.exit()时，会按照添加的顺序依次执行已注册的ShutdownHook线程。
     * 通常，在Java应用程序中，我们需要确保在程序结束时，所有资源都被正确释放，所有文件都被正确关闭，所有数据都被正确保存等等。
     * 此时，就可以使用addShutdownHook()方法来注册一个ShutdownHook线程，在JVM关闭之前执行一些必要的清理操作。
     * 例如，可以在ShutdownHook线程中关闭数据库连接、清空缓存、保存日志等等。
     *
     * <p> 需要注意的是，ShutdownHook线程只有在JVM正常退出时才会执行。
     * 如果JVM是因为操作系统错误、突然断电等原因而退出，那么ShutdownHook线程可能不会被执行。
     * 因此，ShutdownHook线程只是一种清理资源的辅助机制，不能完全依赖它来保证程序的稳定和安全。
     */
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }




    /**
     * 刷新bean工厂
     *
     * @throws BeansException Beans异常
     */
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取bean工厂
     *
     * @return {@link ConfigurableListableBeanFactory}
     * @throws IllegalStateException 非法状态异常
     */
    protected abstract ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;


    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        // 获取实现了 BeanFactoryPostProcessor 接口的 bean
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        // 获取实现了 BeanPostProcessor 接口的 bean
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }
}
