package org.spring.springframework.beans.factory;

/**
 * 初始化bean
 *
 * @author zhengxin
 * @date 2023/03/31
 */
public interface InitializingBean {

    /**
     * 在 Bean 属性填充完成后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
