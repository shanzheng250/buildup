package thread.threadcreate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/5
 */
public class FutureDemo extends FutureTask {


    public FutureDemo(Callable callable) {
        super(callable);
    }


    @Override
    public void run() {

        ExecutorService e = Executors.newFixedThreadPool(6);
        super.run();
    }
}
