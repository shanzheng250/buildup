package rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/14
 */
public class RmiClientDemo {

    public static void main(String[] args) {
        try {
            IUserService service = new UserServiceImpl();
            LocateRegistry.createRegistry(7777);

            Naming.rebind("rmi://10.0.14.101:7777/userservice",service);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
