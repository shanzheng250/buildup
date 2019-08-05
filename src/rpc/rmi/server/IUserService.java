package rpc.rmi.server;

import java.rmi.Remote;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/14
 */
public interface IUserService extends Remote {

    public User getUser(String usernmae);

}
