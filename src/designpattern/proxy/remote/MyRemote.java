package designpattern.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程代理接口，必须扩展Remote接口
 */
public interface MyRemote extends Remote {

    /**
     * 数据传输可能发生不可控的异常，最好抛一下
     * 扩展Remote接口的 返回值 必须实现了序列化接口
     */
    Message getMessage(String name, String message) throws RemoteException;

}
