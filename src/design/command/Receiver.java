package design.command;

/**
 * @ClassName:Receiver
 * @Description: 接收命令者
 * @Author: shanz
 * @Date: 2019/6/12 17:38
 * @Version:1.0
 **/
public interface Receiver {

    /**
     * 功能描述
     *
     * 命令接收者 实际干活的逻辑
     *
     */
    public void action();

}
