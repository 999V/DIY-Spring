package org.spring.demo.effective.demo2;

public class TestDemo {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setId("1")
                .setName("张三")
                .setAge(18)
                .build();
    }
}
