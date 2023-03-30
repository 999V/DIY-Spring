package org.spring.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性值集合
 *
 * @author zhengxin
 * @date 2023/02/07
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>(64);

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
