package design.command;

/**
 * @ClassName:HystrixCommand
 * @Description: 命令实际执行者
 * @Author: shanz
 * @Date: 2019/6/13 9:01
 * @Version:1.0
 **/
public class HystrixCommand implements Command {

    private Receiver receiver;

    public HystrixCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }

    @Override
    public void queue() {
        receiver.action();
    }
}
