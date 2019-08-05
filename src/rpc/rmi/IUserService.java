package rpc.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/14
 */
public interface IUserService extends Remote {

    public User getUser(String usernmae)  throws RemoteException;

}
