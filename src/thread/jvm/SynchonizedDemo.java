package thread.jvm;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/25
 */
public class SynchonizedDemo {
    /**
     * 代码方块块： 进入monitorEnter
     *              出去monitorExit
     *  每个进去的monitorEnter 和monitorExit 必须匹配
     *  当且一个monitor被持有后，它将处于锁定状态。线程执行到monitorenter
     *  指令时，将会尝试获取对象所对应的monitor的所有权，即尝试获得对象的锁
     *
     *
     * 范围：
     *      锁住的是class 类
     *      synchronized(SynchonizedDemo.class)
     *      public static synchronized  void getInstance()
     *      锁住的是一个实例对象
     *          1、synchronized(this)
     *          2、 public synchronized  void getInstance()
     *
     *
     *
     *
     */
    public synchronized  void getInstance(){
        synchronized(SynchonizedDemo.class){

        }
    }

}
