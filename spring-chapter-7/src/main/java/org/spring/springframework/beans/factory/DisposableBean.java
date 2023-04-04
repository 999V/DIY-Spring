package org.spring.springframework.beans.factory;

/**
 * 销毁bean
 *
 * @author zhengxin
 * @date 2023/03/31
 */
public interface DisposableBean {

    /**
     * 销毁bean
     *
     * @throws Exception
     */
    void destroy() throws Exception;

}
