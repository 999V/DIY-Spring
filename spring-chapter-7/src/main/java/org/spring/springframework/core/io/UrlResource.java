package org.spring.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * url资源
 * <p> 通过 HTTP 的方式读取云服务的文件，我们也可以把配置文件放到 GitHub 或者 Gitee 上 </p>
 *
 * @author zhengxin
 * @date 2023/02/09
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = url.openConnection();

        try {
            return connection.getInputStream();
        }
        catch (IOException ex){
            if (connection instanceof HttpURLConnection){
                ((HttpURLConnection)connection).disconnect();
            }
            throw ex;
        }
    }
}
