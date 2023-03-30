package org.spring.proxy;

import net.sf.cglib.proxy.FixedValue;

public class TargetResultFixed implements FixedValue {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果");
        Object obj = 999;
        return obj;
    }

}
