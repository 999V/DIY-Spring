package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例bean注册表
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /** Cache of singleton objects: bean name --> bean instance */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
