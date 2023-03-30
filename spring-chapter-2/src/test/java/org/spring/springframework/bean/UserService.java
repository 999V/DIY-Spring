package org.spring.springframework.bean;

/**
 * 用户服务
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class UserService {
    private String name;


    UserService(String name){
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println(this.hashCode() + ":查询用户信息");
    }

}
