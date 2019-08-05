package thread.threadcreate;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/24
 */
public class ThreadLocalDemo {
    /**
     * 本质是每个线程的副本变量
     *
     * 实现原理：
     * 每个线程中的threadlocal 中有一个ThreadLocalMap
     * 先寻找当前线程对应的ThreadLocalMap
     * ThreadLocalMap 存储的key为ThreadLocal，value为当前值
     * threadlocalMap s是ThreadLocal内部类
     *     A(thread)   ----->   threadlocalMap
     *                          -              -
     *                         -                   -
     *                      threadlocal（软引用）    value
     */
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        threadLocal.set("nj");
        threadLocal.get();
    }
}
