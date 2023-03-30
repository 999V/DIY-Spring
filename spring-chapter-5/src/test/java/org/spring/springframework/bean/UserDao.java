package org.spring.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<Long, String> hashMap = new HashMap<>();

    static {
        hashMap.put(10001L, "张三");
        hashMap.put(10002L, "李四");
        hashMap.put(10003L, "王五");
    }

    public String queryUserName(Long userId) {
        return hashMap.get(userId);
    }
}
