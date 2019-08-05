package rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/14
 */
public class UserServiceImpl extends UnicastRemoteObject implements IUserService {

    protected UserServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public User getUser(String usernmae) throws RemoteException {
        User u = new User();
        u.setAge(12);
        u.setName(usernmae);
        return u;
    }

}
