package proxy;

/**
 * @ClassName:test
 * @Description: TODO
 * @Author: shanz
 * @Date: 2018/12/1 14:11
 * @Version:1.0
 **/
public class test {

    public static void main(String[] args) {

        IUserService userService = new UserService();

        IUserService  proxy = (IUserService) new UserProxy(userService).bindObj();

        proxy.addUser("aa");

    }

}
