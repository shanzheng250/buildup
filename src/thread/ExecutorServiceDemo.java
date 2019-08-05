package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/15
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) {
        Semaphore se = new Semaphore(3);

        try {
            // 获取标签量
            se.acquire();
            se.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //ThreadPoolExecutor 参数解析
        // 1、corePoolSize 核心线程池数，即使是闲置状态也不会受到keepAliveTime限制
        // 2、maximumPoolSize 最大线程池数。当workQueue 为没有大小时，该值无效
        // 3、keepAliveTime非核心存活时间
        // 4、workQueue 任务队列
        // 5、ThreadFactory 线程创建工厂
        // 6、RejectedExecutionHandler 拒绝处理器

        //执行标准：
        // 1 线程数小于corePoolSize立刻创建线程
        // 2 线程数小于corePoolSize 并且小于队列长度workQueue.size() 任务进入队列等待
        // 3 线程数大于队列长度workQueue.size()，并且小于最大线程数，直接新建线程。大于最大线程数则执行RejectedExecutionHandler
        // 4 无界队列的最大线程数无效

        // addWorker 这个是继承AQS的，内涵执行现场的对象，用来初始化core thread 线程执行时待执行的thread的 run 方法
        ExecutorService service = new ThreadPoolExecutor(2,2,0,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());


        // addWork 是按照以上的规则进行处理，执行runable
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });

        while (service.isShutdown()){
            System.out.println("线程结束...");
        }


    }



}
