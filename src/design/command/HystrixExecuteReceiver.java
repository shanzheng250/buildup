package design.command;

/**
 * @ClassName:HystrixReceiver
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/6/13 9:03
 * @Version:1.0
 **/
public class HystrixExecuteReceiver implements Receiver {

    @Override
    public void action() {
        System.out.println("reqest real do thing...nonasync");
    }
}
