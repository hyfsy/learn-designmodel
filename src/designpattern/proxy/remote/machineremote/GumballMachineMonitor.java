package designpattern.proxy.remote.machineremote;

import java.rmi.RemoteException;

/**
 * 客户端辅助
 */
public class GumballMachineMonitor {

    private transient GumballMachineRemote gumballMachineRemote;

    public GumballMachineMonitor(GumballMachineRemote gumballMachineRemote) {
        this.gumballMachineRemote = gumballMachineRemote;
    }

    public void report() {
        try {
            System.out.println("本地接口：" + gumballMachineRemote.getLocation());
            System.out.println("剩余数量：" + gumballMachineRemote.getCount());
            System.out.println("当前状态：" + gumballMachineRemote.getState().getClass().getSimpleName());
            System.out.println();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
