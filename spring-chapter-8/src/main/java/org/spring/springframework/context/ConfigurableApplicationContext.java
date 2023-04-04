package org.spring.springframework.context;

import org.spring.springframework.beans.BeansException;

/**
 * 可配置应用程序上下文
 *
 * @author zhengxin
 * @date 2023/02/10
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新应用上下文
     *
     * @throws BeansException Beans异常
     */
    void refresh() throws BeansException;


    /**
     * 注册关闭钩子
     */
    void registerShutdownHook();

    /**
     * 关闭
     */
    void close();

}
