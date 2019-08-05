package thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class AtomicIntegetDemo {


    /**
     *  CAS compare and swap
     *  核心方法是compareAndSet  -->  乐观锁
     *  比较期望值 和 更新值
     *  实现方法是调用Unsafe 本地方法栈方法
     *  compareAndSwapObject
     *  compareAndSwapInt
     *  compareAndSwapLong
     *
     *  更新操作等 是 while（integer.compareAndSet(0,10);）{
     *
     *  }
     *
     *  AtomicBoolean等 实际上是把boolean转换为int
     *  再调用compareAndSwapInt
     *
     *
     */
    private static AtomicInteger integer;
    private static AtomicBoolean aBoolean;



    public static void main(String[] args) {
        integer = new AtomicInteger();
        integer.getAndAdd(10);
        integer.compareAndSet(0,10);
        integer.incrementAndGet();

        aBoolean.compareAndSet(true,true);
    }

}
