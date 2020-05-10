package designpattern.proxy.protect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 权限为用户本人的处理器
 */
public class OwnHandler implements InvocationHandler {

    private PersonBean personBean;

    public OwnHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
        } else if (method.getName().startsWith("setHotOrNotRating")) {
            //不支持修改自己的欢迎度操作
            throw new IllegalAccessException();
        } else if (method.getName().startsWith("set")) {
            return method.invoke(personBean, args);
        }
        return null;
    }

}
