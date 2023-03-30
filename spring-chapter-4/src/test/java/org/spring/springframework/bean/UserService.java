package org.spring.springframework.bean;

/**
 * 用户服务
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class UserService {

    private Long userId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息：" + userDao.queryUserName(userId));
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userId='" + userId + '\'' +
                ", userDao=" + userDao +
                '}';
    }
}
