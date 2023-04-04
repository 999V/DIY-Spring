package org.spring.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    /**
     * 模拟数据库
     */
    private static Map<String, String> db = new HashMap<>();

    static {
        db.put("10001", "用户1");
        db.put("10002", "用户2");
        db.put("10003", "用户3");
    }

    public String queryUserName(String uId) {
        return db.get(uId);
    }
}
