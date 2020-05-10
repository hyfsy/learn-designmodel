package designpattern.other.memento;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体对象的工具类，用到了内省
 */
public class BeanUtil {

    /**
     * 获取bean对象的所有属性值,要判断getClass()
     */
    public static Map<String, Object> getProperties(Object bean) {
        Map<String, Object> properties = new HashMap<>();
        try {
            //获取实体对象信息
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获取属性描述器
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                //获取属性名称
                String name = pd.getName();
                //获取属性值
                Method readMethod = pd.getReadMethod();
                Object invokeValue = readMethod.invoke(bean);

                //此处一定要判断是否为getClass()方法
                if (!name.equalsIgnoreCase("class")) {
                    properties.put(name, invokeValue);
                }

            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 根据map设置对象的属性
     */
    public static void setProperties(Object bean, Map<String, Object> properties) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                //判断map中是否存在该对象对应的属性
                if (null != properties.get(pd.getName())) {
                    //设置属性
                    Method writeMethod = pd.getWriteMethod();
                    writeMethod.invoke(bean, properties.get(pd.getName()));
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
