package designpattern.proxy.remote;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * rmi客户端
 *
 * 可通过Registry或者Naming两种方式获取代理对象
 */
public class RegistryClient {
    public static void main(String[] args) {
        try {
            //获取对应端口的注册表对象，获取对应服务名的服务
            Registry registry = LocateRegistry.getRegistry(1099);
            MyRemote remote1 = (MyRemote) registry.lookup("MyFirstRemote");

            //Naming其实是对Registry的一个封装,两种lookup都可以
            //通过服务ip和注册时使用的服务名称获取stub（代理对象）
            MyRemote remote2 = (MyRemote) Naming.lookup("rmi://localhost/MyFirstRemote");

            //调用代理对象的方法
            Message message1 = remote1.getMessage("张收纳1", "抵达火星");
            Message message2 = remote2.getMessage("张收纳2", "抵达火星");
            System.out.println(message1 + "\n" + message2);

            //判断是否为动态代理类
            System.out.println("remote是否为动态代理类:" + Proxy.isProxyClass(remote1.getClass()));

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
