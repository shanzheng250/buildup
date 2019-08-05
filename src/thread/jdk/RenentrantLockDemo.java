package thread.jdk;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName:RenentrantLockDemo
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/5/13 19:54
 * @Version:1.0
 **/
public class RenentrantLockDemo {






    /**

     AQS  node链表 以status作原子操作对象 status >0 停止状态 < -1 正常状态

     enq() 入链表 CAS自旋方式
            若为链表空则设置node为header节点，并将尾节点指向头结点（初始化）
            否则则把该节点设置为尾节点

     addWaiter() 添加节点 主要是调用 enq()


     releaseShared（） 释放共享节点
                -> tryReleaseShared() 释放当前资源
                -> doReleaseShared() 唤醒后继线程
                -> unparkSuccessor()
     release() 释放独占节点
                -> tryRelease() 释放当前资源
                ->unparkSuccessor() 唤醒后续节点

     acquire() 获取独占节点
             !tryAcquire(arg) &&  尝试获取共享节点获取成功返回true
             acquireQueued(addWaiter(Node.EXCLUSIVE), arg) //尾部添加节点并自旋获取

     acquireShared() 区别是这个方法进行后续节点的唤醒
     */
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

    }

}
