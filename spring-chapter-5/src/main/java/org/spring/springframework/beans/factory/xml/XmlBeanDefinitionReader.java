package org.spring.springframework.beans.factory.xml;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.spring.springframework.beans.BeansException;
import org.spring.springframework.beans.PropertyValue;
import org.spring.springframework.beans.factory.config.BeanDefinition;
import org.spring.springframework.beans.factory.config.BeanReference;
import org.spring.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.spring.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.spring.springframework.core.io.Resource;
import org.spring.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * xml BeanDefinition 读取器
 * <p> 读取 xml 配置信息，创建成 BeanDefinition 以及 PropertyValue，最终把完整的 BeanDefinition 内容注册到 Bean 容器
 *
 * @author zhengxin
 * @date 2023/02/09
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadBeanDefinitions(inputStream);
        } catch (Exception e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        if (ObjectUtil.isNotEmpty(resources)) {
            for (Resource resource : resources) {
                loadBeanDefinitions(resource);
            }
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        //1. 获取资源加载器
        ResourceLoader resourceLoader = getResourceLoader();
        //2. 通过资源加载器获取资源
        Resource resource = resourceLoader.getResource(location);
        //3. 加载 BeanDefinition
        loadBeanDefinitions(resource);
    }


    /**
     * 解析 XML 文件, 加载 BeanDefinition
     *
     * @param inputStream 输入流
     * @throws ClassNotFoundException 类不发现异常
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        //1. 读取 XML 文件, 转换为 XML 文档对象
        Document document = XmlUtil.readXML(inputStream);
        //2. 获取 XML 根节点
        Element root = document.getDocumentElement();
        //3. 解析 XML 子节点
        NodeList childNodes = root.getChildNodes();

        //4. 遍历子节点, 获取 beanDefinition
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断节点是否为元素节点
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }

            // 判断节点是否为 bean 节点
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }

            // 解析 <bean> 标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            // 通过 className 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);

            // 指定 BeanName，优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            // 读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                // 判断节点是否为元素节点
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }

                // 判断节点是否为 property 节点
                if (ObjectUtil.notEqual("property", bean.getChildNodes().item(j).getNodeName())) {
                    continue;
                }

                // 解析 <property> 标签
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                // 值对象
                String attrValue = property.getAttribute("value");
                // 引入对象，需要用 BeanReference 来包装
                String attrRef = property.getAttribute("ref");

                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;

                // 创建属性信息, 添加到 beanDefinition 的属性列表中
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            // 5.注册 BeanDefinition
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
