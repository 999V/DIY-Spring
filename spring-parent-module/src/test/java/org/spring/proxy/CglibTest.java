package org.spring.proxy;

import com.alibaba.fastjson.JSON;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import netscape.javascript.JSObject;
import org.junit.Test;
import org.spring.Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CglibTest {

    @Test
    public void testCglibProxy() {
        TargetObject targetObject = new TargetObject();
        System.out.println(targetObject.getClass());
        targetObject.method1("hello");

        TargetObject proxyTargetObject = getProxy(targetObject.getClass());
        System.out.println(proxyTargetObject.getClass());
        proxyTargetObject.method1("hello");
    }


    @Test
    public void testCallbackFilter() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);

        // 什么都不做
        Callback callback1 = NoOp.INSTANCE;
        // 拦截器
        Callback callback2 = new TargetInterceptor();
        // 固定值
        Callback callback3 = new TargetResultFixed();

        Callback[] callbacks = new Callback[] {callback1, callback2, callback3};
        enhancer.setCallbacks(callbacks);

        enhancer.setCallbackFilter(new TargetMethodCallbackFilter());

        TargetObject proxy = (TargetObject) enhancer.create();

        System.out.println("method1 结果: " + proxy.method1("hello"));
        System.out.println("method2 结果: " + proxy.method2(100));
        System.out.println("method3 结果: " + proxy.method3(100));
        System.out.println("method3 结果: " + proxy.method3(200));

    }

    public static <T> T getProxy(Class<T> clazz) {
        // 1.创建一个增强器
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(clazz);
        // 3.设置回调函数
        enhancer.setCallback(new TargetInterceptor());
        // 4.创建代理对象
        return (T) enhancer.create();
    }


    public static void main(String[] args) {
        String[] array = new String[] { "A", "C", "B", "E" };
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }

    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
