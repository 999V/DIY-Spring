package org.spring.springframework;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.spring.springframework.bean.UserDao;
import org.spring.springframework.bean.UserService;
import org.spring.springframework.beans.PropertyValue;
import org.spring.springframework.beans.PropertyValues;
import org.spring.springframework.beans.factory.config.BeanDefinition;
import org.spring.springframework.beans.factory.config.BeanReference;
import org.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.spring.springframework.core.io.DefaultResourceLoader;
import org.spring.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhengxin
 * @date 2023/02/04
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }


}
