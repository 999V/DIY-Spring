package org.spring.springframework.beans.factory.support;

import org.spring.springframework.beans.factory.DisposableBean;
import org.spring.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例bean注册表
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 单例对象
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 用于存放实现了 DisposableBean 接口的 bean
     */
    private Map<String, DisposableBean> disposableBeans = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        disposableBeans.put(beanName, disposableBean);
    }

    public void destroySingletons() {
        String[] disposableBeanNames = disposableBeans.keySet().toArray(new String[0]);
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            String disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(disposableBeanName);
            try {
                // 调用销毁方法
                disposableBean.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
