package limit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName:LimitTotalReq
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/5/29 9:52
 * @Version:1.0
 **/
public class LimitTotalReq {

    private final int reqLength = 10;

    private Semaphore semaphore= new Semaphore(reqLength);


    // 对某个请求接口进行限流 暴力方式

    public void exampleLimit(){
        try {

            if (!semaphore.tryAcquire()){
                // 拒绝请求

            }
            // do samething


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            semaphore.release();
        }
    }


    public void getUserCountByTime(){
        LoadingCache<Long,AtomicLong> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(2,TimeUnit.SECONDS)
                .recordStats()
                .build(new CacheLoader<Long, AtomicLong>() {
                    @Override
                    public AtomicLong load(Long aLong) throws Exception {
                        return new AtomicLong(0);
                    }
                });


        int limit  = 2;

        while (true){
            long curTime = System.currentTimeMillis() / 1000;
            try {
                if (cache.get(curTime).incrementAndGet() > limit){
                    System.out.println("被限流了");
                    continue;
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            // do same thing
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        LimitTotalReq limitTotalReq = new LimitTotalReq();

        for (int i=0;i<5;i++){
            executorService.submit(()->{
                limitTotalReq.getUserCountByTime();
            });

        }
    }

}
