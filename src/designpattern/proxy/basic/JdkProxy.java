package designpattern.proxy.basic;

import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk动态代理实现
 *
 * @author baB_hyf
 * @date 2021/04/23
 * @see ProxyGenerator#generateProxyClass
 */
public class JdkProxy {

    public static void main(String[] args) {
        Person person = new Person();
        Human proxy = (Human) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(), new PersonHandler(person));
        proxy.say();
    }

    interface Human {
        void say();
    }

    static class Person implements Human {
        @Override
        public void say() {
            System.out.println("Person starting speak");
        }
    }

    static class PersonHandler implements InvocationHandler {

        private final Person person;

        public PersonHandler(Person person) {
            this.person = person;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("start invoke");
            Object rtn = method.invoke(person, args);
            System.out.println("end invoke");
            return rtn;
        }
    }
}
