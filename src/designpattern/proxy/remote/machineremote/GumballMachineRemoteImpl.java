package designpattern.proxy.remote.machineremote;

import designpattern.state.GumBallMachine;
import designpattern.state.State;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 被代理对象
 */
public class GumballMachineRemoteImpl extends UnicastRemoteObject implements GumballMachineRemote {

    /**
     * 实际上还是委托了糖果机对象
     */
    private GumBallMachine gumBallMachine;
    private String location;

    public GumballMachineRemoteImpl(int count, String location) throws RemoteException {
        this.gumBallMachine = new GumBallMachine(count);
        this.location = location;
    }

    @Override
    public int getCount() {
        return gumBallMachine.getCount();
    }

    /**
     * 此处返回的 State 要实现序列化接口
     */
    @Override
    public State getState() {
        return gumBallMachine.getState();
    }

    @Override
    public String getLocation() {
        return location;
    }
}
