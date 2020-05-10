package designpattern.proxy.protect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object getProxy(Class<?> clazz, InvocationHandler handler){
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),handler);
    }

}
