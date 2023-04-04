package org.spring.springframework.bean;


import lombok.Data;

@Data
public class UserService {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return "name:" + userDao.queryUserName(uId) + ", company:" + company + ", location:" + location;
    }

}
