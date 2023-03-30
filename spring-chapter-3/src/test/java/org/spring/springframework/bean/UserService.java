package org.spring.springframework.bean;

/**
 * 用户服务
 *
 * @author zhengxin
 * @date 2023/02/04
 */
public class UserService {
    private String name;

    private Integer age;

    private String address;

    UserService(){
        System.out.println("调用无参构造函数 UserService()");
    }


    UserService(String name, String address){
        System.out.println("调用构造函数 UserService(String name, String address)");
        this.name = name;
        this.address = address;
    }

    UserService(String name, Integer age){
        System.out.println("调用构造函数 UserService(String name, Integer age)");
        this.name = name;
        this.age = age;
    }

    public void queryUserInfo(){
        System.out.println(this.hashCode() + ":查询用户信息：" + this.toString() );
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
