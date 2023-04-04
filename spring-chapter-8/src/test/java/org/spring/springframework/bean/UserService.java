package org.spring.springframework.bean;


import cn.hutool.core.bean.BeanException;
import lombok.Data;
import org.spring.springframework.beans.factory.BeanClassLoaderAware;
import org.spring.springframework.beans.factory.BeanFactory;
import org.spring.springframework.beans.factory.BeanFactoryAware;
import org.spring.springframework.beans.factory.BeanNameAware;
import org.spring.springframework.context.ApplicationContext;
import org.spring.springframework.context.ApplicationContextAware;

@Data
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return "name:" + userDao.queryUserName(uId) + ", company:" + company + ", location:" + location;
    }


    //******************************
    // 以下是 Bean 的生命周期方法
    //******************************

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("sClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("beanName：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeanException {
        this.applicationContext = applicationContext;
    }
}
