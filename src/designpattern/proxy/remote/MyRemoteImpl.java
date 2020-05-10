package designpattern.proxy.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * 远程接口实现类（被代理对象）
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    /**
     * 继承UnicastRemoteObject（具有可远程的能力）构造器会抛异常
     */
    public MyRemoteImpl() throws RemoteException {
    }

    /**
     * 返回给客户端一条消息
     */
    @Override
    public Message getMessage(String name, String message) {
        return new Message(name, message, new Date());
    }


}
