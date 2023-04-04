package org.spring.springframework.context.support;

import org.spring.springframework.beans.BeansException;

/**
 * 入口上下文类
 * <p> ClassPathXmlApplicationContext，是具体对外给用户提供的应用上下文方法 </p>
 *
 * <P> 在继承了 AbstractXmlApplicationContext 以及层层抽象类的功能分离实现后，
 * 在此类 ClassPathXmlApplicationContext 的实现中就简单多了，主要是对继承抽象
 * 类中方法的调用和提供了配置文件地址信息</P>
 *
 * @author zhengxin
 * @date 2023/02/11
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
