package thread.threadcreate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/15
 */
public class Main {

    /**
     * runnable 和 继承 thread 区别
     * 1、runnable可以再继承一个类，Thread不行
     * 2、runnable多线程实例可以共享，在runnable中设置属性
     *               Run r = new Run();
     *             new Thread(r,"thread-"+i).start();
     *             此时共享Run中的实例变量
     * thread多实例，同一个类static可以共享
     *          Threaddemo t1 = new Threaddemo（）
     *          Threaddemo t2 = new Threaddemo（）
     *           此时共享Threaddemo中static变量
     * @param args
     */


    public static void main(String[] args) {


        for (int i=0;i<10001;i++){
            Run r = new Run();
            new Thread(r,"thread-"+i).start();

        }

//        ReentrantReadWriteLock

    }




    public static class  Run implements Runnable{

        private  int  a =0;

        @Override
        public void run() {
            while(a<100000){
                a++;
            }
            System.out.println(a);
        }
    }

}
