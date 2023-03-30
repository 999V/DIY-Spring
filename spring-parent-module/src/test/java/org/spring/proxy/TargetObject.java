package org.spring.proxy;

public class TargetObject {

    public String method1(String paramName) {
        System.out.println("执行 TargetObject.method1");
        return paramName;
    }

    public int method2(int count) {
        System.out.println("执行 TargetObject.method2");
        return count;
    }

    public int method3(int count) {
        System.out.println("执行 TargetObject.method3");
        return count;
    }
}
