package designpattern.proxy.remote.machineremote;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 服务器
 */
public class Test {
    public static void main(String[] args) {

        String location1 = "Remote1";
        String location2 = "Remote2";
        String location3 = "Remote3";
        try {
            Registry registry = LocateRegistry.createRegistry(8088);
            GumballMachineRemote remote1 = new GumballMachineRemoteImpl(1, location1);
            GumballMachineRemote remote2 = new GumballMachineRemoteImpl(3, location2);
            GumballMachineRemote remote3 = new GumballMachineRemoteImpl(5, location3);
            registry.bind(location1, remote1);
            registry.bind(location2, remote2);
            registry.bind(location3, remote3);
            System.out.println("======服务已开启======");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
