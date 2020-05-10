package designpattern.proxy.protect;

import java.lang.reflect.InvocationHandler;

public class Test {
    public static void main(String[] args) {

        //用户实例对象
        PersonBean person = new PersonBeanImpl();

        //创建两种不同权限的处理器
        InvocationHandler ownHandler = new OwnHandler(person);
        InvocationHandler unOwnHandler = new UnOwnHandler(person);

        //创建对应的代理对象
        PersonBean myself = (PersonBean) ProxyFactory.getProxy(person.getClass(), ownHandler);
        PersonBean other = (PersonBean) ProxyFactory.getProxy(person.getClass(), unOwnHandler);

        myself.setName("张三");
        myself.setAge(18);
        try {
            myself.setHotOrNotRating(123);
        } catch (Exception e) {
            System.out.println("不支持自己给自己设置欢迎度");
        }
        System.out.println(person);


        other.setHotOrNotRating(123);
        try {
            other.setName("张思");
        } catch (Exception e) {
            System.out.println("不支持设置他人的基本信息");
        }
        System.out.println(person);

    }

}
