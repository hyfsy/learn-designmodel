package designpattern.proxy.protect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 权限不是用户本人的处理器
 */
public class UnOwnHandler implements InvocationHandler {

    private PersonBean personBean;

    public UnOwnHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
        } else if (method.getName().startsWith("setHotOrNotRating")) {
            //权限为别人就可以修改欢迎度
            return method.invoke(personBean, args);
        } else if (method.getName().startsWith("set")) {
            //不支持修改别人的信息操作
            throw new IllegalAccessException();
        }
        return null;
    }

}
