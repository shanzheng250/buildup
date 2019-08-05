package thread.threadcreate;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/15
 */
public class ThreadDemo extends Thread{

    /**
     *  Thread 线程和进程的关系   进程是线程集合  线程上下文切换更加方便
     *
     *
     *  Thread 线程状态   new  runable  terminated
     *                    block(等待锁) wait(等待) timewait
     *
     *
     *   线程常用方法
     *   创建线程 extends thread
     *             implements runable
     *             implements callable
     *
     *    run() 不会开启线程 只会在当前线程中执行run方法
     *    stop() 会导致数据偏差，当线程a进行写操作对象时，只设置对象的一部分属性，强制执行stop后 线程终止会导致对象属性偏差
     *    interrupt() 线程终止 优雅的关闭线程方式 while(true){ if(Thread.CurrentThread().isInterrupterd) }
     *    wait() object自带的对象锁。使用object.wait会自动进入object对象等待队列 此时会自动释放拥有的锁，是不公平锁，若有若干个线程等待是没有先后顺序的
     *          必须和Synchronized配合使用，因为wait必须获取一个对象的监视器。
     *
     *
     *
     *
     *
     **/


    @Override
    public void run() {
        super.run();
    }


}
