package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/18
 */
public class CountDownLatchDemo {
    /**
     * AQS源码解析
     *  内部类 node
     *  头结点 head
     *  尾节点 tail
     * 定义了
     * releaseShared
     * 释放结点
     *
     * 获取结点
     *   共享式获取结点 --
     *       tryAcquireShared ->
     *　     1.当返回值大于0时，表示获取同步状态成功，同时还有剩余同步状态可供其他线程获取；
     * 　　  2.当返回值等于0时，表示获取同步状态成功，但没有可用同步状态了；
     * 　　  3.当返回值小于0时，表示获取同步状态失败。
     *       doAcquireShared ->
     *       当前序结点是head时，则判断是否可用获取同步状态,获取成功后setHeadAndPropagate进行状态传播
     *
     *   非共享结点 （独占结点）
     *      tryAcquire -> boolean类型，true就获取状态成功
     *      当前序结点是head时，则判断是否可用获取同步状态,获取成功后setHead
     *      流程总结：
     *       a.首先tryAcquire获取同步状态，成功则直接返回；否则，进入下一环节；
     * 　　　b.线程获取同步状态失败，就构造一个结点，加入同步队列中，这个过程要保证线程安全；
     * 　　　c.加入队列中的结点线程进入自旋状态，若是老二结点（即前驱结点为头结点），才有机会尝试去获取同步状态；否则，当其前驱结点的状态为SIGNAL，线程便可安心休息，进入阻塞状态，直到被中断或者被前驱结点唤醒。
     *
     */


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i =0;i<2;i++){
            service.submit(()->{
                System.out.println("线程阻塞");
                try {
                    Thread.sleep(1000);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             });
        }


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }

}
