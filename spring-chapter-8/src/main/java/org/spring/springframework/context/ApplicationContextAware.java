package org.spring.springframework.context;

import cn.hutool.core.bean.BeanException;
import org.spring.springframework.beans.factory.Aware;

/**
 * 实现此接口，既能感知到所属的 ApplicationContext
 * <P> interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 *
 * @author zhengxin
 * @date 2023/04/04
 */
public interface ApplicationContextAware extends Aware {

    /**
     * 设置应用程序上下文
     * 设置应用上下文
     *
     * @param applicationContext 应用上下文
     * @throws BeanException bean异常
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;

}
