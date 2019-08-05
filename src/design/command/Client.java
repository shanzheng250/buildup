package design.command;

/**
 * @ClassName:Client
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/6/13 9:15
 * @Version:1.0
 **/
public class Client {

    private Command command;

    public Client(Command command) {
        this.command = command;
    }

    public void action(){
        command.execute();
    }

}
