package org.keanu.springframework.bean;

/**
 * 用户服务
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class UserService {

    public void queryUserInfo(){
        System.out.println(this.getClass().getSimpleName() + ":查询用户信息");
    }

}
