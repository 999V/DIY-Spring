package org.spring.springframework.handler;

import cn.hutool.core.bean.BeanException;
import org.spring.springframework.context.ApplicationContext;
import org.spring.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerManager implements ApplicationContextAware {

    private final Map<String, AbstractHandler> handlers = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeanException {
        Map<String, AbstractHandler> beans = applicationContext.getBeansOfType(AbstractHandler.class);
        handlers.putAll(beans);
    }
}
