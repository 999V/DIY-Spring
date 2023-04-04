package org.spring.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 * <p> 有三种不同的实现，分别操作：classPath、FileSystem、URL
 *
 * @author zhengxin
 * @date 2023/02/09
 */
public interface Resource {

    /**
     * 获取输入流
     *
     * @return {@link InputStream}
     * @throws IOException ioexception
     */
    InputStream getInputStream() throws IOException;
}
