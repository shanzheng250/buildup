package collection;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName:TimeWheel
 * @Description: 时间轮
 * @Author: shanz
 * @Date: 2019/2/14 9:54
 * @Version:1.0
 **/
public class TimeWheel {
    // netty.util.hashedWheelTime
    // 环形时钟
    // 时间槽 先hash算出放在哪个槽内
    // 时间槽内是双向链表  加入任务放入链表
    // 启动新的线程定时扫描。到达expire时间后执行链表内所有的任务，否则阻塞。
    // 链表执行后 修改currenttime
    // 如果发现时间溢出 则创建新的环形时钟 跨度范围变大，新的时钟也有单独扫描线程 到执行时间后将任务移动到最小时间轮，然后执行

    static int tickDuration = 10;   //一个槽代表的时间
    static int tickPerWheel = 1000;   //多少个槽
    private static HashedWheelTimer timer = new HashedWheelTimer(tickDuration,TimeUnit.MILLISECONDS,tickPerWheel);

    public static void delay(){
        System.out.println(">>>>>>"+System.currentTimeMillis());
        timer.newTimeout((Timeout)->System.out.println("延迟队列开始" + System.currentTimeMillis()),100l,TimeUnit.MILLISECONDS);

    }


    public static void main(String[] args) {
        TimeWheel.delay();
        TimeWheel.timer.stop();
    }

}
