package design.command;

/**
 * @ClassName:Command
 * @Description: 命令
 * @Author: shanz
 * @Date: 2019/6/13 8:56
 * @Version:1.0
 **/
public interface Command {

    /**
     * 功能描述 同步执行
     * @param:
     * @return:
     * @date: 2019/6/13 8:58
     */
    public void execute();


    /**
     * 功能描述 异步执行
     * @param:
     * @return:
     * @date: 2019/6/13 8:59
     */
    public void queue();

}
