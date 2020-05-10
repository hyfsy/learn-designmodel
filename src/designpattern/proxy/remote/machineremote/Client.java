package designpattern.proxy.remote.machineremote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        //注意此处的url端口号
        String[] locate = {"rmi://localhost:8088/Remote1","rmi://localhost:8088/Remote2","rmi://localhost:8088/Remote3"};
        GumballMachineMonitor[] monitors = new GumballMachineMonitor[locate.length];
        String[] name = {"Remote1","Remote2","Remote3"};
        GumballMachineMonitor[] monitors1 = new GumballMachineMonitor[name.length];
        try {
            Registry registry = LocateRegistry.getRegistry(8088);
            for(int i=0;i<locate.length;i++) {
                GumballMachineRemote lookup = (GumballMachineRemote) registry.lookup(name[i]);
                monitors[i] = new GumballMachineMonitor(lookup);
            }
            for(int i=0;i<monitors.length;i++) {
                monitors[i].report();
            }

            //=============================上Registry 下Naming================================

            for(int i=0;i<locate.length;i++) {
                GumballMachineRemote proxy = (GumballMachineRemote)Naming.lookup(locate[i]);
                monitors1[i] = new GumballMachineMonitor(proxy);
            }
            for(int i=0;i<monitors1.length;i++) {
                monitors1[i].report();
            }
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
