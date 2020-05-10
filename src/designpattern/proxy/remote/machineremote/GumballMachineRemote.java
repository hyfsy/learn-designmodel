package designpattern.proxy.remote.machineremote;

import designpattern.state.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程服务接口,别忘了扩展Remote接口
 */
public interface GumballMachineRemote extends Remote {

    /**
     * 返回类型必须是原语类型或可序列化类型
     */
    int getCount()throws RemoteException;

    State getState() throws RemoteException;

    String getLocation() throws RemoteException;

}
