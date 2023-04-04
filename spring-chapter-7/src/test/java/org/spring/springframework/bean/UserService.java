package org.spring.springframework.bean;


import lombok.Data;
import org.spring.springframework.beans.factory.DisposableBean;
import org.spring.springframework.beans.factory.InitializingBean;

@Data
public class UserService implements InitializingBean, DisposableBean {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return "name:" + userDao.queryUserName(uId) + ", company:" + company + ", location:" + location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService#destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService#afterPropertiesSet");
    }
}
