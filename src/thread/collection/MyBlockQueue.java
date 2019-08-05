package thread.collection;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName:MyBlockQueue
 * @Description: 自己实现的阻塞队列
 * @Author: shanz
 * @Date: 2019/5/21 13:59
 * @Version:1.0
 **/
public class MyBlockQueue<T> {

    ReentrantLock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();

    Condition notEmpty = lock.newCondition();

    Object items [];

    int capacity;   //

    int count;

    /** items index for next take, poll, peek or remove */
    int takeIndex;


    public MyBlockQueue(int capacity) {
        this.items = new Object[capacity];
    }

//    public T take(){
//        try {
//            lock.lockInterruptibly();
//
//            while (count == 0){
//                notEmpty.await();
//            }
//
//            final Object[] items = this.items;
//
//            T x = (T) items[takeIndex];
//            items[takeIndex] = null;
//            if (++takeIndex == items.length)
//                takeIndex = 0;
//            count--;
////            if (itrs != null)
////                itrs.elementDequeued();
//            notFull.signal();
//            return x;
//        } catch (InterruptedException e) {
//            lock.unlock();
//        }
//
//
//    }





}
