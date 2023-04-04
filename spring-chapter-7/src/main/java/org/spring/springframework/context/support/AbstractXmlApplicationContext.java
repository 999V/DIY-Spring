package org.spring.springframework.context.support;

import org.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 抽象xml应用程序上下文
 *
 * @author zhengxin
 * @date 2023/03/30
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取配置位置
     * <p> 此方法是为了从【入口上下文类】，拿到配置信息的地址描述 </p>
     * @return {@link String[]}
     */
    protected abstract String[] getConfigLocations();

}
