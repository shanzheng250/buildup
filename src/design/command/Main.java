package design.command;

/**
 * @ClassName:Main
 * @Description:
 * @Author: shanz
 * @Date: 2019/6/13 9:12
 * @Version:1.0
 **/
public class Main {

    public static void main(String[] args) {

        Receiver receiver = new HystrixExecuteReceiver();

        Command command = new HystrixCommand(receiver);

        Client client = new Client(command);

        client.action();

    }

}
